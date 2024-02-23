package com.springpro.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer p_id;
    @Column
    private String p_title;
    @Column
    private String task;
    @Column
    private String p_time;
    @Column
    private Integer tnumber;
    @Column
    private Integer tsum;
    @Column
    private String desct;
    @Column
    private Integer leader_id;
    @Column
    private String s_t;
    @Column
    private String e_t;
    @Column
    private Integer tasknum;
    @Column
    private Integer comp_tasknum;
    private String leader_name;
}
