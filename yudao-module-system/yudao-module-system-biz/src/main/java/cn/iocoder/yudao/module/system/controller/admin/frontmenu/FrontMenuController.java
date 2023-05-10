package cn.iocoder.yudao.module.system.controller.admin.frontmenu;

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

import cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.frontmenu.FrontMenuDO;
import cn.iocoder.yudao.module.system.convert.frontmenu.FrontMenuConvert;
import cn.iocoder.yudao.module.system.service.frontmenu.FrontMenuService;

@Tag(name = "管理后台 - 前台菜单")
@RestController
@RequestMapping("/system/front-menu")
@Validated
public class FrontMenuController {

    @Resource
    private FrontMenuService frontMenuService;

    @PostMapping("/create")
    @Operation(summary = "创建前台菜单")
    @PreAuthorize("@ss.hasPermission('system:front-menu:create')")
    public CommonResult<Long> createFrontMenu(@Valid @RequestBody FrontMenuCreateReqVO createReqVO) {
        return success(frontMenuService.createFrontMenu(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新前台菜单")
    @PreAuthorize("@ss.hasPermission('system:front-menu:update')")
    public CommonResult<Boolean> updateFrontMenu(@Valid @RequestBody FrontMenuUpdateReqVO updateReqVO) {
        frontMenuService.updateFrontMenu(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除前台菜单")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:front-menu:delete')")
    public CommonResult<Boolean> deleteFrontMenu(@RequestParam("id") Long id) {
        frontMenuService.deleteFrontMenu(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得前台菜单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:front-menu:query')")
    public CommonResult<FrontMenuRespVO> getFrontMenu(@RequestParam("id") Long id) {
        FrontMenuDO frontMenu = frontMenuService.getFrontMenu(id);
        return success(FrontMenuConvert.INSTANCE.convert(frontMenu));
    }

    @GetMapping("/list")
    @Operation(summary = "获得前台菜单列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:front-menu:query')")
    public CommonResult<List<FrontMenuRespVO>> getFrontMenuList(@RequestParam("ids") Collection<Long> ids) {
        List<FrontMenuDO> list = frontMenuService.getFrontMenuList(ids);
        return success(FrontMenuConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得前台菜单分页")
    @PreAuthorize("@ss.hasPermission('system:front-menu:query')")
    public CommonResult<PageResult<FrontMenuRespVO>> getFrontMenuPage(@Valid FrontMenuPageReqVO pageVO) {
        PageResult<FrontMenuDO> pageResult = frontMenuService.getFrontMenuPage(pageVO);
        return success(FrontMenuConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出前台菜单 Excel")
    @PreAuthorize("@ss.hasPermission('system:front-menu:export')")
    @OperateLog(type = EXPORT)
    public void exportFrontMenuExcel(@Valid FrontMenuExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<FrontMenuDO> list = frontMenuService.getFrontMenuList(exportReqVO);
        // 导出 Excel
        List<FrontMenuExcelVO> datas = FrontMenuConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "前台菜单.xls", "数据", FrontMenuExcelVO.class, datas);
    }

}
