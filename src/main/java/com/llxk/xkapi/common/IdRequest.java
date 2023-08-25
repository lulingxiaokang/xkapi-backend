package com.llxk.xkapi.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 仅包含id
 *
 * @author llxk
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}