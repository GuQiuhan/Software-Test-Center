package cn.iocoder.yudao.module.system.controller.admin.report.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 测试报告 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReportRespVO extends ReportBaseVO {

    @Schema(description = "测试报告编号", required = true, example = "15298")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
