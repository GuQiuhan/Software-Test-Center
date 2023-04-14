package cn.iocoder.yudao.module.pay.convert.merchant;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.merchant.PayMerchantCreateReqVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.merchant.PayMerchantExcelVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.merchant.PayMerchantRespVO;
import cn.iocoder.yudao.module.pay.controller.admin.merchant.vo.merchant.PayMerchantUpdateReqVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.merchant.PayMerchantDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:23:08+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class PayMerchantConvertImpl implements PayMerchantConvert {

    @Override
    public PayMerchantDO convert(PayMerchantCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayMerchantDO.PayMerchantDOBuilder payMerchantDO = PayMerchantDO.builder();

        payMerchantDO.name( bean.getName() );
        payMerchantDO.shortName( bean.getShortName() );
        payMerchantDO.status( bean.getStatus() );
        payMerchantDO.remark( bean.getRemark() );

        return payMerchantDO.build();
    }

    @Override
    public PayMerchantDO convert(PayMerchantUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayMerchantDO.PayMerchantDOBuilder payMerchantDO = PayMerchantDO.builder();

        payMerchantDO.id( bean.getId() );
        payMerchantDO.name( bean.getName() );
        payMerchantDO.shortName( bean.getShortName() );
        payMerchantDO.status( bean.getStatus() );
        payMerchantDO.remark( bean.getRemark() );

        return payMerchantDO.build();
    }

    @Override
    public PayMerchantRespVO convert(PayMerchantDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayMerchantRespVO payMerchantRespVO = new PayMerchantRespVO();

        payMerchantRespVO.setName( bean.getName() );
        payMerchantRespVO.setShortName( bean.getShortName() );
        payMerchantRespVO.setStatus( bean.getStatus() );
        payMerchantRespVO.setRemark( bean.getRemark() );
        payMerchantRespVO.setId( bean.getId() );
        payMerchantRespVO.setCreateTime( bean.getCreateTime() );
        payMerchantRespVO.setNo( bean.getNo() );

        return payMerchantRespVO;
    }

    @Override
    public List<PayMerchantRespVO> convertList(List<PayMerchantDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayMerchantRespVO> list1 = new ArrayList<PayMerchantRespVO>( list.size() );
        for ( PayMerchantDO payMerchantDO : list ) {
            list1.add( convert( payMerchantDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<PayMerchantRespVO> convertPage(PageResult<PayMerchantDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayMerchantRespVO> pageResult = new PageResult<PayMerchantRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<PayMerchantExcelVO> convertList02(List<PayMerchantDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayMerchantExcelVO> list1 = new ArrayList<PayMerchantExcelVO>( list.size() );
        for ( PayMerchantDO payMerchantDO : list ) {
            list1.add( payMerchantDOToPayMerchantExcelVO( payMerchantDO ) );
        }

        return list1;
    }

    protected PayMerchantExcelVO payMerchantDOToPayMerchantExcelVO(PayMerchantDO payMerchantDO) {
        if ( payMerchantDO == null ) {
            return null;
        }

        PayMerchantExcelVO payMerchantExcelVO = new PayMerchantExcelVO();

        payMerchantExcelVO.setId( payMerchantDO.getId() );
        payMerchantExcelVO.setNo( payMerchantDO.getNo() );
        payMerchantExcelVO.setName( payMerchantDO.getName() );
        payMerchantExcelVO.setShortName( payMerchantDO.getShortName() );
        payMerchantExcelVO.setStatus( payMerchantDO.getStatus() );
        payMerchantExcelVO.setRemark( payMerchantDO.getRemark() );
        payMerchantExcelVO.setCreateTime( payMerchantDO.getCreateTime() );

        return payMerchantExcelVO;
    }
}
