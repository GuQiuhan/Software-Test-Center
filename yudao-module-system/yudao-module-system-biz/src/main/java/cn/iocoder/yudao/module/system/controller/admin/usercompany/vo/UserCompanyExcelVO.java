package cn.iocoder.yudao.module.system.controller.admin.usercompany.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 用户和公司关联 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class UserCompanyExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("用户编号")
    private Long userId;

    @ExcelProperty("公司编号")
    private Long companyId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
