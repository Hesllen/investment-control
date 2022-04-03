package br.com.investmentcontrol.service.requirement;

import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.dto.InvestmentDTO;
import br.com.investmentcontrol.domain.dto.WalletDTO;
import br.com.investmentcontrol.domain.enums.TypeInvestment;
import br.com.investmentcontrol.domain.enums.TypeOperation;
import br.com.investmentcontrol.exception.StockNotPresentException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockRequirement extends InvestmentRequirement {

//    @Override
//    public void processInvestment(TypeInvestment typeInvestment, WalletDTO walletDTO, List<Investment> investments) {
//
//        List<Investment> stocksInvestments = walletDTO.getAllInvestmentByType(investments, typeInvestment.getCode());
//
//        stocksInvestments.stream().findFirst().orElseThrow(StockNotPresentException::new);
//
//        HashMap<String, InvestmentDTO> hashMap = aggregate(stocksInvestments);
//
//
//        ArrayList<InvestmentDTO> stocksDTOS = new ArrayList<>();
//
//        hashMap.forEach((key, stocksDTO) -> stocksDTOS.add(stocksDTO));
//
////        stocksInvestments.forEach(investment -> stocksDTOS.add(StocksDTO.fillDto(investment)));
//
//        stocksDTOS.forEach(investmentDTO -> {
//            BigDecimal average = investmentDTO.getInvestedEquity().divide(new BigDecimal(investmentDTO.getQuantity()), 2, RoundingMode.HALF_EVEN);
//            investmentDTO.setAveragePrice(average);
//        });
//
//        walletDTO.setStocks(stocksDTOS);
//
//        walletDTO.setEquityStocks(stocksDTOS.stream()
//                                    .map(InvestmentDTO::getInvestedEquity)
//                                    .reduce((b1, b2) -> b1.add(b2)).get());
//
//        calculatePercentage(walletDTO);
//
//    }


    @Override
    public void processInvestment(TypeInvestment typeInvestment, WalletDTO walletDTO, HashMap<TypeInvestment, List<Investment>> stocksMap) {

        List<Investment> investmentList = stocksMap.get(TypeInvestment.STOCK);

        HashMap<String, InvestmentDTO> hashMap = aggregate(investmentList);

        ArrayList<InvestmentDTO> stocksDTOS = new ArrayList<>();

        hashMap.forEach((key, stocksDTO) -> stocksDTOS.add(stocksDTO));

        stocksDTOS.forEach(investmentDTO -> {
            BigDecimal average = investmentDTO.getInvestedEquity().divide(new BigDecimal(investmentDTO.getQuantity()), 2, RoundingMode.HALF_EVEN);
            investmentDTO.setAveragePrice(average);
        });

        walletDTO.setStocks(stocksDTOS);

        walletDTO.setEquityStocks(stocksDTOS.stream()
                .map(InvestmentDTO::getInvestedEquity)
                .reduce((b1, b2) -> b1.add(b2)).get());

        calculatePercentage(walletDTO);

    }

    private void calculatePercentage(WalletDTO walletDTO) {
//        NumberFormat formatter = new DecimalFormat("#0.00");

        Double equityStocks = walletDTO.getEquityStocks().doubleValue();

        walletDTO.getStocks().forEach(investmentDTO -> {
            double eq = investmentDTO.getInvestedEquity().doubleValue();
            double divide = eq / equityStocks;
            double multiply = divide * 100;
//            System.out.println("string: " + formatter.format(multiply));
//            investmentDTO.setPercentageStock(Double.valueOf(formatter.format(multiply).replace(",",".")));
            investmentDTO.setPercentageStock(Double.valueOf(String.format("%.2f", multiply).replace(",",".")));
        });
    }

    @Override
    public HashMap<String, InvestmentDTO> aggregate(List<Investment> stocksInvestments) {
        HashMap<String, InvestmentDTO> map = new HashMap<>();

        stocksInvestments.forEach(investment -> {

            String ticket = investment.getActive().getTicket().concat(investment.getActive().getStockClass().getCode().toString());

            boolean isSell = TypeOperation.SELL.equals(investment.getTypeOperation());
            if(isSell) {
                investment.setValue(investment.getValue().negate());
            }

            if(map.containsKey(ticket)) {
                BigDecimal valueTotal = investment.getValue().multiply(new BigDecimal(investment.getQuantity()));
                map.get(ticket).setQuantity(map.get(ticket).getQuantity() + (isSell ? -investment.getQuantity() : investment.getQuantity()));
                map.get(ticket).setInvestedEquity(map.get(ticket).getInvestedEquity().add(valueTotal));
            } else {
                map.put(ticket, InvestmentDTO.fillDto(investment, ticket));
            }
        });

        return map;
    }
}
