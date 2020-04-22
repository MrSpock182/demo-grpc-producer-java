package br.com.studiotrek.grpc.service;

import br.com.studiotrek.proto.GreeterGrpc;
import br.com.studiotrek.proto.HelloReply;
import br.com.studiotrek.proto.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "Hello " + request.getName() +"!";
        HelloReply helloReply = HelloReply.newBuilder().setReply(message).build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }

}
