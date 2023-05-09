package cn.iocoder.yudao.module.system.convert.frontmenu;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.frontmenu.FrontMenuDO;

/**
 * 前台菜单 Convert
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface FrontMenuConvert {

    FrontMenuConvert INSTANCE = Mappers.getMapper(FrontMenuConvert.class);

    FrontMenuDO convert(FrontMenuCreateReqVO bean);

    FrontMenuDO convert(FrontMenuUpdateReqVO bean);

    FrontMenuRespVO convert(FrontMenuDO bean);

    List<FrontMenuRespVO> convertList(List<FrontMenuDO> list);

    PageResult<FrontMenuRespVO> convertPage(PageResult<FrontMenuDO> page);

    List<FrontMenuExcelVO> convertList02(List<FrontMenuDO> list);

}
