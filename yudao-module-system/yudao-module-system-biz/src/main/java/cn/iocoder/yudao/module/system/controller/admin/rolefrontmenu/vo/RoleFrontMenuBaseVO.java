package cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 角色前台菜单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class RoleFrontMenuBaseVO {

    @Schema(description = "角色编号", example = "7980")
    private Long roleId;

    @Schema(description = "菜单编号", example = "5873")
    private Long frontMenuId;

}
