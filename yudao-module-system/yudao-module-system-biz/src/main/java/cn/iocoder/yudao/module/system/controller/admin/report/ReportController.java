package cn.iocoder.yudao.module.system.controller.admin.report;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.system.controller.admin.report.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.report.ReportDO;
import cn.iocoder.yudao.module.system.convert.report.ReportConvert;
import cn.iocoder.yudao.module.system.service.report.ReportService;

@Tag(name = "管理后台 - 测试报告")
@RestController
@RequestMapping("/system/report")
@Validated
public class ReportController {

    @Resource
    private ReportService reportService;

    @PostMapping("/create")
    @Operation(summary = "创建测试报告")
    @PreAuthorize("@ss.hasPermission('system:report:create')")
    public CommonResult<Long> createReport(@Valid @RequestBody ReportCreateReqVO createReqVO) {
        return success(reportService.createReport(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新测试报告")
    @PreAuthorize("@ss.hasPermission('system:report:update')")
    public CommonResult<Boolean> updateReport(@Valid @RequestBody ReportUpdateReqVO updateReqVO) {
        reportService.updateReport(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除测试报告")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:report:delete')")
    public CommonResult<Boolean> deleteReport(@RequestParam("id") Long id) {
        reportService.deleteReport(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得测试报告")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:report:query')")
    public CommonResult<ReportRespVO> getReport(@RequestParam("id") Long id) {
        ReportDO report = reportService.getReport(id);
        return success(ReportConvert.INSTANCE.convert(report));
    }

    @GetMapping("/list")
    @Operation(summary = "获得测试报告列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:report:query')")
    public CommonResult<List<ReportRespVO>> getReportList(@RequestParam("ids") Collection<Long> ids) {
        List<ReportDO> list = reportService.getReportList(ids);
        return success(ReportConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得测试报告分页")
    @PreAuthorize("@ss.hasPermission('system:report:query')")
    public CommonResult<PageResult<ReportRespVO>> getReportPage(@Valid ReportPageReqVO pageVO) {
        PageResult<ReportDO> pageResult = reportService.getReportPage(pageVO);
        return success(ReportConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出测试报告Excel")
    @PreAuthorize("@ss.hasPermission('system:report:export')")
    @OperateLog(type = EXPORT)
    public void exportReportExcel(@Valid ReportExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ReportDO> list = reportService.getReportList(exportReqVO);
        // 导出 Excel
        List<ReportExcelVO> datas = ReportConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "测试报告xls", "数据", ReportExcelVO.class, datas);
    }

}
