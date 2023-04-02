package com.vw.customer.tracking.demo.service.exception;

public class ProspectNotFoundException extends RuntimeException {

  public ProspectNotFoundException(Long id, Throwable cause) {
    super("Prospect with id=" + id + " not found", cause);
  }

}
