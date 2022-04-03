package br.com.investmentcontrol.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Stock not found")
public class StockNotPresentException extends RuntimeException {


    public void StockNotPresentException(){

    }

}
