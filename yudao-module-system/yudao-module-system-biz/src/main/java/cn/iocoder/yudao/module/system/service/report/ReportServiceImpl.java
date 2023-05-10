package cn.iocoder.yudao.module.system.service.report;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.report.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.report.ReportDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.report.ReportConvert;
import cn.iocoder.yudao.module.system.dal.mysql.report.ReportMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 测试报告
 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public Long createReport(ReportCreateReqVO createReqVO) {
        // 插入
        ReportDO report = ReportConvert.INSTANCE.convert(createReqVO);
        reportMapper.insert(report);
        // 返回
        return report.getId();
    }

    @Override
    public void updateReport(ReportUpdateReqVO updateReqVO) {
        // 校验存在
        validateReportExists(updateReqVO.getId());
        // 更新
        ReportDO updateObj = ReportConvert.INSTANCE.convert(updateReqVO);
        reportMapper.updateById(updateObj);
    }

    @Override
    public void deleteReport(Long id) {
        // 校验存在
        validateReportExists(id);
        // 删除
        reportMapper.deleteById(id);
    }

    private void validateReportExists(Long id) {
        if (reportMapper.selectById(id) == null) {
            throw exception(REPORT_NOT_EXISTS);
        }
    }

    @Override
    public ReportDO getReport(Long id) {
        return reportMapper.selectById(id);
    }

    @Override
    public List<ReportDO> getReportList(Collection<Long> ids) {
        return reportMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ReportDO> getReportPage(ReportPageReqVO pageReqVO) {
        return reportMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ReportDO> getReportList(ReportExportReqVO exportReqVO) {
        return reportMapper.selectList(exportReqVO);
    }

}
