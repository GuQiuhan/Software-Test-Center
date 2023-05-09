package cn.iocoder.yudao.module.system.controller.admin.usercompany.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户和公司关联 Excel 导出 Request VO，参数和 UserCompanyPageReqVO 是一致的")
@Data
public class UserCompanyExportReqVO {

    @Schema(description = "用户编号", example = "15358")
    private Long userId;

    @Schema(description = "公司编号", example = "1936")
    private Long companyId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
