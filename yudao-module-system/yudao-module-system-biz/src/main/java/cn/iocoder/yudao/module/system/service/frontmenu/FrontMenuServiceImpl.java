package cn.iocoder.yudao.module.system.service.frontmenu;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.frontmenu.FrontMenuDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.frontmenu.FrontMenuConvert;
import cn.iocoder.yudao.module.system.dal.mysql.frontmenu.FrontMenuMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 前台菜单 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class FrontMenuServiceImpl implements FrontMenuService {

    @Resource
    private FrontMenuMapper frontMenuMapper;

    @Override
    public Long createFrontMenu(FrontMenuCreateReqVO createReqVO) {
        // 插入
        FrontMenuDO frontMenu = FrontMenuConvert.INSTANCE.convert(createReqVO);
        frontMenuMapper.insert(frontMenu);
        // 返回
        return frontMenu.getId();
    }

    @Override
    public void updateFrontMenu(FrontMenuUpdateReqVO updateReqVO) {
        // 校验存在
        validateFrontMenuExists(updateReqVO.getId());
        // 更新
        FrontMenuDO updateObj = FrontMenuConvert.INSTANCE.convert(updateReqVO);
        frontMenuMapper.updateById(updateObj);
    }

    @Override
    public void deleteFrontMenu(Long id) {
        // 校验存在
        validateFrontMenuExists(id);
        // 删除
        frontMenuMapper.deleteById(id);
    }

    private void validateFrontMenuExists(Long id) {
        if (frontMenuMapper.selectById(id) == null) {
            throw exception(FRONT_MENU_NOT_EXISTS);
        }
    }

    @Override
    public FrontMenuDO getFrontMenu(Long id) {
        return frontMenuMapper.selectById(id);
    }

    @Override
    public List<FrontMenuDO> getFrontMenuList(Collection<Long> ids) {
        return frontMenuMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<FrontMenuDO> getFrontMenuPage(FrontMenuPageReqVO pageReqVO) {
        return frontMenuMapper.selectPage(pageReqVO);
    }

    @Override
    public List<FrontMenuDO> getFrontMenuList(FrontMenuExportReqVO exportReqVO) {
        return frontMenuMapper.selectList(exportReqVO);
    }

}
