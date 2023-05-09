package cn.iocoder.yudao.module.system.dal.dataobject.report;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 测试报告
 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_report")
@KeySequence("system_report_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDO extends BaseDO {

    /**
     * 测试报告编号
     */
    @TableId
    private Long id;
    /**
     * 软件测试报告ID
     */
    private String table7Id;
    /**
     * 测试用例（电子记录）ID
     */
    private String table8Id;
    /**
     * 软件测试记录(电子记录)ID
     */
    private String table9Id;
    /**
     * 软件测试问题清单（电子记录）ID
     */
    private String table11Id;
    /**
     * 测试部主管id
     */
    private Long testingDeptManagerId;
    /**
     * 测试部主管审核意见
     */
    private String managerRemark;
    /**
     * 测试报告检查表ID
     */
    private String table10Id;
    /**
     * 签字人审核意见
     */
    private String signatoryRemark;
    /**
     * 签字人id
     */
    private Long signatoryId;
    /**
     * 客户意见
     */
    private String clientRemark;

}
