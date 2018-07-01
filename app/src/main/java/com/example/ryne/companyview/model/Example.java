
package com.example.ryne.companyview.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example implements Parcelable
{

    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = null;
    public final static Creator<Example> CREATOR = new Creator<Example>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Example createFromParcel(Parcel in) {
            return new Example(in);
        }

        public Example[] newArray(int size) {
            return (new Example[size]);
        }

    }
    ;

    protected Example(Parcel in) {
        in.readList(this.contacts, (com.example.ryne.companyview.model.Contact.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Example() {
    }

    /**
     * 
     * @param contacts
     */
    public Example(List<Contact> contacts) {
        super();
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(contacts);
    }

    public int describeContents() {
        return  0;
    }

}
