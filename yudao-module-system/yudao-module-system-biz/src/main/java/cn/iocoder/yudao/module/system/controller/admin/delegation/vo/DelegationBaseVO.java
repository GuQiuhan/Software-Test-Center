package cn.iocoder.yudao.module.system.controller.admin.delegation.vo;

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
* 委托 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DelegationBaseVO {

    @Schema(description = "发起时间", required = true)
    @NotNull(message = "发起时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime launchTime;

    @Schema(description = "发起者编号", example = "22342")
    private Long creatorId;

    @Schema(description = "委托名称", required = true, example = "王五")
    @NotNull(message = "委托名称不能为空")
    private String name;

    @Schema(description = "软件项目委托测试申请表ID", example = "12622")
    private String table2Id;

    @Schema(description = "委托测试软件功能列表ID", example = "20398")
    private String table3Id;

    @Schema(description = "文档材料url", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "分配的市场部人员ID", example = "18234")
    private Long marketDeptStaffId;

    @Schema(description = "分配的测试部人员ID", example = "221")
    private Long testingDeptStaffId;

    @Schema(description = "市场部人员处理意见", example = "随便")
    private String marketRemark;

    @Schema(description = "测试部人员处理意见", example = "随便")
    private String testingRemark;

    @Schema(description = "软件文档评审表ID", example = "19780")
    private String table14Id;

    @Schema(description = "报价单ID", example = "25895")
    private String offerId;

    @Schema(description = "用户报价单意见", example = "你说的对")
    private String offerRemark;

    @Schema(description = "合同ID", example = "22214")
    private Long contractId;

    @Schema(description = "样品ID", example = "31827")
    private Long sampleId;

    @Schema(description = "测试方案ID", example = "11967")
    private Long solutionId;

    @Schema(description = "测试报告ID", example = "30819")
    private Long reportId;

    @Schema(description = "状态", required = true, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer state;

    @Schema(description = "委托取消原因", example = "随便")
    private String cancelRemark;

    @Schema(description = "软件项目委托测试工作检查表ID", example = "25506")
    private String table12Id;

    @Schema(description = "项目编号", example = "9248")
    private String projectId;

}
