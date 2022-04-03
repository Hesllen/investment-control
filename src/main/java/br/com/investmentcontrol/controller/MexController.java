package br.com.investmentcontrol.controller;

import br.com.investmentcontrol.service.MexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mex")
public class MexController {

    @Autowired
    private MexService mexService;
    @GetMapping("/sendSms")
    public ResponseEntity<String> getLastPriceStock() {
//        log.info("Buscando investment");
//        List<Investment> investments = investmentService.findAllInvestment();
        String s = mexService.sendSms();
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

}
