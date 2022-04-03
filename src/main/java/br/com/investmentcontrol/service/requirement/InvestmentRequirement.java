package br.com.investmentcontrol.service.requirement;

import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.dto.InvestmentDTO;
import br.com.investmentcontrol.domain.dto.WalletDTO;
import br.com.investmentcontrol.domain.enums.TypeInvestment;

import java.util.HashMap;
import java.util.List;

public abstract class InvestmentRequirement {

//    public abstract void processInvestment(TypeInvestment typeInvestment, WalletDTO walletDTO, List<Investment> listStocks);
    public abstract void processInvestment(TypeInvestment typeInvestment, WalletDTO walletDTO, HashMap<TypeInvestment, List<Investment>> hashInvestiments);

    public abstract HashMap<String, InvestmentDTO> aggregate(List<Investment> listInvestments);
}
