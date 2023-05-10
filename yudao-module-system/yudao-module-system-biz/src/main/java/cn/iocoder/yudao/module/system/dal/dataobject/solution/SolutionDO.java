package cn.iocoder.yudao.module.system.dal.dataobject.solution;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 测试方案 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_solution")
@KeySequence("system_solution_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolutionDO extends BaseDO {

    /**
     * 测试方案编号
     */
    @TableId
    private Long id;
    /**
     * 软件测试方案ID
     */
    private String table6Id;
    /**
     * 质量部审核人ID
     */
    private Long auditorId;
    /**
     * 测试方案评审表ID
     */
    private String table13Id;

}
