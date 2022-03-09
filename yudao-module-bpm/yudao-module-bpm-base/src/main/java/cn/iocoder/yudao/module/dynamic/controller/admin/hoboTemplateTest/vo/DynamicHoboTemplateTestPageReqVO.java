package cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 1212分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DynamicHoboTemplateTestPageReqVO extends PageParam {

    @ApiModelProperty(value = "单行文本")
    private String field101;

    @ApiModelProperty(value = "多行文本")
    private String field103;

    @ApiModelProperty(value = "计数器")
    private Integer field104;

    @ApiModelProperty(value = "下拉选择")
    private String field105;

    @ApiModelProperty(value = "结果")
    private Integer result;

    @ApiModelProperty(value = "流程实例的编号")
    private String processInstanceId;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @ApiModelProperty(value = "开始创建时间")
    private Date beginCreateTime;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @ApiModelProperty(value = "结束创建时间")
    private Date endCreateTime;

    @ApiModelProperty(value = "租户编号")
    private Long tenantId;

}
