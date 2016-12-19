package com.github.kevinjom.dubbo;

import com.github.kevinjom.route.DubboInvocation;
import org.springframework.stereotype.Component;

@Component
public class DubboClient {
    public Object invoke(DubboInvocation invocation) {
        //// TODO: 12/19/16
        return "hello";
    }
}
