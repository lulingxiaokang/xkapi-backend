package com.llxk.xkapi.model.dto.userinterfaceinfo;

import com.llxk.xkapi.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author llxk
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = -2616170893084373013L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Integer status;

}