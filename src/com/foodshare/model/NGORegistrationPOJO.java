package com.foodshare.model;

/**
 * POJO for NGO Registration
 */
public class NGORegistrationPOJO {
    private int id;
    private String organizationName;
    private String email;
    private String mobile;
    private String address;
    private String password;
    private String confirmPassword;

    public NGORegistrationPOJO() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getOrganizationName() { return organizationName; }
    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}
