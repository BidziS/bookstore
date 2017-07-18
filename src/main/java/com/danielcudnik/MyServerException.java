package com.danielcudnik;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

/**
 * Created by Bidzis on 7/18/2017.
 */
public class MyServerException extends Exception {
    private HttpStatus status;
    private HttpHeaders headers;

    public MyServerException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.headers = new HttpHeaders();
        this.headers.add("state",message);
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }
}
