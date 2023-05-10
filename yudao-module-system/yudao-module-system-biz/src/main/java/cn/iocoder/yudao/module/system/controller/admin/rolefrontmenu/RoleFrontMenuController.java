package cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu;

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

import cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.rolefrontmenu.RoleFrontMenuDO;
import cn.iocoder.yudao.module.system.convert.rolefrontmenu.RoleFrontMenuConvert;
import cn.iocoder.yudao.module.system.service.rolefrontmenu.RoleFrontMenuService;

@Tag(name = "管理后台 - 角色前台菜单")
@RestController
@RequestMapping("/system/role-front-menu")
@Validated
public class RoleFrontMenuController {

    @Resource
    private RoleFrontMenuService roleFrontMenuService;

    @PostMapping("/create")
    @Operation(summary = "创建角色前台菜单")
    @PreAuthorize("@ss.hasPermission('system:role-front-menu:create')")
    public CommonResult<Long> createRoleFrontMenu(@Valid @RequestBody RoleFrontMenuCreateReqVO createReqVO) {
        return success(roleFrontMenuService.createRoleFrontMenu(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新角色前台菜单")
    @PreAuthorize("@ss.hasPermission('system:role-front-menu:update')")
    public CommonResult<Boolean> updateRoleFrontMenu(@Valid @RequestBody RoleFrontMenuUpdateReqVO updateReqVO) {
        roleFrontMenuService.updateRoleFrontMenu(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除角色前台菜单")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:role-front-menu:delete')")
    public CommonResult<Boolean> deleteRoleFrontMenu(@RequestParam("id") Long id) {
        roleFrontMenuService.deleteRoleFrontMenu(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得角色前台菜单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:role-front-menu:query')")
    public CommonResult<RoleFrontMenuRespVO> getRoleFrontMenu(@RequestParam("id") Long id) {
        RoleFrontMenuDO roleFrontMenu = roleFrontMenuService.getRoleFrontMenu(id);
        return success(RoleFrontMenuConvert.INSTANCE.convert(roleFrontMenu));
    }

    @GetMapping("/list")
    @Operation(summary = "获得角色前台菜单列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:role-front-menu:query')")
    public CommonResult<List<RoleFrontMenuRespVO>> getRoleFrontMenuList(@RequestParam("ids") Collection<Long> ids) {
        List<RoleFrontMenuDO> list = roleFrontMenuService.getRoleFrontMenuList(ids);
        return success(RoleFrontMenuConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得角色前台菜单分页")
    @PreAuthorize("@ss.hasPermission('system:role-front-menu:query')")
    public CommonResult<PageResult<RoleFrontMenuRespVO>> getRoleFrontMenuPage(@Valid RoleFrontMenuPageReqVO pageVO) {
        PageResult<RoleFrontMenuDO> pageResult = roleFrontMenuService.getRoleFrontMenuPage(pageVO);
        return success(RoleFrontMenuConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出角色前台菜单 Excel")
    @PreAuthorize("@ss.hasPermission('system:role-front-menu:export')")
    @OperateLog(type = EXPORT)
    public void exportRoleFrontMenuExcel(@Valid RoleFrontMenuExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<RoleFrontMenuDO> list = roleFrontMenuService.getRoleFrontMenuList(exportReqVO);
        // 导出 Excel
        List<RoleFrontMenuExcelVO> datas = RoleFrontMenuConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "角色前台菜单.xls", "数据", RoleFrontMenuExcelVO.class, datas);
    }

}
