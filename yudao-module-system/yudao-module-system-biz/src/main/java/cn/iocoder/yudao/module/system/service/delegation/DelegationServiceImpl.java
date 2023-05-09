package cn.iocoder.yudao.module.system.service.delegation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.delegation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.delegation.DelegationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.delegation.DelegationConvert;
import cn.iocoder.yudao.module.system.dal.mysql.delegation.DelegationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 委托 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class DelegationServiceImpl implements DelegationService {

    @Resource
    private DelegationMapper delegationMapper;

    @Override
    public Long createDelegation(DelegationCreateReqVO createReqVO) {
        // 插入
        DelegationDO delegation = DelegationConvert.INSTANCE.convert(createReqVO);
        delegationMapper.insert(delegation);
        // 返回
        return delegation.getId();
    }

    @Override
    public void updateDelegation(DelegationUpdateReqVO updateReqVO) {
        // 校验存在
        validateDelegationExists(updateReqVO.getId());
        // 更新
        DelegationDO updateObj = DelegationConvert.INSTANCE.convert(updateReqVO);
        delegationMapper.updateById(updateObj);
    }

    @Override
    public void deleteDelegation(Long id) {
        // 校验存在
        validateDelegationExists(id);
        // 删除
        delegationMapper.deleteById(id);
    }

    private void validateDelegationExists(Long id) {
        if (delegationMapper.selectById(id) == null) {
            throw exception(DELEGATION_NOT_EXISTS);
        }
    }

    @Override
    public DelegationDO getDelegation(Long id) {
        return delegationMapper.selectById(id);
    }

    @Override
    public List<DelegationDO> getDelegationList(Collection<Long> ids) {
        return delegationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DelegationDO> getDelegationPage(DelegationPageReqVO pageReqVO) {
        return delegationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DelegationDO> getDelegationList(DelegationExportReqVO exportReqVO) {
        return delegationMapper.selectList(exportReqVO);
    }

}
