package com.example.todolist;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.fragment.app.DialogFragment;

public class Plan implements Parcelable {

    private studyItems studyItems;
    private int minutes;
    private String day;
    private boolean isAccomplished;

    public Plan(com.example.todolist.studyItems studyItems, int minutes, String day, boolean isAccomplished) {
        this.studyItems = studyItems;
        this.minutes = minutes;
        this.day = day;
        this.isAccomplished = isAccomplished;
    }

    protected Plan(Parcel in) {
        studyItems = in.readParcelable(com.example.todolist.studyItems.class.getClassLoader());
        minutes = in.readInt();
        day = in.readString();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public com.example.todolist.studyItems getStudyItems() {
        return studyItems;
    }

    public void setStudyItems(com.example.todolist.studyItems studyItems) {
        this.studyItems = studyItems;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "studyItems=" + studyItems +
                ", minutes=" + minutes +
                ", day='" + day + '\'' +
                ", isAccomplished=" + isAccomplished +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(studyItems, flags);
        dest.writeInt(minutes);
        dest.writeString(day);
        dest.writeByte((byte) (isAccomplished ? 1 : 0));
    }
}
