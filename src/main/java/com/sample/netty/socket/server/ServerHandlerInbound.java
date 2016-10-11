/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.netty.socket.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 *
 * @author Vitor
 */
public class ServerHandlerInbound extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            StringBuilder sb = new StringBuilder();
            while (in.isReadable()) {
                sb.append((char)in.readByte());
            }
            System.out.println("[SERVER] Recebe mensagem ->"+sb.toString());
            System.out.flush();
        } finally {
            ReferenceCountUtil.release(msg);
            ReferenceCountUtil.release(in);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
