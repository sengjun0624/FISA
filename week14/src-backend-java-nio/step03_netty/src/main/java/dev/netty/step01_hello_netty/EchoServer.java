package dev.netty.step01_hello_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	public static void main(String[] args) {
		/*
		worker와 boss를 구분 각각은 실제 작업(Data I/O)과 연결요청을 담당
		 */
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup(1);

		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workerGroup) // event loop
				.channel(NioServerSocketChannel.class)  //socker mode (blocking or nonblocking)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel socketChannel) throws Exception {
						ChannelPipeline pipeline = socketChannel.pipeline();
						pipeline.addLast(new EchoServerHandler());
					}
				});

			ChannelFuture future = bootstrap.bind(8888).sync();

			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
