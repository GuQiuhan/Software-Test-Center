package cn.iocoder.yudao.module.system.service.operation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.operation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.operation.OperationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.operation.OperationConvert;
import cn.iocoder.yudao.module.system.dal.mysql.operation.OperationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 流程操作 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class OperationServiceImpl implements OperationService {

    @Resource
    private OperationMapper operationMapper;

    @Override
    public Long createOperation(OperationCreateReqVO createReqVO) {
        // 插入
        OperationDO operation = OperationConvert.INSTANCE.convert(createReqVO);
        operationMapper.insert(operation);
        // 返回
        return operation.getId();
    }

    @Override
    public void updateOperation(OperationUpdateReqVO updateReqVO) {
        // 校验存在
        validateOperationExists(updateReqVO.getId());
        // 更新
        OperationDO updateObj = OperationConvert.INSTANCE.convert(updateReqVO);
        operationMapper.updateById(updateObj);
    }

    @Override
    public void deleteOperation(Long id) {
        // 校验存在
        validateOperationExists(id);
        // 删除
        operationMapper.deleteById(id);
    }

    private void validateOperationExists(Long id) {
        if (operationMapper.selectById(id) == null) {
            throw exception(OPERATION_NOT_EXISTS);
        }
    }

    @Override
    public OperationDO getOperation(Long id) {
        return operationMapper.selectById(id);
    }

    @Override
    public List<OperationDO> getOperationList(Collection<Long> ids) {
        return operationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<OperationDO> getOperationPage(OperationPageReqVO pageReqVO) {
        return operationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<OperationDO> getOperationList(OperationExportReqVO exportReqVO) {
        return operationMapper.selectList(exportReqVO);
    }

}
