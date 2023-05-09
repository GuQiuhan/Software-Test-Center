package cn.iocoder.yudao.module.system.convert.operation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.operation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.operation.OperationDO;

/**
 * 流程操作 Convert
 *
 * @author NJU_Test_Center
 */
@Mapper
public interface OperationConvert {

    OperationConvert INSTANCE = Mappers.getMapper(OperationConvert.class);

    OperationDO convert(OperationCreateReqVO bean);

    OperationDO convert(OperationUpdateReqVO bean);

    OperationRespVO convert(OperationDO bean);

    List<OperationRespVO> convertList(List<OperationDO> list);

    PageResult<OperationRespVO> convertPage(PageResult<OperationDO> page);

    List<OperationExcelVO> convertList02(List<OperationDO> list);

}
