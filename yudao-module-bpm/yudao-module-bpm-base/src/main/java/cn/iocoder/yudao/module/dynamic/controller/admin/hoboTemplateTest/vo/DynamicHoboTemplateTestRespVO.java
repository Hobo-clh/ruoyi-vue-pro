package cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ApiModel("管理后台 - 1212 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DynamicHoboTemplateTestRespVO extends DynamicHoboTemplateTestBaseVO {

    @ApiModelProperty(value = "AUTO_INCREMENT ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

}
