package br.com.investmentcontrol.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_stock_class")
@Data
public class StockClass implements Serializable {

    @Id
    private Integer code;

    private String classType;

    private String description;
}
