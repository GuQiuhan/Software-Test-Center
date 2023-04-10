package cn.iocoder.yudao.module.pay.convert.channel;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.channel.PayChannelCreateReqVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.channel.PayChannelExcelVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.channel.PayChannelRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.channel.PayChannelUpdateReqVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.merchant.PayChannelDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:23:08+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class PayChannelConvertImpl implements PayChannelConvert {

    @Override
    public PayChannelDO convert(PayChannelCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayChannelDO.PayChannelDOBuilder payChannelDO = PayChannelDO.builder();

        payChannelDO.code( bean.getCode() );
        payChannelDO.status( bean.getStatus() );
        payChannelDO.feeRate( bean.getFeeRate() );
        payChannelDO.remark( bean.getRemark() );
        payChannelDO.merchantId( bean.getMerchantId() );
        payChannelDO.appId( bean.getAppId() );

        return payChannelDO.build();
    }

    @Override
    public PayChannelDO convert(PayChannelUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayChannelDO.PayChannelDOBuilder payChannelDO = PayChannelDO.builder();

        payChannelDO.id( bean.getId() );
        payChannelDO.code( bean.getCode() );
        payChannelDO.status( bean.getStatus() );
        payChannelDO.feeRate( bean.getFeeRate() );
        payChannelDO.remark( bean.getRemark() );
        payChannelDO.merchantId( bean.getMerchantId() );
        payChannelDO.appId( bean.getAppId() );

        return payChannelDO.build();
    }

    @Override
    public PayChannelRespVO convert(PayChannelDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayChannelRespVO payChannelRespVO = new PayChannelRespVO();

        payChannelRespVO.setCode( bean.getCode() );
        payChannelRespVO.setStatus( bean.getStatus() );
        payChannelRespVO.setRemark( bean.getRemark() );
        payChannelRespVO.setFeeRate( bean.getFeeRate() );
        payChannelRespVO.setMerchantId( bean.getMerchantId() );
        payChannelRespVO.setAppId( bean.getAppId() );
        payChannelRespVO.setId( bean.getId() );
        payChannelRespVO.setCreateTime( bean.getCreateTime() );

        payChannelRespVO.setConfig( cn.iocoder.yudao.framework.common.util.json.JsonUtils.toJsonString(bean.getConfig()) );

        return payChannelRespVO;
    }

    @Override
    public List<PayChannelRespVO> convertList(List<PayChannelDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayChannelRespVO> list1 = new ArrayList<PayChannelRespVO>( list.size() );
        for ( PayChannelDO payChannelDO : list ) {
            list1.add( convert( payChannelDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<PayChannelRespVO> convertPage(PageResult<PayChannelDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayChannelRespVO> pageResult = new PageResult<PayChannelRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<PayChannelExcelVO> convertList02(List<PayChannelDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayChannelExcelVO> list1 = new ArrayList<PayChannelExcelVO>( list.size() );
        for ( PayChannelDO payChannelDO : list ) {
            list1.add( payChannelDOToPayChannelExcelVO( payChannelDO ) );
        }

        return list1;
    }

    protected PayChannelExcelVO payChannelDOToPayChannelExcelVO(PayChannelDO payChannelDO) {
        if ( payChannelDO == null ) {
            return null;
        }

        PayChannelExcelVO payChannelExcelVO = new PayChannelExcelVO();

        payChannelExcelVO.setId( payChannelDO.getId() );
        payChannelExcelVO.setCode( payChannelDO.getCode() );
        payChannelExcelVO.setStatus( payChannelDO.getStatus() );
        payChannelExcelVO.setRemark( payChannelDO.getRemark() );
        payChannelExcelVO.setFeeRate( payChannelDO.getFeeRate() );
        payChannelExcelVO.setMerchantId( payChannelDO.getMerchantId() );
        payChannelExcelVO.setAppId( payChannelDO.getAppId() );
        payChannelExcelVO.setCreateTime( payChannelDO.getCreateTime() );

        return payChannelExcelVO;
    }
}
