package com.springpro.entity;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer m_id;
    @Column
    private Integer send_id;
    @Column
    private Integer receive_id;
    @Column
    private String in_name;
    @Column
    private String bein_name;
    @Column
    private Integer type;
    @Column
    private String m_info;
    @Column
    private String m_time;
    @Column
    private Integer team_id;
    @Column
    private Integer m_status;
}
