package cn.iocoder.yudao.module.system.controller.admin.company.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 公司 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CompanyBaseVO {

    @Schema(description = "公司名称", required = true, example = "甲公司")
    @NotNull(message = "公司名称不能为空")
    private String name;

    @Schema(description = "公司地址", required = true, example = "甲地")
    @NotNull(message = "公司地址不能为空")
    private String address;

    @Schema(description = "公司名称", required = true, example = "123456")
    @NotNull(message = "公司名称不能为空")
    private String phone;

    @Schema(description = "公司编码(用于认证)", required = true, example = "10000001")
    @NotNull(message = "公司编码(用于认证)不能为空")
    private String code;

}
