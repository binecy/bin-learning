package com.disconf.start;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by liangguobin on 2017/7/13.
 */
//@Service
//@Scope("singleton")
//@DisconfFile(filename = "redis.properties")
public class JedisConfig {
    // 代表连接地址
    private String host;

    // 代表连接port
    private int port;

    /**
     * 地址
     *
     * @return
     */
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 端口
     *
     * @return
     */
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
