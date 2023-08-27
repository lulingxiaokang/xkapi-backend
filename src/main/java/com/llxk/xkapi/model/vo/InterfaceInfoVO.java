package com.llxk.xkapi.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: InterfaceInfoVO
 * Package: com.llxk.xkapi.model.vo
 *
 * @author 庐陵小康
 * @version 1.0
 * @Desc 接口信息封装视图
 * @Date 2023/8/28 1:13
 */
@Data
public class InterfaceInfoVO implements Serializable {
    /**
     * 调用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}
