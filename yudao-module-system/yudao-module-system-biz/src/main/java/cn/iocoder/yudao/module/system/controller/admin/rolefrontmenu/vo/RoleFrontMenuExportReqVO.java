package cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 角色前台菜单 Excel 导出 Request VO，参数和 RoleFrontMenuPageReqVO 是一致的")
@Data
public class RoleFrontMenuExportReqVO {

    @Schema(description = "角色编号", example = "7980")
    private Long roleId;

    @Schema(description = "菜单编号", example = "5873")
    private Long frontMenuId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
