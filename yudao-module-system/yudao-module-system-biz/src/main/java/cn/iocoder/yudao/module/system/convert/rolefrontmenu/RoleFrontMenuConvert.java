package cn.iocoder.yudao.module.system.convert.rolefrontmenu;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.rolefrontmenu.RoleFrontMenuDO;

/**
 * 角色前台菜单 Convert
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface RoleFrontMenuConvert {

    RoleFrontMenuConvert INSTANCE = Mappers.getMapper(RoleFrontMenuConvert.class);

    RoleFrontMenuDO convert(RoleFrontMenuCreateReqVO bean);

    RoleFrontMenuDO convert(RoleFrontMenuUpdateReqVO bean);

    RoleFrontMenuRespVO convert(RoleFrontMenuDO bean);

    List<RoleFrontMenuRespVO> convertList(List<RoleFrontMenuDO> list);

    PageResult<RoleFrontMenuRespVO> convertPage(PageResult<RoleFrontMenuDO> page);

    List<RoleFrontMenuExcelVO> convertList02(List<RoleFrontMenuDO> list);

}
