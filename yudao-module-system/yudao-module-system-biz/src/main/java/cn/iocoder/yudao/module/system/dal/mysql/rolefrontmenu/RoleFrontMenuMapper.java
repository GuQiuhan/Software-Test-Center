package cn.iocoder.yudao.module.system.dal.mysql.rolefrontmenu;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.rolefrontmenu.RoleFrontMenuDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo.*;

/**
 * 角色前台菜单 Mapper
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface RoleFrontMenuMapper extends BaseMapperX<RoleFrontMenuDO> {

    default PageResult<RoleFrontMenuDO> selectPage(RoleFrontMenuPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RoleFrontMenuDO>()
                .eqIfPresent(RoleFrontMenuDO::getRoleId, reqVO.getRoleId())
                .eqIfPresent(RoleFrontMenuDO::getFrontMenuId, reqVO.getFrontMenuId())
                .betweenIfPresent(RoleFrontMenuDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RoleFrontMenuDO::getId));
    }

    default List<RoleFrontMenuDO> selectList(RoleFrontMenuExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<RoleFrontMenuDO>()
                .eqIfPresent(RoleFrontMenuDO::getRoleId, reqVO.getRoleId())
                .eqIfPresent(RoleFrontMenuDO::getFrontMenuId, reqVO.getFrontMenuId())
                .betweenIfPresent(RoleFrontMenuDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RoleFrontMenuDO::getId));
    }

}
