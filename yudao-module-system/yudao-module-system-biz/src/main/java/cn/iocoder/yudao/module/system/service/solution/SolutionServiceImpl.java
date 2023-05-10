package cn.iocoder.yudao.module.system.service.solution;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.solution.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.solution.SolutionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.solution.SolutionConvert;
import cn.iocoder.yudao.module.system.dal.mysql.solution.SolutionMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 测试方案 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class SolutionServiceImpl implements SolutionService {

    @Resource
    private SolutionMapper solutionMapper;

    @Override
    public Long createSolution(SolutionCreateReqVO createReqVO) {
        // 插入
        SolutionDO solution = SolutionConvert.INSTANCE.convert(createReqVO);
        solutionMapper.insert(solution);
        // 返回
        return solution.getId();
    }

    @Override
    public void updateSolution(SolutionUpdateReqVO updateReqVO) {
        // 校验存在
        validateSolutionExists(updateReqVO.getId());
        // 更新
        SolutionDO updateObj = SolutionConvert.INSTANCE.convert(updateReqVO);
        solutionMapper.updateById(updateObj);
    }

    @Override
    public void deleteSolution(Long id) {
        // 校验存在
        validateSolutionExists(id);
        // 删除
        solutionMapper.deleteById(id);
    }

    private void validateSolutionExists(Long id) {
        if (solutionMapper.selectById(id) == null) {
            throw exception(SOLUTION_NOT_EXISTS);
        }
    }

    @Override
    public SolutionDO getSolution(Long id) {
        return solutionMapper.selectById(id);
    }

    @Override
    public List<SolutionDO> getSolutionList(Collection<Long> ids) {
        return solutionMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SolutionDO> getSolutionPage(SolutionPageReqVO pageReqVO) {
        return solutionMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SolutionDO> getSolutionList(SolutionExportReqVO exportReqVO) {
        return solutionMapper.selectList(exportReqVO);
    }

}
