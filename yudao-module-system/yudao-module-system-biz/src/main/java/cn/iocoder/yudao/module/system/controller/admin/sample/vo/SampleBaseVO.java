package cn.iocoder.yudao.module.system.controller.admin.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 样品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SampleBaseVO {

    @Schema(description = "样品上传方式，如果在线上传则填写为线上，其余需说明方式的具体信息", example = "1")
    private String type;

    @Schema(description = "处理方式", example = "1")
    private String processType;

    @Schema(description = "如果样品为线上上传，需要填写样品的url", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "样品信息")
    private String information;

    @Schema(description = "审核人id，只能为选定的市场部或者测试部两个人中的一个", example = "30441")
    private Long auditorId;

    @Schema(description = "审核意见", example = "随便")
    private String remark;

    @Schema(description = "修改意见", example = "你猜")
    private String modifyRemark;

    @Schema(description = "样品状态 0.未发送 1.已发送 2.已审核 3.待修改 4.已修改 5.已处理")
    private Integer state;

}
