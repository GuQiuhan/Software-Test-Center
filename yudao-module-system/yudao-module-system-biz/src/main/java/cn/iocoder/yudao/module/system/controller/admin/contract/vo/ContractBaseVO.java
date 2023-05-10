package cn.iocoder.yudao.module.system.controller.admin.contract.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 合同 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ContractBaseVO {

    @Schema(description = "软件委托测试合同ID", example = "5989")
    private String table4Id;

    @Schema(description = "软件项目委托测试保密协议ID", example = "26917")
    private String table5Id;

    @Schema(description = "客户审核合同意见", example = "随便")
    private String clientRemark;

    @Schema(description = "市场部人员审核合同意见", example = "随便")
    private String staffRemark;

    @Schema(description = "实体合同材料url", example = "https://www.iocoder.cn")
    private String url;

}
