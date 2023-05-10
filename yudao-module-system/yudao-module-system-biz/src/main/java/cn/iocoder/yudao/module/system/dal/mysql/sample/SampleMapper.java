package cn.iocoder.yudao.module.system.dal.mysql.sample;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.sample.SampleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.sample.vo.*;

/**
 * 样品 Mapper
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface SampleMapper extends BaseMapperX<SampleDO> {

    default PageResult<SampleDO> selectPage(SamplePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SampleDO>()
                .eqIfPresent(SampleDO::getType, reqVO.getType())
                .eqIfPresent(SampleDO::getProcessType, reqVO.getProcessType())
                .eqIfPresent(SampleDO::getUrl, reqVO.getUrl())
                .eqIfPresent(SampleDO::getInformation, reqVO.getInformation())
                .eqIfPresent(SampleDO::getAuditorId, reqVO.getAuditorId())
                .eqIfPresent(SampleDO::getRemark, reqVO.getRemark())
                .eqIfPresent(SampleDO::getModifyRemark, reqVO.getModifyRemark())
                .eqIfPresent(SampleDO::getState, reqVO.getState())
                .betweenIfPresent(SampleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SampleDO::getId));
    }

    default List<SampleDO> selectList(SampleExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SampleDO>()
                .eqIfPresent(SampleDO::getType, reqVO.getType())
                .eqIfPresent(SampleDO::getProcessType, reqVO.getProcessType())
                .eqIfPresent(SampleDO::getUrl, reqVO.getUrl())
                .eqIfPresent(SampleDO::getInformation, reqVO.getInformation())
                .eqIfPresent(SampleDO::getAuditorId, reqVO.getAuditorId())
                .eqIfPresent(SampleDO::getRemark, reqVO.getRemark())
                .eqIfPresent(SampleDO::getModifyRemark, reqVO.getModifyRemark())
                .eqIfPresent(SampleDO::getState, reqVO.getState())
                .betweenIfPresent(SampleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SampleDO::getId));
    }

}
