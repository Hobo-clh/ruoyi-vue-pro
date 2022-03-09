package cn.iocoder.yudao.module.bpm.dal.dataobject.dynamic;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 动态表单列 DO
 *
 * @author 芋道源码
 */
@TableName("dynamic_table")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicTableDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 字段json串
     */
    private String fieldJson;
    /**
     * 表描述
     */
    private String comment;
    /**
     * 租户编号
     */
    private Long tenantId;

}
