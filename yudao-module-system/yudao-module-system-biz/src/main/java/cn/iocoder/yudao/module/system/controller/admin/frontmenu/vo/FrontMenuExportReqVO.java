package cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 前台菜单 Excel 导出 Request VO，参数和 FrontMenuPageReqVO 是一致的")
@Data
public class FrontMenuExportReqVO {

    @Schema(description = "菜单名称", example = "王五")
    private String name;

    @Schema(description = "路由路径")
    private String path;

    @Schema(description = "是否隐藏（0为否，1为是）")
    private Byte hideInMenu;

    @Schema(description = "菜单状态（0正常1停用）", example = "2")
    private Byte status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "关联数组")
    private String parentKeys;

}
