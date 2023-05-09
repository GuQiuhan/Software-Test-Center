package cn.iocoder.yudao.module.system.controller.admin.report.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 测试报告更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReportUpdateReqVO extends ReportBaseVO {

    @Schema(description = "测试报告编号", required = true, example = "15298")
    @NotNull(message = "测试报告编号不能为空")
    private Long id;

}
