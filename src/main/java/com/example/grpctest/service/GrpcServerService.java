package com.example.grpctest.service;

import com.example.grpctest.HelloReply;
import com.example.grpctest.HelloRequest;
import com.example.grpctest.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

/**
 * @author zp
 * Grpc远程服务端
 */
@GrpcService(SimpleGrpc.class)
public class GrpcServerService extends SimpleGrpc.SimpleImplBase{
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello =============> " + request
                .getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
