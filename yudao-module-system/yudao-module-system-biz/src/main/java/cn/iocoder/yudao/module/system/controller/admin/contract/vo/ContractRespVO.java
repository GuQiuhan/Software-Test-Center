package cn.iocoder.yudao.module.system.controller.admin.contract.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 合同 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ContractRespVO extends ContractBaseVO {

    @Schema(description = "合同编号", required = true, example = "1951")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
