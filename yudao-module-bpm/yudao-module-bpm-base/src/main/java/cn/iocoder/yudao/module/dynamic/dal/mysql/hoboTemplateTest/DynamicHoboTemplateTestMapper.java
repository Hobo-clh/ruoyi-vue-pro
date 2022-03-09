package cn.iocoder.yudao.module.dynamic.dal.mysql.hoboTemplateTest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestPageReqVO;
import cn.iocoder.yudao.module.dynamic.dal.dataobject.hoboTemplateTest.DynamicHoboTemplateTestDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 1212 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DynamicHoboTemplateTestMapper extends BaseMapperX<DynamicHoboTemplateTestDO> {

    default PageResult<DynamicHoboTemplateTestDO> selectPage(DynamicHoboTemplateTestPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DynamicHoboTemplateTestDO>()
                .eqIfPresent(DynamicHoboTemplateTestDO::getField101, reqVO.getField101())
                .eqIfPresent(DynamicHoboTemplateTestDO::getField103, reqVO.getField103())
                .eqIfPresent(DynamicHoboTemplateTestDO::getField104, reqVO.getField104())
                .eqIfPresent(DynamicHoboTemplateTestDO::getField105, reqVO.getField105())
                .eqIfPresent(DynamicHoboTemplateTestDO::getResult, reqVO.getResult())
                .eqIfPresent(DynamicHoboTemplateTestDO::getProcessInstanceId, reqVO.getProcessInstanceId())
                .betweenIfPresent(DynamicHoboTemplateTestDO::getCreateTime, reqVO.getBeginCreateTime(), reqVO.getEndCreateTime())
                .eqIfPresent(DynamicHoboTemplateTestDO::getTenantId, reqVO.getTenantId())
                .orderByDesc(DynamicHoboTemplateTestDO::getId));
    }

}
