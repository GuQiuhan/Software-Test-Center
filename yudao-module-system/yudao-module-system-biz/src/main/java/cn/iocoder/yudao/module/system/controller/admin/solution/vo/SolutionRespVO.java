package cn.iocoder.yudao.module.system.controller.admin.solution.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 测试方案 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SolutionRespVO extends SolutionBaseVO {

    @Schema(description = "测试方案编号", required = true, example = "16926")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
