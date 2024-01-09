package com.gr2.fashionshop.exceptions;

public class ImageNotFoundException extends RuntimeException{
  public ImageNotFoundException(String message){
    super(message);
  }
}
