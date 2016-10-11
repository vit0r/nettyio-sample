/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.netty.socket.utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.nio.charset.Charset;

/**
 *
 * @author Vitor
 */
public class MessageEncoder extends MessageToByteEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext chc, String msg, ByteBuf out) throws Exception {
        if (out != null && !msg.isEmpty()) {
            out.writeCharSequence(msg, Charset.defaultCharset());
        }
    }

}
