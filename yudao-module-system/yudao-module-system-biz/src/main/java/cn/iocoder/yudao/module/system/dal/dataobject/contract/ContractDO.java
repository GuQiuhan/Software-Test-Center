package cn.iocoder.yudao.module.system.dal.dataobject.contract;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 合同 DO
 *
 * @author NJU_Test_Center
 */
@TableName("system_contract")
@KeySequence("system_contract_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDO extends BaseDO {

    /**
     * 合同编号
     */
    @TableId
    private Long id;
    /**
     * 软件委托测试合同ID
     */
    private String table4Id;
    /**
     * 软件项目委托测试保密协议ID
     */
    private String table5Id;
    /**
     * 客户审核合同意见
     */
    private String clientRemark;
    /**
     * 市场部人员审核合同意见
     */
    private String staffRemark;
    /**
     * 实体合同材料url
     */
    private String url;

}
