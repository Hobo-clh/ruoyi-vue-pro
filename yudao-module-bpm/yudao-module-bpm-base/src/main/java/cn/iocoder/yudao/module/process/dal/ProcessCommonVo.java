package cn.iocoder.yudao.module.process.dal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 流程公共类
 * @author Hobo
 * @date 2022/3/7
 */
@Data
public class ProcessCommonVo<T> {

    /**
     * T 表单数据类型
     */
    private T formData;

    @ApiModelProperty(value = "结果", required = true)
    private Integer result;

    @ApiModelProperty(value = "申请时间", required = true)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date createTime;

    @ApiModelProperty(value = "流程实例的编号")
    private String processInstanceId;
}
