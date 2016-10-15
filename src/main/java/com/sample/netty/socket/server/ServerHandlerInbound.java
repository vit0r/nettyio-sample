/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.netty.socket.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vitor
 */
public class ServerHandlerInbound extends ChannelInboundHandlerAdapter {

    static final Logger LOG = LoggerFactory.getLogger(ServerHandlerInbound.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        LOG.trace("[SERVER] Recebe mensagem ->" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        LOG.trace("[SERVER] processa mensagem ->" + ctx.fireChannelReadComplete().name());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
