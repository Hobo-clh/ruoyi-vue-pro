package cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 动态表单列 Excel 导出 Request VO", description = "参数和 DynamicTablePageReqVO 是一致的")
@Data
public class DynamicTableExportReqVO {

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "字段json串")
    private String fieldJson;

    @ApiModelProperty(value = "表描述")
    private String comment;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @ApiModelProperty(value = "开始创建时间")
    private Date beginCreateTime;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @ApiModelProperty(value = "结束创建时间")
    private Date endCreateTime;

    @ApiModelProperty(value = "租户编号")
    private Long tenantId;

}
