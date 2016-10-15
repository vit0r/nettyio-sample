/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.netty.socket.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vitor
 */
public class ClientHandlerOutbound extends ChannelOutboundHandlerAdapter {

    static final Logger LOG = LoggerFactory.getLogger(ClientHandlerOutbound.class);
    
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeBytes(((String)msg).getBytes());
        ctx.writeAndFlush(encoded, promise);
        LOG.trace("[CLIENT SEND MENSSAGE] "+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
