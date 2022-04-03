package br.com.investmentcontrol.service;

import br.com.investmentcontrol.feignClient.MexClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MexService {

    @Autowired
    private MexClient mexClient;


    public String sendSms() {

        Set<Integer> list = getListNumbers();

        Set<Integer> newList = list.stream().filter(nr -> validateInitialNumber(nr)).collect(Collectors.toSet());
        Integer contato = 0;
        String smsResult = "";
        newList.forEach(number -> {
            String result = mexClient.sendSms("34"+number , "PROMOÇÃO na Sorveteria ORIGINAL AÇAÍ no estacionamento do Bernardao Olaria \n" +
                    "Na compra de um açaí GANHE um adicional grátis \n" +
                    "Válido até 06/03");
            System.out.println(number + " " + result);
        });

//        String smsResult = mexClient.sendSms("teste", "testando");
//        System.out.println(smsResult);
        return smsResult;
    }

    private static boolean validateInitialNumber(Integer nr) {
        if((nr.toString().startsWith("9") || nr.toString().startsWith("8")) && nr.toString().length() >= 9 )
            return true;
        else
            return false;
    }

    private static Set<Integer> getListNumbers() {
        Set<Integer> integers = new HashSet<>(Arrays.asList(
                991451818,
                768687767,
                998001002,
                998224117,
                981516160,
                999552222,
                998960504,
                999986763,
                991823230,
                992259382,
                992144353,
                992362425,
                999250061,
                999120808,
                996898877,
                998969617,
                988089529,
                991166564,
                992742391,
                999855221,
                999759522,
                991139940,
                996519355,
                999989737,
                999110293,
                984152552,
                991904272,
                996950061,
                988635417,
                988744461,
                992610761,
                988066293,
                991659157,
                991664080,
                994264654,
                996443773,
                999990802,
                999663323,
                999564082,
                991386734,
                999470712,
                998047959,
                946464646,
                999756432,
                992130678,
                991659157,
                984179450,
                988067333,
                997682100,
                988067333,
                996901912,
                996901912,
                999100310,
                987450100,
                991257200,
                991451818,
                991904272,
                999782329,
                996351526,
                988375090,
                999752304,
                984094111,
                998181548,
                988957752,
                991940101,
                996351526,
                985000000,
                988192643,
                992511289,
                997799696,
                988999990,
                984152552,
                998928924,
                991904272,
                996351526,
                998024079,
                991325133,
                999487223,
                768687767,
                991951216,
                988192643,
                991325133,
                999323956,
                999592018,
                999506436,
                999323956,
                996639652,
                996639652,
                915435355,
                992411038,
                999277173,
                998793263,
                992168989,
                988298062,
                991385000,
                999992124,
                999834984,
                999989737,
                999556991,
                998780790,
                998292247,
                991066014,
                999110293,
                999667858,
                998884335,
                998428458,
                992247072,
                969875485,
                991280995,
                999974467,
                991458412,
                999609701,
                996386232,
                992239118,
                998428458,
                768687767,
                996901912
        ));

        return integers;
    }
}
