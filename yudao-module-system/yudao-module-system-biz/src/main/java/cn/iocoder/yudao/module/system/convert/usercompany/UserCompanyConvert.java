package cn.iocoder.yudao.module.system.convert.usercompany;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.usercompany.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.usercompany.UserCompanyDO;

/**
 * 用户和公司关联 Convert
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface UserCompanyConvert {

    UserCompanyConvert INSTANCE = Mappers.getMapper(UserCompanyConvert.class);

    UserCompanyDO convert(UserCompanyCreateReqVO bean);

    UserCompanyDO convert(UserCompanyUpdateReqVO bean);

    UserCompanyRespVO convert(UserCompanyDO bean);

    List<UserCompanyRespVO> convertList(List<UserCompanyDO> list);

    PageResult<UserCompanyRespVO> convertPage(PageResult<UserCompanyDO> page);

    List<UserCompanyExcelVO> convertList02(List<UserCompanyDO> list);

}
