package com.vw.customer.tracking.demo.service.exception;

public class CartypeNotFoundException extends RuntimeException {

  public CartypeNotFoundException(Long id, Throwable cause) {
    super("Cart Type with id=" + id + " not found", cause);
  }

}
