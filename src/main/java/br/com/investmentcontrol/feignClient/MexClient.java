package br.com.investmentcontrol.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mex", url="https://mex10.com/api")
public interface MexClient {

    @RequestMapping(method = RequestMethod.GET, value = "/shortcodev2.aspx?token=cb6fdb0d18b9c9507c9d22ec2aca1003f83a212362338df3dc2fd3640a51afd6&t=send&n={number}&m={message}")
    String sendSms(@PathVariable("number") String number,
                         @PathVariable("message") String message);
}
