package cn.iocoder.yudao.module.system.controller.admin.usercompany;

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

import cn.iocoder.yudao.module.system.controller.admin.usercompany.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.usercompany.UserCompanyDO;
import cn.iocoder.yudao.module.system.convert.usercompany.UserCompanyConvert;
import cn.iocoder.yudao.module.system.service.usercompany.UserCompanyService;

@Tag(name = "管理后台 - 用户和公司关联")
@RestController
@RequestMapping("/system/user-company")
@Validated
public class UserCompanyController {

    @Resource
    private UserCompanyService userCompanyService;

    @PostMapping("/create")
    @Operation(summary = "创建用户和公司关联")
    @PreAuthorize("@ss.hasPermission('system:user-company:create')")
    public CommonResult<Long> createUserCompany(@Valid @RequestBody UserCompanyCreateReqVO createReqVO) {
        return success(userCompanyService.createUserCompany(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户和公司关联")
    @PreAuthorize("@ss.hasPermission('system:user-company:update')")
    public CommonResult<Boolean> updateUserCompany(@Valid @RequestBody UserCompanyUpdateReqVO updateReqVO) {
        userCompanyService.updateUserCompany(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户和公司关联")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user-company:delete')")
    public CommonResult<Boolean> deleteUserCompany(@RequestParam("id") Long id) {
        userCompanyService.deleteUserCompany(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得用户和公司关联")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user-company:query')")
    public CommonResult<UserCompanyRespVO> getUserCompany(@RequestParam("id") Long id) {
        UserCompanyDO userCompany = userCompanyService.getUserCompany(id);
        return success(UserCompanyConvert.INSTANCE.convert(userCompany));
    }

    @GetMapping("/list")
    @Operation(summary = "获得用户和公司关联列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user-company:query')")
    public CommonResult<List<UserCompanyRespVO>> getUserCompanyList(@RequestParam("ids") Collection<Long> ids) {
        List<UserCompanyDO> list = userCompanyService.getUserCompanyList(ids);
        return success(UserCompanyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得用户和公司关联分页")
    @PreAuthorize("@ss.hasPermission('system:user-company:query')")
    public CommonResult<PageResult<UserCompanyRespVO>> getUserCompanyPage(@Valid UserCompanyPageReqVO pageVO) {
        PageResult<UserCompanyDO> pageResult = userCompanyService.getUserCompanyPage(pageVO);
        return success(UserCompanyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出用户和公司关联 Excel")
    @PreAuthorize("@ss.hasPermission('system:user-company:export')")
    @OperateLog(type = EXPORT)
    public void exportUserCompanyExcel(@Valid UserCompanyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<UserCompanyDO> list = userCompanyService.getUserCompanyList(exportReqVO);
        // 导出 Excel
        List<UserCompanyExcelVO> datas = UserCompanyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户和公司关联.xls", "数据", UserCompanyExcelVO.class, datas);
    }

}
