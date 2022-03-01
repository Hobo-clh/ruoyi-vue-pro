package cn.iocoder.yudao.module.bpm.service.oa.listener;

import cn.iocoder.yudao.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEvent;
import cn.iocoder.yudao.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEventListener;
import cn.iocoder.yudao.module.bpm.service.oa.BpmOAApplyService;
import cn.iocoder.yudao.module.bpm.service.oa.BpmOAApplyServiceImpl;
import cn.iocoder.yudao.module.bpm.service.oa.BpmOALeaveService;
import cn.iocoder.yudao.module.bpm.service.oa.BpmOALeaveServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * OA 请假单的结果的监听器实现类
 *
 * @author 芋道源码
 */
@Component
public class BpmOAApplyResultListener extends BpmProcessInstanceResultEventListener {

    @Resource
    private BpmOAApplyService applyService;

    @Override
    protected String getProcessDefinitionKey() {
        return BpmOAApplyServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceResultEvent event) {
        applyService.updateApplyResult(Long.parseLong(event.getBusinessKey()), event.getResult());
    }

}
