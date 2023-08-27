package com.llxk.xkapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.llxk.xkapi.common.ErrorCode;
import com.llxk.xkapi.exception.BusinessException;
import com.llxk.xkapi.mapper.InterfaceInfoMapper;
import com.llxk.xkapicommon.model.entity.InterfaceInfo;
import com.llxk.xkapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * ClassName: InnerInterfaceInfoServiceImpl
 * Package: com.llxk.xkapi.service.impl.inner
 *
 * @author 庐陵小康
 * @version 1.0
 * @Desc
 * @Date 2023/8/27 23:32
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {


    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if(StringUtils.isAnyBlank(url, method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        LambdaQueryWrapper<InterfaceInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(InterfaceInfo::getUrl, url)
                .eq(InterfaceInfo::getMethod, method);
        return interfaceInfoMapper.selectOne(lambdaQueryWrapper);
    }
}
