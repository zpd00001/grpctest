package com.example.grpctest.service;

import com.example.grpctest.HelloReply;
import com.example.grpctest.HelloRequest;
import com.example.grpctest.SimpleGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author zp
 * Grpc客户端
 */
@Service
public class GrpcClientService {
    @GrpcClient(value = "grpctest")
    private Channel serverChannel;

    public String sendMessage(String name){
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(serverChannel);
        HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return reply.getMessage();
    }
}
