package cn.iocoder.yudao.module.system.controller.admin.delegation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 委托 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class DelegationExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("发起时间")
    private LocalDateTime launchTime;

    @ExcelProperty("发起者编号")
    private Long creatorId;

    @ExcelProperty("委托名称")
    private String name;

    @ExcelProperty("软件项目委托测试申请表ID")
    private String table2Id;

    @ExcelProperty("委托测试软件功能列表ID")
    private String table3Id;

    @ExcelProperty("文档材料url")
    private String url;

    @ExcelProperty("分配的市场部人员ID")
    private Long marketDeptStaffId;

    @ExcelProperty("分配的测试部人员ID")
    private Long testingDeptStaffId;

    @ExcelProperty("市场部人员处理意见")
    private String marketRemark;

    @ExcelProperty("测试部人员处理意见")
    private String testingRemark;

    @ExcelProperty("软件文档评审表ID")
    private String table14Id;

    @ExcelProperty("报价单ID")
    private String offerId;

    @ExcelProperty("用户报价单意见")
    private String offerRemark;

    @ExcelProperty("合同ID")
    private Long contractId;

    @ExcelProperty("样品ID")
    private Long sampleId;

    @ExcelProperty("测试方案ID")
    private Long solutionId;

    @ExcelProperty("测试报告ID")
    private Long reportId;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer state;

    @ExcelProperty("委托取消原因")
    private String cancelRemark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("软件项目委托测试工作检查表ID")
    private String table12Id;

    @ExcelProperty("项目编号")
    private String projectId;

}
