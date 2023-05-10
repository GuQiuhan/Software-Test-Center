package cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 角色前台菜单 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleFrontMenuRespVO extends RoleFrontMenuBaseVO {

    @Schema(description = "编号", required = true, example = "4774")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
