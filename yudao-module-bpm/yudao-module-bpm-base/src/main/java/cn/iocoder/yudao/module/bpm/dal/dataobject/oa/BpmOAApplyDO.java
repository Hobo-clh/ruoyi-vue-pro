package cn.iocoder.yudao.module.bpm.dal.dataobject.oa;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.module.bpm.enums.task.BpmProcessInstanceResultEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * OA 申请 DO
 *
 *
 * @author jason
 * @author 芋道源码
 */
@TableName("bpm_oa_apply")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BpmOAApplyDO extends BaseDO {

    /**
     * 请假表单主键
     */
    @TableId
    private Long id;
    /**
     * 申请人的用户编号
     *
     * 关联 AdminUserDO 的 id 属性
     */
    private Long userId;
    /**
     * 原因
     */
    private String reason;
    /**
     * 申请时间
     */
    private Date time;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 请假的结果
     *
     * 枚举 {@link BpmProcessInstanceResultEnum}
     * 考虑到简单，所以直接复用了 BpmProcessInstanceResultEnum 枚举，也可以自己定义一个枚举哈
     */
    private Integer result;

    /**
     * 对应的流程编号
     *
     * 关联 ProcessInstance 的 id 属性
     */
    private String processInstanceId;

}
