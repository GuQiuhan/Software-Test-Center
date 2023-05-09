package cn.iocoder.yudao.module.system.controller.admin.rolefrontmenu.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 角色前台菜单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleFrontMenuCreateReqVO extends RoleFrontMenuBaseVO {

}
