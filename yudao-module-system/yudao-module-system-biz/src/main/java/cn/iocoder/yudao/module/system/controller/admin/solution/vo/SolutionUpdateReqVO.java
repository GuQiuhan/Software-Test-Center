package cn.iocoder.yudao.module.system.controller.admin.solution.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 测试方案更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SolutionUpdateReqVO extends SolutionBaseVO {

    @Schema(description = "测试方案编号", required = true, example = "16926")
    @NotNull(message = "测试方案编号不能为空")
    private Long id;

}
