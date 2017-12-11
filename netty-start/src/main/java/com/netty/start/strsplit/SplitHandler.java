package com.netty.start.strsplit;


import io.netty.buffer.ByteBuf;
import io.netty.channel.*;


public class SplitHandler  extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("split in inboundHandler channelRead");
        ByteBuf in = (ByteBuf) msg;
        byte[] bytes = new byte[in.writerIndex()];
        in.readBytes(bytes);
        String s = new String(bytes);

        System.out.println("read string : " + s);
        ctx.fireChannelRead(s.split("\\|"));
    }
}
