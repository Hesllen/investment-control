package br.com.investmentcontrol.service;

import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.dto.StockTimeSeriesDailyDTO;
import br.com.investmentcontrol.domain.dto.WalletDTO;
import br.com.investmentcontrol.domain.enums.TypeInvestment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class WalletService {

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private StockService stockService;
    @Autowired
    private ObjectMapper mapper;

    public WalletDTO getWallet(){
        WalletDTO walletDTO = WalletDTO.builder().build();

        List<Investment> allInvestment = investmentService.findAllInvestment();

        HashMap<TypeInvestment, List<Investment>> aggregate = aggregateInvestimentsByType(allInvestment);

//        aggregate.size();

        TypeInvestment.getList().forEach(typeInvestment -> typeInvestment.doIt(walletDTO, aggregate));
//        TypeInvestment.getList().forEach(typeInvestment -> typeInvestment.doIt(walletDTO, allInvestment));

        stockService.calculateEquityStockCurrent(walletDTO);

        return walletDTO;
    }


    public HashMap<TypeInvestment, List<Investment>> aggregateInvestimentsByType(List<Investment> investments) {
        HashMap<TypeInvestment, List<Investment>> map = new HashMap<>();

        investments.forEach(investment -> {
            TypeInvestment typeInvestment = investment.getTypeInvestment();
            if(map.containsKey(typeInvestment)) {
                map.get(typeInvestment).add(investment);
            } else {
                ArrayList<Investment> list = new ArrayList<>();
                list.add(investment);
                map.put(typeInvestment, list);
            }
        });

        return map;
    }
}
