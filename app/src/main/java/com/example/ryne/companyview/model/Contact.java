
package com.example.ryne.companyview.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact implements Parcelable
{

    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("parent")
    @Expose
    private String parent;
    @SerializedName("managers")
    @Expose
    private List<String> managers = null;
    @SerializedName("phones")
    @Expose
    private List<String> phones = null;
    @SerializedName("addresses")
    @Expose
    private List<String> addresses = null;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<Contact> CREATOR = new Creator<Contact>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return (new Contact[size]);
        }

    }
    ;

    private Contact(Parcel in) {
        this.companyName = ((String) in.readValue((String.class.getClassLoader())));
        this.parent = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.managers, (String.class.getClassLoader()));
        in.readList(this.phones, (String.class.getClassLoader()));
        in.readList(this.addresses, (String.class.getClassLoader()));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Contact() {
    }

    /**
     *  @param companyName
     * @param parent
     * @param managers
     * @param phones
     * @param addresses
     */
    public Contact(String companyName, String parent, List<String> managers, List<String> phones, List<String> addresses) {
        super();
        this.companyName = companyName;
        this.parent = parent;
        this.managers = managers;
        this.phones = phones;
        this.addresses = addresses;
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<String> getManagers() {
        return managers;
    }

    public void setManagers(List<String> managers) {
        this.managers = managers;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(companyName);
        dest.writeValue(parent);
        dest.writeList(managers);
        dest.writeList(phones);
        dest.writeList(addresses);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
