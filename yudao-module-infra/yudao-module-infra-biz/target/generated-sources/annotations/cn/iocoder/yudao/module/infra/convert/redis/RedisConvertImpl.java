package cn.iocoder.yudao.module.infra.convert.redis;

import cn.iocoder.yudao.framework.redis.core.RedisKeyDefine;
import cn.iocoder.yudao.module.infra.controller.admin.redis.vo.RedisKeyDefineRespVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T22:26:28+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class RedisConvertImpl implements RedisConvert {

    @Override
    public List<RedisKeyDefineRespVO> convertList(List<RedisKeyDefine> list) {
        if ( list == null ) {
            return null;
        }

        List<RedisKeyDefineRespVO> list1 = new ArrayList<RedisKeyDefineRespVO>( list.size() );
        for ( RedisKeyDefine redisKeyDefine : list ) {
            list1.add( redisKeyDefineToRedisKeyDefineRespVO( redisKeyDefine ) );
        }

        return list1;
    }

    protected RedisKeyDefineRespVO redisKeyDefineToRedisKeyDefineRespVO(RedisKeyDefine redisKeyDefine) {
        if ( redisKeyDefine == null ) {
            return null;
        }

        RedisKeyDefineRespVO.RedisKeyDefineRespVOBuilder redisKeyDefineRespVO = RedisKeyDefineRespVO.builder();

        redisKeyDefineRespVO.keyTemplate( redisKeyDefine.getKeyTemplate() );
        redisKeyDefineRespVO.keyType( redisKeyDefine.getKeyType() );
        redisKeyDefineRespVO.valueType( redisKeyDefine.getValueType() );
        redisKeyDefineRespVO.timeoutType( redisKeyDefine.getTimeoutType() );
        redisKeyDefineRespVO.timeout( redisKeyDefine.getTimeout() );
        redisKeyDefineRespVO.memo( redisKeyDefine.getMemo() );

        return redisKeyDefineRespVO.build();
    }
}
