package cn.iocoder.yudao.module.bpm.controller.admin.dynamic;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.*;
import cn.iocoder.yudao.module.bpm.convert.dynamic.DynamicTableConvert;
import cn.iocoder.yudao.module.bpm.dal.dataobject.dynamic.DynamicTableDO;
import cn.iocoder.yudao.module.bpm.service.dynamic.DynamicTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 动态表单列")
@RestController
@RequestMapping("/dynamic/table")
@Validated
public class DynamicTableController {

    @Resource
    private DynamicTableService tableService;

    @PostMapping("/create")
    @ApiOperation("创建动态表单列")
    @PreAuthorize("@ss.hasPermission('dynamic:table:create')")
    public CommonResult<Long> createTable(@Valid @RequestBody DynamicTableCreateReqVO createReqVO) {
        return success(tableService.createTable(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新动态表单列")
    @PreAuthorize("@ss.hasPermission('dynamic:table:update')")
    public CommonResult<Boolean> updateTable(@Valid @RequestBody DynamicTableUpdateReqVO updateReqVO) {
        tableService.updateTable(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除动态表单列")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('dynamic:table:delete')")
    public CommonResult<Boolean> deleteTable(@RequestParam("id") Long id) {
        tableService.deleteTable(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得动态表单列")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('dynamic:table:query')")
    public CommonResult<DynamicTableRespVO> getTable(@RequestParam("id") Long id) {
        DynamicTableDO table = tableService.getTable(id);
        return success(DynamicTableConvert.INSTANCE.convert(table));
    }

    @GetMapping("/list")
    @ApiOperation("获得动态表单列列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('dynamic:table:query')")
    public CommonResult<List<DynamicTableRespVO>> getTableList(@RequestParam("ids") Collection<Long> ids) {
        List<DynamicTableDO> list = tableService.getTableList(ids);
        return success(DynamicTableConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得动态表单列分页")
    @PreAuthorize("@ss.hasPermission('dynamic:table:query')")
    public CommonResult<PageResult<DynamicTableRespVO>> getTablePage(@Valid DynamicTablePageReqVO pageVO) {
        PageResult<DynamicTableDO> pageResult = tableService.getTablePage(pageVO);
        return success(DynamicTableConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出动态表单列 Excel")
    @PreAuthorize("@ss.hasPermission('dynamic:table:export')")
    @OperateLog(type = EXPORT)
    public void exportTableExcel(@Valid DynamicTableExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DynamicTableDO> list = tableService.getTableList(exportReqVO);
        // 导出 Excel
        List<DynamicTableExcelVO> datas = DynamicTableConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "动态表单列.xls", "数据", DynamicTableExcelVO.class, datas);
    }


    @PostMapping("/sync")
    @ApiOperation("导出动态表单列 Excel")
    @PreAuthorize("@ss.hasPermission('dynamic:table:export')")
    @OperateLog(type = EXPORT)
    public CommonResult<Void> syncTable(@Valid @RequestBody DynamicTableUpdateReqVO updateReqVO) throws IOException {
//        PageResult<DynamicTableDO> pageResult = tableService.syncTable(updateReqVO);
        return success(null);
    }


}
