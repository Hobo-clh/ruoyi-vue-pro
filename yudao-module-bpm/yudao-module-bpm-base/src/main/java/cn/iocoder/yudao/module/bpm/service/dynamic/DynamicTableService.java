package cn.iocoder.yudao.module.bpm.service.dynamic;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableExportReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTablePageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableUpdateReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.dynamic.DynamicTableDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 动态表单列 Service 接口
 *
 * @author 芋道源码
 */
public interface DynamicTableService {

    /**
     * 创建动态表单列
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTable(@Valid DynamicTableCreateReqVO createReqVO);

    /**
     * 更新动态表单列
     *
     * @param updateReqVO 更新信息
     */
    void updateTable(@Valid DynamicTableUpdateReqVO updateReqVO);

    /**
     * 删除动态表单列
     *
     * @param id 编号
     */
    void deleteTable(Long id);

    /**
     * 获得动态表单列
     *
     * @param id 编号
     * @return 动态表单列
     */
    DynamicTableDO getTable(Long id);

    /**
     * 获得动态表单列列表
     *
     * @param ids 编号
     * @return 动态表单列列表
     */
    List<DynamicTableDO> getTableList(Collection<Long> ids);

    /**
     * 获得动态表单列分页
     *
     * @param pageReqVO 分页查询
     * @return 动态表单列分页
     */
    PageResult<DynamicTableDO> getTablePage(DynamicTablePageReqVO pageReqVO);

    /**
     * 获得动态表单列列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 动态表单列列表
     */
    List<DynamicTableDO> getTableList(DynamicTableExportReqVO exportReqVO);

}
