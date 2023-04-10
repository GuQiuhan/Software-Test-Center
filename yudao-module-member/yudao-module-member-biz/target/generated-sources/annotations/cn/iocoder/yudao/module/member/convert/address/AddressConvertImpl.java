package cn.iocoder.yudao.module.member.convert.address;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.member.api.address.dto.AddressRespDTO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressCreateReqVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressRespVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressUpdateReqVO;
import cn.iocoder.yudao.module.member.dal.dataobject.address.AddressDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:26:20+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class AddressConvertImpl implements AddressConvert {

    @Override
    public AddressDO convert(AppAddressCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        AddressDO.AddressDOBuilder addressDO = AddressDO.builder();

        addressDO.name( bean.getName() );
        addressDO.mobile( bean.getMobile() );
        addressDO.areaId( bean.getAreaId() );
        addressDO.postCode( bean.getPostCode() );
        addressDO.detailAddress( bean.getDetailAddress() );
        addressDO.defaulted( bean.getDefaulted() );

        return addressDO.build();
    }

    @Override
    public AddressDO convert(AppAddressUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        AddressDO.AddressDOBuilder addressDO = AddressDO.builder();

        addressDO.id( bean.getId() );
        addressDO.name( bean.getName() );
        addressDO.mobile( bean.getMobile() );
        addressDO.areaId( bean.getAreaId() );
        addressDO.postCode( bean.getPostCode() );
        addressDO.detailAddress( bean.getDetailAddress() );
        addressDO.defaulted( bean.getDefaulted() );

        return addressDO.build();
    }

    @Override
    public AppAddressRespVO convert(AddressDO bean) {
        if ( bean == null ) {
            return null;
        }

        AppAddressRespVO appAddressRespVO = new AppAddressRespVO();

        appAddressRespVO.setName( bean.getName() );
        appAddressRespVO.setMobile( bean.getMobile() );
        appAddressRespVO.setAreaId( bean.getAreaId() );
        appAddressRespVO.setPostCode( bean.getPostCode() );
        appAddressRespVO.setDetailAddress( bean.getDetailAddress() );
        appAddressRespVO.setDefaulted( bean.getDefaulted() );
        appAddressRespVO.setId( bean.getId() );
        appAddressRespVO.setCreateTime( bean.getCreateTime() );

        return appAddressRespVO;
    }

    @Override
    public List<AppAddressRespVO> convertList(List<AddressDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppAddressRespVO> list1 = new ArrayList<AppAddressRespVO>( list.size() );
        for ( AddressDO addressDO : list ) {
            list1.add( convert( addressDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<AppAddressRespVO> convertPage(PageResult<AddressDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<AppAddressRespVO> pageResult = new PageResult<AppAddressRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public AddressRespDTO convert02(AddressDO bean) {
        if ( bean == null ) {
            return null;
        }

        AddressRespDTO addressRespDTO = new AddressRespDTO();

        addressRespDTO.setId( bean.getId() );
        addressRespDTO.setUserId( bean.getUserId() );
        addressRespDTO.setName( bean.getName() );
        addressRespDTO.setMobile( bean.getMobile() );
        addressRespDTO.setAreaId( bean.getAreaId() );
        addressRespDTO.setPostCode( bean.getPostCode() );
        addressRespDTO.setDetailAddress( bean.getDetailAddress() );
        addressRespDTO.setDefaulted( bean.getDefaulted() );

        return addressRespDTO;
    }
}
