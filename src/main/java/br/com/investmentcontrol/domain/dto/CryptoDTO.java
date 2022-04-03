package br.com.investmentcontrol.domain.dto;

import br.com.investmentcontrol.domain.Investment;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class CryptoDTO {

    private String ticket;
    private Long quantity;
    private BigDecimal equity;

    public static List<CryptoDTO> fillDto(List<Investment> stocksInvestments) {
        ArrayList<CryptoDTO> cryptos = new ArrayList<>();
        stocksInvestments.forEach(stock -> {
            BigDecimal value = new BigDecimal(String.valueOf(stock.getValue()));
            BigDecimal quantity = new BigDecimal(stock.getQuantity());

            CryptoDTO dto = CryptoDTO.builder()
                    .ticket(stock.getActive().getTicket())
                    .quantity(stock.getQuantity())
                    .equity(value.multiply(quantity))
                    .build();
            cryptos.add(dto);
        });
        return cryptos;
    }

    public static CryptoDTO fillDto(Investment stock) {

        BigDecimal value = new BigDecimal(String.valueOf(stock.getValue()));
        BigDecimal quantity = new BigDecimal(stock.getQuantity());

        return CryptoDTO.builder()
                .ticket(stock.getActive().getTicket())
                .quantity(stock.getQuantity())
                .equity(value.multiply(quantity))
                .build();

    }
}
