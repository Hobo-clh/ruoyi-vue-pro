package cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 动态表单列 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DynamicTableExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("表名")
    private String tableName;

    @ExcelProperty("字段json串")
    private String fieldJson;

    private List<String> fields;

    @ExcelProperty("表描述")
    private String comment;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("租户编号")
    private Long tenantId;

}
