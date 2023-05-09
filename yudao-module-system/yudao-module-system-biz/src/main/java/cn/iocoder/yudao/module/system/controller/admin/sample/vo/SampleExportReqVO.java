package cn.iocoder.yudao.module.system.controller.admin.sample.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 样品 Excel 导出 Request VO，参数和 SamplePageReqVO 是一致的")
@Data
public class SampleExportReqVO {

    @Schema(description = "样品上传方式，如果在线上传则填写为线上，其余需说明方式的具体信息", example = "1")
    private String type;

    @Schema(description = "处理方式", example = "1")
    private String processType;

    @Schema(description = "如果样品为线上上传，需要填写样品的url", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "样品信息")
    private String information;

    @Schema(description = "审核人id，只能为选定的市场部或者测试部两个人中的一个", example = "30441")
    private Long auditorId;

    @Schema(description = "审核意见", example = "随便")
    private String remark;

    @Schema(description = "修改意见", example = "你猜")
    private String modifyRemark;

    @Schema(description = "样品状态 0.未发送 1.已发送 2.已审核 3.待修改 4.已修改 5.已处理")
    private Integer state;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
