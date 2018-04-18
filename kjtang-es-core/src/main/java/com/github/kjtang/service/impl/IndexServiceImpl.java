package com.github.kjtang.service.impl;

import com.github.kjtang.service.IndexService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kjtang on 2018/4/18 0018.
 * 索引管理API
 */
public class IndexServiceImpl implements IndexService {

    @Autowired
    private TransportClient transportClient;


}
