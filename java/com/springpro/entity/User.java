package com.springpro.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer user_id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String i_status;
    @Column
    private Integer team_id;
    @Column
    private Integer del;
}
