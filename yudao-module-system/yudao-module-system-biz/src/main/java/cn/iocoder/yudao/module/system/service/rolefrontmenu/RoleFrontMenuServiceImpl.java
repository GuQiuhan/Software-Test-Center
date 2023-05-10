package cn.iocoder.yudao.module.system.service.rolefrontmenu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.rolefrontmenu.RoleFrontMenuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.rolefrontmenu.RoleFrontMenuConvert;
import cn.iocoder.yudao.module.system.dal.mysql.rolefrontmenu.RoleFrontMenuMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 角色前台菜单 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class RoleFrontMenuServiceImpl implements RoleFrontMenuService {

    @Resource
    private RoleFrontMenuMapper roleFrontMenuMapper;

    @Override
    public Long createRoleFrontMenu(RoleFrontMenuCreateReqVO createReqVO) {
        // 插入
        RoleFrontMenuDO roleFrontMenu = RoleFrontMenuConvert.INSTANCE.convert(createReqVO);
        roleFrontMenuMapper.insert(roleFrontMenu);
        // 返回
        return roleFrontMenu.getId();
    }

    @Override
    public void updateRoleFrontMenu(RoleFrontMenuUpdateReqVO updateReqVO) {
        // 校验存在
        validateRoleFrontMenuExists(updateReqVO.getId());
        // 更新
        RoleFrontMenuDO updateObj = RoleFrontMenuConvert.INSTANCE.convert(updateReqVO);
        roleFrontMenuMapper.updateById(updateObj);
    }

    @Override
    public void deleteRoleFrontMenu(Long id) {
        // 校验存在
        validateRoleFrontMenuExists(id);
        // 删除
        roleFrontMenuMapper.deleteById(id);
    }

    private void validateRoleFrontMenuExists(Long id) {
        if (roleFrontMenuMapper.selectById(id) == null) {
            throw exception(ROLE_FRONT_MENU_NOT_EXISTS);
        }
    }

    @Override
    public RoleFrontMenuDO getRoleFrontMenu(Long id) {
        return roleFrontMenuMapper.selectById(id);
    }

    @Override
    public List<RoleFrontMenuDO> getRoleFrontMenuList(Collection<Long> ids) {
        return roleFrontMenuMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<RoleFrontMenuDO> getRoleFrontMenuPage(RoleFrontMenuPageReqVO pageReqVO) {
        return roleFrontMenuMapper.selectPage(pageReqVO);
    }

    @Override
    public List<RoleFrontMenuDO> getRoleFrontMenuList(RoleFrontMenuExportReqVO exportReqVO) {
        return roleFrontMenuMapper.selectList(exportReqVO);
    }

}
