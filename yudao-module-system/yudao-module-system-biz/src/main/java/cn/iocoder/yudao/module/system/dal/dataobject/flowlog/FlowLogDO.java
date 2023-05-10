package cn.iocoder.yudao.module.system.dal.dataobject.flowlog;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 流程日志 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_flow_log")
@KeySequence("system_flow_log_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowLogDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 委托的编号
     */
    private Long delegationId;
    /**
     * 现状态
     */
    private Integer toState;
    /**
     * 操作人编号
     */
    private Long operatorId;
    /**
     * 日志时间
     */
    private LocalDateTime operateTime;
    /**
     * 日志信息
     */
    private String remark;
    /**
     * 日志变量
     */
    private String mapValue;
    /**
     * 原状态
     */
    private Integer fromState;

}
