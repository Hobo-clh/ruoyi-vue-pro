package cn.iocoder.yudao.module.bpm.convert.dynamic;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableExcelVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.dynamic.vo.DynamicTableUpdateReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.dynamic.DynamicTableDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 动态表单列 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DynamicTableConvert {

    DynamicTableConvert INSTANCE = Mappers.getMapper(DynamicTableConvert.class);

    DynamicTableDO convert(DynamicTableCreateReqVO bean);

    DynamicTableDO convert(DynamicTableUpdateReqVO bean);

    DynamicTableRespVO convert(DynamicTableDO bean);

    List<DynamicTableRespVO> convertList(List<DynamicTableDO> list);

    PageResult<DynamicTableRespVO> convertPage(PageResult<DynamicTableDO> page);

    List<DynamicTableExcelVO> convertList02(List<DynamicTableDO> list);

}
