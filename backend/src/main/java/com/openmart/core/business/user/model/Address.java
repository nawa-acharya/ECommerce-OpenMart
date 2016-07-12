package com.openmart.core.business.user.model;

/**
 * Created by Nawa on 7/9/2016.
 */
//address interface
public interface Address {
    public String getStreet();

    public String getCity();

    public String getState();

    public String getZip();

    public int getId();

    public void setStreet(String s);

    public void setCity(String s);

    public void setState(String s);

    public void setZip(String s);

    public void setId(int id);

}
