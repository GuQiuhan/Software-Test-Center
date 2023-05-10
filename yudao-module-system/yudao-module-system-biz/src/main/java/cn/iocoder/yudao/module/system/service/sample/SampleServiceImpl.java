package cn.iocoder.yudao.module.system.service.sample;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.sample.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sample.SampleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.sample.SampleConvert;
import cn.iocoder.yudao.module.system.dal.mysql.sample.SampleMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 样品 Service 实现类
 *
 * @author NJU_Test_Center
 */
@Service
@Validated
public class SampleServiceImpl implements SampleService {

    @Resource
    private SampleMapper sampleMapper;

    @Override
    public Long createSample(SampleCreateReqVO createReqVO) {
        // 插入
        SampleDO sample = SampleConvert.INSTANCE.convert(createReqVO);
        sampleMapper.insert(sample);
        // 返回
        return sample.getId();
    }

    @Override
    public void updateSample(SampleUpdateReqVO updateReqVO) {
        // 校验存在
        validateSampleExists(updateReqVO.getId());
        // 更新
        SampleDO updateObj = SampleConvert.INSTANCE.convert(updateReqVO);
        sampleMapper.updateById(updateObj);
    }

    @Override
    public void deleteSample(Long id) {
        // 校验存在
        validateSampleExists(id);
        // 删除
        sampleMapper.deleteById(id);
    }

    private void validateSampleExists(Long id) {
        if (sampleMapper.selectById(id) == null) {
            throw exception(SAMPLE_NOT_EXISTS);
        }
    }

    @Override
    public SampleDO getSample(Long id) {
        return sampleMapper.selectById(id);
    }

    @Override
    public List<SampleDO> getSampleList(Collection<Long> ids) {
        return sampleMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<SampleDO> getSamplePage(SamplePageReqVO pageReqVO) {
        return sampleMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SampleDO> getSampleList(SampleExportReqVO exportReqVO) {
        return sampleMapper.selectList(exportReqVO);
    }

}
