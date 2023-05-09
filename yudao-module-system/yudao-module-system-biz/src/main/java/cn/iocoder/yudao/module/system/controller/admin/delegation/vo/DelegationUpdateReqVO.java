package cn.iocoder.yudao.module.system.controller.admin.delegation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 委托更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DelegationUpdateReqVO extends DelegationBaseVO {

    @Schema(description = "编号", required = true, example = "19321")
    @NotNull(message = "编号不能为空")
    private Long id;

}
