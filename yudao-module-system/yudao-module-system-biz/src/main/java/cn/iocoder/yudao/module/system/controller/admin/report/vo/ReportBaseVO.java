package cn.iocoder.yudao.module.system.controller.admin.report.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 测试报告
 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ReportBaseVO {

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

}
