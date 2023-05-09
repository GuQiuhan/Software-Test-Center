package cn.iocoder.yudao.module.system.service.solution;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.solution.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.solution.SolutionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 测试方案 Service 接口
 *
 * @author NJU_Test_Center
 */
public interface SolutionService {

    /**
     * 创建测试方案
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSolution(@Valid SolutionCreateReqVO createReqVO);

    /**
     * 更新测试方案
     *
     * @param updateReqVO 更新信息
     */
    void updateSolution(@Valid SolutionUpdateReqVO updateReqVO);

    /**
     * 删除测试方案
     *
     * @param id 编号
     */
    void deleteSolution(Long id);

    /**
     * 获得测试方案
     *
     * @param id 编号
     * @return 测试方案
     */
    SolutionDO getSolution(Long id);

    /**
     * 获得测试方案列表
     *
     * @param ids 编号
     * @return 测试方案列表
     */
    List<SolutionDO> getSolutionList(Collection<Long> ids);

    /**
     * 获得测试方案分页
     *
     * @param pageReqVO 分页查询
     * @return 测试方案分页
     */
    PageResult<SolutionDO> getSolutionPage(SolutionPageReqVO pageReqVO);

    /**
     * 获得测试方案列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 测试方案列表
     */
    List<SolutionDO> getSolutionList(SolutionExportReqVO exportReqVO);

}
