package cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 角色前台菜单更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleFrontMenuUpdateReqVO extends RoleFrontMenuBaseVO {

    @Schema(description = "编号", required = true, example = "4774")
    @NotNull(message = "编号不能为空")
    private Long id;

}
