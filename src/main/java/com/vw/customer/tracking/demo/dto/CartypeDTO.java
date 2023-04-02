package com.vw.customer.tracking.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CartypeDTO implements Serializable {

  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank
  @NotNull
  @Size(max = 5)
  private String code;

  @NotBlank
  @NotNull
  @Size(max = 50)
  private String name;

  @NotNull
  private Boolean active;

}
