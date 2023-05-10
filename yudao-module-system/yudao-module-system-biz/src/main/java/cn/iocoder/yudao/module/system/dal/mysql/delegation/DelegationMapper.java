package cn.iocoder.yudao.module.system.dal.mysql.delegation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.delegation.DelegationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.delegation.vo.*;

/**
 * 委托 Mapper
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface DelegationMapper extends BaseMapperX<DelegationDO> {

    default PageResult<DelegationDO> selectPage(DelegationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DelegationDO>()
                .betweenIfPresent(DelegationDO::getLaunchTime, reqVO.getLaunchTime())
                .eqIfPresent(DelegationDO::getCreatorId, reqVO.getCreatorId())
                .likeIfPresent(DelegationDO::getName, reqVO.getName())
                .eqIfPresent(DelegationDO::getTable2Id, reqVO.getTable2Id())
                .eqIfPresent(DelegationDO::getTable3Id, reqVO.getTable3Id())
                .eqIfPresent(DelegationDO::getUrl, reqVO.getUrl())
                .eqIfPresent(DelegationDO::getMarketDeptStaffId, reqVO.getMarketDeptStaffId())
                .eqIfPresent(DelegationDO::getTestingDeptStaffId, reqVO.getTestingDeptStaffId())
                .eqIfPresent(DelegationDO::getMarketRemark, reqVO.getMarketRemark())
                .eqIfPresent(DelegationDO::getTestingRemark, reqVO.getTestingRemark())
                .eqIfPresent(DelegationDO::getTable14Id, reqVO.getTable14Id())
                .eqIfPresent(DelegationDO::getOfferId, reqVO.getOfferId())
                .eqIfPresent(DelegationDO::getOfferRemark, reqVO.getOfferRemark())
                .eqIfPresent(DelegationDO::getContractId, reqVO.getContractId())
                .eqIfPresent(DelegationDO::getSampleId, reqVO.getSampleId())
                .eqIfPresent(DelegationDO::getSolutionId, reqVO.getSolutionId())
                .eqIfPresent(DelegationDO::getReportId, reqVO.getReportId())
                .eqIfPresent(DelegationDO::getState, reqVO.getState())
                .eqIfPresent(DelegationDO::getCancelRemark, reqVO.getCancelRemark())
                .betweenIfPresent(DelegationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(DelegationDO::getTable12Id, reqVO.getTable12Id())
                .eqIfPresent(DelegationDO::getProjectId, reqVO.getProjectId())
                .orderByDesc(DelegationDO::getId));
    }

    default List<DelegationDO> selectList(DelegationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DelegationDO>()
                .betweenIfPresent(DelegationDO::getLaunchTime, reqVO.getLaunchTime())
                .eqIfPresent(DelegationDO::getCreatorId, reqVO.getCreatorId())
                .likeIfPresent(DelegationDO::getName, reqVO.getName())
                .eqIfPresent(DelegationDO::getTable2Id, reqVO.getTable2Id())
                .eqIfPresent(DelegationDO::getTable3Id, reqVO.getTable3Id())
                .eqIfPresent(DelegationDO::getUrl, reqVO.getUrl())
                .eqIfPresent(DelegationDO::getMarketDeptStaffId, reqVO.getMarketDeptStaffId())
                .eqIfPresent(DelegationDO::getTestingDeptStaffId, reqVO.getTestingDeptStaffId())
                .eqIfPresent(DelegationDO::getMarketRemark, reqVO.getMarketRemark())
                .eqIfPresent(DelegationDO::getTestingRemark, reqVO.getTestingRemark())
                .eqIfPresent(DelegationDO::getTable14Id, reqVO.getTable14Id())
                .eqIfPresent(DelegationDO::getOfferId, reqVO.getOfferId())
                .eqIfPresent(DelegationDO::getOfferRemark, reqVO.getOfferRemark())
                .eqIfPresent(DelegationDO::getContractId, reqVO.getContractId())
                .eqIfPresent(DelegationDO::getSampleId, reqVO.getSampleId())
                .eqIfPresent(DelegationDO::getSolutionId, reqVO.getSolutionId())
                .eqIfPresent(DelegationDO::getReportId, reqVO.getReportId())
                .eqIfPresent(DelegationDO::getState, reqVO.getState())
                .eqIfPresent(DelegationDO::getCancelRemark, reqVO.getCancelRemark())
                .betweenIfPresent(DelegationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(DelegationDO::getTable12Id, reqVO.getTable12Id())
                .eqIfPresent(DelegationDO::getProjectId, reqVO.getProjectId())
                .orderByDesc(DelegationDO::getId));
    }

}
