package cn.iocoder.yudao.module.bpm.controller.admin.oa;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyPageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyRespVO;
import cn.iocoder.yudao.module.bpm.convert.oa.BpmOAApplyConvert;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOAApplyDO;
import cn.iocoder.yudao.module.bpm.service.oa.BpmOAApplyService;
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

/**
 * OA 请假申请 Controller，用于演示自己存储数据，接入工作流的例子
 *
 * @author jason
 * @author 芋道源码
 */
@Api(tags = "管理后台 - OA 申请")
@RestController
@RequestMapping("/bpm/oa/apply")
@Validated
public class BpmOAApplyController {

    @Resource
    private BpmOAApplyService applyService;

    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('bpm:oa-Apply:create')")
    @ApiOperation("创建申请")
    public CommonResult<Long> createApply(@Valid @RequestBody BpmOAApplyCreateReqVO createReqVO) {
        return success(applyService.createApply(getLoginUserId(), createReqVO));
    }

    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('bpm:oa-Apply:query')")
    @ApiOperation("获得申请")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<BpmOAApplyRespVO> getApply(@RequestParam("id") Long id) {
        BpmOAApplyDO apply = applyService.getApply(id);
        return success(BpmOAApplyConvert.INSTANCE.convert(apply));
    }

    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('bpm:oa-Apply:query')")
    @ApiOperation("获得申请分页")
    public CommonResult<PageResult<BpmOAApplyRespVO>> getApplyPage(@Valid BpmOAApplyPageReqVO pageVO) {
        PageResult<BpmOAApplyDO> pageResult = applyService.getApplyPage(getLoginUserId(), pageVO);
        return success(BpmOAApplyConvert.INSTANCE.convertPage(pageResult));
    }

}
