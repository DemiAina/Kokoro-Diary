package com.example.mentalhealthapp.ui.onboarding.components;

import android.os.Parcel;
import android.os.Parcelable;

public class onBoardingPage implements Parcelable {
    private int imageResourceId;
    private String heading;
    private String description;
    public onBoardingPage(int imageResourceId, String heading, String description) {
        this.imageResourceId = imageResourceId;
        this.heading = heading;
        this.description = description;
    }

    public static final Creator<onBoardingPage> CREATOR = new Creator<onBoardingPage>() {
        @Override
        public onBoardingPage createFromParcel(Parcel in) {
            return new onBoardingPage(in);
        }

        @Override
        public onBoardingPage[] newArray(int size) {
            return new onBoardingPage[size];
        }
    };
    protected onBoardingPage(Parcel in) {
        imageResourceId = in.readInt();
        heading = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResourceId);
        dest.writeString(heading);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }



    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
