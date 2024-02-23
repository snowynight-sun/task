package com.springpro.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer news_id;
    @Column
    private Integer user_id;
    @Column
    private Integer team_id;
    @Column
    private String info;
    @Column
    private String user_name;
    @Column
    private String time;
}
