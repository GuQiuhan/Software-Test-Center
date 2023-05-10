package cn.iocoder.yudao.module.system.controller.admin.usercompany.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 用户和公司关联 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class UserCompanyBaseVO {

    @Schema(description = "用户编号", required = true, example = "15358")
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    @Schema(description = "公司编号", required = true, example = "1936")
    @NotNull(message = "公司编号不能为空")
    private Long companyId;

}
