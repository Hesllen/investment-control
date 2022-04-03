package br.com.investmentcontrol.domain;

import br.com.investmentcontrol.domain.enums.TypeIncome;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "tb_income")
public class Income {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
////    @ManyToOne()
////    @JoinColumn(name = "action_id")
////    private Action action;
//    @Enumerated(EnumType.STRING)
//    private TypeIncome type;
//
//    @ManyToOne
//    @JoinColumn(name = "active_id")
//    private Active active;
//
//    private BigDecimal income;
//    private LocalDate dtEx;
//    private LocalDate dtCom;
//    private LocalDate dtPayment;

//	@ManyToOne()
//	@JoinColumn(name = "wallet_id")
//	private Wallet wallet;
}
