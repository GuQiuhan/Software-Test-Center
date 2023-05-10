package cn.iocoder.yudao.module.system.controller.admin.contract.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 合同分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ContractPageReqVO extends PageParam {

    @Schema(description = "软件委托测试合同ID", example = "5989")
    private String table4Id;

    @Schema(description = "软件项目委托测试保密协议ID", example = "26917")
    private String table5Id;

    @Schema(description = "客户审核合同意见", example = "随便")
    private String clientRemark;

    @Schema(description = "市场部人员审核合同意见", example = "随便")
    private String staffRemark;

    @Schema(description = "实体合同材料url", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
