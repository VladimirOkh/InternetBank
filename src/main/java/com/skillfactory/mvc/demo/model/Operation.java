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

    @Column(name = "operation_type")
    private Integer type;

    @Column(name = "operation_date")
    private Date date;

    public Operation(Long operation_id, String username, Integer type, Date date) {
        this.operation_id = operation_id;
        this.username = username;
        this.type = type;
        this.date = date;
    }

    public Operation(){

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
