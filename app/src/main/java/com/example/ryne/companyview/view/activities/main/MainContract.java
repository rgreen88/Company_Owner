package com.example.ryne.companyview.view.activities.main;

import com.example.ryne.companyview.model.Contact;
import com.example.ryne.companyview.view.BasePresenter;
import com.example.ryne.companyview.view.BaseView;

public interface MainContract {
    interface View extends BaseView {
        void setupAdapter(Contact information);
    }

    interface Presenter extends BasePresenter<View> {
        void getContact(String company, String owner);
    }
}