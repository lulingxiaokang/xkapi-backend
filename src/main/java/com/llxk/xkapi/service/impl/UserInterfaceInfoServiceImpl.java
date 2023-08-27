package com.llxk.xkapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llxk.xkapi.common.ErrorCode;
import com.llxk.xkapi.exception.BusinessException;
import com.llxk.xkapi.mapper.UserInterfaceInfoMapper;
import com.llxk.xkapi.service.UserInterfaceInfoService;
import com.llxk.xkapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
* @author llxk
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-08-26 15:58:56
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        //TODO 校验可扩展
        //创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }


    }

    /**
     * 接口调用次数 + 1
     * @param interfaceInfoId 接口id
     * @param userId 用户id
     * @return
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //校验
        if(interfaceInfoId <= 0 || userId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //更新
        //TODO 事务
        LambdaUpdateWrapper<UserInterfaceInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(UserInterfaceInfo::getInterfaceInfoId, interfaceInfoId)
                .eq(UserInterfaceInfo::getUserId, userId)
                .gt(UserInterfaceInfo::getLeftNum, 0);
        lambdaUpdateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");

        return this.update(lambdaUpdateWrapper);
    }

}




