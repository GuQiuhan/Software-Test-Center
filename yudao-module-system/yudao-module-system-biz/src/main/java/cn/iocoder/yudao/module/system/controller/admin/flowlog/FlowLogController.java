package cn.iocoder.yudao.module.system.controller.admin.flowlog;

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

import cn.iocoder.yudao.module.system.controller.admin.flowlog.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowlog.FlowLogDO;
import cn.iocoder.yudao.module.system.convert.flowlog.FlowLogConvert;
import cn.iocoder.yudao.module.system.service.flowlog.FlowLogService;

@Tag(name = "管理后台 - 流程日志")
@RestController
@RequestMapping("/system/flow-log")
@Validated
public class FlowLogController {

    @Resource
    private FlowLogService flowLogService;

    @PostMapping("/create")
    @Operation(summary = "创建流程日志")
    @PreAuthorize("@ss.hasPermission('system:flow-log:create')")
    public CommonResult<Long> createFlowLog(@Valid @RequestBody FlowLogCreateReqVO createReqVO) {
        return success(flowLogService.createFlowLog(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新流程日志")
    @PreAuthorize("@ss.hasPermission('system:flow-log:update')")
    public CommonResult<Boolean> updateFlowLog(@Valid @RequestBody FlowLogUpdateReqVO updateReqVO) {
        flowLogService.updateFlowLog(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除流程日志")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:flow-log:delete')")
    public CommonResult<Boolean> deleteFlowLog(@RequestParam("id") Long id) {
        flowLogService.deleteFlowLog(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得流程日志")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:flow-log:query')")
    public CommonResult<FlowLogRespVO> getFlowLog(@RequestParam("id") Long id) {
        FlowLogDO flowLog = flowLogService.getFlowLog(id);
        return success(FlowLogConvert.INSTANCE.convert(flowLog));
    }

    @GetMapping("/list")
    @Operation(summary = "获得流程日志列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:flow-log:query')")
    public CommonResult<List<FlowLogRespVO>> getFlowLogList(@RequestParam("ids") Collection<Long> ids) {
        List<FlowLogDO> list = flowLogService.getFlowLogList(ids);
        return success(FlowLogConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得流程日志分页")
    @PreAuthorize("@ss.hasPermission('system:flow-log:query')")
    public CommonResult<PageResult<FlowLogRespVO>> getFlowLogPage(@Valid FlowLogPageReqVO pageVO) {
        PageResult<FlowLogDO> pageResult = flowLogService.getFlowLogPage(pageVO);
        return success(FlowLogConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出流程日志 Excel")
    @PreAuthorize("@ss.hasPermission('system:flow-log:export')")
    @OperateLog(type = EXPORT)
    public void exportFlowLogExcel(@Valid FlowLogExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<FlowLogDO> list = flowLogService.getFlowLogList(exportReqVO);
        // 导出 Excel
        List<FlowLogExcelVO> datas = FlowLogConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "流程日志.xls", "数据", FlowLogExcelVO.class, datas);
    }

}
