package com.springboot.util;

public class R {

    private boolean success = true;
    private String message = "ok";
    private Object result;

    public R ok(){
        return new R();
    }

    public R error(String message){
        R r = new R();
        r.success = false;
        r.message = message;
        return r;
    }

    public void setResult(Object result){
        R r = new R();
        r.result = result;
    }
}
