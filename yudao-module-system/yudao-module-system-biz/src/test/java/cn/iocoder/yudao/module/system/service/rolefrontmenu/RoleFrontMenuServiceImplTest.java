package cn.iocoder.yudao.module.system.service.rolefrontmenu;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.rolefrontmenu.RoleFrontMenuDO;
import cn.iocoder.yudao.module.system.dal.mysql.rolefrontmenu.RoleFrontMenuMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link RoleFrontMenuServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(RoleFrontMenuServiceImpl.class)
public class RoleFrontMenuServiceImplTest extends BaseDbUnitTest {

    @Resource
    private RoleFrontMenuServiceImpl roleFrontMenuService;

    @Resource
    private RoleFrontMenuMapper roleFrontMenuMapper;

    @Test
    public void testCreateRoleFrontMenu_success() {
        // 准备参数
        RoleFrontMenuCreateReqVO reqVO = randomPojo(RoleFrontMenuCreateReqVO.class);

        // 调用
        Long roleFrontMenuId = roleFrontMenuService.createRoleFrontMenu(reqVO);
        // 断言
        assertNotNull(roleFrontMenuId);
        // 校验记录的属性是否正确
        RoleFrontMenuDO roleFrontMenu = roleFrontMenuMapper.selectById(roleFrontMenuId);
        assertPojoEquals(reqVO, roleFrontMenu);
    }

    @Test
    public void testUpdateRoleFrontMenu_success() {
        // mock 数据
        RoleFrontMenuDO dbRoleFrontMenu = randomPojo(RoleFrontMenuDO.class);
        roleFrontMenuMapper.insert(dbRoleFrontMenu);// @Sql: 先插入出一条存在的数据
        // 准备参数
        RoleFrontMenuUpdateReqVO reqVO = randomPojo(RoleFrontMenuUpdateReqVO.class, o -> {
            o.setId(dbRoleFrontMenu.getId()); // 设置更新的 ID
        });

        // 调用
        roleFrontMenuService.updateRoleFrontMenu(reqVO);
        // 校验是否更新正确
        RoleFrontMenuDO roleFrontMenu = roleFrontMenuMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, roleFrontMenu);
    }

    @Test
    public void testUpdateRoleFrontMenu_notExists() {
        // 准备参数
        RoleFrontMenuUpdateReqVO reqVO = randomPojo(RoleFrontMenuUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> roleFrontMenuService.updateRoleFrontMenu(reqVO), ROLE_FRONT_MENU_NOT_EXISTS);
    }

    @Test
    public void testDeleteRoleFrontMenu_success() {
        // mock 数据
        RoleFrontMenuDO dbRoleFrontMenu = randomPojo(RoleFrontMenuDO.class);
        roleFrontMenuMapper.insert(dbRoleFrontMenu);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbRoleFrontMenu.getId();

        // 调用
        roleFrontMenuService.deleteRoleFrontMenu(id);
       // 校验数据不存在了
       assertNull(roleFrontMenuMapper.selectById(id));
    }

    @Test
    public void testDeleteRoleFrontMenu_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> roleFrontMenuService.deleteRoleFrontMenu(id), ROLE_FRONT_MENU_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRoleFrontMenuPage() {
       // mock 数据
       RoleFrontMenuDO dbRoleFrontMenu = randomPojo(RoleFrontMenuDO.class, o -> { // 等会查询到
           o.setRoleId(null);
           o.setFrontMenuId(null);
           o.setCreateTime(null);
       });
       roleFrontMenuMapper.insert(dbRoleFrontMenu);
       // 测试 roleId 不匹配
       roleFrontMenuMapper.insert(cloneIgnoreId(dbRoleFrontMenu, o -> o.setRoleId(null)));
       // 测试 frontMenuId 不匹配
       roleFrontMenuMapper.insert(cloneIgnoreId(dbRoleFrontMenu, o -> o.setFrontMenuId(null)));
       // 测试 createTime 不匹配
       roleFrontMenuMapper.insert(cloneIgnoreId(dbRoleFrontMenu, o -> o.setCreateTime(null)));
       // 准备参数
       RoleFrontMenuPageReqVO reqVO = new RoleFrontMenuPageReqVO();
       reqVO.setRoleId(null);
       reqVO.setFrontMenuId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<RoleFrontMenuDO> pageResult = roleFrontMenuService.getRoleFrontMenuPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbRoleFrontMenu, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetRoleFrontMenuList() {
       // mock 数据
       RoleFrontMenuDO dbRoleFrontMenu = randomPojo(RoleFrontMenuDO.class, o -> { // 等会查询到
           o.setRoleId(null);
           o.setFrontMenuId(null);
           o.setCreateTime(null);
       });
       roleFrontMenuMapper.insert(dbRoleFrontMenu);
       // 测试 roleId 不匹配
       roleFrontMenuMapper.insert(cloneIgnoreId(dbRoleFrontMenu, o -> o.setRoleId(null)));
       // 测试 frontMenuId 不匹配
       roleFrontMenuMapper.insert(cloneIgnoreId(dbRoleFrontMenu, o -> o.setFrontMenuId(null)));
       // 测试 createTime 不匹配
       roleFrontMenuMapper.insert(cloneIgnoreId(dbRoleFrontMenu, o -> o.setCreateTime(null)));
       // 准备参数
       RoleFrontMenuExportReqVO reqVO = new RoleFrontMenuExportReqVO();
       reqVO.setRoleId(null);
       reqVO.setFrontMenuId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<RoleFrontMenuDO> list = roleFrontMenuService.getRoleFrontMenuList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbRoleFrontMenu, list.get(0));
    }

}
