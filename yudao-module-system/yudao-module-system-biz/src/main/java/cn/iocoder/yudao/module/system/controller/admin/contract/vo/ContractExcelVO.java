package cn.iocoder.yudao.module.system.controller.admin.contract.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 合同 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class ContractExcelVO {

    @ExcelProperty("合同编号")
    private Long id;

    @ExcelProperty("软件委托测试合同ID")
    private String table4Id;

    @ExcelProperty("软件项目委托测试保密协议ID")
    private String table5Id;

    @ExcelProperty("客户审核合同意见")
    private String clientRemark;

    @ExcelProperty("市场部人员审核合同意见")
    private String staffRemark;

    @ExcelProperty("实体合同材料url")
    private String url;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
