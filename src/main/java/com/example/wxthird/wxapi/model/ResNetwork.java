package com.example.wxthird.wxapi.model;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ResNetwork {


    private List<String> RequestDomain;

    private List<String> WsRequestDomain;

    private List<String> UploadDomain;

    private List<String> DownloadDomain;

    private List<String> BizDomain;


    public List<String> getRequestDomain() {
        return RequestDomain;
    }

    public void setRequestDomain(List<String> requestDomain) {
        RequestDomain = requestDomain;
    }

    public List<String> getWsRequestDomain() {
        return WsRequestDomain;
    }

    public void setWsRequestDomain(List<String> wsRequestDomain) {
        WsRequestDomain = wsRequestDomain;
    }

    public List<String> getUploadDomain() {
        return UploadDomain;
    }

    public void setUploadDomain(List<String> uploadDomain) {
        UploadDomain = uploadDomain;
    }

    public List<String> getDownloadDomain() {
        return DownloadDomain;
    }

    public void setDownloadDomain(List<String> downloadDomain) {
        DownloadDomain = downloadDomain;
    }

    public List<String> getBizDomain() {
        return BizDomain;
    }

    public void setBizDomain(List<String> bizDomain) {
        BizDomain = bizDomain;
    }
}
