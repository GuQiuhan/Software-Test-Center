package cn.iocoder.yudao.adminserver.modules.bpm.framework.activiti.core.behavior;

import cn.iocoder.yudao.adminserver.modules.bpm.service.definition.BpmTaskAssignRuleService;
import cn.iocoder.yudao.adminserver.modules.system.service.permission.SysPermissionService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.bpmn.parser.factory.DefaultActivityBehaviorFactory;

/**
 * 自定义的 ActivityBehaviorFactory 实现类，目的如下：
 * 1. 自定义 {@link #createUserTaskActivityBehavior(UserTask)}：实现自定义的流程任务的 assignee 负责人的分配
 *
 * @author 芋道源码
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmActivityBehaviorFactory extends DefaultActivityBehaviorFactory {

    @Setter
    private BpmTaskAssignRuleService bpmTaskRuleService;
    @Setter
    private SysPermissionService permissionService;

    @Override
    public UserTaskActivityBehavior createUserTaskActivityBehavior(UserTask userTask) {
        BpmUserTaskActivitiBehavior userTaskActivityBehavior = new BpmUserTaskActivitiBehavior(userTask);
        userTaskActivityBehavior.setBpmTaskRuleService(bpmTaskRuleService);
        userTaskActivityBehavior.setPermissionService(permissionService);
        return userTaskActivityBehavior;
    }

    // TODO 芋艿：并行任务 ParallelMultiInstanceBehavior

    // TODO 芋艿：并行任务 SequentialMultiInstanceBehavior

}
