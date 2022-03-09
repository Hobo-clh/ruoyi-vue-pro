package cn.iocoder.yudao.module.tool.enums.codegen;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.module.tool.service.codegen.template.OneToOneCodegenTemplate;
import cn.iocoder.yudao.module.tool.service.codegen.template.ProcessCodegenTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 代码生成模板类型
 *
 * @author 芋道源码
 */
@AllArgsConstructor
@Getter
public enum CodegenTemplateTypeEnum {
    /**
     * 单表（增删改查）
     */
    CRUD(1,  OneToOneCodegenTemplate.MAP),
    /**
     * 树表的增删改查
     */
    TREE(2, Collections.EMPTY_MAP),
//    /**
//     * 主子表，一对多的增删改查
//     */

    /**
     * 流程的模板
     */
    PROCESS(4, ProcessCodegenTemplate.MAP),
    ;

    /**
     * 类型
     */
    private final Integer type;

    /**
     * 模板
     */
    private final Map<String, String> map;


    public static Map<String, String> getTemplateMap(Integer type) {
        for (CodegenTemplateTypeEnum value : CodegenTemplateTypeEnum.values()) {
            if (value.type.equals(type)) {
                return value.map;
            }
        }
        throw exception(StrUtil.format("模板不存在，请检查类型是否正确：{}", type));
    }

}
