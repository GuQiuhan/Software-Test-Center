package cn.iocoder.yudao.module.system.controller.admin.usercompany.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户和公司关联 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserCompanyRespVO extends UserCompanyBaseVO {

    @Schema(description = "编号", required = true, example = "23349")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
