package cn.iocoder.yudao.module.system.service.delegation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.delegation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.delegation.DelegationDO;
import cn.iocoder.yudao.module.system.dal.mysql.delegation.DelegationMapper;
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
* {@link DelegationServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(DelegationServiceImpl.class)
public class DelegationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DelegationServiceImpl delegationService;

    @Resource
    private DelegationMapper delegationMapper;

    @Test
    public void testCreateDelegation_success() {
        // 准备参数
        DelegationCreateReqVO reqVO = randomPojo(DelegationCreateReqVO.class);

        // 调用
        Long delegationId = delegationService.createDelegation(reqVO);
        // 断言
        assertNotNull(delegationId);
        // 校验记录的属性是否正确
        DelegationDO delegation = delegationMapper.selectById(delegationId);
        assertPojoEquals(reqVO, delegation);
    }

    @Test
    public void testUpdateDelegation_success() {
        // mock 数据
        DelegationDO dbDelegation = randomPojo(DelegationDO.class);
        delegationMapper.insert(dbDelegation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DelegationUpdateReqVO reqVO = randomPojo(DelegationUpdateReqVO.class, o -> {
            o.setId(dbDelegation.getId()); // 设置更新的 ID
        });

        // 调用
        delegationService.updateDelegation(reqVO);
        // 校验是否更新正确
        DelegationDO delegation = delegationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, delegation);
    }

    @Test
    public void testUpdateDelegation_notExists() {
        // 准备参数
        DelegationUpdateReqVO reqVO = randomPojo(DelegationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> delegationService.updateDelegation(reqVO), DELEGATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteDelegation_success() {
        // mock 数据
        DelegationDO dbDelegation = randomPojo(DelegationDO.class);
        delegationMapper.insert(dbDelegation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbDelegation.getId();

        // 调用
        delegationService.deleteDelegation(id);
       // 校验数据不存在了
       assertNull(delegationMapper.selectById(id));
    }

    @Test
    public void testDeleteDelegation_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> delegationService.deleteDelegation(id), DELEGATION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDelegationPage() {
       // mock 数据
       DelegationDO dbDelegation = randomPojo(DelegationDO.class, o -> { // 等会查询到
           o.setLaunchTime(null);
           o.setCreatorId(null);
           o.setName(null);
           o.setTable2Id(null);
           o.setTable3Id(null);
           o.setUrl(null);
           o.setMarketDeptStaffId(null);
           o.setTestingDeptStaffId(null);
           o.setMarketRemark(null);
           o.setTestingRemark(null);
           o.setTable14Id(null);
           o.setOfferId(null);
           o.setOfferRemark(null);
           o.setContractId(null);
           o.setSampleId(null);
           o.setSolutionId(null);
           o.setReportId(null);
           o.setState(null);
           o.setCancelRemark(null);
           o.setCreateTime(null);
           o.setTable12Id(null);
           o.setProjectId(null);
       });
       delegationMapper.insert(dbDelegation);
       // 测试 launchTime 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setLaunchTime(null)));
       // 测试 creatorId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setCreatorId(null)));
       // 测试 name 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setName(null)));
       // 测试 table2Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable2Id(null)));
       // 测试 table3Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable3Id(null)));
       // 测试 url 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setUrl(null)));
       // 测试 marketDeptStaffId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setMarketDeptStaffId(null)));
       // 测试 testingDeptStaffId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTestingDeptStaffId(null)));
       // 测试 marketRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setMarketRemark(null)));
       // 测试 testingRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTestingRemark(null)));
       // 测试 table14Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable14Id(null)));
       // 测试 offerId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setOfferId(null)));
       // 测试 offerRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setOfferRemark(null)));
       // 测试 contractId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setContractId(null)));
       // 测试 sampleId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setSampleId(null)));
       // 测试 solutionId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setSolutionId(null)));
       // 测试 reportId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setReportId(null)));
       // 测试 state 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setState(null)));
       // 测试 cancelRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setCancelRemark(null)));
       // 测试 createTime 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setCreateTime(null)));
       // 测试 table12Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable12Id(null)));
       // 测试 projectId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setProjectId(null)));
       // 准备参数
       DelegationPageReqVO reqVO = new DelegationPageReqVO();
       reqVO.setLaunchTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setCreatorId(null);
       reqVO.setName(null);
       reqVO.setTable2Id(null);
       reqVO.setTable3Id(null);
       reqVO.setUrl(null);
       reqVO.setMarketDeptStaffId(null);
       reqVO.setTestingDeptStaffId(null);
       reqVO.setMarketRemark(null);
       reqVO.setTestingRemark(null);
       reqVO.setTable14Id(null);
       reqVO.setOfferId(null);
       reqVO.setOfferRemark(null);
       reqVO.setContractId(null);
       reqVO.setSampleId(null);
       reqVO.setSolutionId(null);
       reqVO.setReportId(null);
       reqVO.setState(null);
       reqVO.setCancelRemark(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setTable12Id(null);
       reqVO.setProjectId(null);

       // 调用
       PageResult<DelegationDO> pageResult = delegationService.getDelegationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDelegation, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDelegationList() {
       // mock 数据
       DelegationDO dbDelegation = randomPojo(DelegationDO.class, o -> { // 等会查询到
           o.setLaunchTime(null);
           o.setCreatorId(null);
           o.setName(null);
           o.setTable2Id(null);
           o.setTable3Id(null);
           o.setUrl(null);
           o.setMarketDeptStaffId(null);
           o.setTestingDeptStaffId(null);
           o.setMarketRemark(null);
           o.setTestingRemark(null);
           o.setTable14Id(null);
           o.setOfferId(null);
           o.setOfferRemark(null);
           o.setContractId(null);
           o.setSampleId(null);
           o.setSolutionId(null);
           o.setReportId(null);
           o.setState(null);
           o.setCancelRemark(null);
           o.setCreateTime(null);
           o.setTable12Id(null);
           o.setProjectId(null);
       });
       delegationMapper.insert(dbDelegation);
       // 测试 launchTime 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setLaunchTime(null)));
       // 测试 creatorId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setCreatorId(null)));
       // 测试 name 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setName(null)));
       // 测试 table2Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable2Id(null)));
       // 测试 table3Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable3Id(null)));
       // 测试 url 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setUrl(null)));
       // 测试 marketDeptStaffId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setMarketDeptStaffId(null)));
       // 测试 testingDeptStaffId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTestingDeptStaffId(null)));
       // 测试 marketRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setMarketRemark(null)));
       // 测试 testingRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTestingRemark(null)));
       // 测试 table14Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable14Id(null)));
       // 测试 offerId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setOfferId(null)));
       // 测试 offerRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setOfferRemark(null)));
       // 测试 contractId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setContractId(null)));
       // 测试 sampleId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setSampleId(null)));
       // 测试 solutionId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setSolutionId(null)));
       // 测试 reportId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setReportId(null)));
       // 测试 state 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setState(null)));
       // 测试 cancelRemark 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setCancelRemark(null)));
       // 测试 createTime 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setCreateTime(null)));
       // 测试 table12Id 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setTable12Id(null)));
       // 测试 projectId 不匹配
       delegationMapper.insert(cloneIgnoreId(dbDelegation, o -> o.setProjectId(null)));
       // 准备参数
       DelegationExportReqVO reqVO = new DelegationExportReqVO();
       reqVO.setLaunchTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setCreatorId(null);
       reqVO.setName(null);
       reqVO.setTable2Id(null);
       reqVO.setTable3Id(null);
       reqVO.setUrl(null);
       reqVO.setMarketDeptStaffId(null);
       reqVO.setTestingDeptStaffId(null);
       reqVO.setMarketRemark(null);
       reqVO.setTestingRemark(null);
       reqVO.setTable14Id(null);
       reqVO.setOfferId(null);
       reqVO.setOfferRemark(null);
       reqVO.setContractId(null);
       reqVO.setSampleId(null);
       reqVO.setSolutionId(null);
       reqVO.setReportId(null);
       reqVO.setState(null);
       reqVO.setCancelRemark(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setTable12Id(null);
       reqVO.setProjectId(null);

       // 调用
       List<DelegationDO> list = delegationService.getDelegationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDelegation, list.get(0));
    }

}
