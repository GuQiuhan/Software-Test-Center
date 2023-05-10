package cn.iocoder.yudao.module.system.dal.dataobject.operation;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 流程操作 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_operation")
@KeySequence("system_operation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationDO extends BaseDO {

    /**
     * 操作编号
     */
    @TableId
    private Long id;
    /**
     * 流程编号
     */
    private Long flowId;
    /**
     * 操作人编号
     */
    private Long operatorId;
    /**
     * 操作时间
     */
    private LocalDateTime operateTime;
    /**
     * 操作信息
     */
    private String remark;

}
