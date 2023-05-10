package cn.iocoder.yudao.module.system.dal.mysql.usercompany;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.usercompany.UserCompanyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.usercompany.vo.*;

/**
 * 用户和公司关联 Mapper
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface UserCompanyMapper extends BaseMapperX<UserCompanyDO> {

    default PageResult<UserCompanyDO> selectPage(UserCompanyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UserCompanyDO>()
                .eqIfPresent(UserCompanyDO::getUserId, reqVO.getUserId())
                .eqIfPresent(UserCompanyDO::getCompanyId, reqVO.getCompanyId())
                .betweenIfPresent(UserCompanyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UserCompanyDO::getId));
    }

    default List<UserCompanyDO> selectList(UserCompanyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<UserCompanyDO>()
                .eqIfPresent(UserCompanyDO::getUserId, reqVO.getUserId())
                .eqIfPresent(UserCompanyDO::getCompanyId, reqVO.getCompanyId())
                .betweenIfPresent(UserCompanyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UserCompanyDO::getId));
    }

}
