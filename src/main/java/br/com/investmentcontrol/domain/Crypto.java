package br.com.investmentcontrol.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Data
//@Builder
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "tb_crypto")
public class Crypto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String ticket;

    //	@Fetch(FetchMode.SUBSELECT)
//    @OneToMany(mappedBy = "stock_id", fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "stock")
//    private Set<Income> income;
//	@OneToMany(mappedBy = "actionId", fetch = FetchType.EAGER)
//	private Set<Investment> investment;

//    @ManyToOne
//    @JoinColumn(name = "wallet_id")
//    private Wallet wallet;

//    @OneToMany(mappedBy = "crypto")
//    private Set<Investment> investments;
}
