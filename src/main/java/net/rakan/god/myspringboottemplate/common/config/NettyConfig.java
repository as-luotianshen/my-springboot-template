package net.rakan.god.myspringboottemplate.common.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import net.rakan.god.myspringboottemplate.common.handler.ServerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class NettyConfig {
    @Value("${netty.boss}")
    private Integer boss;
    @Value("${netty.worker}")
    private Integer worker;
    @Value("${netty.timeout}")
    private Integer timeout;
    @Value("${netty.tcp}")
    private Integer tcp;

    /**
     * 标记1 注意点
     */
    @Autowired
    private ServerHandler serverHandler;

    /**
     * boss 线程池
     * 负责客户端连接
     *
     * @Author LiChangRui on 2023/8/2 11:24
     */
    @Bean
    public NioEventLoopGroup boosGroup() {
        return new NioEventLoopGroup(boss);
    }

    /**
     * worker 线程池
     * 负责业务处理
     *
     * @Author LiChangRui on 2023/8/2 11:24
     */
    @Bean
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(worker);
    }

    /**
     * 服务器启动器
     *
     * @Author LiChangRui on 2023/8/2 11:24
     */
    @Bean
    public ServerBootstrap serverBootstrap() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                // 设置主从线程组
                .group(boosGroup(), workerGroup())
                // 设置nio双向通道
                .channel(NioServerSocketChannel.class)
                // 指定连接超时时间
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
                // tcp参数 1024个队列
                .option(ChannelOption.SO_BACKLOG, tcp)
                // 字处理器 用于处理workerGroup中的任务
                .childHandler(serverHandler);
        return serverBootstrap;
    }
}

