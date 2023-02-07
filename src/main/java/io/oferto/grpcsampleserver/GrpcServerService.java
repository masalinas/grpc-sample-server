package io.oferto.grpcsampleserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import net.devh.boot.grpc.examples.lib.HelloReply;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.MyServiceGrpc;

@GrpcService
public class GrpcServerService extends MyServiceGrpc.MyServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(GrpcServerService.class);

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
    	log.info("say hello called from server side");
    	
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}