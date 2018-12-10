package cn.edu.hust.domain;

public class Address {
    private int id;
    private String country;
    private String province;
    private String city;
    private int code;

    public Address(int id, String country, String province, String city, int code) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.code = code;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
