package com.skillfactory.mvc.demo.model;




import javax.persistence.*;
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

    @Column(name = "date")
    private String date;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "receiver")
    private String receiver;


    public Operation(Long operation_id, String username, String type, String date) {
        this.operation_id = operation_id;
        this.username = username;
        this.type = type;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
