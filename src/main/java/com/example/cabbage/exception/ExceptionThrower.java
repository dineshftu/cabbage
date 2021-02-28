package com.example.cabbage.exception;

public class ExceptionThrower {

    public void throwGeneralException() throws Exception{
        Exception e = new CustomException();
        throw e;
    }

    public void throwCustomException() throws CustomException{
        CustomException e =  new CustomException();
        // e.setCode(10);
        e.setMessage("Org Not Provided");
        throw e;
    }

    // public void throwExternalApiResponseException() throws ExternalApiResponseException{
    //     ExternalApiResponseException e =  new ExternalApiResponseException();
    //     e.setCode(10);
    //     e.setHttpStatus(HttpStatus.GATEWAY_TIMEOUT);
    //     e.setErr("err");
    //     throw e;
    // }

    public void throwNullPointException(){
        String name;
        name = null;
        name = null + name;
    }
}
