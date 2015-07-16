package org.stone.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import org.stone.model.FileInfo;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Response {

    private Integer statusCode = 200;
    private String path;

    private List<FileInfo> files;

    public List<FileInfo> getFiles() {
        return files;
    }

    public String getPath() {
        return path;
    }

    public void setFiles(List<FileInfo> files) {
        this.files = files;
    }

    public void setPath(String path) {
        this.path= path;
    }

    public Response(Integer statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    private String message = null;

    private String errorClass = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorClass() {
        return errorClass;
    }

    public void setErrorClass(String errorClass) {
        this.errorClass = errorClass;
    }

}
