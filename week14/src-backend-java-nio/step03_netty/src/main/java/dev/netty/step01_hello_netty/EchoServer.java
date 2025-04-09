package dev.netty.step01_hello_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/*
    Echo: 응답하다
    클라이언트의 요청을 받고 응답하는 서버
 */
public class EchoServer {
	public static void main(String[] args) throws InterruptedException {
		// Boss - 주로 클라이언트 연결 요청 처리 담당
		// 1 -> 부모 이벤트 루프 스레드 그룹은 단일 스레드로 동작
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);

		// Worker - 데이터 송수신 처리 담당
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		// NioEventLoopGroup()을 인수 없이 생성 -> 사용할 스레드 수를 서버 애플리케이션이 동작하는 하드웨어 코어 수를 기준으로 지정
		// 일반적으로 스레드 수는 하드웨어가 가지고 있는 CPU 코어 수의 2배를 사용함
		// 만약 서버 애플리케이션이 동작하는 하드웨어가 4코어 CPU이고 하이퍼 스레딩을 지원할 경우 스레드는 16개가 생성됨

		try {
			// 서버 초기화용 부트스트랩 객체 생성
			ServerBootstrap bootstrap = new ServerBootstrap();
			// 부트스트랩 객체를 통해 각종 네트워크 옵션 설정 적용
			bootstrap.group(bossGroup, workerGroup) // 이벤트 루프 설정, 미리 생성한 EventRoopGroup을 인수로 전달 group(부모 스레드, 자식 스레드)

				// 부모 스레드 - 클라이언트의 연결 요청 수락 담당
				// 자식 스레드 - 연결된 소켓에 대한 IO 처리 담당


				.channel(NioServerSocketChannel.class) // 서버 소켓(부모 스레드)이 사용할 네트워크 입출력 모드 설정, NIOServer~ - 논블로킹 모드

				// ChannelInitializer - 클라이언트로부터 연결된 채널이 초기화될 때 수행할 동작이 지정된 클래스
				.childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel socketChannel) throws Exception { // 채널 초기화 시 수행할 동작
						ChannelPipeline pipeline = socketChannel.pipeline(); // 채널 파이프라인 객체 생성
						pipeline.addLast(new EchoServerHandler()); // 채널 파이프라인에 EchoServerHandler 등록
						// EchoServerHandler - 클라이언트의 연결이 생성되었을 때 수행할 데이터 처리 로직 담당
					}
				});

			// ChannelFuture를 통해 비동기 메서드의 처리 결과를 확인
			// sync(): ChannelFuture 객체의 요청이 완료될 때까지 대기
			ChannelFuture future = bootstrap.bind(8888).sync();
			future.channel().closeFuture().sync();

		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
