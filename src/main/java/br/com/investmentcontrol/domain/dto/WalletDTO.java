package br.com.investmentcontrol.domain.dto;

import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.predicate.InvestmentPredicate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDTO {

    private List<InvestmentDTO> stocks;
    private List<InvestmentDTO> cryptos;

    private BigDecimal equityStocks;
    private BigDecimal equityCryptos;
    private BigDecimal equityWallet;

    @Transient
    public List<Investment> getAllInvestmentByType(List<Investment> investmentList, Integer code) {
        return Optional.ofNullable(investmentList)
                .orElse(List.of())
                .stream()
                .filter(InvestmentPredicate.builder().build().getOnlyInvestmentByType(code))
                .sorted(Comparator.comparing(investment -> investment.getDate()))
                .collect(Collectors.toList());
    }

}
