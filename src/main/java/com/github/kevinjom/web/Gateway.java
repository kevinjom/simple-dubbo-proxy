package com.github.kevinjom.web;

import com.github.kevinjom.dubbo.DubboClient;
import com.github.kevinjom.route.DubboInvocation;
import com.github.kevinjom.route.DubboRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Gateway {
    private final DubboRouteService routeService;
    private final DubboClient dubboClient;

    @Autowired
    public Gateway(DubboRouteService routeService, DubboClient dubboClient) {
        this.routeService = routeService;
        this.dubboClient = dubboClient;
    }

    @RequestMapping("/**")
    public ResponseEntity handle(RequestEntity<Map<String, Object>> request) {

        DubboInvocation dubboInvocation = routeService.get(request);
        if (dubboInvocation == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


        return ResponseEntity.ok(dubboClient.invoke(dubboInvocation));
    }
}

