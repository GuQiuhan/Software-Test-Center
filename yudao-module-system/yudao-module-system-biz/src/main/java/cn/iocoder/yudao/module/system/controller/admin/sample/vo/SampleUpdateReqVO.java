package cn.iocoder.yudao.module.system.controller.admin.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 样品更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SampleUpdateReqVO extends SampleBaseVO {

    @Schema(description = "样品编号", required = true, example = "30565")
    @NotNull(message = "样品编号不能为空")
    private Long id;

}
