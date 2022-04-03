package br.com.investmentcontrol.domain;

import br.com.investmentcontrol.domain.enums.TypeInvestment;
import br.com.investmentcontrol.domain.enums.TypeOperation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_investment")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investment")
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "wallet_id")
//    private Wallet wallet;

    private Long quantity;

    @Enumerated(EnumType.STRING)
    private TypeInvestment typeInvestment;

    @ManyToOne
    @JoinColumn(name = "id_active")
    private Active active;

    @Enumerated(EnumType.STRING)
    private TypeOperation typeOperation;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Brazil/East")
    private LocalDate date;

    private BigDecimal value;

    private String teste;



//    @OneToOne
//    private TypeAction typeAction;



//    @ManyToOne()
//    @JoinColumn(name = "stock_id")
//    private Stock stock;
//
//    @ManyToOne()
//    @JoinColumn(name = "crypto_id")
//    private Crypto crypto;

//	private FII fiis;
//	private Cryptos;



}
