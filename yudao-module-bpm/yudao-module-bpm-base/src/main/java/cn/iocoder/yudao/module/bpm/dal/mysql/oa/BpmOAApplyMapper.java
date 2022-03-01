package cn.iocoder.yudao.module.bpm.dal.mysql.oa;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOAApplyPageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.oa.vo.BpmOALeavePageReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOAApplyDO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.oa.BpmOAApplyDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 请假申请 Mapper
 *
 * @author jason
 * @author 芋道源码
 */
@Mapper
public interface BpmOAApplyMapper extends BaseMapperX<BpmOAApplyDO> {

    default PageResult<BpmOAApplyDO> selectPage(Long userId, BpmOAApplyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmOAApplyDO>()
                .eqIfPresent(BpmOAApplyDO::getUserId, userId)
                .eqIfPresent(BpmOAApplyDO::getResult, reqVO.getResult())
                .eqIfPresent(BpmOAApplyDO::getTime, reqVO.getTime())
                .likeIfPresent(BpmOAApplyDO::getReason, reqVO.getReason())
                .betweenIfPresent(BpmOAApplyDO::getCreateTime, reqVO.getBeginCreateTime(), reqVO.getEndCreateTime())
                .orderByDesc(BpmOAApplyDO::getId));
    }

}
