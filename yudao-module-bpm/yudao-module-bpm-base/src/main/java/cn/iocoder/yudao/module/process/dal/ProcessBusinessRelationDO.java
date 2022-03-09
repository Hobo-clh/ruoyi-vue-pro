package cn.iocoder.yudao.module.process.dal;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 流程与业务表单关联 DO
 *
 * @author 芋道源码
 */
@TableName("process_business_relation")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessBusinessRelationDO extends TenantBaseDO {

    /**
     * AUTO_INCREMENT ID
     */
    @TableId
    private Long id;
    /**
     * 业务id
     */
    private Long businessId;
    /**
     * 业务名称
     */
    private String businessName;
    /**
     * 流程结果
     */
    private Integer result;
    /**
     * 流程实例的编号
     */
    private String processInstanceId;
    /**
     * 租户编号
     */
    private Long tenantId;

}
