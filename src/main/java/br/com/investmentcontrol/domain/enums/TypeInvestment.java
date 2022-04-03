package br.com.investmentcontrol.domain.enums;

import br.com.investmentcontrol.domain.Investment;
import br.com.investmentcontrol.domain.dto.InvestmentDTO;
import br.com.investmentcontrol.domain.dto.WalletDTO;
import br.com.investmentcontrol.service.requirement.CryptoRequirement;
import br.com.investmentcontrol.service.requirement.InvestmentRequirement;
import br.com.investmentcontrol.service.requirement.PutRequirement;
import br.com.investmentcontrol.service.requirement.StockRequirement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum TypeInvestment {

    STOCK(0, StockRequirement.class),
    CRYPTO(1, CryptoRequirement.class),
    FII(2, CryptoRequirement.class),
    BDR(3, CryptoRequirement.class),
    PUT(4, PutRequirement.class),
    CALL(5, CryptoRequirement.class),
    ETF(6, CryptoRequirement.class);

    private Integer code;
    private Class<? extends InvestmentRequirement> investmentRequirement;

    TypeInvestment(Integer code, Class<? extends InvestmentRequirement> investmentRequirement) {
        this.code = code;
        this.investmentRequirement = investmentRequirement;
    }

    public void doIt(WalletDTO walletDTO, HashMap<TypeInvestment, List<Investment>> hashInvestments) {
        //TO DO  CRIAR OS REQUIREMENTS
        InvestmentRequirement requirement = null;
        try {
            requirement = this.investmentRequirement.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        requirement.processInvestment(this, walletDTO, hashInvestments);
    }

//    public void doIt(WalletDTO walletDTO, List<Investment> listStocks) {
//        //TO DO  CRIAR OS REQUIREMENTS
//        InvestmentRequirement requirement = null;
//        try {
//            requirement = this.investmentRequirement.getDeclaredConstructor().newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        requirement.processInvestment(this, walletDTO, listStocks);
//    }

    public Integer getCode() {
        return code;
    }

    public static List<TypeInvestment> getList() {
        return Arrays.asList(TypeInvestment.values());
    }

    public static TypeInvestment getById(int id) {
        return Arrays.asList(TypeInvestment.values()).stream().filter(type -> type.getCode() == id).findFirst().get();
    }
}
