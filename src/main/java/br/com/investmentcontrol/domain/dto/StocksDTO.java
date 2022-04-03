package br.com.investmentcontrol.domain.dto;

import br.com.investmentcontrol.domain.Investment;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class StocksDTO {

    private String ticket;
    private Long quantity;
    private BigDecimal equity;

    public static List<StocksDTO> fillDto(List<Investment> stocksInvestments) {
        ArrayList<StocksDTO> stocksDTOS = new ArrayList<>();
        stocksInvestments.forEach(stock -> {
            BigDecimal value = new BigDecimal(String.valueOf(stock.getValue()));
            BigDecimal quantity = new BigDecimal(stock.getQuantity());

            StocksDTO dto = StocksDTO.builder()
                    .ticket(stock.getActive().getTicket().concat(stock.getActive().getStockClass().getCode().toString()))
                    .quantity(stock.getQuantity())
                    .equity(value.multiply(quantity))
                    .build();
            stocksDTOS.add(dto);
        });
        return stocksDTOS;
    }

    public static StocksDTO fillDto(Investment stock) {

            BigDecimal value = new BigDecimal(String.valueOf(stock.getValue()));
            BigDecimal quantity = new BigDecimal(stock.getQuantity());

        return StocksDTO.builder()
                    .ticket(stock.getActive().getTicket().concat(stock.getActive().getStockClass().getCode().toString()))
                    .quantity(stock.getQuantity())
                    .equity(value.multiply(quantity))
                    .build();

    }
}
