package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name= "Task")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Date dueDate;
    @Column
    private Boolean completed;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name="TP_USER_ID")
    private User user;

//    public Task (String title, String description, Date dueDate, Boolean completed, User user){
//        this.title = title;
//        this.description = description;
//        this.dueDate = dueDate;
//        this.completed = completed;
//        this.user = user;
//    }

}
