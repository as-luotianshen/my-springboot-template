package net.rakan.god.myspringboottemplate.common.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ChannelHandler.Sharable
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 前端连接
     *
     * @Author LiChangRui on 2023/8/2 11:26
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("前端连接进来了");
        ctx.fireChannelActive();
    }

    /**
     * 连接掉线
     *
     * @Author LiChangRui on 2023/8/2 11:26
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("前端连接断开了");
        ctx.fireChannelInactive();
    }


    /**
     * 读取客户端信息
     *
     * @Author LiChangRui on 2023/8/2 11:26
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        log.info("发消息来了,消息是{}", msg.text());
    }

    /**
     * 发生异常时
     *
     * @Author LiChangRui on 2023/8/2 11:26
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("出现异常了");
    }
}

