package cn.iocoder.yudao.module.system.service.report;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.report.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.report.ReportDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 测试报告
 Service 接口
 *
 * @author NJU_Test_Center
 */
public interface ReportService {

    /**
     * 创建测试报告

     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createReport(@Valid ReportCreateReqVO createReqVO);

    /**
     * 更新测试报告

     *
     * @param updateReqVO 更新信息
     */
    void updateReport(@Valid ReportUpdateReqVO updateReqVO);

    /**
     * 删除测试报告

     *
     * @param id 编号
     */
    void deleteReport(Long id);

    /**
     * 获得测试报告

     *
     * @param id 编号
     * @return 测试报告

     */
    ReportDO getReport(Long id);

    /**
     * 获得测试报告
列表
     *
     * @param ids 编号
     * @return 测试报告
列表
     */
    List<ReportDO> getReportList(Collection<Long> ids);

    /**
     * 获得测试报告
分页
     *
     * @param pageReqVO 分页查询
     * @return 测试报告
分页
     */
    PageResult<ReportDO> getReportPage(ReportPageReqVO pageReqVO);

    /**
     * 获得测试报告
列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 测试报告
列表
     */
    List<ReportDO> getReportList(ReportExportReqVO exportReqVO);

}
