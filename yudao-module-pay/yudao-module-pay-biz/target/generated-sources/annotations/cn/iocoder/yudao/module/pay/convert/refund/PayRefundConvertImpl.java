package cn.iocoder.yudao.module.pay.convert.refund;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.pay.controller.admin.refund.vo.PayRefundCreateReqVO;
import cn.iocoder.yudao.module.pay.controller.admin.refund.vo.PayRefundDetailsRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.refund.vo.PayRefundExcelVO;
import cn.iocoder.yudao.module.pay.controller.admin.refund.vo.PayRefundPageItemRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.refund.vo.PayRefundRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.refund.vo.PayRefundUpdateReqVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.order.PayOrderDO;
import cn.iocoder.yudao.module.pay.dal.dataobject.refund.PayRefundDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:23:08+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class PayRefundConvertImpl implements PayRefundConvert {

    @Override
    public PayRefundDO convert(PayRefundCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayRefundDO.PayRefundDOBuilder payRefundDO = PayRefundDO.builder();

        payRefundDO.merchantId( bean.getMerchantId() );
        payRefundDO.appId( bean.getAppId() );
        payRefundDO.channelId( bean.getChannelId() );
        payRefundDO.channelCode( bean.getChannelCode() );
        payRefundDO.orderId( bean.getOrderId() );
        payRefundDO.tradeNo( bean.getTradeNo() );
        payRefundDO.merchantOrderId( bean.getMerchantOrderId() );
        payRefundDO.merchantRefundNo( bean.getMerchantRefundNo() );
        payRefundDO.notifyUrl( bean.getNotifyUrl() );
        payRefundDO.notifyStatus( bean.getNotifyStatus() );
        payRefundDO.status( bean.getStatus() );
        payRefundDO.type( bean.getType() );
        if ( bean.getPayAmount() != null ) {
            payRefundDO.payAmount( bean.getPayAmount().intValue() );
        }
        if ( bean.getRefundAmount() != null ) {
            payRefundDO.refundAmount( bean.getRefundAmount().intValue() );
        }
        payRefundDO.reason( bean.getReason() );
        payRefundDO.userIp( bean.getUserIp() );
        payRefundDO.channelOrderNo( bean.getChannelOrderNo() );
        payRefundDO.channelRefundNo( bean.getChannelRefundNo() );
        payRefundDO.channelErrorCode( bean.getChannelErrorCode() );
        payRefundDO.channelErrorMsg( bean.getChannelErrorMsg() );
        payRefundDO.channelExtras( bean.getChannelExtras() );
        payRefundDO.expireTime( bean.getExpireTime() );
        payRefundDO.successTime( bean.getSuccessTime() );
        payRefundDO.notifyTime( bean.getNotifyTime() );

        return payRefundDO.build();
    }

    @Override
    public PayRefundDO convert(PayRefundUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayRefundDO.PayRefundDOBuilder payRefundDO = PayRefundDO.builder();

        payRefundDO.id( bean.getId() );
        payRefundDO.merchantId( bean.getMerchantId() );
        payRefundDO.appId( bean.getAppId() );
        payRefundDO.channelId( bean.getChannelId() );
        payRefundDO.channelCode( bean.getChannelCode() );
        payRefundDO.orderId( bean.getOrderId() );
        payRefundDO.tradeNo( bean.getTradeNo() );
        payRefundDO.merchantOrderId( bean.getMerchantOrderId() );
        payRefundDO.merchantRefundNo( bean.getMerchantRefundNo() );
        payRefundDO.notifyUrl( bean.getNotifyUrl() );
        payRefundDO.notifyStatus( bean.getNotifyStatus() );
        payRefundDO.status( bean.getStatus() );
        payRefundDO.type( bean.getType() );
        if ( bean.getPayAmount() != null ) {
            payRefundDO.payAmount( bean.getPayAmount().intValue() );
        }
        if ( bean.getRefundAmount() != null ) {
            payRefundDO.refundAmount( bean.getRefundAmount().intValue() );
        }
        payRefundDO.reason( bean.getReason() );
        payRefundDO.userIp( bean.getUserIp() );
        payRefundDO.channelOrderNo( bean.getChannelOrderNo() );
        payRefundDO.channelRefundNo( bean.getChannelRefundNo() );
        payRefundDO.channelErrorCode( bean.getChannelErrorCode() );
        payRefundDO.channelErrorMsg( bean.getChannelErrorMsg() );
        payRefundDO.channelExtras( bean.getChannelExtras() );
        payRefundDO.expireTime( bean.getExpireTime() );
        payRefundDO.successTime( bean.getSuccessTime() );
        payRefundDO.notifyTime( bean.getNotifyTime() );

        return payRefundDO.build();
    }

    @Override
    public PayRefundRespVO convert(PayRefundDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayRefundRespVO payRefundRespVO = new PayRefundRespVO();

        payRefundRespVO.setMerchantId( bean.getMerchantId() );
        payRefundRespVO.setAppId( bean.getAppId() );
        payRefundRespVO.setChannelId( bean.getChannelId() );
        payRefundRespVO.setChannelCode( bean.getChannelCode() );
        payRefundRespVO.setOrderId( bean.getOrderId() );
        payRefundRespVO.setTradeNo( bean.getTradeNo() );
        payRefundRespVO.setMerchantOrderId( bean.getMerchantOrderId() );
        payRefundRespVO.setMerchantRefundNo( bean.getMerchantRefundNo() );
        payRefundRespVO.setNotifyUrl( bean.getNotifyUrl() );
        payRefundRespVO.setNotifyStatus( bean.getNotifyStatus() );
        payRefundRespVO.setStatus( bean.getStatus() );
        payRefundRespVO.setType( bean.getType() );
        if ( bean.getPayAmount() != null ) {
            payRefundRespVO.setPayAmount( bean.getPayAmount().longValue() );
        }
        if ( bean.getRefundAmount() != null ) {
            payRefundRespVO.setRefundAmount( bean.getRefundAmount().longValue() );
        }
        payRefundRespVO.setReason( bean.getReason() );
        payRefundRespVO.setUserIp( bean.getUserIp() );
        payRefundRespVO.setChannelOrderNo( bean.getChannelOrderNo() );
        payRefundRespVO.setChannelRefundNo( bean.getChannelRefundNo() );
        payRefundRespVO.setChannelErrorCode( bean.getChannelErrorCode() );
        payRefundRespVO.setChannelErrorMsg( bean.getChannelErrorMsg() );
        payRefundRespVO.setChannelExtras( bean.getChannelExtras() );
        payRefundRespVO.setExpireTime( bean.getExpireTime() );
        payRefundRespVO.setSuccessTime( bean.getSuccessTime() );
        payRefundRespVO.setNotifyTime( bean.getNotifyTime() );
        payRefundRespVO.setId( bean.getId() );
        payRefundRespVO.setCreateTime( bean.getCreateTime() );

        return payRefundRespVO;
    }

    @Override
    public PayRefundDetailsRespVO refundDetailConvert(PayRefundDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayRefundDetailsRespVO payRefundDetailsRespVO = new PayRefundDetailsRespVO();

        payRefundDetailsRespVO.setMerchantId( bean.getMerchantId() );
        payRefundDetailsRespVO.setAppId( bean.getAppId() );
        payRefundDetailsRespVO.setChannelId( bean.getChannelId() );
        payRefundDetailsRespVO.setChannelCode( bean.getChannelCode() );
        payRefundDetailsRespVO.setOrderId( bean.getOrderId() );
        payRefundDetailsRespVO.setTradeNo( bean.getTradeNo() );
        payRefundDetailsRespVO.setMerchantOrderId( bean.getMerchantOrderId() );
        payRefundDetailsRespVO.setMerchantRefundNo( bean.getMerchantRefundNo() );
        payRefundDetailsRespVO.setNotifyUrl( bean.getNotifyUrl() );
        payRefundDetailsRespVO.setNotifyStatus( bean.getNotifyStatus() );
        payRefundDetailsRespVO.setStatus( bean.getStatus() );
        payRefundDetailsRespVO.setType( bean.getType() );
        if ( bean.getPayAmount() != null ) {
            payRefundDetailsRespVO.setPayAmount( bean.getPayAmount().longValue() );
        }
        if ( bean.getRefundAmount() != null ) {
            payRefundDetailsRespVO.setRefundAmount( bean.getRefundAmount().longValue() );
        }
        payRefundDetailsRespVO.setReason( bean.getReason() );
        payRefundDetailsRespVO.setUserIp( bean.getUserIp() );
        payRefundDetailsRespVO.setChannelOrderNo( bean.getChannelOrderNo() );
        payRefundDetailsRespVO.setChannelRefundNo( bean.getChannelRefundNo() );
        payRefundDetailsRespVO.setChannelErrorCode( bean.getChannelErrorCode() );
        payRefundDetailsRespVO.setChannelErrorMsg( bean.getChannelErrorMsg() );
        payRefundDetailsRespVO.setChannelExtras( bean.getChannelExtras() );
        payRefundDetailsRespVO.setExpireTime( bean.getExpireTime() );
        payRefundDetailsRespVO.setSuccessTime( bean.getSuccessTime() );
        payRefundDetailsRespVO.setNotifyTime( bean.getNotifyTime() );
        payRefundDetailsRespVO.setId( bean.getId() );
        payRefundDetailsRespVO.setCreateTime( bean.getCreateTime() );
        payRefundDetailsRespVO.setUpdateTime( bean.getUpdateTime() );

        return payRefundDetailsRespVO;
    }

    @Override
    public PayRefundPageItemRespVO pageItemConvert(PayRefundDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayRefundPageItemRespVO payRefundPageItemRespVO = new PayRefundPageItemRespVO();

        payRefundPageItemRespVO.setMerchantId( bean.getMerchantId() );
        payRefundPageItemRespVO.setAppId( bean.getAppId() );
        payRefundPageItemRespVO.setChannelId( bean.getChannelId() );
        payRefundPageItemRespVO.setChannelCode( bean.getChannelCode() );
        payRefundPageItemRespVO.setOrderId( bean.getOrderId() );
        payRefundPageItemRespVO.setTradeNo( bean.getTradeNo() );
        payRefundPageItemRespVO.setMerchantOrderId( bean.getMerchantOrderId() );
        payRefundPageItemRespVO.setMerchantRefundNo( bean.getMerchantRefundNo() );
        payRefundPageItemRespVO.setNotifyUrl( bean.getNotifyUrl() );
        payRefundPageItemRespVO.setNotifyStatus( bean.getNotifyStatus() );
        payRefundPageItemRespVO.setStatus( bean.getStatus() );
        payRefundPageItemRespVO.setType( bean.getType() );
        if ( bean.getPayAmount() != null ) {
            payRefundPageItemRespVO.setPayAmount( bean.getPayAmount().longValue() );
        }
        if ( bean.getRefundAmount() != null ) {
            payRefundPageItemRespVO.setRefundAmount( bean.getRefundAmount().longValue() );
        }
        payRefundPageItemRespVO.setReason( bean.getReason() );
        payRefundPageItemRespVO.setUserIp( bean.getUserIp() );
        payRefundPageItemRespVO.setChannelOrderNo( bean.getChannelOrderNo() );
        payRefundPageItemRespVO.setChannelRefundNo( bean.getChannelRefundNo() );
        payRefundPageItemRespVO.setChannelErrorCode( bean.getChannelErrorCode() );
        payRefundPageItemRespVO.setChannelErrorMsg( bean.getChannelErrorMsg() );
        payRefundPageItemRespVO.setChannelExtras( bean.getChannelExtras() );
        payRefundPageItemRespVO.setExpireTime( bean.getExpireTime() );
        payRefundPageItemRespVO.setSuccessTime( bean.getSuccessTime() );
        payRefundPageItemRespVO.setNotifyTime( bean.getNotifyTime() );
        payRefundPageItemRespVO.setId( bean.getId() );
        payRefundPageItemRespVO.setCreateTime( bean.getCreateTime() );

        return payRefundPageItemRespVO;
    }

    @Override
    public List<PayRefundRespVO> convertList(List<PayRefundDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayRefundRespVO> list1 = new ArrayList<PayRefundRespVO>( list.size() );
        for ( PayRefundDO payRefundDO : list ) {
            list1.add( convert( payRefundDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<PayRefundRespVO> convertPage(PageResult<PayRefundDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayRefundRespVO> pageResult = new PageResult<PayRefundRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<PayRefundExcelVO> convertList02(List<PayRefundDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayRefundExcelVO> list1 = new ArrayList<PayRefundExcelVO>( list.size() );
        for ( PayRefundDO payRefundDO : list ) {
            list1.add( excelConvert( payRefundDO ) );
        }

        return list1;
    }

    @Override
    public PayRefundDO convert(PayOrderDO orderDO) {
        if ( orderDO == null ) {
            return null;
        }

        PayRefundDO.PayRefundDOBuilder payRefundDO = PayRefundDO.builder();

        payRefundDO.payAmount( orderDO.getAmount() );
        payRefundDO.orderId( orderDO.getId() );
        payRefundDO.id( orderDO.getId() );
        payRefundDO.merchantId( orderDO.getMerchantId() );
        payRefundDO.appId( orderDO.getAppId() );
        payRefundDO.channelId( orderDO.getChannelId() );
        payRefundDO.channelCode( orderDO.getChannelCode() );
        payRefundDO.merchantOrderId( orderDO.getMerchantOrderId() );
        payRefundDO.notifyUrl( orderDO.getNotifyUrl() );
        payRefundDO.notifyStatus( orderDO.getNotifyStatus() );
        if ( orderDO.getRefundAmount() != null ) {
            payRefundDO.refundAmount( orderDO.getRefundAmount().intValue() );
        }
        payRefundDO.userIp( orderDO.getUserIp() );
        payRefundDO.channelOrderNo( orderDO.getChannelOrderNo() );
        payRefundDO.expireTime( orderDO.getExpireTime() );
        payRefundDO.successTime( orderDO.getSuccessTime() );
        payRefundDO.notifyTime( orderDO.getNotifyTime() );

        return payRefundDO.build();
    }
}
