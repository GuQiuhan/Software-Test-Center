package cn.iocoder.yudao.module.pay.convert.app;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.app.PayAppCreateReqVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.app.PayAppExcelVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.app.PayAppPageItemRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.app.PayAppRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.app.PayAppUpdateReqVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.merchant.PayAppDO;
import cn.iocoder.yudao.module.pay.dal.dataobject.merchant.PayMerchantDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:23:08+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class PayAppConvertImpl implements PayAppConvert {

    @Override
    public PayAppPageItemRespVO pageConvert(PayAppDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppPageItemRespVO payAppPageItemRespVO = new PayAppPageItemRespVO();

        payAppPageItemRespVO.setName( bean.getName() );
        payAppPageItemRespVO.setStatus( bean.getStatus() );
        payAppPageItemRespVO.setRemark( bean.getRemark() );
        payAppPageItemRespVO.setPayNotifyUrl( bean.getPayNotifyUrl() );
        payAppPageItemRespVO.setRefundNotifyUrl( bean.getRefundNotifyUrl() );
        payAppPageItemRespVO.setMerchantId( bean.getMerchantId() );
        payAppPageItemRespVO.setId( bean.getId() );
        payAppPageItemRespVO.setCreateTime( bean.getCreateTime() );

        return payAppPageItemRespVO;
    }

    @Override
    public PayAppPageItemRespVO.PayMerchant convert(PayMerchantDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppPageItemRespVO.PayMerchant payMerchant = new PayAppPageItemRespVO.PayMerchant();

        payMerchant.setId( bean.getId() );
        payMerchant.setName( bean.getName() );

        return payMerchant;
    }

    @Override
    public PayAppDO convert(PayAppCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppDO.PayAppDOBuilder payAppDO = PayAppDO.builder();

        payAppDO.name( bean.getName() );
        payAppDO.status( bean.getStatus() );
        payAppDO.remark( bean.getRemark() );
        payAppDO.payNotifyUrl( bean.getPayNotifyUrl() );
        payAppDO.refundNotifyUrl( bean.getRefundNotifyUrl() );
        payAppDO.merchantId( bean.getMerchantId() );

        return payAppDO.build();
    }

    @Override
    public PayAppDO convert(PayAppUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppDO.PayAppDOBuilder payAppDO = PayAppDO.builder();

        payAppDO.id( bean.getId() );
        payAppDO.name( bean.getName() );
        payAppDO.status( bean.getStatus() );
        payAppDO.remark( bean.getRemark() );
        payAppDO.payNotifyUrl( bean.getPayNotifyUrl() );
        payAppDO.refundNotifyUrl( bean.getRefundNotifyUrl() );
        payAppDO.merchantId( bean.getMerchantId() );

        return payAppDO.build();
    }

    @Override
    public PayAppRespVO convert(PayAppDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppRespVO payAppRespVO = new PayAppRespVO();

        payAppRespVO.setName( bean.getName() );
        payAppRespVO.setStatus( bean.getStatus() );
        payAppRespVO.setRemark( bean.getRemark() );
        payAppRespVO.setPayNotifyUrl( bean.getPayNotifyUrl() );
        payAppRespVO.setRefundNotifyUrl( bean.getRefundNotifyUrl() );
        payAppRespVO.setMerchantId( bean.getMerchantId() );
        payAppRespVO.setId( bean.getId() );
        payAppRespVO.setCreateTime( bean.getCreateTime() );

        return payAppRespVO;
    }

    @Override
    public List<PayAppRespVO> convertList(List<PayAppDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayAppRespVO> list1 = new ArrayList<PayAppRespVO>( list.size() );
        for ( PayAppDO payAppDO : list ) {
            list1.add( convert( payAppDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<PayAppRespVO> convertPage(PageResult<PayAppDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayAppRespVO> pageResult = new PageResult<PayAppRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<PayAppExcelVO> convertList02(List<PayAppDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayAppExcelVO> list1 = new ArrayList<PayAppExcelVO>( list.size() );
        for ( PayAppDO payAppDO : list ) {
            list1.add( payAppDOToPayAppExcelVO( payAppDO ) );
        }

        return list1;
    }

    protected PayAppExcelVO payAppDOToPayAppExcelVO(PayAppDO payAppDO) {
        if ( payAppDO == null ) {
            return null;
        }

        PayAppExcelVO payAppExcelVO = new PayAppExcelVO();

        payAppExcelVO.setId( payAppDO.getId() );
        payAppExcelVO.setName( payAppDO.getName() );
        payAppExcelVO.setStatus( payAppDO.getStatus() );
        payAppExcelVO.setRemark( payAppDO.getRemark() );
        payAppExcelVO.setPayNotifyUrl( payAppDO.getPayNotifyUrl() );
        payAppExcelVO.setRefundNotifyUrl( payAppDO.getRefundNotifyUrl() );
        payAppExcelVO.setMerchantId( payAppDO.getMerchantId() );
        payAppExcelVO.setCreateTime( payAppDO.getCreateTime() );

        return payAppExcelVO;
    }
}
