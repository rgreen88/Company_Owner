package com.example.ryne.companyview.view.activities.main;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.ryne.companyview.data.remote.APIProvider;
import com.example.ryne.companyview.model.Contact;
import retrofit2.Call;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "test";
    private MainContract.View view;

    @Override
    public void addView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getContact(String company, String owner) {

        Call<Contact> contactCall = APIProvider.getContact(company, owner);
        contactCall.enqueue((new retrofit2.Callback<Contact>() {
            @Override
            public void onResponse(@NonNull Call<Contact> call, @NonNull Response<Contact> response) {
                Log.d(TAG, "onResponse: " + response.body());
                view.setupAdapter(response.body()); //passing Contact using body() into adapter
            }

            @Override
            public void onFailure(@NonNull Call<Contact> call, @NonNull Throwable t) {
                view.showError(t.getMessage());
            }
        }));
    }
}