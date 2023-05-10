package cn.iocoder.yudao.module.system.dal.dataobject.delegation;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 委托 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_delegation")
@KeySequence("system_delegation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DelegationDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 发起时间
     */
    private LocalDateTime launchTime;
    /**
     * 发起者编号
     */
    private Long creatorId;
    /**
     * 委托名称
     */
    private String name;
    /**
     * 软件项目委托测试申请表ID
     */
    private String table2Id;
    /**
     * 委托测试软件功能列表ID
     */
    private String table3Id;
    /**
     * 文档材料url
     */
    private String url;
    /**
     * 分配的市场部人员ID
     */
    private Long marketDeptStaffId;
    /**
     * 分配的测试部人员ID
     */
    private Long testingDeptStaffId;
    /**
     * 市场部人员处理意见
     */
    private String marketRemark;
    /**
     * 测试部人员处理意见
     */
    private String testingRemark;
    /**
     * 软件文档评审表ID
     */
    private String table14Id;
    /**
     * 报价单ID
     */
    private String offerId;
    /**
     * 用户报价单意见
     */
    private String offerRemark;
    /**
     * 合同ID
     */
    private Long contractId;
    /**
     * 样品ID
     */
    private Long sampleId;
    /**
     * 测试方案ID
     */
    private Long solutionId;
    /**
     * 测试报告ID
     */
    private Long reportId;
    /**
     * 状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer state;
    /**
     * 委托取消原因
     */
    private String cancelRemark;
    /**
     * 软件项目委托测试工作检查表ID
     */
    private String table12Id;
    /**
     * 项目编号
     */
    private String projectId;

}
