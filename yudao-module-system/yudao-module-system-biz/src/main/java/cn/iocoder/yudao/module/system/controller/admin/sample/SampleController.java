package cn.iocoder.yudao.module.system.controller.admin.sample;

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

import cn.iocoder.yudao.module.system.controller.admin.sample.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sample.SampleDO;
import cn.iocoder.yudao.module.system.convert.sample.SampleConvert;
import cn.iocoder.yudao.module.system.service.sample.SampleService;

@Tag(name = "管理后台 - 样品")
@RestController
@RequestMapping("/system/sample")
@Validated
public class SampleController {

    @Resource
    private SampleService sampleService;

    @PostMapping("/create")
    @Operation(summary = "创建样品")
    @PreAuthorize("@ss.hasPermission('system:sample:create')")
    public CommonResult<Long> createSample(@Valid @RequestBody SampleCreateReqVO createReqVO) {
        return success(sampleService.createSample(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新样品")
    @PreAuthorize("@ss.hasPermission('system:sample:update')")
    public CommonResult<Boolean> updateSample(@Valid @RequestBody SampleUpdateReqVO updateReqVO) {
        sampleService.updateSample(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除样品")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:sample:delete')")
    public CommonResult<Boolean> deleteSample(@RequestParam("id") Long id) {
        sampleService.deleteSample(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得样品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:sample:query')")
    public CommonResult<SampleRespVO> getSample(@RequestParam("id") Long id) {
        SampleDO sample = sampleService.getSample(id);
        return success(SampleConvert.INSTANCE.convert(sample));
    }

    @GetMapping("/list")
    @Operation(summary = "获得样品列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:sample:query')")
    public CommonResult<List<SampleRespVO>> getSampleList(@RequestParam("ids") Collection<Long> ids) {
        List<SampleDO> list = sampleService.getSampleList(ids);
        return success(SampleConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得样品分页")
    @PreAuthorize("@ss.hasPermission('system:sample:query')")
    public CommonResult<PageResult<SampleRespVO>> getSamplePage(@Valid SamplePageReqVO pageVO) {
        PageResult<SampleDO> pageResult = sampleService.getSamplePage(pageVO);
        return success(SampleConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出样品 Excel")
    @PreAuthorize("@ss.hasPermission('system:sample:export')")
    @OperateLog(type = EXPORT)
    public void exportSampleExcel(@Valid SampleExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<SampleDO> list = sampleService.getSampleList(exportReqVO);
        // 导出 Excel
        List<SampleExcelVO> datas = SampleConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "样品.xls", "数据", SampleExcelVO.class, datas);
    }

}
