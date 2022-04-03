package br.com.investmentcontrol.service;

import br.com.investmentcontrol.domain.Action;
import br.com.investmentcontrol.domain.Income;
import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.dto.StockTimeSeriesDailyDTO;
import br.com.investmentcontrol.feignClient.AlphaVantageClient;
import br.com.investmentcontrol.repository.InvestmentRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private AlphaVantageClient alphaVantageClient;

//
//    @Autowired
//    private StockRepository actionRepository;
//
//    @Autowired
//    private IncomeRepository incomeRepository;

//    public Optional<Investment> findById(Long id) {
//        return  investmentRepository.findById(id);
//    }

//    public Stock saveAction(ActionForm form) {
//        Stock action = form.convert(form);
//        return actionRepository.save(action);
//
//    }

//    public Optional<Action> findActionById(Long id) {
//        return actionRepository.findById(id);
//    }

//    public Investment saveInvestment(InvestmentForm form) {
//        Investment investment = form.convert(form, actionRepository);
////		Action action = investment.getAction();
//        investmentRepository.save(investment);
//        return investment;
//    }

//    public Income saveIncome(IncomeForm form) {
//        Income income = form.convert(form, actionRepository);
////		income.setTotalInvested(getAllInvestedInAction(actionRepository.getOne(form.getActionId())));
//        calculateYield(income);
//        incomeRepository.save(income);
//        return income;
//    }

    private void calculateYield(Income income) {
//		NumberFormat formatter = new DecimalFormat("#0.00");
//		Double income2 = Double.valueOf((income.getIncome().setScale(2, RoundingMode.HALF_EVEN)).toString());
//		Double totalInvested = Double.valueOf((income.getTotalInvested().setScale(2, RoundingMode.HALF_EVEN)).toString());
//		Double yield = ((income2/totalInvested)*100.0);
//		income.setYield(Double.parseDouble(formatter.format(yield).replace(",", ".")));

    }

    private BigDecimal getAllInvestedInAction(Action action) {
        BigDecimal totalBuy = BigDecimal.ZERO;
        BigDecimal totalSold = BigDecimal.TEN;
//		for (Investment investment : action.getListInvestment()) {
//			BigDecimal buy = Optional.ofNullable(investment.getBuyValue()).orElse(BigDecimal.ZERO);
//			totalBuy = buy.add(totalBuy);
//
//			BigDecimal sold = Optional.ofNullable(investment.getSaleValue()).orElse(BigDecimal.ZERO);
//			totalSold = sold.add(totalSold);
//		}
        return totalBuy.subtract(totalSold);
    }

    public List<Investment> findAllInvestment() {
        return investmentRepository.findAll();
    }

    public StockTimeSeriesDailyDTO getLastStockPriceByFunction(String funciton, String symbol) {
        StockTimeSeriesDailyDTO sdto = null;
        try {
            Gson gson = new Gson();
            String stockPrice = alphaVantageClient.getStockPrice(funciton, symbol);
            String convert = StockTimeSeriesDailyDTO.getLastStockPriceUpdated(stockPrice);

            sdto = gson.fromJson(convert, StockTimeSeriesDailyDTO.class);

        } catch (Exception e) {
            log.warn("erro getLastStockPriceByFunction");
            e.printStackTrace();
        }
        return sdto;
    }

//    public Optional<Income> findIncomeById(Long id) {
//        return incomeRepository.findById(id);
//    }


}
