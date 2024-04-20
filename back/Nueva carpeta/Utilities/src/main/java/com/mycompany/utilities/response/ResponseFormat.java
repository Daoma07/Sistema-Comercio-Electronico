package com.mycompany.utilities.response;

import java.io.Serializable;

public class ResponseFormat implements Serializable {

    private String content;
    private int responseStatus;

    public ResponseFormat() {
    }

    public ResponseFormat(String content, int responseStatus) {
        this.content = content;
        this.responseStatus = responseStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

}
