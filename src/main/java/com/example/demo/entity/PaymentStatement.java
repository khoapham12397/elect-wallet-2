package com.example.demo.entity;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@IdClass(UserTrans.class)
@Table(name = "payment_statement", indexes = @Index(name = "state_index", columnList = "user_id"))
public class PaymentStatement {
    @Id
    @Column(name = "user_id")
    private String user_id;

    @Id
    @Column(name = "trans_id")
    private String trans_id;

    @Column(name = "title")
    private String title;

    @Column(name = "time")
    private Long time;

    @NotNull
    @Column(name = "money")
    private Long money;

    @NotNull
    @Column(name = "type")
    private Integer type;

    public String getUser_id() {return user_id;}
    public void setUser_id(String user_id) {this.user_id = user_id;}

    public String getTrans_id() {return trans_id;}
    public void setTrans_id(String trans_id) {this.trans_id = trans_id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public Long getTime() {return time;}
    public void setTime(Long time) {this.time = time;}

    public Integer getType() {return type;}
    public void setType(Integer type) {this.type = type;}

    public Long getMoney() {return money;}
    public void setMoney(Long money) {this.money = money;}
}
