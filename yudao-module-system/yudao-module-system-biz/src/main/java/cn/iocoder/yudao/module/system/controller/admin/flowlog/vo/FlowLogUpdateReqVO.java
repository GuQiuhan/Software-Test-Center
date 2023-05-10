package cn.iocoder.yudao.module.system.controller.admin.flowlog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 流程日志更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FlowLogUpdateReqVO extends FlowLogBaseVO {

    @Schema(description = "编号", required = true, example = "7053")
    @NotNull(message = "编号不能为空")
    private Long id;

}
