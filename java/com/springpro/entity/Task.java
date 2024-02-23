package com.springpro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int t_id;
    @Column
    private String t_title;
    @Column
    private String desct;
    @Column
    private int p_id;
    @Column
    private String s_t;
    @Column
    private String e_t;
    @Column
    private int user_id;
    @Column
    private int t_status;
    @Column
    private int leader_id;
    @Column
    private String info;
    private String username;
    @Column
    private String taskInfo;
    @Column
    private String filename;
}
