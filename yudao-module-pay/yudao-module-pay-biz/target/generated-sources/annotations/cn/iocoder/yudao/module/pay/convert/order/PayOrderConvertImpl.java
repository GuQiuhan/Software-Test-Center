package cn.iocoder.yudao.module.pay.convert.order;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.pay.core.client.dto.order.PayOrderUnifiedReqDTO;
import cn.iocoder.yudao.framework.pay.core.client.dto.order.PayOrderUnifiedRespDTO;
import cn.iocoder.yudao.module.pay.api.order.dto.PayOrderCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.order.dto.PayOrderRespDTO;
import cn.iocoder.yudao.module.pay.controller.admin.order.vo.PayOrderDetailsRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.order.vo.PayOrderExcelVO;
import cn.iocoder.yudao.module.pay.controller.admin.order.vo.PayOrderPageItemRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.order.vo.PayOrderRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.order.vo.PayOrderSubmitReqVO;
import cn.iocoder.yudao.module.pay.controller.admin.order.vo.PayOrderSubmitRespVO;
import cn.iocoder.yudao.module.pay.controller.app.order.vo.AppPayOrderSubmitRespVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.order.PayOrderDO;
import cn.iocoder.yudao.module.pay.dal.dataobject.order.PayOrderExtensionDO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:23:08+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class PayOrderConvertImpl implements PayOrderConvert {

    @Override
    public PayOrderRespVO convert(PayOrderDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayOrderRespVO payOrderRespVO = new PayOrderRespVO();

        payOrderRespVO.setMerchantId( bean.getMerchantId() );
        payOrderRespVO.setAppId( bean.getAppId() );
        payOrderRespVO.setChannelId( bean.getChannelId() );
        payOrderRespVO.setChannelCode( bean.getChannelCode() );
        payOrderRespVO.setMerchantOrderId( bean.getMerchantOrderId() );
        payOrderRespVO.setSubject( bean.getSubject() );
        payOrderRespVO.setBody( bean.getBody() );
        payOrderRespVO.setNotifyUrl( bean.getNotifyUrl() );
        payOrderRespVO.setNotifyStatus( bean.getNotifyStatus() );
        if ( bean.getAmount() != null ) {
            payOrderRespVO.setAmount( bean.getAmount().longValue() );
        }
        payOrderRespVO.setChannelFeeRate( bean.getChannelFeeRate() );
        payOrderRespVO.setChannelFeeAmount( bean.getChannelFeeAmount() );
        payOrderRespVO.setStatus( bean.getStatus() );
        payOrderRespVO.setUserIp( bean.getUserIp() );
        payOrderRespVO.setExpireTime( bean.getExpireTime() );
        payOrderRespVO.setSuccessTime( bean.getSuccessTime() );
        payOrderRespVO.setNotifyTime( bean.getNotifyTime() );
        payOrderRespVO.setSuccessExtensionId( bean.getSuccessExtensionId() );
        payOrderRespVO.setRefundStatus( bean.getRefundStatus() );
        payOrderRespVO.setRefundTimes( bean.getRefundTimes() );
        payOrderRespVO.setRefundAmount( bean.getRefundAmount() );
        payOrderRespVO.setChannelUserId( bean.getChannelUserId() );
        payOrderRespVO.setChannelOrderNo( bean.getChannelOrderNo() );
        payOrderRespVO.setId( bean.getId() );
        payOrderRespVO.setCreateTime( bean.getCreateTime() );

        return payOrderRespVO;
    }

    @Override
    public PayOrderRespDTO convert2(PayOrderDO order) {
        if ( order == null ) {
            return null;
        }

        PayOrderRespDTO payOrderRespDTO = new PayOrderRespDTO();

        payOrderRespDTO.setId( order.getId() );
        payOrderRespDTO.setChannelCode( order.getChannelCode() );
        payOrderRespDTO.setMerchantOrderId( order.getMerchantOrderId() );
        payOrderRespDTO.setAmount( order.getAmount() );
        payOrderRespDTO.setStatus( order.getStatus() );

        return payOrderRespDTO;
    }

    @Override
    public PayOrderDetailsRespVO orderDetailConvert(PayOrderDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayOrderDetailsRespVO payOrderDetailsRespVO = new PayOrderDetailsRespVO();

        payOrderDetailsRespVO.setMerchantId( bean.getMerchantId() );
        payOrderDetailsRespVO.setAppId( bean.getAppId() );
        payOrderDetailsRespVO.setChannelId( bean.getChannelId() );
        payOrderDetailsRespVO.setChannelCode( bean.getChannelCode() );
        payOrderDetailsRespVO.setMerchantOrderId( bean.getMerchantOrderId() );
        payOrderDetailsRespVO.setSubject( bean.getSubject() );
        payOrderDetailsRespVO.setBody( bean.getBody() );
        payOrderDetailsRespVO.setNotifyUrl( bean.getNotifyUrl() );
        payOrderDetailsRespVO.setNotifyStatus( bean.getNotifyStatus() );
        if ( bean.getAmount() != null ) {
            payOrderDetailsRespVO.setAmount( bean.getAmount().longValue() );
        }
        payOrderDetailsRespVO.setChannelFeeRate( bean.getChannelFeeRate() );
        payOrderDetailsRespVO.setChannelFeeAmount( bean.getChannelFeeAmount() );
        payOrderDetailsRespVO.setStatus( bean.getStatus() );
        payOrderDetailsRespVO.setUserIp( bean.getUserIp() );
        payOrderDetailsRespVO.setExpireTime( bean.getExpireTime() );
        payOrderDetailsRespVO.setSuccessTime( bean.getSuccessTime() );
        payOrderDetailsRespVO.setNotifyTime( bean.getNotifyTime() );
        payOrderDetailsRespVO.setSuccessExtensionId( bean.getSuccessExtensionId() );
        payOrderDetailsRespVO.setRefundStatus( bean.getRefundStatus() );
        payOrderDetailsRespVO.setRefundTimes( bean.getRefundTimes() );
        payOrderDetailsRespVO.setRefundAmount( bean.getRefundAmount() );
        payOrderDetailsRespVO.setChannelUserId( bean.getChannelUserId() );
        payOrderDetailsRespVO.setChannelOrderNo( bean.getChannelOrderNo() );
        payOrderDetailsRespVO.setId( bean.getId() );
        payOrderDetailsRespVO.setCreateTime( bean.getCreateTime() );

        return payOrderDetailsRespVO;
    }

    @Override
    public PayOrderDetailsRespVO.PayOrderExtension orderDetailExtensionConvert(PayOrderExtensionDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayOrderDetailsRespVO.PayOrderExtension payOrderExtension = new PayOrderDetailsRespVO.PayOrderExtension();

        payOrderExtension.setNo( bean.getNo() );
        payOrderExtension.setChannelNotifyData( bean.getChannelNotifyData() );

        return payOrderExtension;
    }

    @Override
    public List<PayOrderRespVO> convertList(List<PayOrderDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayOrderRespVO> list1 = new ArrayList<PayOrderRespVO>( list.size() );
        for ( PayOrderDO payOrderDO : list ) {
            list1.add( convert( payOrderDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<PayOrderRespVO> convertPage(PageResult<PayOrderDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayOrderRespVO> pageResult = new PageResult<PayOrderRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<PayOrderExcelVO> convertList02(List<PayOrderDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayOrderExcelVO> list1 = new ArrayList<PayOrderExcelVO>( list.size() );
        for ( PayOrderDO payOrderDO : list ) {
            list1.add( excelConvert( payOrderDO ) );
        }

        return list1;
    }

    @Override
    public PayOrderPageItemRespVO pageConvertItemPage(PayOrderDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayOrderPageItemRespVO payOrderPageItemRespVO = new PayOrderPageItemRespVO();

        payOrderPageItemRespVO.setMerchantId( bean.getMerchantId() );
        payOrderPageItemRespVO.setAppId( bean.getAppId() );
        payOrderPageItemRespVO.setChannelId( bean.getChannelId() );
        payOrderPageItemRespVO.setChannelCode( bean.getChannelCode() );
        payOrderPageItemRespVO.setMerchantOrderId( bean.getMerchantOrderId() );
        payOrderPageItemRespVO.setSubject( bean.getSubject() );
        payOrderPageItemRespVO.setBody( bean.getBody() );
        payOrderPageItemRespVO.setNotifyUrl( bean.getNotifyUrl() );
        payOrderPageItemRespVO.setNotifyStatus( bean.getNotifyStatus() );
        if ( bean.getAmount() != null ) {
            payOrderPageItemRespVO.setAmount( bean.getAmount().longValue() );
        }
        payOrderPageItemRespVO.setChannelFeeRate( bean.getChannelFeeRate() );
        payOrderPageItemRespVO.setChannelFeeAmount( bean.getChannelFeeAmount() );
        payOrderPageItemRespVO.setStatus( bean.getStatus() );
        payOrderPageItemRespVO.setUserIp( bean.getUserIp() );
        payOrderPageItemRespVO.setExpireTime( bean.getExpireTime() );
        payOrderPageItemRespVO.setSuccessTime( bean.getSuccessTime() );
        payOrderPageItemRespVO.setNotifyTime( bean.getNotifyTime() );
        payOrderPageItemRespVO.setSuccessExtensionId( bean.getSuccessExtensionId() );
        payOrderPageItemRespVO.setRefundStatus( bean.getRefundStatus() );
        payOrderPageItemRespVO.setRefundTimes( bean.getRefundTimes() );
        payOrderPageItemRespVO.setRefundAmount( bean.getRefundAmount() );
        payOrderPageItemRespVO.setChannelUserId( bean.getChannelUserId() );
        payOrderPageItemRespVO.setChannelOrderNo( bean.getChannelOrderNo() );
        payOrderPageItemRespVO.setId( bean.getId() );
        payOrderPageItemRespVO.setCreateTime( bean.getCreateTime() );

        return payOrderPageItemRespVO;
    }

    @Override
    public PayOrderDO convert(PayOrderCreateReqDTO bean) {
        if ( bean == null ) {
            return null;
        }

        PayOrderDO.PayOrderDOBuilder payOrderDO = PayOrderDO.builder();

        payOrderDO.appId( bean.getAppId() );
        payOrderDO.merchantOrderId( bean.getMerchantOrderId() );
        payOrderDO.subject( bean.getSubject() );
        payOrderDO.body( bean.getBody() );
        payOrderDO.amount( bean.getAmount() );
        payOrderDO.userIp( bean.getUserIp() );
        payOrderDO.expireTime( bean.getExpireTime() );

        return payOrderDO.build();
    }

    @Override
    public PayOrderExtensionDO convert(PayOrderSubmitReqVO bean, String userIp) {
        if ( bean == null && userIp == null ) {
            return null;
        }

        PayOrderExtensionDO.PayOrderExtensionDOBuilder payOrderExtensionDO = PayOrderExtensionDO.builder();

        if ( bean != null ) {
            payOrderExtensionDO.channelCode( bean.getChannelCode() );
            Map<String, String> map = bean.getChannelExtras();
            if ( map != null ) {
                payOrderExtensionDO.channelExtras( new LinkedHashMap<String, String>( map ) );
            }
        }
        payOrderExtensionDO.userIp( userIp );

        return payOrderExtensionDO.build();
    }

    @Override
    public PayOrderUnifiedReqDTO convert2(PayOrderSubmitReqVO reqVO) {
        if ( reqVO == null ) {
            return null;
        }

        PayOrderUnifiedReqDTO payOrderUnifiedReqDTO = new PayOrderUnifiedReqDTO();

        Map<String, String> map = reqVO.getChannelExtras();
        if ( map != null ) {
            payOrderUnifiedReqDTO.setChannelExtras( new LinkedHashMap<String, String>( map ) );
        }
        payOrderUnifiedReqDTO.setDisplayMode( reqVO.getDisplayMode() );

        return payOrderUnifiedReqDTO;
    }

    @Override
    public PayOrderSubmitRespVO convert(PayOrderUnifiedRespDTO bean) {
        if ( bean == null ) {
            return null;
        }

        PayOrderSubmitRespVO payOrderSubmitRespVO = new PayOrderSubmitRespVO();

        payOrderSubmitRespVO.setDisplayMode( bean.getDisplayMode() );
        payOrderSubmitRespVO.setDisplayContent( bean.getDisplayContent() );

        return payOrderSubmitRespVO;
    }

    @Override
    public AppPayOrderSubmitRespVO convert3(PayOrderSubmitRespVO bean) {
        if ( bean == null ) {
            return null;
        }

        AppPayOrderSubmitRespVO appPayOrderSubmitRespVO = new AppPayOrderSubmitRespVO();

        appPayOrderSubmitRespVO.setDisplayMode( bean.getDisplayMode() );
        appPayOrderSubmitRespVO.setDisplayContent( bean.getDisplayContent() );

        return appPayOrderSubmitRespVO;
    }
}
