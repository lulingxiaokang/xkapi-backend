package com.llxk.xkapi.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * ClassName: DemoServiceImpl
 * Package: com.llxk.xkapi.provider
 *
 * @author 庐陵小康
 * @version 1.0
 * @Desc
 * @Date 2023/8/27 20:17
 */
@DubboService
public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello(String name) {
        System.out.println("Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name;
    }

}
