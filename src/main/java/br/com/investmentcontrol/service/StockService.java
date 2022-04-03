package br.com.investmentcontrol.service;

import br.com.investmentcontrol.domain.dto.StockTimeSeriesDailyDTO;
import br.com.investmentcontrol.domain.dto.WalletDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StockService {

    @Autowired
    private InvestmentService investmentService;

    public void calculateEquityStockCurrent(WalletDTO walletDTO) {
        walletDTO.getStocks().forEach(investmentDTO -> {
            StockTimeSeriesDailyDTO lastPrice = investmentService.getLastStockPriceByFunction("TIME_SERIES_DAILY_ADJUSTED", investmentDTO.getTicket().concat(".SAO"));
            BigDecimal multiply = lastPrice.getClose().multiply(new BigDecimal(investmentDTO.getQuantity()));
            investmentDTO.setCurrentEquity(multiply);
            investmentDTO.setCurrentPrice(lastPrice.getClose());
        });
    }

}
