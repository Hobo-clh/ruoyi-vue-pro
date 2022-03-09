package cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
* 动态表单列 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DynamicTableBaseVO {

    @ApiModelProperty(value = "表名", required = true)
    @NotNull(message = "表名不能为空")
    private String tableName;

    @ApiModelProperty(value = "表描述")
    private String comment;

}
