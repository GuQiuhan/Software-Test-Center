package cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 前台菜单 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FrontMenuRespVO extends FrontMenuBaseVO {

    @Schema(description = "编号", required = true, example = "6853")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
