package cn.iocoder.yudao.module.system.controller.admin.flowlog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 流程日志 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class FlowLogBaseVO {

    @Schema(description = "委托的编号", required = true, example = "29344")
    @NotNull(message = "委托的编号不能为空")
    private Long delegationId;

    @Schema(description = "现状态", required = true)
    @NotNull(message = "现状态不能为空")
    private Integer toState;

    @Schema(description = "操作人编号", required = true, example = "25376")
    @NotNull(message = "操作人编号不能为空")
    private Long operatorId;

    @Schema(description = "日志时间", required = true)
    @NotNull(message = "日志时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime operateTime;

    @Schema(description = "日志信息", required = true, example = "你猜")
    @NotNull(message = "日志信息不能为空")
    private String remark;

    @Schema(description = "日志变量")
    private String mapValue;

    @Schema(description = "原状态")
    private Integer fromState;

}
