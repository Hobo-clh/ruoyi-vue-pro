package cn.iocoder.yudao.module.bpm.service.oa;

import cn.hutool.core.date.DateUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyPageReqVO;
import cn.iocoder.yudao.module.bpm.convert.oa.BpmOAApplyConvert;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOAApplyDO;
import cn.iocoder.yudao.module.bpm.dal.mysql.oa.BpmOAApplyMapper;
import cn.iocoder.yudao.module.bpm.enums.task.BpmProcessInstanceResultEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bpm.enums.ErrorCodeConstants.OA_LEAVE_NOT_EXISTS;

/**
 * OA 请假申请 Service 实现类
 *
 * @author jason
 * @author 芋道源码
 */
@Service
@Validated
public class BpmOAApplyServiceImpl implements BpmOAApplyService {

    /**
     * OA apply对应的流程定义 KEY
     */
    public static final String PROCESS_KEY = "apply";

    @Resource
    private BpmOAApplyMapper applyMapper;

    @Resource
    private BpmProcessInstanceApi processInstanceApi;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createApply(Long userId, BpmOAApplyCreateReqVO createReqVO) {
        // 插入 OA 请假单
        long day = DateUtil.betweenDay(createReqVO.getStartTime(), createReqVO.getEndTime(), false);
        BpmOAApplyDO apply = BpmOAApplyConvert.INSTANCE.convert(createReqVO).setUserId(userId)
                .setResult(BpmProcessInstanceResultEnum.PROCESS.getResult());
        applyMapper.insert(apply);

        // 发起 BPM 流程
        Map<String, Object> processInstanceVariables = new HashMap<>();

        String processInstanceId = processInstanceApi.createProcessInstance(userId,
                new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
                        .setVariables(processInstanceVariables).setBusinessKey(String.valueOf(apply.getId())));

        // 将工作流的编号，更新到 OA 请假单中
        applyMapper.updateById(new BpmOAApplyDO().setId(apply.getId()).setProcessInstanceId(processInstanceId));
        return apply.getId();
    }

    @Override
    public void updateApplyResult(Long id, Integer result) {
        validateLeaveExists(id);
        applyMapper.updateById(new BpmOAApplyDO().setId(id).setResult(result));
    }

    private void validateLeaveExists(Long id) {
        if (applyMapper.selectById(id) == null) {
            throw exception(OA_LEAVE_NOT_EXISTS);
        }
    }

    @Override
    public BpmOAApplyDO getApply(Long id) {
        return applyMapper.selectById(id);
    }

    @Override
    public PageResult<BpmOAApplyDO> getApplyPage(Long userId, BpmOAApplyPageReqVO pageReqVO) {
        return applyMapper.selectPage(userId, pageReqVO);
    }

}
