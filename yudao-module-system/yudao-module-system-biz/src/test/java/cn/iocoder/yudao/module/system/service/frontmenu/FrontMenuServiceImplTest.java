package cn.iocoder.yudao.module.system.service.frontmenu;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.frontmenu.FrontMenuDO;
import cn.iocoder.yudao.module.system.dal.mysql.frontmenu.FrontMenuMapper;
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
* {@link FrontMenuServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(FrontMenuServiceImpl.class)
public class FrontMenuServiceImplTest extends BaseDbUnitTest {

    @Resource
    private FrontMenuServiceImpl frontMenuService;

    @Resource
    private FrontMenuMapper frontMenuMapper;

    @Test
    public void testCreateFrontMenu_success() {
        // 准备参数
        FrontMenuCreateReqVO reqVO = randomPojo(FrontMenuCreateReqVO.class);

        // 调用
        Long frontMenuId = frontMenuService.createFrontMenu(reqVO);
        // 断言
        assertNotNull(frontMenuId);
        // 校验记录的属性是否正确
        FrontMenuDO frontMenu = frontMenuMapper.selectById(frontMenuId);
        assertPojoEquals(reqVO, frontMenu);
    }

    @Test
    public void testUpdateFrontMenu_success() {
        // mock 数据
        FrontMenuDO dbFrontMenu = randomPojo(FrontMenuDO.class);
        frontMenuMapper.insert(dbFrontMenu);// @Sql: 先插入出一条存在的数据
        // 准备参数
        FrontMenuUpdateReqVO reqVO = randomPojo(FrontMenuUpdateReqVO.class, o -> {
            o.setId(dbFrontMenu.getId()); // 设置更新的 ID
        });

        // 调用
        frontMenuService.updateFrontMenu(reqVO);
        // 校验是否更新正确
        FrontMenuDO frontMenu = frontMenuMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, frontMenu);
    }

    @Test
    public void testUpdateFrontMenu_notExists() {
        // 准备参数
        FrontMenuUpdateReqVO reqVO = randomPojo(FrontMenuUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> frontMenuService.updateFrontMenu(reqVO), FRONT_MENU_NOT_EXISTS);
    }

    @Test
    public void testDeleteFrontMenu_success() {
        // mock 数据
        FrontMenuDO dbFrontMenu = randomPojo(FrontMenuDO.class);
        frontMenuMapper.insert(dbFrontMenu);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbFrontMenu.getId();

        // 调用
        frontMenuService.deleteFrontMenu(id);
       // 校验数据不存在了
       assertNull(frontMenuMapper.selectById(id));
    }

    @Test
    public void testDeleteFrontMenu_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> frontMenuService.deleteFrontMenu(id), FRONT_MENU_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFrontMenuPage() {
       // mock 数据
       FrontMenuDO dbFrontMenu = randomPojo(FrontMenuDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setPath(null);
           o.setHideInMenu(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setParentKeys(null);
       });
       frontMenuMapper.insert(dbFrontMenu);
       // 测试 name 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setName(null)));
       // 测试 path 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setPath(null)));
       // 测试 hideInMenu 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setHideInMenu(null)));
       // 测试 status 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setCreateTime(null)));
       // 测试 parentKeys 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setParentKeys(null)));
       // 准备参数
       FrontMenuPageReqVO reqVO = new FrontMenuPageReqVO();
       reqVO.setName(null);
       reqVO.setPath(null);
       reqVO.setHideInMenu(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setParentKeys(null);

       // 调用
       PageResult<FrontMenuDO> pageResult = frontMenuService.getFrontMenuPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbFrontMenu, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFrontMenuList() {
       // mock 数据
       FrontMenuDO dbFrontMenu = randomPojo(FrontMenuDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setPath(null);
           o.setHideInMenu(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setParentKeys(null);
       });
       frontMenuMapper.insert(dbFrontMenu);
       // 测试 name 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setName(null)));
       // 测试 path 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setPath(null)));
       // 测试 hideInMenu 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setHideInMenu(null)));
       // 测试 status 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setCreateTime(null)));
       // 测试 parentKeys 不匹配
       frontMenuMapper.insert(cloneIgnoreId(dbFrontMenu, o -> o.setParentKeys(null)));
       // 准备参数
       FrontMenuExportReqVO reqVO = new FrontMenuExportReqVO();
       reqVO.setName(null);
       reqVO.setPath(null);
       reqVO.setHideInMenu(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setParentKeys(null);

       // 调用
       List<FrontMenuDO> list = frontMenuService.getFrontMenuList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbFrontMenu, list.get(0));
    }

}
