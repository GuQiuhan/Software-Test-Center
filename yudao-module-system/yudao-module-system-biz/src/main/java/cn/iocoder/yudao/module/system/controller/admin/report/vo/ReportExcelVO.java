package cn.iocoder.yudao.module.system.controller.admin.report.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 测试报告
 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class ReportExcelVO {

    @ExcelProperty("测试报告编号")
    private Long id;

    @ExcelProperty("软件测试报告ID")
    private String table7Id;

    @ExcelProperty("测试用例（电子记录）ID")
    private String table8Id;

    @ExcelProperty("软件测试记录(电子记录)ID")
    private String table9Id;

    @ExcelProperty("软件测试问题清单（电子记录）ID")
    private String table11Id;

    @ExcelProperty("测试部主管id")
    private Long testingDeptManagerId;

    @ExcelProperty("测试部主管审核意见")
    private String managerRemark;

    @ExcelProperty("测试报告检查表ID")
    private String table10Id;

    @ExcelProperty("签字人审核意见")
    private String signatoryRemark;

    @ExcelProperty("签字人id")
    private Long signatoryId;

    @ExcelProperty("客户意见")
    private String clientRemark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
