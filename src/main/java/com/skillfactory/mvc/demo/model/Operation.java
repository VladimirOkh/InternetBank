package com.skillfactory.mvc.demo.model;




import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "operations")
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long operation_id;


    @Column(name = "username")
    private String username;

    @Column(name = "type")
    private String type;

    @Column(name = "day")
    private int day;

    @Column(name = "month")
    private int month;

    @Column(name = "year")
    private int year;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "receiver")
    private String receiver;

    public Operation(Long operation_id, String username, String type, int day, int month, int year, Integer amount, String receiver) {
        this.operation_id = operation_id;
        this.username = username;
        this.type = type;
        this.day = day;
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.receiver = receiver;
    }


    public Operation(){

    }




    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Long operation_id) {
        this.operation_id = operation_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
