package cn.iocoder.yudao.module.bpm.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.form.BpmFormCreateReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.dynamic.DynamicTableDO;
import cn.iocoder.yudao.module.bpm.enums.dynamic.DbTypeMappingEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TableUtil {

    public static String translationSQL(BpmFormCreateReqVO createReqVO) {
        DynamicTableDO table = convertToDynamicTable(createReqVO);
        return generateCreateTableSQL(table);
    }

    public static DynamicTableDO convertToDynamicTable(BpmFormCreateReqVO createReqVO) {
        DynamicTableDO table = new DynamicTableDO();
        table.setTableName("dynamic_" + createReqVO.getName());
        table.setComment(createReqVO.getRemark());

        List<TableField> list = new ArrayList<>();


        if (CollUtil.isNotEmpty(createReqVO.getFields())) {
            createReqVO.getFields().forEach(field -> {
                TableField tableField = new TableField();
                list.add(tableField);

                try {
                    ObjectNode node = new ObjectMapper().readValue(field, ObjectNode.class);
                    // 字段名
                    tableField.setFieldName(node.get("__vModel__").toString().replace("\"", ""));

                    if (node.get("maxlength") != null) {
                        String maxlength = node.get("maxlength").toString();
                        // 最大长度
                        if (StrUtil.isNotBlank(maxlength) && !StrUtil.NULL.equals(maxlength)) {
                            tableField.setLength(Long.parseLong(maxlength));
                        }
                    }

                    if (node.has("__config__")) {
                        JsonNode configNode = node.get("__config__");
                        if (configNode.has("tag")) {
                            JsonNode tag = configNode.get("tag");
                            // 属性
                            typeMapper(tag.toString().replace("\"", ""), tableField);
                        }
                        // 默认值
                        if (configNode.has("defaultValue")) {
                            JsonNode defaultValue = configNode.get("defaultValue");

                            String replace = defaultValue.toString().replace("\"", "");
                            tableField.setDefaultVal(replace);
                        }
                        // 是否必填
                        if (configNode.has("required")) {
                            JsonNode required = configNode.get("required");
                            tableField.setWhetherNull(!Boolean.parseBoolean(required.toString().replace("\"", "")));
                        }
                        // 描述
                        if (configNode.has("label")) {
                            JsonNode label = configNode.get("label");
                            tableField.setComment(label.toString().replace("\"", ""));
                        }
                    }

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            table.setFieldJson(new ObjectMapper().writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return table;
    }

    public static void typeMapper(String type, TableField tableField) {
        DbTypeMappingEnum dbTypeEnum = DbTypeMappingEnum.getByTag(type);
        if (tableField.getLength() == null) {
            tableField.setLength(dbTypeEnum.getDefaultLength());
        }
        tableField.setType(dbTypeEnum.getDbType());

    }

    public static String generateCreateTableSQL(DynamicTableDO table) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        new ArrayList<>();
        String fieldJson = table.getFieldJson();

        TableField[] tableFields = new TableField[0];
        try {
            tableFields = new ObjectMapper().readValue(fieldJson, TableField[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Stream.of(tableFields).forEach(field -> {
            sb2.append(StrUtil.format("`{}`", field.getFieldName())).append(" ").append(field.getType());
            if (field.getLength() != null) {
                sb2.append("(").append(field.getLength()).append(")");
            }
            if ("varchar".equals(field.getType())) {
                sb2.append(" COLLATE utf8_unicode_ci");
            }
            sb2.append(" ");
            if (!field.isWhetherNull()) {
                sb2.append("NOT NULL").append(" ");
            }

            if (StrUtil.isNotBlank(field.getDefaultVal()) && !StrUtil.isNullOrUndefined(field.getDefaultVal())) {
                sb2.append(StrUtil.format("DEFAULT '{}'", field.getDefaultVal())).append(" ");
            }
            if (StrUtil.isNotBlank(field.getComment())) {
                sb2.append(StrUtil.format("COMMENT '{}'", field.getComment()));
            }
            sb2.append(",").append("\n");
        });

//        sb.append(StrUtil.format("DROP TABLE IF EXISTS `{}`; ", table.getTableName())).append("\n");
        sb.append(StrUtil.format("CREATE TABLE `{}` ( ", table.getTableName())).append("\n");
        sb.append("`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT ID',").append("\n");
        sb.append(sb2).append("\n");
        sb.append("PRIMARY KEY (`id`) USING BTREE").append("\n");
        sb.append(") ENGINE=InnoDB ");
        if (StrUtil.isNotBlank(table.getComment())) {
            sb.append(StrUtil.format("COMMENT '{}'", table.getComment()));
        }
        sb.append(";");
        return sb.toString();
    }

    //    public static String generateCreateTableSQL(DynamicTableDO table) {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//
//        new ArrayList<>();
//        String fieldJson = table.getFieldJson();
//
//        new ObjectMapper().readValue(fieldJson, TableField[].class);
//
//
//        if (CollUtil.isNotEmpty(table.getFields())) {
//
//            table.getFields().forEach(field -> {
//                sb2.append(StrUtil.format("`{}`", field.getFieldName())).append(" ").append(field.getType());
//                if (field.getLength() != null) {
//                    sb2.append("(").append(field.getLength()).append(")");
//                }
//                sb2.append(" ");
//                if (!field.isWhetherNull()) {
//                    sb2.append("NOT NULL").append(" ");
//                }
//
//                if (StrUtil.isNotBlank(field.getDefaultVal())) {
//                    sb2.append(StrUtil.format("DEFAULT '{}'", field.getDefaultVal())).append(" ");
//                }
//                if (StrUtil.isNotBlank(field.getComment())) {
//                    sb2.append(StrUtil.format("COMMENT '{}'", field.getComment()));
//                }
//                sb2.append(",").append("\n");
//            });
//        }
//
////        sb.append(StrUtil.format("DROP TABLE IF EXISTS `{}`; ", table.getTableName())).append("\n");
//        sb.append(StrUtil.format("CREATE TABLE `{}` ( ", table.getTableName())).append("\n");
//        sb.append("`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT ID',").append("\n");
//        sb.append(sb2).append("\n");
//        sb.append("PRIMARY KEY (`id`) USING BTREE").append("\n");
//        sb.append(") ENGINE=InnoDB ");
//        if (StrUtil.isNotBlank(table.getComment())) {
//            sb.append(StrUtil.format("COMMENT '{}'", table.getComment()));
//        }
//        sb.append(";");
//        return sb.toString();
//    }
    @Data
    static class TableField {
        private String fieldName;
        private String comment;
        private boolean whetherNull;
        private String type;
        private boolean primaryKey;
        private String defaultVal;
        private Long length;
    }

}
