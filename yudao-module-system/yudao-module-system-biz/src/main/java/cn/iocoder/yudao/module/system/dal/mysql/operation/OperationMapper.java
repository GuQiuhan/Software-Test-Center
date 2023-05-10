package cn.iocoder.yudao.module.system.dal.mysql.operation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.operation.OperationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.operation.vo.*;

/**
 * 流程操作 Mapper
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface OperationMapper extends BaseMapperX<OperationDO> {

    default PageResult<OperationDO> selectPage(OperationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OperationDO>()
                .eqIfPresent(OperationDO::getFlowId, reqVO.getFlowId())
                .eqIfPresent(OperationDO::getOperatorId, reqVO.getOperatorId())
                .betweenIfPresent(OperationDO::getOperateTime, reqVO.getOperateTime())
                .eqIfPresent(OperationDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(OperationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OperationDO::getId));
    }

    default List<OperationDO> selectList(OperationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<OperationDO>()
                .eqIfPresent(OperationDO::getFlowId, reqVO.getFlowId())
                .eqIfPresent(OperationDO::getOperatorId, reqVO.getOperatorId())
                .betweenIfPresent(OperationDO::getOperateTime, reqVO.getOperateTime())
                .eqIfPresent(OperationDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(OperationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(OperationDO::getId));
    }

}
