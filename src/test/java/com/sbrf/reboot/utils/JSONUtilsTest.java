package com.sbrf.reboot.utils;

import com.sbrf.reboot.JSONUtils;
import com.sbrf.reboot.Request;
import com.sbrf.reboot.Response;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JSONUtilsTest {

    @SneakyThrows
    @Test
    void toJSONRequest() {
        Request request = new Request("ATM12345");
        Assertions.assertTrue(JSONUtils.toJSON(request).contains("atmNumber"));
    }

    @SneakyThrows
    @Test
    void toJSONResponse() {
        Response response = new Response("SUCCESS");
        Assertions.assertTrue(JSONUtils.toJSON(response).contains("statusCode"));
    }

    @Test
    void JSONtoRequest() throws IOException {
        Request request = JSONUtils.JSONtoRequest("{\"atmNumber\":\"ATM12345\"}");
        Assertions.assertEquals("ATM12345", request.getAtmNumber());
    }

    @Test
    void JSONtoResponse() throws IOException {
        Response request = JSONUtils.JSONtoResponse("{\"statusCode\":\"SUCCESS\"}");
        Assertions.assertEquals("SUCCESS", request.getStatusCode());
    }

}