package cn.iocoder.yudao.module.system.service.solution;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.solution.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.solution.SolutionDO;
import cn.iocoder.yudao.module.system.dal.mysql.solution.SolutionMapper;
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
* {@link SolutionServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(SolutionServiceImpl.class)
public class SolutionServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SolutionServiceImpl solutionService;

    @Resource
    private SolutionMapper solutionMapper;

    @Test
    public void testCreateSolution_success() {
        // 准备参数
        SolutionCreateReqVO reqVO = randomPojo(SolutionCreateReqVO.class);

        // 调用
        Long solutionId = solutionService.createSolution(reqVO);
        // 断言
        assertNotNull(solutionId);
        // 校验记录的属性是否正确
        SolutionDO solution = solutionMapper.selectById(solutionId);
        assertPojoEquals(reqVO, solution);
    }

    @Test
    public void testUpdateSolution_success() {
        // mock 数据
        SolutionDO dbSolution = randomPojo(SolutionDO.class);
        solutionMapper.insert(dbSolution);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SolutionUpdateReqVO reqVO = randomPojo(SolutionUpdateReqVO.class, o -> {
            o.setId(dbSolution.getId()); // 设置更新的 ID
        });

        // 调用
        solutionService.updateSolution(reqVO);
        // 校验是否更新正确
        SolutionDO solution = solutionMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, solution);
    }

    @Test
    public void testUpdateSolution_notExists() {
        // 准备参数
        SolutionUpdateReqVO reqVO = randomPojo(SolutionUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> solutionService.updateSolution(reqVO), SOLUTION_NOT_EXISTS);
    }

    @Test
    public void testDeleteSolution_success() {
        // mock 数据
        SolutionDO dbSolution = randomPojo(SolutionDO.class);
        solutionMapper.insert(dbSolution);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSolution.getId();

        // 调用
        solutionService.deleteSolution(id);
       // 校验数据不存在了
       assertNull(solutionMapper.selectById(id));
    }

    @Test
    public void testDeleteSolution_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> solutionService.deleteSolution(id), SOLUTION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSolutionPage() {
       // mock 数据
       SolutionDO dbSolution = randomPojo(SolutionDO.class, o -> { // 等会查询到
           o.setTable6Id(null);
           o.setAuditorId(null);
           o.setTable13Id(null);
           o.setCreateTime(null);
       });
       solutionMapper.insert(dbSolution);
       // 测试 table6Id 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setTable6Id(null)));
       // 测试 auditorId 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setAuditorId(null)));
       // 测试 table13Id 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setTable13Id(null)));
       // 测试 createTime 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setCreateTime(null)));
       // 准备参数
       SolutionPageReqVO reqVO = new SolutionPageReqVO();
       reqVO.setTable6Id(null);
       reqVO.setAuditorId(null);
       reqVO.setTable13Id(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<SolutionDO> pageResult = solutionService.getSolutionPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSolution, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSolutionList() {
       // mock 数据
       SolutionDO dbSolution = randomPojo(SolutionDO.class, o -> { // 等会查询到
           o.setTable6Id(null);
           o.setAuditorId(null);
           o.setTable13Id(null);
           o.setCreateTime(null);
       });
       solutionMapper.insert(dbSolution);
       // 测试 table6Id 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setTable6Id(null)));
       // 测试 auditorId 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setAuditorId(null)));
       // 测试 table13Id 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setTable13Id(null)));
       // 测试 createTime 不匹配
       solutionMapper.insert(cloneIgnoreId(dbSolution, o -> o.setCreateTime(null)));
       // 准备参数
       SolutionExportReqVO reqVO = new SolutionExportReqVO();
       reqVO.setTable6Id(null);
       reqVO.setAuditorId(null);
       reqVO.setTable13Id(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<SolutionDO> list = solutionService.getSolutionList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSolution, list.get(0));
    }

}
