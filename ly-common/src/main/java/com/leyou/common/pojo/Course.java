package com.leyou.common.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by lq on 2019/9/4.
 */
@Entity
@Table(name = "course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String teacher;

}
