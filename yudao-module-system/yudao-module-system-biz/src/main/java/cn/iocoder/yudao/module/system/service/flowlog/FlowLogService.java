package cn.iocoder.yudao.module.system.service.flowlog;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.flowlog.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowlog.FlowLogDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 流程日志 Service 接口
 *
 * @author NJU_Test_Center
 */
public interface FlowLogService {

    /**
     * 创建流程日志
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFlowLog(@Valid FlowLogCreateReqVO createReqVO);

    /**
     * 更新流程日志
     *
     * @param updateReqVO 更新信息
     */
    void updateFlowLog(@Valid FlowLogUpdateReqVO updateReqVO);

    /**
     * 删除流程日志
     *
     * @param id 编号
     */
    void deleteFlowLog(Long id);

    /**
     * 获得流程日志
     *
     * @param id 编号
     * @return 流程日志
     */
    FlowLogDO getFlowLog(Long id);

    /**
     * 获得流程日志列表
     *
     * @param ids 编号
     * @return 流程日志列表
     */
    List<FlowLogDO> getFlowLogList(Collection<Long> ids);

    /**
     * 获得流程日志分页
     *
     * @param pageReqVO 分页查询
     * @return 流程日志分页
     */
    PageResult<FlowLogDO> getFlowLogPage(FlowLogPageReqVO pageReqVO);

    /**
     * 获得流程日志列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 流程日志列表
     */
    List<FlowLogDO> getFlowLogList(FlowLogExportReqVO exportReqVO);

}
