package cn.iocoder.yudao.module.system.controller.admin.frontmenu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 前台菜单 Excel VO
 *
 * @author NJU_Test_Center
 */
@Data
public class FrontMenuExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("菜单名称")
    private String name;

    @ExcelProperty("路由路径")
    private String path;

    @ExcelProperty("是否隐藏（0为否，1为是）")
    private Byte hideInMenu;

    @ExcelProperty(value = "菜单状态（0正常1停用）", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("关联数组")
    private String parentKeys;

}
