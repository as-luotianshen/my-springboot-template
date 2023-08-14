package net.rakan.god.myspringboottemplate.common.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerHandler extends ChannelInitializer<SocketChannel> {

    /**
     * 标记2 注意点
     */
    @Autowired
    private WebSocketHandler webSocketHandler;

    /**
     * 初始化通道以及配置对应管道的处理器
     *
     * @Author LiChangRui on 2023/8/2 11:24
     */
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline
                // 添加http编码解码器
                .addLast(new HttpServerCodec())
                // 支持大数据流
                .addLast(new ChunkedWriteHandler())
                // 对http消息做聚合操作，FuLLHttpRequest、 FuLLHttpResponse
                .addLast(new HttpObjectAggregator(1024 * 64))
                // websocket访问路径
                .addLast(new WebSocketServerProtocolHandler("/"))
                // 指定处理器
                .addLast(webSocketHandler);
    }
}
