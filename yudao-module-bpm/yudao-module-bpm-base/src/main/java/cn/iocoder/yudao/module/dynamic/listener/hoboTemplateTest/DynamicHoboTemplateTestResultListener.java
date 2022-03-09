package cn.iocoder.yudao.module.dynamic.listener.hoboTemplateTest;

import cn.iocoder.yudao.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEvent;
import cn.iocoder.yudao.module.bpm.framework.bpm.core.event.BpmProcessInstanceResultEventListener;
import cn.iocoder.yudao.module.dynamic.service.hoboTemplateTest.DynamicHoboTemplateTestService;
import cn.iocoder.yudao.module.dynamic.service.hoboTemplateTest.DynamicHoboTemplateTestServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
* 1212 的结果的监听器实现类
*
* @author 芋道源码
*/
@Component
public class DynamicHoboTemplateTestResultListener extends BpmProcessInstanceResultEventListener {


    @Resource
    private DynamicHoboTemplateTestService hoboTemplateTestService;

    @Override
    protected String getProcessDefinitionKey() {
        return DynamicHoboTemplateTestServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceResultEvent event) {
        hoboTemplateTestService.updateHoboTemplateTestResult(Integer.parseInt(event.getBusinessKey()), event.getResult());
    }
}