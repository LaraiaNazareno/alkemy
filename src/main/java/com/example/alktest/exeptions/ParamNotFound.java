package com.example.alktest.exeptions;


public class ParamNotFound  extends RuntimeException {

    public ParamNotFound (String error){
        super(error);
    }
}
