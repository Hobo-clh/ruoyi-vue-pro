package cn.iocoder.yudao.module.dynamic.convert.hoboTemplateTest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestCreateReqVO;
import cn.iocoder.yudao.module.dynamic.controller.admin.hoboTemplateTest.vo.DynamicHoboTemplateTestRespVO;
import cn.iocoder.yudao.module.dynamic.dal.dataobject.hoboTemplateTest.DynamicHoboTemplateTestDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 1212 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DynamicHoboTemplateTestConvert {

    DynamicHoboTemplateTestConvert INSTANCE = Mappers.getMapper(DynamicHoboTemplateTestConvert.class);

    DynamicHoboTemplateTestDO convert(DynamicHoboTemplateTestCreateReqVO bean);

    DynamicHoboTemplateTestRespVO convert(DynamicHoboTemplateTestDO bean);

    List<DynamicHoboTemplateTestRespVO> convertList(List<DynamicHoboTemplateTestDO> list);

    PageResult<DynamicHoboTemplateTestRespVO> convertPage(PageResult<DynamicHoboTemplateTestDO> page);

}
