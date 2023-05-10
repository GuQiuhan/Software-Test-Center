package cn.iocoder.yudao.module.system.controller.admin.operation.vo;

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
* 流程操作 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class OperationBaseVO {

    @Schema(description = "流程编号", required = true, example = "22040")
    @NotNull(message = "流程编号不能为空")
    private Long flowId;

    @Schema(description = "操作人编号", required = true, example = "27132")
    @NotNull(message = "操作人编号不能为空")
    private Long operatorId;

    @Schema(description = "操作时间", required = true)
    @NotNull(message = "操作时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime operateTime;

    @Schema(description = "操作信息", example = "你说的对")
    private String remark;

}
