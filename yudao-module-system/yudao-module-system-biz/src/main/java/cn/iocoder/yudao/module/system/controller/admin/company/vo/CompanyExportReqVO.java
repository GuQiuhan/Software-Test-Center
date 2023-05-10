package cn.iocoder.yudao.module.system.controller.admin.company.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 公司 Excel 导出 Request VO，参数和 CompanyPageReqVO 是一致的")
@Data
public class CompanyExportReqVO {

    @Schema(description = "公司名称", example = "甲公司")
    private String name;

    @Schema(description = "公司地址", example = "甲地")
    private String address;

    @Schema(description = "公司名称", example = "123456")
    private String phone;

    @Schema(description = "公司编码(用于认证)", example = "10000001")
    private String code;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
