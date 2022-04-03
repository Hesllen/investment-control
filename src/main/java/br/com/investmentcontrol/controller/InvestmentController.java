package br.com.investmentcontrol.controller;

import br.com.investmentcontrol.domain.dto.StockTimeSeriesDailyDTO;
import br.com.investmentcontrol.domain.dto.WalletDTO;
import br.com.investmentcontrol.service.InvestmentService;
import br.com.investmentcontrol.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investments")
@Slf4j
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private WalletService walletService;


    @GetMapping("/lastPriceStock/{symbol}")
    public ResponseEntity<StockTimeSeriesDailyDTO> getLastPriceStock(@PathVariable("symbol") String symbol) {
        log.info("Buscando investment");
//        List<Investment> investments = investmentService.findAllInvestment();
        StockTimeSeriesDailyDTO lastStockPrice = investmentService.getLastStockPriceByFunction("TIME_SERIES_DAILY_ADJUSTED", symbol);
        return ResponseEntity.status(HttpStatus.OK).body(lastStockPrice);
    }
    @GetMapping()
    public ResponseEntity<WalletDTO> getWallet() {
        log.info("Buscando investment");
//        List<Investment> investments = investmentService.findAllInvestment();
        WalletDTO walletDTO = walletService.getWallet();
//        if(investments.isPresent()) {
        return ResponseEntity.status(HttpStatus.OK).body(walletDTO);
//        }
//        return ResponseEntity.notFound().build();
    }
//    @PostMapping("/action")
//    @Transactional
////	@CacheEvict(value = "listaDeTopicos", allEntries = true)
//    public ResponseEntity<ActionDTO> saveAction(@RequestBody @Valid ActionForm form, UriComponentsBuilder uriBuilder) {
//        log.info("salvando acao");
//        Stock action = investmentService.saveAction(form);
//        URI uri = uriBuilder.path("/investment/action/{id}").buildAndExpand(action.getId()).toUri();
//        return ResponseEntity.created(uri).body(new ActionDTO(action));
//    }
//
//    @GetMapping("/action/{id}")
//    public ResponseEntity<ActionDTO> getActionById(@PathVariable("id") Long id) {
//        log.info("Buscando acao id: {}", id);
//        Optional<Action> action = investmentService.findActionById(id);
//        if(action.isPresent()) {
//            return ResponseEntity.ok(new ActionDTO(action.get()));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping()
//    @Transactional
//    public ResponseEntity<InvestmentDTO> saveInvestment(@RequestBody @Valid InvestmentForm form, UriComponentsBuilder uriBuilder) {
//        log.info("salvando acao");
//        Investment investment = investmentService.saveInvestment(form);
//        URI uri = uriBuilder.path("/investment/{id}").buildAndExpand(investment.getId()).toUri();
//        return ResponseEntity.created(uri).body(InvestmentDTO.convert(investment));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<InvestmentDTO> getInvestmentById(@PathVariable("id") Long id) {
//        log.info("Buscando investment id: {}", id);
//        Optional<Investment> investment = investmentService.findById(id);
//        if(investment.isPresent()) {
//            return ResponseEntity.ok(InvestmentDTO.convert(investment.get()));
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/income")
//    @Transactional
////	@CacheEvict(value = "listaDeTopicos", allEntries = true)
//    public ResponseEntity<IncomeDTO> saveIncome(@RequestBody @Valid IncomeForm form, UriComponentsBuilder uriBuilder) {
//        log.info("salvando income");
//        Income income = investmentService.saveIncome(form);
//        URI uri = uriBuilder.path("/investment/action/{id}").buildAndExpand(income.getId()).toUri();
//        return ResponseEntity.created(uri).body(IncomeDTO.convert(income));
//    }
//
//    @GetMapping("/income/{id}")
//    public ResponseEntity<IncomeDTO> getIncomeById(@PathVariable("id") Long id) {
//        log.info("Buscando income id: {}", id);
//        Optional<Income> income = investmentService.findIncomeById(id);
//        if(income.isPresent()) {
//            return ResponseEntity.ok(IncomeDTO.convert(income.get()));
//        }
//        return ResponseEntity.notFound().build();
//    }
}
