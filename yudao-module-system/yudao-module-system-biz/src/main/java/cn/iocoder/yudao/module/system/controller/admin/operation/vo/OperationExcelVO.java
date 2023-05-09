package cn.iocoder.yudao.module.system.controller.admin.operation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 流程操作 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class OperationExcelVO {

    @ExcelProperty("操作编号")
    private Long id;

    @ExcelProperty("流程编号")
    private Long flowId;

    @ExcelProperty("操作人编号")
    private Long operatorId;

    @ExcelProperty("操作时间")
    private LocalDateTime operateTime;

    @ExcelProperty("操作信息")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
