package cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* 动态表单列 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DynamicTableBaseVO {

    @ApiModelProperty(value = "表名", required = true)
    @NotNull(message = "表名不能为空")
    private String tableName;

    @ApiModelProperty(value = "字段json串", required = true)
    @NotNull(message = "字段json串不能为空")
    private String fieldJson;

    @ApiModelProperty(value = "表描述", required = true)
    private String comment;

    @ApiModelProperty(value = "租户编号", required = true)
    @NotNull(message = "租户编号不能为空")
    private Long tenantId;

}
