package cn.iocoder.yudao.module.dynamic.service.hoboTemplateTest;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestCreateReqVO;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestPageReqVO;
import cn.iocoder.yudao.module.dynamic.convert.hoboTemplateTest.DynamicHoboTemplateTestConvert;
import cn.iocoder.yudao.module.dynamic.dal.dataobject.hoboTemplateTest.DynamicHoboTemplateTestDO;
import cn.iocoder.yudao.module.dynamic.dal.mysql.hoboTemplateTest.DynamicHoboTemplateTestMapper;
import cn.iocoder.yudao.module.process.dal.ProcessCommonVo;
import cn.iocoder.yudao.module.process.service.ProcessCommonService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
/**
 * 1212 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DynamicHoboTemplateTestServiceImpl implements DynamicHoboTemplateTestService {

    /**
    * OA 请假对应的流程定义 KEY
    */
    public static final String PROCESS_KEY = "${processKey}";

    @Resource
    private DynamicHoboTemplateTestMapper hoboTemplateTestMapper;

    @Resource
    private BpmProcessInstanceApi processInstanceApi;

    @Resource
    private ProcessCommonService processCommonService;


    @Override
    public Integer createHoboTemplateTest(Long userId, DynamicHoboTemplateTestCreateReqVO createReqVO) {
        // 插入
        DynamicHoboTemplateTestDO hoboTemplateTest = DynamicHoboTemplateTestConvert.INSTANCE.convert(createReqVO);
        hoboTemplateTestMapper.insert(hoboTemplateTest);
        // 返回
        String processInstanceId = processInstanceApi.createProcessInstance(userId,
                new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
                    .setBusinessKey(String.valueOf(hoboTemplateTest.getId())));

        hoboTemplateTestMapper.updateById(new DynamicHoboTemplateTestDO().setId(hoboTemplateTest.getId()).setProcessInstanceId(processInstanceId));
        return hoboTemplateTest.getId();
    }

    @Override
    public void updateHoboTemplateTestResult(Integer id, Integer result) {
        // 校验存在
        this.validateHoboTemplateTestExists(id);
        // 更新
        processCommonService.updateResult(new Long(id), result, DynamicHoboTemplateTestDO.class);
    }


    private void validateHoboTemplateTestExists(Integer id) {
        if (hoboTemplateTestMapper.selectById(id) == null) {
            throw exception(new ErrorCode(-1,"1212不存在"));
        }
    }

    @Override
    public DynamicHoboTemplateTestDO getHoboTemplateTest(Integer id) {
        return hoboTemplateTestMapper.selectById(id);
    }

    @Override
    public PageResult<ProcessCommonVo<DynamicHoboTemplateTestDO>> getHoboTemplateTestPage(DynamicHoboTemplateTestPageReqVO pageReqVO) {
        return processCommonService.getProcessCommentPage(hoboTemplateTestMapper.selectPage(pageReqVO));
    }

}
