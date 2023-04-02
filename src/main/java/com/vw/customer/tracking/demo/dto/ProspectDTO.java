package com.vw.customer.tracking.demo.dto;

import com.vw.customer.tracking.demo.model.Cartype;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProspectDTO implements Serializable {

  @EqualsAndHashCode.Include
  private Long id;

  @NotNull
  private Cartype cartype;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String name;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String firstname;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String lastname;

  @NotBlank
  @NotNull
  @Size(max = 200)
  private String address;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String state;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String city;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String email;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String phone;

  @NotBlank
  @NotNull
  @Size(max = 200)
  private String comments;

  @NotNull
  private Boolean active;

}













