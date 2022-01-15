package com.sbrf.reboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLUtils {
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static String toXML(Request request) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(request);
    }
    public static String toXML(Response response) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(response);
    }

    public static Request XMLtoRequest(String xmlStringReq) throws JsonProcessingException {
        return xmlMapper.readValue(xmlStringReq, Request.class);
    }

    public static Response XMLtoResponse(String xmlStringResp) throws JsonProcessingException {
        return xmlMapper.readValue(xmlStringResp, Response.class);
    }
}
