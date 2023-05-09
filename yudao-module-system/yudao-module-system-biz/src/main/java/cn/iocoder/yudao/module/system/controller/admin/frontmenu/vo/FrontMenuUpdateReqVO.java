package cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 前台菜单更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FrontMenuUpdateReqVO extends FrontMenuBaseVO {

    @Schema(description = "编号", required = true, example = "6853")
    @NotNull(message = "编号不能为空")
    private Long id;

}
