package com.llxk.xkapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llxk.xkapicommon.model.entity.InterfaceInfo;

/**
* @author llxk
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-08-23 21:37:55
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
