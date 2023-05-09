package cn.iocoder.yudao.module.system.controller.admin.solution.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 测试方案 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class SolutionExcelVO {

    @ExcelProperty("测试方案编号")
    private Long id;

    @ExcelProperty("软件测试方案ID")
    private String table6Id;

    @ExcelProperty("质量部审核人ID")
    private Long auditorId;

    @ExcelProperty("测试方案评审表ID")
    private String table13Id;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
