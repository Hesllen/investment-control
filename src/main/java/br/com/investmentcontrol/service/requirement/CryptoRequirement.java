package br.com.investmentcontrol.service.requirement;

import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.dto.InvestmentDTO;
import br.com.investmentcontrol.domain.dto.WalletDTO;
import br.com.investmentcontrol.domain.enums.TypeInvestment;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

@Slf4j
public class CryptoRequirement extends InvestmentRequirement {
    @Override
    public void processInvestment(TypeInvestment typeInvestment, WalletDTO walletDTO, HashMap<TypeInvestment, List<Investment>> hashInvestiments) {
        log.info("PASSANDO PELO CryptoRequirement");


    }

//    @Override
//    public void processInvestment(TypeInvestment typeInvestment, WalletDTO walletDTO, List<Investment> listStocks) {
//
//    }

    @Override
    public HashMap<String, InvestmentDTO> aggregate(List<Investment> listInvestments) {
        return null;
    }
}
