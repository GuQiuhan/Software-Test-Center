package cn.iocoder.yudao.module.system.service.rolefrontmenu;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.rolefrontmenu.RoleFrontMenuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 角色前台菜单 Service 接口
 *
 * @author NJU_Test_Center
 */
public interface RoleFrontMenuService {

    /**
     * 创建角色前台菜单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRoleFrontMenu(@Valid RoleFrontMenuCreateReqVO createReqVO);

    /**
     * 更新角色前台菜单
     *
     * @param updateReqVO 更新信息
     */
    void updateRoleFrontMenu(@Valid RoleFrontMenuUpdateReqVO updateReqVO);

    /**
     * 删除角色前台菜单
     *
     * @param id 编号
     */
    void deleteRoleFrontMenu(Long id);

    /**
     * 获得角色前台菜单
     *
     * @param id 编号
     * @return 角色前台菜单
     */
    RoleFrontMenuDO getRoleFrontMenu(Long id);

    /**
     * 获得角色前台菜单列表
     *
     * @param ids 编号
     * @return 角色前台菜单列表
     */
    List<RoleFrontMenuDO> getRoleFrontMenuList(Collection<Long> ids);

    /**
     * 获得角色前台菜单分页
     *
     * @param pageReqVO 分页查询
     * @return 角色前台菜单分页
     */
    PageResult<RoleFrontMenuDO> getRoleFrontMenuPage(RoleFrontMenuPageReqVO pageReqVO);

    /**
     * 获得角色前台菜单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 角色前台菜单列表
     */
    List<RoleFrontMenuDO> getRoleFrontMenuList(RoleFrontMenuExportReqVO exportReqVO);

}
