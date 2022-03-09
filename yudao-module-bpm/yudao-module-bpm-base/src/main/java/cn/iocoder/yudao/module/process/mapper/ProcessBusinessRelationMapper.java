package cn.iocoder.yudao.module.process.mapper;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.process.dal.ProcessBusinessRelationDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 流程与业务表单关联 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProcessBusinessRelationMapper extends BaseMapperX<ProcessBusinessRelationDO> {




    default List<ProcessBusinessRelationDO> selectByBusiness(Collection<Long> businessIds, String businessName) {
        return this.selectList(new LambdaQueryWrapper<ProcessBusinessRelationDO>()
                .in(ProcessBusinessRelationDO::getBusinessId, businessIds)
                .eq(ProcessBusinessRelationDO::getBusinessName, businessName)
        );
    }


    default Map<Long, ProcessBusinessRelationDO> selectMapByBusiness(Collection<Long> businessIds, String businessName) {
        return selectByBusiness(businessIds, businessName).stream()
                .collect(Collectors.toMap(ProcessBusinessRelationDO::getBusinessId, e -> e));
    }



}
