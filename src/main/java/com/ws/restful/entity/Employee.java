package com.ws.restful.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String designation;
    private String expertise;
    private LocalDate createdAt;
    private LocalDate updatedAt;

//    @Temporal(TemporalType.DATE)
//    @LastModifiedDate
//    private Date updatedAt;

}
