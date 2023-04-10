package cn.iocoder.yudao.module.system.convert.social;

import cn.iocoder.yudao.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.iocoder.yudao.module.system.api.social.dto.SocialUserUnbindReqDTO;
import cn.iocoder.yudao.module.system.controller.admin.socail.vo.SocialUserBindReqVO;
import cn.iocoder.yudao.module.system.controller.admin.socail.vo.SocialUserUnbindReqVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:26:06+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class SocialUserConvertImpl implements SocialUserConvert {

    @Override
    public SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO) {
        if ( userId == null && userType == null && reqVO == null ) {
            return null;
        }

        SocialUserBindReqDTO socialUserBindReqDTO = new SocialUserBindReqDTO();

        if ( reqVO != null ) {
            socialUserBindReqDTO.setType( reqVO.getType() );
            socialUserBindReqDTO.setCode( reqVO.getCode() );
            socialUserBindReqDTO.setState( reqVO.getState() );
        }
        socialUserBindReqDTO.setUserId( userId );
        socialUserBindReqDTO.setUserType( userType );

        return socialUserBindReqDTO;
    }

    @Override
    public SocialUserUnbindReqDTO convert(Long userId, Integer userType, SocialUserUnbindReqVO reqVO) {
        if ( userId == null && userType == null && reqVO == null ) {
            return null;
        }

        SocialUserUnbindReqDTO socialUserUnbindReqDTO = new SocialUserUnbindReqDTO();

        if ( reqVO != null ) {
            socialUserUnbindReqDTO.setType( reqVO.getType() );
        }
        socialUserUnbindReqDTO.setUserId( userId );
        socialUserUnbindReqDTO.setUserType( userType );

        return socialUserUnbindReqDTO;
    }
}
