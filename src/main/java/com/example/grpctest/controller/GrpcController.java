package com.example.grpctest.controller;

import com.example.grpctest.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("grpc")
public class GrpcController {
    @Autowired
    private GrpcClientService grpcClientService;

    @ResponseBody
    @RequestMapping("query")
    public String grpcTestQuery(@RequestParam String name){
        return grpcClientService.sendMessage(name);
    }
}
