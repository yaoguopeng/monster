package com.island.monster.common;

import java.io.Serializable;

public class Response<T>  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private Integer code;
    private Status status;
    private T entity;

    public enum Status{
        SUCCESS,FAILED
    }

    public Response() {
    }

    public Response(Status status, String message, T entity) {
        this.status = status;
        this.message = message;
        this.entity = entity;
    }

    public Response(Status status, String message, T entity, Integer code) {
        super();
        this.status = status;
        this.message = message;
        this.entity = entity;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    /**
     * 带错误信息和错误代码的失败响应体
     *
     * @param message
     * @param code
     * @param <T>
     * @return
     */
    public static <T> Response<T> failed(String message,Integer code){
        return new Response(Status.FAILED,message,null,code);
    }

    /**
     * 带实体类信息和成功信息的成功响应体
     *
     * @param entity
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T entity,String message){
        return new Response(Status.SUCCESS,message,entity,0);
    }

    /**
     * 带实体类信息和默认成功信息的成功响应体
     *
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T entity){
        return new Response(Status.SUCCESS,"response with success",entity,0);
    }
}
