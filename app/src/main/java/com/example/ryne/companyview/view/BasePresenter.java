package com.example.ryne.companyview.view;



public interface BasePresenter<V extends BaseView> {

    void addView(V view);

    void removeView();
}