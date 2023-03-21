package com.listadecompras.compras.application.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class CompraEntity {

    private Long id;
    private LocalDate dateReference;
    private String items;
    private String comments;
    private Boolean isDone;

}
