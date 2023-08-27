package com.llxk.xkapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.llxk.xkapi.common.ErrorCode;
import com.llxk.xkapi.exception.BusinessException;
import com.llxk.xkapi.mapper.UserMapper;
import com.llxk.xkapicommon.model.entity.User;
import com.llxk.xkapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * ClassName: InnerUserServiceImpl
 * Package: com.llxk.xkapi.service.impl.inner
 *
 * @author 庐陵小康
 * @version 1.0
 * @Desc
 * @Date 2023/8/27 23:32
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if(StringUtils.isAnyBlank(accessKey)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAccessKey, accessKey);
        return userMapper.selectOne(lambdaQueryWrapper);
    }
}
