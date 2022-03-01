package cn.iocoder.yudao.module.bpm.convert.oa;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyRespVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOAApplyDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 请假申请 Convert
 *
 * @author 芋艿
 */
@Mapper
public interface BpmOAApplyConvert {

    BpmOAApplyConvert INSTANCE = Mappers.getMapper(BpmOAApplyConvert.class);

    BpmOAApplyDO convert(BpmOAApplyCreateReqVO bean);

    BpmOAApplyRespVO convert(BpmOAApplyDO bean);

    List<BpmOAApplyRespVO> convertList(List<BpmOAApplyDO> list);

    PageResult<BpmOAApplyRespVO> convertPage(PageResult<BpmOAApplyDO> page);

}
