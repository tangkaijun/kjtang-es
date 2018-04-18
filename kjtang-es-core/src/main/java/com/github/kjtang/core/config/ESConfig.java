package com.github.kjtang.core.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by kjtang on 2018/4/10 0010.
 * ES配置，IP及访问端口，采用TCP协议
 */
@Configuration
public class ESConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        // 设置集群名称
        Settings settings = Settings.builder()
                .put("cluster.name", "es-cluster")//集群名称验证
                .put("client.transport.sniff",true) //监控集群状态，自动嗅探 ，将集群中其他节点的IP地址加到本地客户端列表中
                .build();
        // 创建client
        TransportAddress node = new TransportAddress(InetAddress.getByName("172.16.8.12"), 9300);
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}
