package cn.iocoder.yudao.module.system.dal.dataobject.rolefrontmenu;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 角色前台菜单 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_role_front_menu")
@KeySequence("system_role_front_menu_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleFrontMenuDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 角色编号
     */
    private Long roleId;
    /**
     * 菜单编号
     */
    private Long frontMenuId;

}
