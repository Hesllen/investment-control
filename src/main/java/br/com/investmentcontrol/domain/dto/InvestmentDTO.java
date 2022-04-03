package br.com.investmentcontrol.domain.dto;

import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.enums.TypeOperation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvestmentDTO {

    private String ticket;
    private Long quantity;
    private BigDecimal investedEquity;
    private BigDecimal averagePrice;
    private Double percentageStock;
    private BigDecimal currentEquity;
    private BigDecimal currentPrice;

    public static List<InvestmentDTO> fillDto(List<Investment> stocksInvestments, String ticket) {
        ArrayList<InvestmentDTO> dtos = new ArrayList<>();
        stocksInvestments.forEach(stock -> {
            BigDecimal value = new BigDecimal(String.valueOf(stock.getValue()));
            BigDecimal quantity = new BigDecimal(stock.getQuantity());

            InvestmentDTO dto = InvestmentDTO.builder()
                    .ticket(ticket)
                    .quantity(stock.getQuantity())
                    .investedEquity(value.multiply(quantity))
                    .build();
            dtos.add(dto);
        });
        return dtos;
    }

    public static InvestmentDTO fillDto(Investment investment, String ticket) {

        BigDecimal value = new BigDecimal(String.valueOf(investment.getValue()));
        BigDecimal quantity = new BigDecimal(investment.getQuantity());

        return InvestmentDTO.builder()
                .ticket(ticket)
                .quantity(TypeOperation.SELL.equals(investment.getTypeOperation()) ? -investment.getQuantity() : investment.getQuantity())
                .investedEquity(value.multiply(quantity))
                .build();
    }
}
