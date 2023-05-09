package cn.iocoder.yudao.module.system.dal.mysql.flowlog;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.flowlog.FlowLogDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.flowlog.vo.*;

/**
 * 流程日志 Mapper
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface FlowLogMapper extends BaseMapperX<FlowLogDO> {

    default PageResult<FlowLogDO> selectPage(FlowLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FlowLogDO>()
                .eqIfPresent(FlowLogDO::getDelegationId, reqVO.getDelegationId())
                .eqIfPresent(FlowLogDO::getToState, reqVO.getToState())
                .eqIfPresent(FlowLogDO::getOperatorId, reqVO.getOperatorId())
                .betweenIfPresent(FlowLogDO::getOperateTime, reqVO.getOperateTime())
                .eqIfPresent(FlowLogDO::getRemark, reqVO.getRemark())
                .eqIfPresent(FlowLogDO::getMapValue, reqVO.getMapValue())
                .betweenIfPresent(FlowLogDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(FlowLogDO::getFromState, reqVO.getFromState())
                .orderByDesc(FlowLogDO::getId));
    }

    default List<FlowLogDO> selectList(FlowLogExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<FlowLogDO>()
                .eqIfPresent(FlowLogDO::getDelegationId, reqVO.getDelegationId())
                .eqIfPresent(FlowLogDO::getToState, reqVO.getToState())
                .eqIfPresent(FlowLogDO::getOperatorId, reqVO.getOperatorId())
                .betweenIfPresent(FlowLogDO::getOperateTime, reqVO.getOperateTime())
                .eqIfPresent(FlowLogDO::getRemark, reqVO.getRemark())
                .eqIfPresent(FlowLogDO::getMapValue, reqVO.getMapValue())
                .betweenIfPresent(FlowLogDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(FlowLogDO::getFromState, reqVO.getFromState())
                .orderByDesc(FlowLogDO::getId));
    }

}
