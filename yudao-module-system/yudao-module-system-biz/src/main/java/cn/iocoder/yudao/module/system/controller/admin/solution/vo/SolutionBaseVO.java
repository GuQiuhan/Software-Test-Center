package cn.iocoder.yudao.module.system.controller.admin.solution.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 测试方案 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SolutionBaseVO {

    @Schema(description = "软件测试方案ID", example = "24892")
    private String table6Id;

    @Schema(description = "质量部审核人ID", example = "25835")
    private Long auditorId;

    @Schema(description = "测试方案评审表ID", example = "20234")
    private String table13Id;

}
