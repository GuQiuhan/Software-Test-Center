package cn.iocoder.yudao.module.member.convert.user;

import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import cn.iocoder.yudao.module.member.controller.app.user.vo.AppUserInfoRespVO;
import cn.iocoder.yudao.module.member.dal.dataobject.user.MemberUserDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:26:20+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public AppUserInfoRespVO convert(MemberUserDO bean) {
        if ( bean == null ) {
            return null;
        }

        AppUserInfoRespVO appUserInfoRespVO = new AppUserInfoRespVO();

        appUserInfoRespVO.setNickname( bean.getNickname() );
        appUserInfoRespVO.setAvatar( bean.getAvatar() );
        appUserInfoRespVO.setMobile( bean.getMobile() );

        return appUserInfoRespVO;
    }

    @Override
    public MemberUserRespDTO convert2(MemberUserDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberUserRespDTO memberUserRespDTO = new MemberUserRespDTO();

        memberUserRespDTO.setId( bean.getId() );
        memberUserRespDTO.setNickname( bean.getNickname() );
        memberUserRespDTO.setStatus( bean.getStatus() );
        memberUserRespDTO.setMobile( bean.getMobile() );

        return memberUserRespDTO;
    }

    @Override
    public List<MemberUserRespDTO> convertList2(List<MemberUserDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberUserRespDTO> list1 = new ArrayList<MemberUserRespDTO>( list.size() );
        for ( MemberUserDO memberUserDO : list ) {
            list1.add( convert2( memberUserDO ) );
        }

        return list1;
    }
}
