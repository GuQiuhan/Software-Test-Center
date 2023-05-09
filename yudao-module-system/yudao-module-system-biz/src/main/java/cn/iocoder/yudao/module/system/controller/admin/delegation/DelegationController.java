package cn.iocoder.yudao.module.system.controller.admin.delegation;

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

import cn.iocoder.yudao.module.system.controller.admin.delegation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.delegation.DelegationDO;
import cn.iocoder.yudao.module.system.convert.delegation.DelegationConvert;
import cn.iocoder.yudao.module.system.service.delegation.DelegationService;

@Tag(name = "管理后台 - 委托")
@RestController
@RequestMapping("/system/delegation")
@Validated
public class DelegationController {

    @Resource
    private DelegationService delegationService;

    @PostMapping("/create")
    @Operation(summary = "创建委托")
    @PreAuthorize("@ss.hasPermission('system:delegation:create')")
    public CommonResult<Long> createDelegation(@Valid @RequestBody DelegationCreateReqVO createReqVO) {
        return success(delegationService.createDelegation(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新委托")
    @PreAuthorize("@ss.hasPermission('system:delegation:update')")
    public CommonResult<Boolean> updateDelegation(@Valid @RequestBody DelegationUpdateReqVO updateReqVO) {
        delegationService.updateDelegation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除委托")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:delegation:delete')")
    public CommonResult<Boolean> deleteDelegation(@RequestParam("id") Long id) {
        delegationService.deleteDelegation(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得委托")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:delegation:query')")
    public CommonResult<DelegationRespVO> getDelegation(@RequestParam("id") Long id) {
        DelegationDO delegation = delegationService.getDelegation(id);
        return success(DelegationConvert.INSTANCE.convert(delegation));
    }

    @GetMapping("/list")
    @Operation(summary = "获得委托列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:delegation:query')")
    public CommonResult<List<DelegationRespVO>> getDelegationList(@RequestParam("ids") Collection<Long> ids) {
        List<DelegationDO> list = delegationService.getDelegationList(ids);
        return success(DelegationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得委托分页")
    @PreAuthorize("@ss.hasPermission('system:delegation:query')")
    public CommonResult<PageResult<DelegationRespVO>> getDelegationPage(@Valid DelegationPageReqVO pageVO) {
        PageResult<DelegationDO> pageResult = delegationService.getDelegationPage(pageVO);
        return success(DelegationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出委托 Excel")
    @PreAuthorize("@ss.hasPermission('system:delegation:export')")
    @OperateLog(type = EXPORT)
    public void exportDelegationExcel(@Valid DelegationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DelegationDO> list = delegationService.getDelegationList(exportReqVO);
        // 导出 Excel
        List<DelegationExcelVO> datas = DelegationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "委托.xls", "数据", DelegationExcelVO.class, datas);
    }

}
