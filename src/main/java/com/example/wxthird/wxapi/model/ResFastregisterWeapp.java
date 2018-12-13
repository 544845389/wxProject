package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
public class ResFastregisterWeapp {



    /**
     *  状态码，0成功，其他失败
     */
    private  int errcode;

    /**
     * 错误信息
     */
    private  String  errmsg;


    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }


    @Override
    public String toString() {
        return "ResFastregisterWeapp{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
