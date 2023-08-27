package com.llxk.xkapi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llxk.xkapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author llxk
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-08-26 15:58:56
* @Entity com.llxk.xkapi.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {



    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




