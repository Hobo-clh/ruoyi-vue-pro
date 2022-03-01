package cn.iocoder.yudao.module.bpm.service.dynamic;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableExportReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTablePageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableUpdateReqVO;
import cn.iocoder.yudao.module.bpm.convert.dynamic.DynamicTableConvert;
import cn.iocoder.yudao.module.bpm.dal.dataobject.dynamic.DynamicTableDO;
import cn.iocoder.yudao.module.bpm.dal.mysql.dynamic.DynamicTableMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bpm.enums.ErrorCodeConstants.TABLE_NOT_EXISTS;

/**
 * 动态表单列 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DynamicTableServiceImpl implements DynamicTableService {

    @Resource
    private DynamicTableMapper tableMapper;

    @Override
    public Long createTable(DynamicTableCreateReqVO createReqVO) {
        // 插入
        DynamicTableDO table = DynamicTableConvert.INSTANCE.convert(createReqVO);
        tableMapper.insert(table);
        // 返回
        return table.getId();
    }

    @Override
    public void updateTable(DynamicTableUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTableExists(updateReqVO.getId());
        // 更新
        DynamicTableDO updateObj = DynamicTableConvert.INSTANCE.convert(updateReqVO);
        tableMapper.updateById(updateObj);
    }

    @Override
    public void deleteTable(Long id) {
        // 校验存在
        this.validateTableExists(id);
        // 删除
        tableMapper.deleteById(id);
    }

    private void validateTableExists(Long id) {
        if (tableMapper.selectById(id) == null) {
            throw exception(TABLE_NOT_EXISTS);
        }
    }

    @Override
    public DynamicTableDO getTable(Long id) {
        return tableMapper.selectById(id);
    }

    @Override
    public List<DynamicTableDO> getTableList(Collection<Long> ids) {
        return tableMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DynamicTableDO> getTablePage(DynamicTablePageReqVO pageReqVO) {
        return tableMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DynamicTableDO> getTableList(DynamicTableExportReqVO exportReqVO) {
        return tableMapper.selectList(exportReqVO);
    }

}
