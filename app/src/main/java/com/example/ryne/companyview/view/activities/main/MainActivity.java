package com.example.ryne.companyview.view.activities.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryne.companyview.R;
import com.example.ryne.companyview.model.Contact;
import com.example.ryne.companyview.view.activities.main.injection.DaggerMainComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    //Injecting presenter into MainActivity
    @Inject
    MainPresenter presenter;

    //RV
    private RecyclerView contactView;
    RecyclerView.ItemAnimator itemAnimator;
    RecyclerView.LayoutManager manager;
    private List<Contact> contactList = new ArrayList<>();

    String companyName, owner;

    //user input to set company and owner
    EditText etCompanyName, etOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupDagger();

        //populate view
        presenter.addView(this);
        contactView = findViewById(R.id.rv_company_name);

        presenter.getContact(companyName, owner);

        //bind et
        etCompanyName = findViewById(R.id.et_company_name);
        etOwner = findViewById(R.id.et_owner);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupDagger() {
        DaggerMainComponent.create().inject(this);
    }


    //method setting up recyclerview
    @Override
    public void setupAdapter(Contact information) {

        manager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        contactList.clear();

//      new contact object pulling data to display company info
        Contact contact = new Contact(
                information.getCompanyName(),
                information.getParent(),
                information.getManagers(),
                information.getPhones(),
                information.getAddresses());

        contactList.add(contact);
        contactList.addAll(Collections.singleton(information));

        //setting adapter
        MainAdapter mainAdapter = new MainAdapter(Collections.singletonList(contact));
        contactView.setAdapter(mainAdapter);
        contactView.setLayoutManager(manager);
        contactView.setItemAnimator(itemAnimator);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }

    //refresh button reverts to lat long coordinates San Diego
    public void getRefresh(View view) {

        String name = "";
        String owner = "";
        presenter.getContact(name, owner);
    }

    public void get_company_name(View view) {

        //conditional statement to check lat/lng values and calls to search for weather info
        // by input lat/lng and converts input to string. Adds error toasts for specific errors
        if (etCompanyName.getText().toString().equals("") && etOwner.getText().toString().equals("")) {
            String company = etCompanyName.getText().toString();
            String owner = etOwner.getText().toString();
            if (company.equals("") || owner.equals("") )
            {
                showError("Company and owner needs to be filled");
            }
            else {
                presenter.getContact(companyName, owner);
            }

        }
    }
}