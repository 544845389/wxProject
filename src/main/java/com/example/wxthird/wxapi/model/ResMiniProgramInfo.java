package com.example.wxthird.wxapi.model;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ResMiniProgramInfo {


    private ResNetwork network;

    private List<String> categories;

    private int visit_status;

    public ResNetwork getNetwork() {
        return network;
    }

    public void setNetwork(ResNetwork network) {
        this.network = network;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getVisit_status() {
        return visit_status;
    }

    public void setVisit_status(int visit_status) {
        this.visit_status = visit_status;
    }
}
