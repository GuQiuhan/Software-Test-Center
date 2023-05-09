package cn.iocoder.yudao.module.system.service.flowlog;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.flowlog.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowlog.FlowLogDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.flowlog.FlowLogConvert;
import cn.iocoder.yudao.module.system.dal.mysql.flowlog.FlowLogMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 流程日志 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class FlowLogServiceImpl implements FlowLogService {

    @Resource
    private FlowLogMapper flowLogMapper;

    @Override
    public Long createFlowLog(FlowLogCreateReqVO createReqVO) {
        // 插入
        FlowLogDO flowLog = FlowLogConvert.INSTANCE.convert(createReqVO);
        flowLogMapper.insert(flowLog);
        // 返回
        return flowLog.getId();
    }

    @Override
    public void updateFlowLog(FlowLogUpdateReqVO updateReqVO) {
        // 校验存在
        validateFlowLogExists(updateReqVO.getId());
        // 更新
        FlowLogDO updateObj = FlowLogConvert.INSTANCE.convert(updateReqVO);
        flowLogMapper.updateById(updateObj);
    }

    @Override
    public void deleteFlowLog(Long id) {
        // 校验存在
        validateFlowLogExists(id);
        // 删除
        flowLogMapper.deleteById(id);
    }

    private void validateFlowLogExists(Long id) {
        if (flowLogMapper.selectById(id) == null) {
            throw exception(FLOW_LOG_NOT_EXISTS);
        }
    }

    @Override
    public FlowLogDO getFlowLog(Long id) {
        return flowLogMapper.selectById(id);
    }

    @Override
    public List<FlowLogDO> getFlowLogList(Collection<Long> ids) {
        return flowLogMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<FlowLogDO> getFlowLogPage(FlowLogPageReqVO pageReqVO) {
        return flowLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<FlowLogDO> getFlowLogList(FlowLogExportReqVO exportReqVO) {
        return flowLogMapper.selectList(exportReqVO);
    }

}
