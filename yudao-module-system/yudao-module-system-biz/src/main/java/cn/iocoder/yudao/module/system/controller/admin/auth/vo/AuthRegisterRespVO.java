package cn.iocoder.yudao.module.system.controller.admin.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "账号注册 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRegisterRespVO {
    /*@Schema(description = "token。返回token作为认证，调用需要认证的接口时需要传入该参数", required = true, example = "4389dhkd93ujdasgudd32h2e")
    private String token;*/
    @Schema(description = "用户编号", required = true, example = "1024")
    private Long userId;

    @Schema(description = "访问令牌", required = true, example = "happy")
    private String accessToken;

    @Schema(description = "刷新令牌", required = true, example = "nice")
    private String refreshToken;

    @Schema(description = "过期时间", required = true)
    private LocalDateTime expiresTime;

}
