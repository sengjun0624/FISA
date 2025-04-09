package dev.netty.step01_hello_netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	/*
		서버 입장에서 채널을 통해 읽기 이벤트가 발생했을 때, 처리할 로직을 작성하는 부분
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 채널을 통해 버퍼에서 읽은 메시지를 문자열 타입으로 변환
		String readMessage = ((ByteBuf) msg).toString(Charset.defaultCharset());

		StringBuilder builder = new StringBuilder();
		builder.append("수신한 문자열 [");
		builder.append(readMessage);
		builder.append("]");
		System.out.println(builder.toString());

		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// super.exceptionCaught(ctx, cause);
	}
}
