package com.pisces.android.wuha.function.user;

/**
 * Created by Jam on 2017/9/14.
 */

public class BodyForLogin {


    /**
     * IdentityToken : string
     * MobliePhoneNumber : string
     * CurrentDeviceIdentificationNumber : string
     * DeviceName : string
     */

    private String IdentityToken;
    private String MobliePhoneNumber;
    private String CurrentDeviceIdentificationNumber;
    private String DeviceName;

    public String getIdentityToken() {
        return IdentityToken;
    }

    public void setIdentityToken(String IdentityToken) {
        this.IdentityToken = IdentityToken;
    }

    public String getMobliePhoneNumber() {
        return MobliePhoneNumber;
    }

    public void setMobliePhoneNumber(String MobliePhoneNumber) {
        this.MobliePhoneNumber = MobliePhoneNumber;
    }

    public String getCurrentDeviceIdentificationNumber() {
        return CurrentDeviceIdentificationNumber;
    }

    public void setCurrentDeviceIdentificationNumber(String CurrentDeviceIdentificationNumber) {
        this.CurrentDeviceIdentificationNumber = CurrentDeviceIdentificationNumber;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }
}
