package com.example.ryne.companyview.view.activities.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ryne.companyview.R;
import com.example.ryne.companyview.model.Contact;
import com.example.ryne.companyview.view.activities.extended.ExtendedCompany;
import com.google.gson.Gson;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Contact> contactList;

    public MainAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.company_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Contact contact = contactList.get(position);

        String company = "Company Name: " + contact.getCompanyName();
        String owner = "Owner: " + contact.getParent();
        String phoneNumber = "Phone Number: " + contact.getPhones();
        String manager = "Manager: " + contact.getManagers();
        String address = "Address: " + contact.getAddresses();

        holder.company.setText(company);
        holder.owner.setText(owner);
        holder.phone.setText(phoneNumber);
        holder.manager.setText(manager);
        holder.address.setText(address);

        //onClick for Recycler View
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ExtendedCompany.class);
                Gson gson = new Gson(); //converting gson object to string
                intent.putExtra("weather", gson.toJson(contactList));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView company;
        TextView owner;
        TextView phone;
        TextView manager;
        TextView address;

        public ViewHolder(final View itemView) {
            super(itemView);

            //TODO: create text views of company info to be displayed after search displlays results
            //TODO: Company names in rv and click to next activity to display info in extended**
            company = itemView.findViewById(R.id.tv_company_name);
            owner = itemView.findViewById(R.id.tv_owner);
            phone = itemView.findViewById(R.id.tv_phone);
            manager = itemView.findViewById(R.id.tv_manager);
            address = itemView.findViewById(R.id.tv_address);
        }
    }
}