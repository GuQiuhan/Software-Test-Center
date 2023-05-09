package cn.iocoder.yudao.module.system.dal.dataobject.frontmenu;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 前台菜单 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_front_menu")
@KeySequence("system_front_menu_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrontMenuDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 路由路径
     */
    private String path;
    /**
     * 是否隐藏（0为否，1为是）
     */
    private Byte hideInMenu;
    /**
     * 菜单状态（0正常1停用）
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Byte status;
    /**
     * 关联数组
     */
    private String parentKeys;

}
