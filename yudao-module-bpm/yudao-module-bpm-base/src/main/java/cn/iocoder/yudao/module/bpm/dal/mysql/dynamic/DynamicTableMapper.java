package cn.iocoder.yudao.module.bpm.dal.mysql.dynamic;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableExportReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTablePageReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.dynamic.DynamicTableDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 动态表单列 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DynamicTableMapper extends BaseMapperX<DynamicTableDO> {

    default PageResult<DynamicTableDO> selectPage(DynamicTablePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DynamicTableDO>()
                .likeIfPresent(DynamicTableDO::getTableName, reqVO.getTableName())
                .eqIfPresent(DynamicTableDO::getComment, reqVO.getComment())
                .betweenIfPresent(DynamicTableDO::getCreateTime, reqVO.getBeginCreateTime(), reqVO.getEndCreateTime())
                .orderByDesc(DynamicTableDO::getId));
    }

    default List<DynamicTableDO> selectList(DynamicTableExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DynamicTableDO>()
                .likeIfPresent(DynamicTableDO::getTableName, reqVO.getTableName())
                .eqIfPresent(DynamicTableDO::getComment, reqVO.getComment())
                .betweenIfPresent(DynamicTableDO::getCreateTime, reqVO.getBeginCreateTime(), reqVO.getEndCreateTime())
                .orderByDesc(DynamicTableDO::getId));
    }

}
