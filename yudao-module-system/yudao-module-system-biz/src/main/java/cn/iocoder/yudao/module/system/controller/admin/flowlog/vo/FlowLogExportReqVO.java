package cn.iocoder.yudao.module.system.controller.admin.flowlog.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 流程日志 Excel 导出 Request VO，参数和 FlowLogPageReqVO 是一致的")
@Data
public class FlowLogExportReqVO {

    @Schema(description = "委托的编号", example = "29344")
    private Long delegationId;

    @Schema(description = "现状态")
    private Integer toState;

    @Schema(description = "操作人编号", example = "25376")
    private Long operatorId;

    @Schema(description = "日志时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] operateTime;

    @Schema(description = "日志信息", example = "你猜")
    private String remark;

    @Schema(description = "日志变量")
    private String mapValue;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "原状态")
    private Integer fromState;

}
