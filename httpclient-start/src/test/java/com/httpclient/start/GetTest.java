package com.httpclient.start;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class GetTest {

    // 连接怎么重用

    @Test
    public void testGet() throws IOException, InterruptedException {

            try (CloseableHttpClient client = HttpClients.createDefault()) {

                for(int i = 0; i < 3; i++) {
                    HttpGet get = new HttpGet("http://localhost:8012/");
                HttpResponse response;
                response = client.execute(get);

                HttpEntity entity = response.getEntity();
                ContentType contentType = ContentType.getOrDefault(entity);
                String body = EntityUtils.toString(entity, contentType.getCharset());

                System.out.println("code : " + response.getStatusLine().getStatusCode());
                if (response.getStatusLine().getStatusCode() < HttpStatus.SC_BAD_REQUEST) {
                    System.out.println(body);
                }

                get.abort();

                Thread.sleep(1000);
            }

        }

    }

}
