package cn.iocoder.yudao.module.system.controller.admin.usercompany.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 用户和公司关联更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserCompanyUpdateReqVO extends UserCompanyBaseVO {

    @Schema(description = "编号", required = true, example = "23349")
    @NotNull(message = "编号不能为空")
    private Long id;

}
