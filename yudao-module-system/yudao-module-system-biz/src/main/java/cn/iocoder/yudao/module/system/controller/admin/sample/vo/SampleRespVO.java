package cn.iocoder.yudao.module.system.controller.admin.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 样品 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SampleRespVO extends SampleBaseVO {

    @Schema(description = "样品编号", required = true, example = "30565")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
