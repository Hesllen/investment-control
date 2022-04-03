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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

//@Entity
//@Data
//@Builder
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "tb_action")
public class Action {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String ticket;

    //	@Fetch(FetchMode.SUBSELECT)
//    @OneToMany(mappedBy = "stock_id", fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "action")
//    private List<Income> income;
//
//    @OneToMany(mappedBy = "action")
//    private List<TypeAction> typeActions;

//	@OneToMany(mappedBy = "actionId", fetch = FetchType.EAGER)
//	private Set<Investment> investment;

//    @ManyToOne
//    @JoinColumn(name = "wallet_id")
//    private Wallet wallet;

//    @OneToMany(mappedBy = "action")
//    private List<Investment> investments;

}