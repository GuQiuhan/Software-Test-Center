package cn.iocoder.yudao.module.system.controller.admin.company.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 公司 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class CompanyExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("公司名称")
    private String name;

    @ExcelProperty("公司地址")
    private String address;

    @ExcelProperty("公司名称")
    private String phone;

    @ExcelProperty("公司编码(用于认证)")
    private String code;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
