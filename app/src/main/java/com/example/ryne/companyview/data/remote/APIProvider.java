package com.example.ryne.companyview.data.remote;

import com.example.ryne.companyview.model.Contact;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Retrofit2 setup
public class APIProvider {
    private static final String BASE_URL = "https://api.myjson.com/";
    private static final String API_KEY ="bins/jz6bp"; //url ext
    private static Retrofit create(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Call<Contact> getContact(String company, String owner){
        Retrofit retrofit = create();
        APIService services = retrofit.create(APIService.class);
        return services.contactCall(API_KEY,company, owner);
    }
}