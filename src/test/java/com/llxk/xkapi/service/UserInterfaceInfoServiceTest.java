package com.llxk.xkapi.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: UserInterfaceInfoServiceTest
 * Package: com.llxk.xkapi.service
 *
 * @author 庐陵小康
 * @version 1.0
 * @Desc
 * @Date 2023/8/26 16:54
 */
@SpringBootTest
class UserInterfaceInfoServiceTest {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Test
    void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(1L, 1L);
        Assert.assertTrue(b);
    }
}