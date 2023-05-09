package cn.iocoder.yudao.module.system.controller.admin.operation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 流程操作更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OperationUpdateReqVO extends OperationBaseVO {

    @Schema(description = "操作编号", required = true, example = "22511")
    @NotNull(message = "操作编号不能为空")
    private Long id;

}
