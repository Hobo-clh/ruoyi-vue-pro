package cn.iocoder.yudao.module.bpm.enums.dynamic;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bpm.enums.ErrorCodeConstants.DYNAMIC_TABLE_TAG_NOT_FOUND;

/**
 * 前端表单与数据库字段类型映射枚举
 * @author 80725
 */
@Getter
@AllArgsConstructor
public enum DbTypeMappingEnum {
    /**
     *  下拉框 el-select
     *  级联选择 el-cascader
     *  颜色选择器 el-color-picker
     *  按钮 el-button
     *  文件上传 el-upload
     *  输入框 el-input
     *  单选框 el-radio-group
     *  多选框 el-checkbox-group
     *  开关 el-switch
     */
    VARCHAR("varchar", Sets.newHashSet("el-select", "el-cascader", "el-color-picker", "el-button", "el-upload", "el-input", "el-radio-group", "el-checkbox-group", "el-switch"), 300L),
    /**
     * 计数器 el-input-number
     * 评分 el-rate
     * 滑块 el-slider
     */
    INT("int", Sets.newHashSet("el-input-number", "el-rate", "el-slider"), 50L),
    /**
     * el-time-picker todo 范围和非范围处理
     * el-date-picker todo 范围和非范围处理
     */
    JSON("json", Sets.newHashSet( "el-time-picker", "el-date-picker"), null),
    /**
     * 富文本 tinymce
     */
    TEXT("text", Sets.newHashSet("tinymce"), null),

    ;

    private final String dbType;
    private final Set<String> tagSet;
    private final Long defaultLength;


    public static DbTypeMappingEnum getByTag(String tag) {
        for (DbTypeMappingEnum value : DbTypeMappingEnum.values()) {
            if (value.getTagSet().contains(tag)) {
                return value;
            }
        }
        throw exception(DYNAMIC_TABLE_TAG_NOT_FOUND, tag);
    }
}
