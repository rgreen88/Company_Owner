package com.example.ryne.companyview.data.remote;


import com.example.ryne.companyview.model.Contact;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//making call to retrieve information on Contacts model
public interface APIService {
    @GET("bins/jz6bp")
    Call<Contact> contactCall(@Query("phones") String phone, @Query("companyName") String company,
                              @Query("managers") String owner);

//    TODO: add query and work it
}