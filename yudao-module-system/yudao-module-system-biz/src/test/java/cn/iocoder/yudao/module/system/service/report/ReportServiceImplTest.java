package cn.iocoder.yudao.module.system.service.report;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.report.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.report.ReportDO;
import cn.iocoder.yudao.module.system.dal.mysql.report.ReportMapper;
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
* {@link ReportServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(ReportServiceImpl.class)
public class ReportServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ReportServiceImpl reportService;

    @Resource
    private ReportMapper reportMapper;

    @Test
    public void testCreateReport_success() {
        // 准备参数
        ReportCreateReqVO reqVO = randomPojo(ReportCreateReqVO.class);

        // 调用
        Long reportId = reportService.createReport(reqVO);
        // 断言
        assertNotNull(reportId);
        // 校验记录的属性是否正确
        ReportDO report = reportMapper.selectById(reportId);
        assertPojoEquals(reqVO, report);
    }

    @Test
    public void testUpdateReport_success() {
        // mock 数据
        ReportDO dbReport = randomPojo(ReportDO.class);
        reportMapper.insert(dbReport);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ReportUpdateReqVO reqVO = randomPojo(ReportUpdateReqVO.class, o -> {
            o.setId(dbReport.getId()); // 设置更新的 ID
        });

        // 调用
        reportService.updateReport(reqVO);
        // 校验是否更新正确
        ReportDO report = reportMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, report);
    }

    @Test
    public void testUpdateReport_notExists() {
        // 准备参数
        ReportUpdateReqVO reqVO = randomPojo(ReportUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> reportService.updateReport(reqVO), REPORT_NOT_EXISTS);
    }

    @Test
    public void testDeleteReport_success() {
        // mock 数据
        ReportDO dbReport = randomPojo(ReportDO.class);
        reportMapper.insert(dbReport);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbReport.getId();

        // 调用
        reportService.deleteReport(id);
       // 校验数据不存在了
       assertNull(reportMapper.selectById(id));
    }

    @Test
    public void testDeleteReport_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> reportService.deleteReport(id), REPORT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReportPage() {
       // mock 数据
       ReportDO dbReport = randomPojo(ReportDO.class, o -> { // 等会查询到
           o.setTable7Id(null);
           o.setTable8Id(null);
           o.setTable9Id(null);
           o.setTable11Id(null);
           o.setTestingDeptManagerId(null);
           o.setManagerRemark(null);
           o.setTable10Id(null);
           o.setSignatoryRemark(null);
           o.setSignatoryId(null);
           o.setClientRemark(null);
           o.setCreateTime(null);
       });
       reportMapper.insert(dbReport);
       // 测试 table7Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable7Id(null)));
       // 测试 table8Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable8Id(null)));
       // 测试 table9Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable9Id(null)));
       // 测试 table11Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable11Id(null)));
       // 测试 testingDeptManagerId 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTestingDeptManagerId(null)));
       // 测试 managerRemark 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setManagerRemark(null)));
       // 测试 table10Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable10Id(null)));
       // 测试 signatoryRemark 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setSignatoryRemark(null)));
       // 测试 signatoryId 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setSignatoryId(null)));
       // 测试 clientRemark 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setClientRemark(null)));
       // 测试 createTime 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setCreateTime(null)));
       // 准备参数
       ReportPageReqVO reqVO = new ReportPageReqVO();
       reqVO.setTable7Id(null);
       reqVO.setTable8Id(null);
       reqVO.setTable9Id(null);
       reqVO.setTable11Id(null);
       reqVO.setTestingDeptManagerId(null);
       reqVO.setManagerRemark(null);
       reqVO.setTable10Id(null);
       reqVO.setSignatoryRemark(null);
       reqVO.setSignatoryId(null);
       reqVO.setClientRemark(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<ReportDO> pageResult = reportService.getReportPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbReport, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetReportList() {
       // mock 数据
       ReportDO dbReport = randomPojo(ReportDO.class, o -> { // 等会查询到
           o.setTable7Id(null);
           o.setTable8Id(null);
           o.setTable9Id(null);
           o.setTable11Id(null);
           o.setTestingDeptManagerId(null);
           o.setManagerRemark(null);
           o.setTable10Id(null);
           o.setSignatoryRemark(null);
           o.setSignatoryId(null);
           o.setClientRemark(null);
           o.setCreateTime(null);
       });
       reportMapper.insert(dbReport);
       // 测试 table7Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable7Id(null)));
       // 测试 table8Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable8Id(null)));
       // 测试 table9Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable9Id(null)));
       // 测试 table11Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable11Id(null)));
       // 测试 testingDeptManagerId 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTestingDeptManagerId(null)));
       // 测试 managerRemark 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setManagerRemark(null)));
       // 测试 table10Id 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setTable10Id(null)));
       // 测试 signatoryRemark 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setSignatoryRemark(null)));
       // 测试 signatoryId 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setSignatoryId(null)));
       // 测试 clientRemark 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setClientRemark(null)));
       // 测试 createTime 不匹配
       reportMapper.insert(cloneIgnoreId(dbReport, o -> o.setCreateTime(null)));
       // 准备参数
       ReportExportReqVO reqVO = new ReportExportReqVO();
       reqVO.setTable7Id(null);
       reqVO.setTable8Id(null);
       reqVO.setTable9Id(null);
       reqVO.setTable11Id(null);
       reqVO.setTestingDeptManagerId(null);
       reqVO.setManagerRemark(null);
       reqVO.setTable10Id(null);
       reqVO.setSignatoryRemark(null);
       reqVO.setSignatoryId(null);
       reqVO.setClientRemark(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<ReportDO> list = reportService.getReportList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbReport, list.get(0));
    }

}
