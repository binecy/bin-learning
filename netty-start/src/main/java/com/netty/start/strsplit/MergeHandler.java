package com.netty.start.strsplit;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

public class MergeHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println("fire outboundHandler read");
        ctx.read();
    }


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("merge in outboundHandler write");

        String[] arr = (String[])msg;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(i > 0) {
                sb.append("|");
            }
            sb.append(arr[i]);
        }
        System.out.println("response str : " + sb.toString());
        byte[] bytes = sb.toString().getBytes();
        ByteBuf byteBuf = ctx.alloc().buffer(bytes.length);
        byteBuf.writeBytes(bytes);
        ctx.write(byteBuf, promise);
    }
}
