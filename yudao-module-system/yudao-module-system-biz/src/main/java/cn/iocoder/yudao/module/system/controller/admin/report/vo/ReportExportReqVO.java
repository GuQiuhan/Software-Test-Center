package cn.iocoder.yudao.module.system.controller.admin.report.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 测试报告Excel 导出 Request VO，参数和 ReportPageReqVO 是一致的")
@Data
public class ReportExportReqVO {

    @Schema(description = "软件测试报告ID", example = "11848")
    private String table7Id;

    @Schema(description = "测试用例（电子记录）ID", example = "1370")
    private String table8Id;

    @Schema(description = "软件测试记录(电子记录)ID", example = "16328")
    private String table9Id;

    @Schema(description = "软件测试问题清单（电子记录）ID", example = "28183")
    private String table11Id;

    @Schema(description = "测试部主管id", example = "22524")
    private Long testingDeptManagerId;

    @Schema(description = "测试部主管审核意见", example = "你说的对")
    private String managerRemark;

    @Schema(description = "测试报告检查表ID", example = "15483")
    private String table10Id;

    @Schema(description = "签字人审核意见", example = "随便")
    private String signatoryRemark;

    @Schema(description = "签字人id", example = "19229")
    private Long signatoryId;

    @Schema(description = "客户意见", example = "你猜")
    private String clientRemark;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
