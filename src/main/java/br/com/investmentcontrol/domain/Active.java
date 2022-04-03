package br.com.investmentcontrol.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_active")
@Data
public class Active {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_active")
    private Long id;
    private String name;

    @NotNull
    private String ticket;

    @OneToOne
    @JoinColumn(name= "code", referencedColumnName = "code")
    private StockClass stockClass;

    private Integer qtyOn;
    private Integer qtyPn;

}
