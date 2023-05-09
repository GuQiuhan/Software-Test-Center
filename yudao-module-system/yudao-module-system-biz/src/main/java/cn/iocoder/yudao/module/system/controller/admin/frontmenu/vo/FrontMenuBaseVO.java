package cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 前台菜单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class FrontMenuBaseVO {

    @Schema(description = "菜单名称", example = "王五")
    private String name;

    @Schema(description = "路由路径")
    private String path;

    @Schema(description = "是否隐藏（0为否，1为是）")
    private Byte hideInMenu;

    @Schema(description = "菜单状态（0正常1停用）", required = true, example = "2")
    @NotNull(message = "菜单状态（0正常1停用）不能为空")
    private Byte status;

    @Schema(description = "关联数组")
    private String parentKeys;

}
