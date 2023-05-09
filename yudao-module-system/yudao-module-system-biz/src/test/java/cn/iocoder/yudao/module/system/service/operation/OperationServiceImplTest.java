package cn.iocoder.yudao.module.system.service.operation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.operation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.operation.OperationDO;
import cn.iocoder.yudao.module.system.dal.mysql.operation.OperationMapper;
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
* {@link OperationServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(OperationServiceImpl.class)
public class OperationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private OperationServiceImpl operationService;

    @Resource
    private OperationMapper operationMapper;

    @Test
    public void testCreateOperation_success() {
        // 准备参数
        OperationCreateReqVO reqVO = randomPojo(OperationCreateReqVO.class);

        // 调用
        Long operationId = operationService.createOperation(reqVO);
        // 断言
        assertNotNull(operationId);
        // 校验记录的属性是否正确
        OperationDO operation = operationMapper.selectById(operationId);
        assertPojoEquals(reqVO, operation);
    }

    @Test
    public void testUpdateOperation_success() {
        // mock 数据
        OperationDO dbOperation = randomPojo(OperationDO.class);
        operationMapper.insert(dbOperation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        OperationUpdateReqVO reqVO = randomPojo(OperationUpdateReqVO.class, o -> {
            o.setId(dbOperation.getId()); // 设置更新的 ID
        });

        // 调用
        operationService.updateOperation(reqVO);
        // 校验是否更新正确
        OperationDO operation = operationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, operation);
    }

    @Test
    public void testUpdateOperation_notExists() {
        // 准备参数
        OperationUpdateReqVO reqVO = randomPojo(OperationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> operationService.updateOperation(reqVO), OPERATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteOperation_success() {
        // mock 数据
        OperationDO dbOperation = randomPojo(OperationDO.class);
        operationMapper.insert(dbOperation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbOperation.getId();

        // 调用
        operationService.deleteOperation(id);
       // 校验数据不存在了
       assertNull(operationMapper.selectById(id));
    }

    @Test
    public void testDeleteOperation_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> operationService.deleteOperation(id), OPERATION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOperationPage() {
       // mock 数据
       OperationDO dbOperation = randomPojo(OperationDO.class, o -> { // 等会查询到
           o.setFlowId(null);
           o.setOperatorId(null);
           o.setOperateTime(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       operationMapper.insert(dbOperation);
       // 测试 flowId 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setFlowId(null)));
       // 测试 operatorId 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setOperatorId(null)));
       // 测试 operateTime 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setOperateTime(null)));
       // 测试 remark 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setCreateTime(null)));
       // 准备参数
       OperationPageReqVO reqVO = new OperationPageReqVO();
       reqVO.setFlowId(null);
       reqVO.setOperatorId(null);
       reqVO.setOperateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setRemark(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<OperationDO> pageResult = operationService.getOperationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbOperation, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetOperationList() {
       // mock 数据
       OperationDO dbOperation = randomPojo(OperationDO.class, o -> { // 等会查询到
           o.setFlowId(null);
           o.setOperatorId(null);
           o.setOperateTime(null);
           o.setRemark(null);
           o.setCreateTime(null);
       });
       operationMapper.insert(dbOperation);
       // 测试 flowId 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setFlowId(null)));
       // 测试 operatorId 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setOperatorId(null)));
       // 测试 operateTime 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setOperateTime(null)));
       // 测试 remark 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setRemark(null)));
       // 测试 createTime 不匹配
       operationMapper.insert(cloneIgnoreId(dbOperation, o -> o.setCreateTime(null)));
       // 准备参数
       OperationExportReqVO reqVO = new OperationExportReqVO();
       reqVO.setFlowId(null);
       reqVO.setOperatorId(null);
       reqVO.setOperateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setRemark(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<OperationDO> list = operationService.getOperationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbOperation, list.get(0));
    }

}
