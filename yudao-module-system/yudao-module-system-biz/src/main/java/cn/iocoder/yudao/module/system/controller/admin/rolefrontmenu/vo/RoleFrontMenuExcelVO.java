package cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 角色前台菜单 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class RoleFrontMenuExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("角色编号")
    private Long roleId;

    @ExcelProperty("菜单编号")
    private Long frontMenuId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
