package com.mycompany.utilities.request;

import java.io.Serializable;

public class RequestFormat implements Serializable {

    private String content;
    private String method;

    public RequestFormat() {
    }

    public RequestFormat(String content, String method) {
        this.content = content;
        this.method = method;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
