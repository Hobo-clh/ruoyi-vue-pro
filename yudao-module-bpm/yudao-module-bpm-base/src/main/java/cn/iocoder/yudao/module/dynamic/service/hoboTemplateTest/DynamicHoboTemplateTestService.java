package cn.iocoder.yudao.module.dynamic.service.hoboTemplateTest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestCreateReqVO;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestPageReqVO;
import cn.iocoder.yudao.module.dynamic.dal.dataobject.hoboTemplateTest.DynamicHoboTemplateTestDO;
import cn.iocoder.yudao.module.process.dal.ProcessCommonVo;

import javax.validation.Valid;

/**
 * 1212 Service 接口
 *
 * @author 芋道源码
 */
public interface DynamicHoboTemplateTestService {

    /**
     * 创建1212
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createHoboTemplateTest(Long userId, @Valid DynamicHoboTemplateTestCreateReqVO createReqVO);

    /**
     * 更新1212的状态
     *
     * @param id 编号
     * @param result 结果
     */
    void updateHoboTemplateTestResult(Integer id, Integer result);

    /**
     * 获得1212
     *
     * @param id 编号
     * @return 1212
     */
    DynamicHoboTemplateTestDO getHoboTemplateTest(Integer id);

    /**
     * 获得1212分页
     *
     * @param userId 用户编号
     * @param pageReqVO 分页查询
     * @return 1212分页
     */
    PageResult<ProcessCommonVo<DynamicHoboTemplateTestDO>> getHoboTemplateTestPage(DynamicHoboTemplateTestPageReqVO pageReqVO);

}
