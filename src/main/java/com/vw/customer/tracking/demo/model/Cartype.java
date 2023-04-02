package com.vw.customer.tracking.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Cartype implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 5, nullable = false)
  private String code;

  @Column(length = 50, nullable = false, unique = true)
  private String name;

  @Column(length = 1, nullable = false)
  private Boolean active;

}
