package cn.iocoder.yudao.module.system.controller.admin.flowlog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 流程日志 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class FlowLogExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("委托的编号")
    private Long delegationId;

    @ExcelProperty("现状态")
    private Integer toState;

    @ExcelProperty("操作人编号")
    private Long operatorId;

    @ExcelProperty("日志时间")
    private LocalDateTime operateTime;

    @ExcelProperty("日志信息")
    private String remark;

    @ExcelProperty("日志变量")
    private String mapValue;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("原状态")
    private Integer fromState;

}
