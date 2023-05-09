package cn.iocoder.yudao.module.system.service.usercompany;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.usercompany.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.usercompany.UserCompanyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.usercompany.UserCompanyConvert;
import cn.iocoder.yudao.module.system.dal.mysql.usercompany.UserCompanyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 用户和公司关联 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class UserCompanyServiceImpl implements UserCompanyService {

    @Resource
    private UserCompanyMapper userCompanyMapper;

    @Override
    public Long createUserCompany(UserCompanyCreateReqVO createReqVO) {
        // 插入
        UserCompanyDO userCompany = UserCompanyConvert.INSTANCE.convert(createReqVO);
        userCompanyMapper.insert(userCompany);
        // 返回
        return userCompany.getId();
    }

    @Override
    public void updateUserCompany(UserCompanyUpdateReqVO updateReqVO) {
        // 校验存在
        validateUserCompanyExists(updateReqVO.getId());
        // 更新
        UserCompanyDO updateObj = UserCompanyConvert.INSTANCE.convert(updateReqVO);
        userCompanyMapper.updateById(updateObj);
    }

    @Override
    public void deleteUserCompany(Long id) {
        // 校验存在
        validateUserCompanyExists(id);
        // 删除
        userCompanyMapper.deleteById(id);
    }

    private void validateUserCompanyExists(Long id) {
        if (userCompanyMapper.selectById(id) == null) {
            throw exception(USER_COMPANY_NOT_EXISTS);
        }
    }

    @Override
    public UserCompanyDO getUserCompany(Long id) {
        return userCompanyMapper.selectById(id);
    }

    @Override
    public List<UserCompanyDO> getUserCompanyList(Collection<Long> ids) {
        return userCompanyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<UserCompanyDO> getUserCompanyPage(UserCompanyPageReqVO pageReqVO) {
        return userCompanyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<UserCompanyDO> getUserCompanyList(UserCompanyExportReqVO exportReqVO) {
        return userCompanyMapper.selectList(exportReqVO);
    }

}
