package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ResFuncscopeCategoryPublic {

    private  ResFuncscopeCategoryId funcscope_category;

    private  ResConfirmInfo confirm_info;

    public ResFuncscopeCategoryId getFuncscope_category() {
        return funcscope_category;
    }

    public void setFuncscope_category(ResFuncscopeCategoryId funcscope_category) {
        this.funcscope_category = funcscope_category;
    }

    public ResConfirmInfo getConfirm_info() {
        return confirm_info;
    }

    public void setConfirm_info(ResConfirmInfo confirm_info) {
        this.confirm_info = confirm_info;
    }
}
