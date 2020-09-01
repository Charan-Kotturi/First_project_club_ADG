package com.example.todolist;

import android.os.Parcel;
import android.os.Parcelable;

public class studyItems implements Parcelable {
    private String name , shortDec, longDec;
    private String imageUrl;
    private int ID;

    public studyItems(String name, String shortDec, String longDec, String imageUrl, int ID) {
        this.name = name;
        this.shortDec = shortDec;
        this.longDec = longDec;
        this.imageUrl = imageUrl;
        this.ID = ID;
    }

    protected studyItems(Parcel in) {
        name = in.readString();
        shortDec = in.readString();
        longDec = in.readString();
        imageUrl = in.readString();
        ID = in.readInt();
    }

    public static final Creator<studyItems> CREATOR = new Creator<studyItems>() {
        @Override
        public studyItems createFromParcel(Parcel in) {
            return new studyItems(in);
        }

        @Override
        public studyItems[] newArray(int size) {
            return new studyItems[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDec() {
        return shortDec;
    }

    public void setShortDec(String shortDec) {
        this.shortDec = shortDec;
    }

    public String getLongDec() {
        return longDec;
    }

    public void setLongDec(String longDec) {
        this.longDec = longDec;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "studyItems{" +
                "name='" + name + '\'' +
                ", shortDec='" + shortDec + '\'' +
                ", longDec='" + longDec + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(shortDec);
        dest.writeString(longDec);
        dest.writeString(imageUrl);
        dest.writeInt(ID);
    }
}
