package com.netty.start.strsplit;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class LogicHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("logic handle in inboundHandler channelRead");
        String[] arr = (String[])msg;

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println("split result : " + s);
            arr[i] = "ok for " + s;
        }
        ctx.writeAndFlush(arr);
    }
}
