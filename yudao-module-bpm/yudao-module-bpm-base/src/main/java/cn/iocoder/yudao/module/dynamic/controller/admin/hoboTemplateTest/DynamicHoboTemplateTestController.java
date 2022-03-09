package cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestCreateReqVO;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestPageReqVO;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestRespVO;
import cn.iocoder.yudao.module.dynamic.convert.hoboTemplateTest.DynamicHoboTemplateTestConvert;
import cn.iocoder.yudao.module.dynamic.dal.dataobject.hoboTemplateTest.DynamicHoboTemplateTestDO;
import cn.iocoder.yudao.module.dynamic.service.hoboTemplateTest.DynamicHoboTemplateTestService;
import cn.iocoder.yudao.module.process.dal.ProcessCommonVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Api(tags = "管理后台 - 1212")
@RestController
@RequestMapping("/dynamic/hobo-template-test")
@Validated
public class DynamicHoboTemplateTestController {

    @Resource
    private DynamicHoboTemplateTestService hoboTemplateTestService;

    @PostMapping("/create")
    @ApiOperation("创建1212")
    @PreAuthorize("@ss.hasPermission('dynamic:hobo-template-test:create')")    public CommonResult<Integer> createHoboTemplateTest(@Valid @RequestBody DynamicHoboTemplateTestCreateReqVO createReqVO) {
        return success(hoboTemplateTestService.createHoboTemplateTest(getLoginUserId(), createReqVO));
    }

    @GetMapping("/get")
    @ApiOperation("获得1212")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Integer.class)
    @PreAuthorize("@ss.hasPermission('dynamic:hobo-template-test:query')")
    public CommonResult<DynamicHoboTemplateTestRespVO> getHoboTemplateTest(@RequestParam("id") Integer id) {
        DynamicHoboTemplateTestDO hoboTemplateTest = hoboTemplateTestService.getHoboTemplateTest(id);
        return success(DynamicHoboTemplateTestConvert.INSTANCE.convert(hoboTemplateTest));
    }

    @GetMapping("/page")
    @ApiOperation("获得1212分页")
    @PreAuthorize("@ss.hasPermission('dynamic:hobo-template-test:query')")
    public CommonResult<PageResult<ProcessCommonVo<DynamicHoboTemplateTestDO>>> getHoboTemplateTestPage(@Valid DynamicHoboTemplateTestPageReqVO pageVO) {
        ;
        return success(hoboTemplateTestService.getHoboTemplateTestPage(pageVO));
    }

}
