package com.enriquesportfolio.stormy.weather;

import com.enriquesportfolio.stormy.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Enrique on 4/20/15.
 */
public class Current {
    private String mIcon;
    private Long mTime;
    private Double mTemperature;
    private Double mHumidity;
    private Double mPrecipChance;
    private String mSummary;
    private String mTimeZone;

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public String getIcon() {
        return mIcon;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public Long getTime() {
        return mTime;
    }

    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mma");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone()));
        Date dateTime = new Date(getTime() * 1000);
        String timeString = formatter.format(dateTime);

        return timeString;
    }

    public void setTime(Long time) {
        mTime = time;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(Double temperature) {
        mTemperature = temperature;
    }

    public Double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(Double humidity) {
        mHumidity = humidity;
    }

    public int getPrecipChance() {
        double precipPercentage = mPrecipChance * 100;
        return (int) Math.round(precipPercentage);
    }

    public void setPrecipChance(Double precipChance) {
        mPrecipChance = precipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }
}
