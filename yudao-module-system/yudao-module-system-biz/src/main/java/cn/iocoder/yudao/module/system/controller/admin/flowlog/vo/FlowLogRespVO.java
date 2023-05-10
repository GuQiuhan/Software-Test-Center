package cn.iocoder.yudao.module.system.controller.admin.flowlog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 流程日志 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FlowLogRespVO extends FlowLogBaseVO {

    @Schema(description = "编号", required = true, example = "7053")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
