package cn.iocoder.yudao.module.system.convert.flowlog;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.flowlog.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowlog.FlowLogDO;

/**
 * 流程日志 Convert
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface FlowLogConvert {

    FlowLogConvert INSTANCE = Mappers.getMapper(FlowLogConvert.class);

    FlowLogDO convert(FlowLogCreateReqVO bean);

    FlowLogDO convert(FlowLogUpdateReqVO bean);

    FlowLogRespVO convert(FlowLogDO bean);

    List<FlowLogRespVO> convertList(List<FlowLogDO> list);

    PageResult<FlowLogRespVO> convertPage(PageResult<FlowLogDO> page);

    List<FlowLogExcelVO> convertList02(List<FlowLogDO> list);

}
