package com.bryansinqadu.admin_panel;




public class Bookings {

    private String Name;
    private String BookingId;
    private String Email;
    private String Department;
    private String Slot;
    private String Status;
    private String Date;
    private String Time;

    public Bookings(){

    }

    public Bookings(String name, String bookingId, String email, String department, String slot, String status, String date,String time) {
        Name = name;
        BookingId = bookingId;
        Email = email;
        Department = department;
        Slot = slot;
        Status = status;
        Date = date;
        Time = time;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBookingid() {
        return BookingId;
    }

    public void setBookingid(String bookingid) {
        BookingId = bookingid;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getSlot() {
        return Slot;
    }

    public void setSlot(String slot) {
        Slot = slot;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
