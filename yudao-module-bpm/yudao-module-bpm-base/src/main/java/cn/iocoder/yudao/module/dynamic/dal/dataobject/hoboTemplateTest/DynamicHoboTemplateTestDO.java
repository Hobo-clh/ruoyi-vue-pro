package cn.iocoder.yudao.module.dynamic.dal.dataobject.hoboTemplateTest;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 1212 DO
 *
 * @author 芋道源码
 */
@TableName("dynamic_hobo_template_test")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicHoboTemplateTestDO extends TenantBaseDO {

    /**
     * AUTO_INCREMENT ID
     */
    @TableId
    private Integer id;
    /**
     * 单行文本
     */
    private String field101;
    /**
     * 多行文本
     */
    private String field103;
    /**
     * 计数器
     */
    private Integer field104;
    /**
     * 下拉选择
     */
    private String field105;
    /**
     * 结果
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
