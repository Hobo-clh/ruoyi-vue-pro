package cn.iocoder.yudao.module.process.service;

import cn.iocoder.yudao.module.process.dal.ProcessBusinessRelationDO;
import cn.iocoder.yudao.module.process.mapper.ProcessBusinessRelationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * @author Hobo
 * @date 2022/3/8
 */
@Service
public class ProcessBusinessRelationService extends ServiceImpl<ProcessBusinessRelationMapper, ProcessBusinessRelationDO>{
    public Map<Long, ProcessBusinessRelationDO> selectMapByBusiness(Set<Long> idSet, String value) {
        return this.baseMapper.selectMapByBusiness(idSet, value);
    }
}
