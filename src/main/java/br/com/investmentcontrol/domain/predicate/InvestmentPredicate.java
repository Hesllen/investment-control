package br.com.investmentcontrol.domain.predicate;

import br.com.investmentcontrol.domain.Investment;
import lombok.Builder;

import java.util.List;
import java.util.function.Predicate;

@Builder
public class InvestmentPredicate extends PredicateAbstract<Investment> {

    public Predicate<Investment> getOnlyInvestmentByType(Integer code) {
        return investment -> code.equals(investment.getTypeInvestment().getCode());

    }
}
