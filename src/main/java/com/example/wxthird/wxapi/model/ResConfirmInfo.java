package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ResConfirmInfo {

    private  int need_confirm;

    private  int already_confirm;

    private  int can_confirm;

    public int getNeed_confirm() {
        return need_confirm;
    }

    public void setNeed_confirm(int need_confirm) {
        this.need_confirm = need_confirm;
    }

    public int getAlready_confirm() {
        return already_confirm;
    }

    public void setAlready_confirm(int already_confirm) {
        this.already_confirm = already_confirm;
    }

    public int getCan_confirm() {
        return can_confirm;
    }

    public void setCan_confirm(int can_confirm) {
        this.can_confirm = can_confirm;
    }
}
