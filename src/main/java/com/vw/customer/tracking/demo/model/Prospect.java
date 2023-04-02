package com.vw.customer.tracking.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Prospect implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name="cartype_id")
  private Cartype cartype;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(length = 50, nullable = false)
  private String firstname;

  @Column(length = 50, nullable = false)
  private String lastname;

  @Column(length = 200, nullable = false)
  private String address;

  @Column(length = 50, nullable = false)
  private String state;

  @Column(length = 50, nullable = false)
  private String city;

  @Column(length = 50, nullable = false)
  private String email;

  @Column(length = 50, nullable = false)
  private String phone;

  @Column(length = 200, nullable = false)
  private String comments;

  @Column(length = 1, nullable = false)
  private Boolean active;

}
