package cn.iocoder.yudao.module.system.service.operation;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.operation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.operation.OperationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 流程操作 Service 接口
 *
 * @author NJU_Test_Center
 */
public interface OperationService {

    /**
     * 创建流程操作
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOperation(@Valid OperationCreateReqVO createReqVO);

    /**
     * 更新流程操作
     *
     * @param updateReqVO 更新信息
     */
    void updateOperation(@Valid OperationUpdateReqVO updateReqVO);

    /**
     * 删除流程操作
     *
     * @param id 编号
     */
    void deleteOperation(Long id);

    /**
     * 获得流程操作
     *
     * @param id 编号
     * @return 流程操作
     */
    OperationDO getOperation(Long id);

    /**
     * 获得流程操作列表
     *
     * @param ids 编号
     * @return 流程操作列表
     */
    List<OperationDO> getOperationList(Collection<Long> ids);

    /**
     * 获得流程操作分页
     *
     * @param pageReqVO 分页查询
     * @return 流程操作分页
     */
    PageResult<OperationDO> getOperationPage(OperationPageReqVO pageReqVO);

    /**
     * 获得流程操作列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 流程操作列表
     */
    List<OperationDO> getOperationList(OperationExportReqVO exportReqVO);

}
