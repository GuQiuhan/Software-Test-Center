package cn.iocoder.yudao.module.system.controller.admin.solution;

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

import cn.iocoder.yudao.module.system.controller.admin.solution.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.solution.SolutionDO;
import cn.iocoder.yudao.module.system.convert.solution.SolutionConvert;
import cn.iocoder.yudao.module.system.service.solution.SolutionService;

@Tag(name = "管理后台 - 测试方案")
@RestController
@RequestMapping("/system/solution")
@Validated
public class SolutionController {

    @Resource
    private SolutionService solutionService;

    @PostMapping("/create")
    @Operation(summary = "创建测试方案")
    @PreAuthorize("@ss.hasPermission('system:solution:create')")
    public CommonResult<Long> createSolution(@Valid @RequestBody SolutionCreateReqVO createReqVO) {
        return success(solutionService.createSolution(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新测试方案")
    @PreAuthorize("@ss.hasPermission('system:solution:update')")
    public CommonResult<Boolean> updateSolution(@Valid @RequestBody SolutionUpdateReqVO updateReqVO) {
        solutionService.updateSolution(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除测试方案")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:solution:delete')")
    public CommonResult<Boolean> deleteSolution(@RequestParam("id") Long id) {
        solutionService.deleteSolution(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得测试方案")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:solution:query')")
    public CommonResult<SolutionRespVO> getSolution(@RequestParam("id") Long id) {
        SolutionDO solution = solutionService.getSolution(id);
        return success(SolutionConvert.INSTANCE.convert(solution));
    }

    @GetMapping("/list")
    @Operation(summary = "获得测试方案列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:solution:query')")
    public CommonResult<List<SolutionRespVO>> getSolutionList(@RequestParam("ids") Collection<Long> ids) {
        List<SolutionDO> list = solutionService.getSolutionList(ids);
        return success(SolutionConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得测试方案分页")
    @PreAuthorize("@ss.hasPermission('system:solution:query')")
    public CommonResult<PageResult<SolutionRespVO>> getSolutionPage(@Valid SolutionPageReqVO pageVO) {
        PageResult<SolutionDO> pageResult = solutionService.getSolutionPage(pageVO);
        return success(SolutionConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出测试方案 Excel")
    @PreAuthorize("@ss.hasPermission('system:solution:export')")
    @OperateLog(type = EXPORT)
    public void exportSolutionExcel(@Valid SolutionExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SolutionDO> list = solutionService.getSolutionList(exportReqVO);
        // 导出 Excel
        List<SolutionExcelVO> datas = SolutionConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "测试方案.xls", "数据", SolutionExcelVO.class, datas);
    }

}
