package com.gr2.fashionshop.exceptions;

public class ProductNotFoundException extends RuntimeException{
//    public ProductNotFoundException() {
//        // TODO Auto-generated constructor stub
//    }

    public ProductNotFoundException(String message){
        super(message);
    }
}
