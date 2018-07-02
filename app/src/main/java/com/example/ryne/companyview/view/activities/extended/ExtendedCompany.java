package com.example.ryne.companyview.view.activities.extended;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.ryne.companyview.R;
import com.example.ryne.companyview.model.Contact;
import com.example.ryne.companyview.view.activities.main.MainActivity;
import com.google.gson.Gson;

public class ExtendedCompany extends AppCompatActivity {

    TextView companyAddress, phoneNumber, companyName, parentCompany, managers;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extended_company);

        //tv binding
        companyName = findViewById(R.id.tv_company_name);
        parentCompany = findViewById(R.id.tv_parent);
        managers = findViewById(R.id.tv_manager);
        phoneNumber = findViewById(R.id.tv_phone);
        companyAddress = findViewById(R.id.tv_address);

        //calling to set text views in new activity
        Gson gson = new Gson();
        contact = gson.fromJson(getIntent().getStringExtra("companyName"), Contact.class);
        String company = "Company name: " + contact.getCompanyName(); //TODO: null causes new activity from onclick event to crash
        String parent = "Parent company: " + contact.getParent();
//        String manager = "Managers: " + contact.getManagers();
//        String phone = "Phone: " + contact.getPhones();
//        String address = "Address: " + contact.getAddresses();

        //set textviews
        companyName.setText(company);
        parentCompany.setText(parent);
//        managers.setText(manager);
//        phoneNumber.setText(phone);
//        companyAddress.setText(address);

    }

    public void goBack(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);

    }
}