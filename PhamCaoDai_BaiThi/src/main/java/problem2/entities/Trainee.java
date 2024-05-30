package problem2.entities;

import java.util.Date;

public class Trainee {
    private int trainee_id;
    private String account;
    private String full_name;
    private boolean gender;
    private Date birth_date;
    private int Phone_number;
    private double gpa;
    private String Status;


    public Trainee(int trainee_id, String account, String full_name, boolean gender, Date birth_date, int phone_number, double gpa, String status) {
        this.trainee_id = trainee_id;
        this.account = account;
        this.full_name = full_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.Phone_number = phone_number;
        this.gpa = gpa;
        Status = status;
    }

    public Trainee() {

    }

    public int getTrainee_id() {
        return trainee_id;
    }

    public void setTrainee_id(int trainee_id) {
        this.trainee_id = trainee_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public java.sql.Date getBirth_date() {
        return (java.sql.Date) birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public int getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(int phone_number) {
        Phone_number = phone_number;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "trainee_id=" + trainee_id +
                ", account='" + account + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", birth_date=" + birth_date +
                ", Phone_number=" + Phone_number +
                ", gpa=" + gpa +
                ", Status='" + Status + '\'' +
                '}';
    }
}
