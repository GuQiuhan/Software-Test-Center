package cn.iocoder.yudao.module.system.service.sample;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.sample.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.sample.SampleDO;
import cn.iocoder.yudao.module.system.dal.mysql.sample.SampleMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link SampleServiceImpl} 的单元测试类
*
* @author NJU_Test_Center
*/
@Import(SampleServiceImpl.class)
public class SampleServiceImplTest extends BaseDbUnitTest {

    @Resource
    private SampleServiceImpl sampleService;

    @Resource
    private SampleMapper sampleMapper;

    @Test
    public void testCreateSample_success() {
        // 准备参数
        SampleCreateReqVO reqVO = randomPojo(SampleCreateReqVO.class);

        // 调用
        Long sampleId = sampleService.createSample(reqVO);
        // 断言
        assertNotNull(sampleId);
        // 校验记录的属性是否正确
        SampleDO sample = sampleMapper.selectById(sampleId);
        assertPojoEquals(reqVO, sample);
    }

    @Test
    public void testUpdateSample_success() {
        // mock 数据
        SampleDO dbSample = randomPojo(SampleDO.class);
        sampleMapper.insert(dbSample);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SampleUpdateReqVO reqVO = randomPojo(SampleUpdateReqVO.class, o -> {
            o.setId(dbSample.getId()); // 设置更新的 ID
        });

        // 调用
        sampleService.updateSample(reqVO);
        // 校验是否更新正确
        SampleDO sample = sampleMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, sample);
    }

    @Test
    public void testUpdateSample_notExists() {
        // 准备参数
        SampleUpdateReqVO reqVO = randomPojo(SampleUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> sampleService.updateSample(reqVO), SAMPLE_NOT_EXISTS);
    }

    @Test
    public void testDeleteSample_success() {
        // mock 数据
        SampleDO dbSample = randomPojo(SampleDO.class);
        sampleMapper.insert(dbSample);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSample.getId();

        // 调用
        sampleService.deleteSample(id);
       // 校验数据不存在了
       assertNull(sampleMapper.selectById(id));
    }

    @Test
    public void testDeleteSample_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> sampleService.deleteSample(id), SAMPLE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSamplePage() {
       // mock 数据
       SampleDO dbSample = randomPojo(SampleDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setProcessType(null);
           o.setUrl(null);
           o.setInformation(null);
           o.setAuditorId(null);
           o.setRemark(null);
           o.setModifyRemark(null);
           o.setState(null);
           o.setCreateTime(null);
       });
       sampleMapper.insert(dbSample);
       // 测试 type 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setType(null)));
       // 测试 processType 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setProcessType(null)));
       // 测试 url 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setUrl(null)));
       // 测试 information 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setInformation(null)));
       // 测试 auditorId 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setAuditorId(null)));
       // 测试 remark 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setRemark(null)));
       // 测试 modifyRemark 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setModifyRemark(null)));
       // 测试 state 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setState(null)));
       // 测试 createTime 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setCreateTime(null)));
       // 准备参数
       SamplePageReqVO reqVO = new SamplePageReqVO();
       reqVO.setType(null);
       reqVO.setProcessType(null);
       reqVO.setUrl(null);
       reqVO.setInformation(null);
       reqVO.setAuditorId(null);
       reqVO.setRemark(null);
       reqVO.setModifyRemark(null);
       reqVO.setState(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<SampleDO> pageResult = sampleService.getSamplePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbSample, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetSampleList() {
       // mock 数据
       SampleDO dbSample = randomPojo(SampleDO.class, o -> { // 等会查询到
           o.setType(null);
           o.setProcessType(null);
           o.setUrl(null);
           o.setInformation(null);
           o.setAuditorId(null);
           o.setRemark(null);
           o.setModifyRemark(null);
           o.setState(null);
           o.setCreateTime(null);
       });
       sampleMapper.insert(dbSample);
       // 测试 type 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setType(null)));
       // 测试 processType 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setProcessType(null)));
       // 测试 url 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setUrl(null)));
       // 测试 information 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setInformation(null)));
       // 测试 auditorId 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setAuditorId(null)));
       // 测试 remark 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setRemark(null)));
       // 测试 modifyRemark 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setModifyRemark(null)));
       // 测试 state 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setState(null)));
       // 测试 createTime 不匹配
       sampleMapper.insert(cloneIgnoreId(dbSample, o -> o.setCreateTime(null)));
       // 准备参数
       SampleExportReqVO reqVO = new SampleExportReqVO();
       reqVO.setType(null);
       reqVO.setProcessType(null);
       reqVO.setUrl(null);
       reqVO.setInformation(null);
       reqVO.setAuditorId(null);
       reqVO.setRemark(null);
       reqVO.setModifyRemark(null);
       reqVO.setState(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<SampleDO> list = sampleService.getSampleList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbSample, list.get(0));
    }

}
