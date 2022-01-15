package com.sbrf.reboot;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JSONUtils {
    private static StringWriter writer;
    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static StringReader reader;

    public static String toJSON(Request request) throws IOException {
        writer = new StringWriter();
        jsonMapper.writeValue(writer, request);
        return writer.toString();
    }

    public static String toJSON(Response response) throws IOException {
        writer = new StringWriter();
        jsonMapper.writeValue(writer, response);
        return writer.toString();
    }

    public static Request JSONtoRequest(String jsonStringReq) throws IOException {
        reader = new StringReader(jsonStringReq);
        return jsonMapper.readValue(reader, Request.class);
    }

    public static Response JSONtoResponse(String jsonStringResp) throws IOException {
        reader =  new StringReader(jsonStringResp);
        return jsonMapper.readValue(reader, Response.class);
    }
}