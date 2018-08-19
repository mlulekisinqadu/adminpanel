package com.bryansinqadu.admin_panel;

public class AdminUser {
    private String Name;
    private String Phone;
    private String Gender;
    private String Email;
    private String Password;
    private long CreatedAt;

    public AdminUser() {

    }

    public AdminUser(String name, String phone, String gender, String email, String password, long createdAt) {
        Name = name;
        Phone = phone;
        Gender = gender;
        Email = email;
        Password = password;
        CreatedAt = createdAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(long createdAt) {
        CreatedAt = createdAt;
    }
}