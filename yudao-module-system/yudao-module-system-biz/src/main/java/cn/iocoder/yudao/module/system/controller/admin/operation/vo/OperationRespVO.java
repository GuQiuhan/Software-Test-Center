package cn.iocoder.yudao.module.system.controller.admin.operation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 流程操作 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OperationRespVO extends OperationBaseVO {

    @Schema(description = "操作编号", required = true, example = "22511")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
