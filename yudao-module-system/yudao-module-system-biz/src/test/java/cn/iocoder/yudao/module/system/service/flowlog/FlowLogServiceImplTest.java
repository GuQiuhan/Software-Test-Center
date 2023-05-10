package cn.iocoder.yudao.module.system.service.flowlog;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.flowlog.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowlog.FlowLogDO;
import cn.iocoder.yudao.module.system.dal.mysql.flowlog.FlowLogMapper;
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
* {@link FlowLogServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(FlowLogServiceImpl.class)
public class FlowLogServiceImplTest extends BaseDbUnitTest {

    @Resource
    private FlowLogServiceImpl flowLogService;

    @Resource
    private FlowLogMapper flowLogMapper;

    @Test
    public void testCreateFlowLog_success() {
        // 准备参数
        FlowLogCreateReqVO reqVO = randomPojo(FlowLogCreateReqVO.class);

        // 调用
        Long flowLogId = flowLogService.createFlowLog(reqVO);
        // 断言
        assertNotNull(flowLogId);
        // 校验记录的属性是否正确
        FlowLogDO flowLog = flowLogMapper.selectById(flowLogId);
        assertPojoEquals(reqVO, flowLog);
    }

    @Test
    public void testUpdateFlowLog_success() {
        // mock 数据
        FlowLogDO dbFlowLog = randomPojo(FlowLogDO.class);
        flowLogMapper.insert(dbFlowLog);// @Sql: 先插入出一条存在的数据
        // 准备参数
        FlowLogUpdateReqVO reqVO = randomPojo(FlowLogUpdateReqVO.class, o -> {
            o.setId(dbFlowLog.getId()); // 设置更新的 ID
        });

        // 调用
        flowLogService.updateFlowLog(reqVO);
        // 校验是否更新正确
        FlowLogDO flowLog = flowLogMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, flowLog);
    }

    @Test
    public void testUpdateFlowLog_notExists() {
        // 准备参数
        FlowLogUpdateReqVO reqVO = randomPojo(FlowLogUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> flowLogService.updateFlowLog(reqVO), FLOW_LOG_NOT_EXISTS);
    }

    @Test
    public void testDeleteFlowLog_success() {
        // mock 数据
        FlowLogDO dbFlowLog = randomPojo(FlowLogDO.class);
        flowLogMapper.insert(dbFlowLog);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbFlowLog.getId();

        // 调用
        flowLogService.deleteFlowLog(id);
       // 校验数据不存在了
       assertNull(flowLogMapper.selectById(id));
    }

    @Test
    public void testDeleteFlowLog_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> flowLogService.deleteFlowLog(id), FLOW_LOG_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFlowLogPage() {
       // mock 数据
       FlowLogDO dbFlowLog = randomPojo(FlowLogDO.class, o -> { // 等会查询到
           o.setDelegationId(null);
           o.setToState(null);
           o.setOperatorId(null);
           o.setOperateTime(null);
           o.setRemark(null);
           o.setMapValue(null);
           o.setCreateTime(null);
           o.setFromState(null);
       });
       flowLogMapper.insert(dbFlowLog);
       // 测试 delegationId 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setDelegationId(null)));
       // 测试 toState 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setToState(null)));
       // 测试 operatorId 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setOperatorId(null)));
       // 测试 operateTime 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setOperateTime(null)));
       // 测试 remark 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setRemark(null)));
       // 测试 mapValue 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setMapValue(null)));
       // 测试 createTime 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setCreateTime(null)));
       // 测试 fromState 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setFromState(null)));
       // 准备参数
       FlowLogPageReqVO reqVO = new FlowLogPageReqVO();
       reqVO.setDelegationId(null);
       reqVO.setToState(null);
       reqVO.setOperatorId(null);
       reqVO.setOperateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setRemark(null);
       reqVO.setMapValue(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setFromState(null);

       // 调用
       PageResult<FlowLogDO> pageResult = flowLogService.getFlowLogPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbFlowLog, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetFlowLogList() {
       // mock 数据
       FlowLogDO dbFlowLog = randomPojo(FlowLogDO.class, o -> { // 等会查询到
           o.setDelegationId(null);
           o.setToState(null);
           o.setOperatorId(null);
           o.setOperateTime(null);
           o.setRemark(null);
           o.setMapValue(null);
           o.setCreateTime(null);
           o.setFromState(null);
       });
       flowLogMapper.insert(dbFlowLog);
       // 测试 delegationId 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setDelegationId(null)));
       // 测试 toState 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setToState(null)));
       // 测试 operatorId 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setOperatorId(null)));
       // 测试 operateTime 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setOperateTime(null)));
       // 测试 remark 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setRemark(null)));
       // 测试 mapValue 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setMapValue(null)));
       // 测试 createTime 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setCreateTime(null)));
       // 测试 fromState 不匹配
       flowLogMapper.insert(cloneIgnoreId(dbFlowLog, o -> o.setFromState(null)));
       // 准备参数
       FlowLogExportReqVO reqVO = new FlowLogExportReqVO();
       reqVO.setDelegationId(null);
       reqVO.setToState(null);
       reqVO.setOperatorId(null);
       reqVO.setOperateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setRemark(null);
       reqVO.setMapValue(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setFromState(null);

       // 调用
       List<FlowLogDO> list = flowLogService.getFlowLogList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbFlowLog, list.get(0));
    }

}
