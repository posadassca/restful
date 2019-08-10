package com.ws.restful.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private int id;
    private String name;
    private String designation;
    private String expertise;
    private LocalDate createdAt;
    private LocalDate updatedAt;
//    private Date updatedAt;

}
