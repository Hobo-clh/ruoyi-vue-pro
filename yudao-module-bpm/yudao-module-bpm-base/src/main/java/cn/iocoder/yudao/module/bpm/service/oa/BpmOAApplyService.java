package cn.iocoder.yudao.module.bpm.service.oa;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyPageReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOAApplyDO;

import javax.validation.Valid;

/**
 * @author 80725
 */ // 报销
public interface BpmOAApplyService {

    /**
     * 创建请假申请
     *
     * @param userId 用户编号
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createApply(Long userId, @Valid BpmOAApplyCreateReqVO createReqVO);

    /**
     * 更新请假申请的状态
     *
     * @param id 编号
     * @param result 结果
     */
    void updateApplyResult(Long id, Integer result);

    /**
     * 获得请假申请
     *
     * @param id 编号
     * @return 请假申请
     */
    BpmOAApplyDO getApply(Long id);

    /**
     * 获得请假申请分页
     *
     * @param userId 用户编号
     * @param pageReqVO 分页查询
     * @return 请假申请分页
     */
    PageResult<BpmOAApplyDO> getApplyPage(Long userId, BpmOAApplyPageReqVO pageReqVO);
}
