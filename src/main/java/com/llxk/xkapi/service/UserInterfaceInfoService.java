package com.llxk.xkapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llxk.xkapicommon.model.entity.UserInterfaceInfo;


/**
* @author llxk
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-08-26 15:58:56
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add 是否为创建校验
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);


    /**
     * 调用接口统计
     * @param interfaceInfoId 接口id
     * @param userId 用户id
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);


}
