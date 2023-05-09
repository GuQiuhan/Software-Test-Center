package cn.iocoder.yudao.module.system.controller.admin.operation;

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

import cn.iocoder.yudao.module.system.controller.admin.operation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.operation.OperationDO;
import cn.iocoder.yudao.module.system.convert.operation.OperationConvert;
import cn.iocoder.yudao.module.system.service.operation.OperationService;

@Tag(name = "管理后台 - 流程操作")
@RestController
@RequestMapping("/system/operation")
@Validated
public class OperationController {

    @Resource
    private OperationService operationService;

    @PostMapping("/create")
    @Operation(summary = "创建流程操作")
    @PreAuthorize("@ss.hasPermission('system:operation:create')")
    public CommonResult<Long> createOperation(@Valid @RequestBody OperationCreateReqVO createReqVO) {
        return success(operationService.createOperation(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新流程操作")
    @PreAuthorize("@ss.hasPermission('system:operation:update')")
    public CommonResult<Boolean> updateOperation(@Valid @RequestBody OperationUpdateReqVO updateReqVO) {
        operationService.updateOperation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除流程操作")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:operation:delete')")
    public CommonResult<Boolean> deleteOperation(@RequestParam("id") Long id) {
        operationService.deleteOperation(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得流程操作")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:operation:query')")
    public CommonResult<OperationRespVO> getOperation(@RequestParam("id") Long id) {
        OperationDO operation = operationService.getOperation(id);
        return success(OperationConvert.INSTANCE.convert(operation));
    }

    @GetMapping("/list")
    @Operation(summary = "获得流程操作列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:operation:query')")
    public CommonResult<List<OperationRespVO>> getOperationList(@RequestParam("ids") Collection<Long> ids) {
        List<OperationDO> list = operationService.getOperationList(ids);
        return success(OperationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得流程操作分页")
    @PreAuthorize("@ss.hasPermission('system:operation:query')")
    public CommonResult<PageResult<OperationRespVO>> getOperationPage(@Valid OperationPageReqVO pageVO) {
        PageResult<OperationDO> pageResult = operationService.getOperationPage(pageVO);
        return success(OperationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出流程操作 Excel")
    @PreAuthorize("@ss.hasPermission('system:operation:export')")
    @OperateLog(type = EXPORT)
    public void exportOperationExcel(@Valid OperationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<OperationDO> list = operationService.getOperationList(exportReqVO);
        // 导出 Excel
        List<OperationExcelVO> datas = OperationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "流程操作.xls", "数据", OperationExcelVO.class, datas);
    }

}
