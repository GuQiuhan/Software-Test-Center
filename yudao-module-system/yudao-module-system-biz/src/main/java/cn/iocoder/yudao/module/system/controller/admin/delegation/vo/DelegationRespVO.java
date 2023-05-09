package cn.iocoder.yudao.module.system.controller.admin.delegation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 委托 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DelegationRespVO extends DelegationBaseVO {

    @Schema(description = "编号", required = true, example = "19321")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
