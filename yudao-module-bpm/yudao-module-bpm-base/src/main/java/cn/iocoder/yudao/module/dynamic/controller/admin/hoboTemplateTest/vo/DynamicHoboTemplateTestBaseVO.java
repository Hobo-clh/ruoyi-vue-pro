package cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* 1212 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DynamicHoboTemplateTestBaseVO {

    @ApiModelProperty(value = "单行文本")
    private String field101;

    @ApiModelProperty(value = "多行文本")
    private String field103;

    @ApiModelProperty(value = "计数器")
    private Integer field104;

    @ApiModelProperty(value = "下拉选择")
    private String field105;

    @ApiModelProperty(value = "结果", required = true)
    @NotNull(message = "结果不能为空")
    private Integer result;

    @ApiModelProperty(value = "流程实例的编号")
    private String processInstanceId;

    @ApiModelProperty(value = "租户编号", required = true)
    @NotNull(message = "租户编号不能为空")
    private Long tenantId;

}
