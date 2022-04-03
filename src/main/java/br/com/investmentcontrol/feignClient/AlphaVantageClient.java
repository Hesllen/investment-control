package br.com.investmentcontrol.feignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "alpha-vantage", url="https://www.alphavantage.co")
public interface AlphaVantageClient {

    @RequestMapping(method = RequestMethod.GET, value = "/query?function={function}&symbol={symbol}&apikey=Q131U7I6JD0YEYZB")
    String getStockPrice(@PathVariable("function") String function,
                         @PathVariable("symbol") String symbol);
}
