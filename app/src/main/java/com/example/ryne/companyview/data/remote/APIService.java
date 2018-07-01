package com.example.ryne.companyview.data.remote;


import com.example.ryne.companyview.model.Contact;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//making call to retrieve information on Contacts model
public interface APIService {
    @GET("bins/jz6bp")
    Call<Contact> contactCall(@Path("phones") String key, @Path("companyName") String company,
                              @Path("managers") String owner);
}