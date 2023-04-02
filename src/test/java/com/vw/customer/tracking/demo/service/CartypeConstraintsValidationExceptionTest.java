package com.vw.customer.tracking.demo.service;

import com.vw.customer.tracking.demo.dto.CartypeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CartypeConstraintsValidationExceptionTest {

  @Autowired
  private CartypeServiceImpl cartypeService;

  @Test
  public void constraintsValidationExceptionTest() {
    CartypeDTO cartypeDTO = new CartypeDTO();
    assertThrows(ConstraintViolationException.class, () -> {
      cartypeService.save(cartypeDTO);
    });

    // SOLO PARA VALIDACIONES
    /*try {
      CartypeDTO cartypeDTO = new CartypeDTO();
      cartypeService.create(cartypeDTO);
    } catch (Exception e) {
      System.out.println();
    }*/
  }
}
