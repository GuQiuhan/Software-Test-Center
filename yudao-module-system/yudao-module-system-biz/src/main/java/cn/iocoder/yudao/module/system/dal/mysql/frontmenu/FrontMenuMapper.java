package cn.iocoder.yudao.module.system.dal.mysql.frontmenu;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.frontmenu.FrontMenuDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo.*;

/**
 * 前台菜单 Mapper
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface FrontMenuMapper extends BaseMapperX<FrontMenuDO> {

    default PageResult<FrontMenuDO> selectPage(FrontMenuPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FrontMenuDO>()
                .likeIfPresent(FrontMenuDO::getName, reqVO.getName())
                .eqIfPresent(FrontMenuDO::getPath, reqVO.getPath())
                .eqIfPresent(FrontMenuDO::getHideInMenu, reqVO.getHideInMenu())
                .eqIfPresent(FrontMenuDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(FrontMenuDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(FrontMenuDO::getParentKeys, reqVO.getParentKeys())
                .orderByDesc(FrontMenuDO::getId));
    }

    default List<FrontMenuDO> selectList(FrontMenuExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<FrontMenuDO>()
                .likeIfPresent(FrontMenuDO::getName, reqVO.getName())
                .eqIfPresent(FrontMenuDO::getPath, reqVO.getPath())
                .eqIfPresent(FrontMenuDO::getHideInMenu, reqVO.getHideInMenu())
                .eqIfPresent(FrontMenuDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(FrontMenuDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(FrontMenuDO::getParentKeys, reqVO.getParentKeys())
                .orderByDesc(FrontMenuDO::getId));
    }

}
