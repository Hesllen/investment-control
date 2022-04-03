package br.com.investmentcontrol.domain.enums;

import java.util.Arrays;


public enum TypeIncome {

    DEPOSIT (0, "DEPOSIT"), DIVIDEND(1, "DIVIDEND"), JCP(2, "JCP"), PUT(3, "PUT"), CALL(4, "CALL");

    private Integer id;
    private String name;

    TypeIncome(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static TypeIncome getById(int id) {
        return Arrays.asList(TypeIncome.values()).stream().filter(type -> type.getId() == id).findFirst().orElseGet(() -> TypeIncome.DEPOSIT);
    }

}