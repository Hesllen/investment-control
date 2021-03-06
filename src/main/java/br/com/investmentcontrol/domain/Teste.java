package br.com.investmentcontrol.domain;

import br.com.investmentcontrol.domain.dto.StockTimeSeriesDailyDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teste {

    public static void main(String[] args) {
        Set<Integer> list = getListNumbers();

        Set<Integer> newList = list.stream().filter(nr -> validateInitialNumber(nr)).collect(Collectors.toSet());
        Integer contato = 0;

        for ( Integer n : newList) {
            if (n.toString().length() == 8) {
                System.out.println("contato " + contato + ";0349" + n);
                contato++;
            } else {
                System.out.println("contato " + contato + ";034" + n);
                contato++;
            }
        }

    }

    private static boolean validateInitialNumber(Integer nr) {
        if((nr.toString().startsWith("9") || nr.toString().startsWith("8")) && nr.toString().length() >= 8 )
            return true;
        else
            return false;
    }
    private static Set<Integer> getListNumbers() {
        Set<Integer> integers = new HashSet<>(Arrays.asList(
                999453744,
                999758240,
                996764239,
                988526636,
                91289708,
                996950061,
                996950061,
                99792914,
                91992107,
                988575070,
                992309969,
                999638181,
                999158558,
                99287413,
                98101099,
                98101099,
                99402043,
                991151700,
                992006459,
                999136988,
                999457547,
                999457547,
                98836269,
                999959405,
                999178844,
                996524502,
                991441617,
                984082278,
                984082278,
                91932593,
                991064654,
                948484848,
                999683346,
                991458711,
                991445116,
                991509660,
                991357913,
                88180534,
                999758242,
                991768071,
                991415953,
                99990268,
                88416006,
                96528754,
                991677339,
                999755026,
                999755026,
                992217628,
                991166564,
                991726334,
                988746336,
                988746336,
                99813815,
                99813815,
                991955180,
                991955180,
                991413214,
                999988825,
                999957108,
                999751124,
                984111830,
                99969521,
                99969521,
                991285529,
                990548454,
                99320346,
                999556511,
                1,
                992880006,
                991463676,
                984128886,
                38215858,
                992080365,
                99247021,
                996776409,
                999751339,
                988198650,
                992073503,
                999470002,
                997963938,
                999022386,
                981857504,
                98112266,
                99258182,
                999089393,
                999999999,
                99759010,
                99759010,
                984128920,
                999696935,
                99226685,
                991922998,
                99123462,
                999096006,
                91066229,
                999710724,
                999710724,
                996626616,
                999292588,
                988534359,
                999110870,
                996594781,
                988032111,
                38232320,
                991038092,
                999170118,
                999170118,
                996515707,
                93313414,
                369877541,
                369877541,
                991745000,
                999172528,
                999846681,
                998094393,
                99753656,
                92316666,
                996317770,
                999191419,
                991635730,
                991734584,
                998085454,
                998085454,
                991961005,
                988635214,
                988216807,
                938226114,
                92170466,
                38246654,
                998072422,
                911255458,
                991814433,
                91767813,
                988649514,
                988649514,
                999104416,
                991547081,
                988632011,
                988632011,
                999994123,
                994156255,
                99639640,
                991347190,
                996962060,
                992565872,
                999759969,
                999751090,
                99841632,
                99750313,
                999652362,
                999555222,
                999555222,
                991281282,
                991788451,
                991870370,
                966325854,
                999526874,
                999526874,
                93702457,
                999557831,
                988825227,
                999045943,
                992953707,
                996614959,
                996614959,
                991947352,
                91968888,
                998794207,
                996460838,
                991460850,
                99778172,
                991032211,
                996524785,
                968505649,
                998110335,
                991926848,
                991926848,
                991926848,
                966999197,
                999959993,
                999959993,
                999975224,
                988683569,
                99999999,
                999844735,
                91755624,
                996521415,
                984209381,
                996421860,
                997901816,
                991562369,
                999232251,
                999111895,
                999111895,
                999037305,
                994342276,
                91788592,
                996264248,
                998751906,
                99757663,
                991125869,
                991179106,
                98055063,
                992742391,
                999263917,
                991069401,
                992593102,
                988436152,
                999788854,
                99263354,
                991324317,
                88416535,
                88222290,
                991544787,
                999702919,
                992562369,
                998986505,
                992323616,
                99954789,
                998457125,
                999358068,
                999358068,
                999194978,
                996533889,
                991828373,
                99611908,
                99425934,
                991085466,
                997936486,
                991417203,
                991976769,
                99489313,
                99141814,
                991215621,
                999394503,
                991983633,
                93010000,
                995478777,
                988015100,
                999612352,
                981159445,
                998748978,
                988656852,
                38224196,
                991122288,
                999779603,
                38245123,
                98964443,
                98025998,
                99776827,
                988587728,
                920809731,
                99275727,
                999753969,
                992542267,
                991188068,
                984901926,
                991385000,
                92822328,
                991036553,
                991036553,
                91521239,
                91292232,
                991006036,
                991255121,
                996782985,
                999290481,
                991949411,
                992492795,
                999239895,
                999963625,
                996675622,
                999617296,
                984040002,
                999699012,
                991624566,
                991904272,
                988331172,
                999937142,
                91001475,
                999668032,
                98075906,
                999328446,
                99240458,
                994368844,
                991635814,
                991635814,
                988112466,
                988112466,
                991564665,
                996670582,
                996664425,
                984064692,
                996853214,
                992932284,
                996597326,
                999443742,
                98052883,
                91066014,
                999981632,
                999229015,
                999138409,
                989465656,
                996623041,
                996623041,
                999689661,
                999937382,
                999192997,
                997819396,
                991555577,
                999165209,
                996810995,
                338966544,
                991032646,
                988874496,
                996963611,
                999246736,
                97916965,
                998151361,
                9990,
                999923007,
                996939233,
                998950898,
                991984007,
                991998084,
                998021516,
                998021516,
                858954564,
                999588927,
                996535672,
                999956118,
                996969614,
                999932750,
                998969617,
                999318792,
                999318792,
                999756674,
                996981454,
                999807444,
                952052815,
                952052815,
                999862020,
                999671646,
                999166447,
                992248168,
                991209199,
                996692975,
                991094543,
                991094543,
                998081234,
                991853415,
                991744509,
                991701004,
                991701004,
                91914576,
                992288017,
                999609701,
                996545822,
                960422424,
                988655866,
                91527067,
                96979892,
                988476055,
                987004688,
                996692411,
                992837777,
                96329642,
                98081488,
                998181548,
                999294665,
                998078744,
                32584544,
                99302699,
                988550723,
                988298062,
                992131953,
                991940601,
                99612383,
                988858808,
                991076844,
                991955447,
                999751443,
                91664796,
                996929880,
                999176706,
                992198788,
                996391997,
                982058778,
                982058778,
                977197768,
                999110293,
                991289732,
                992502000,
                991790343,
                988471665,
                999460853,
                972822575,
                991502234,
                924951212,
                989548498,
                991761977,
                999857496,
                991162066,
                992465854,
                992456754,
                991320267,
                988066293,
                999039500,
                999039500,
                996775607,
                999629654,
                988249126,
                988249126,
                991291544,
                998000404,
                988526331,
                988250302,
                991032121,
                999076585,
                98140256,
                988470105,
                999232663,
                985500000,
                999158072,
                996389004,
                999244991,
                996312777,
                984145723,
                988089529,
                992391907,
                996906737,
                999180172,
                999250644,
                998252000,
                999397522,
                991442901,
                984214436,
                38213535,
                991460568,
                988759479,
                991548917,
                996351526,
                988816360,
                996682607,
                997885260,
                998309755,
                38234318,
                999674041,
                993109616,
                92335592,
                996901912,
                996901912,
                999569080,
                999556568,
                992399005,
                991229921,
                991434338,
                992376857,
                992376857,
                984191390,
                999264128,
                999910181,
                991007935,
                987000000,
                991386992,
                991619069,
                998328353,
                999763752,
                999277173,
                997806255,
                999753690,
                999757670,
                999643152,
                999890055,
                998284573,
                998103006,
                988445815,
                988445815,
                998196466,
                992111464,
                993202774,
                998013013,
                38213424,
                999371649,
                989974577,
                989974577,
                999757109,
                999757109,
                38222453,
                991540800,
                999752709,
                99988351,
                965241111,
                992529858,
                382456236,
                382456236,
                996521478,
                991950688,
                999807007,
                991068623,
                992228305,
                996587482,
                988089529,
                999812060,
                999757694,
                988160800,
                998673613,
                998673613,
                988197652,
                998395172,
                38218263,
                999752423,
                992712035,
                991458711,
                999431086,
                333226655,
                992355514,
                992130678,
                999794701,
                98585985,
                992549294,
                992113792,
                992164378,
                992478226,
                999024745,
                999990201,
                999397644,
                981523620,
                991653129,
                996578312,
                982231718,
                982231718,
                38217788,
                99999999,
                998276868,
                984030097,
                999755205,
                988375090,
                996710141,
                91675821,
                325669899,
                999904344,
                992305673,
                991658948,
                991478844,
                99220466,
                992133020,
                996634081,
                92063803,
                998323572,
                993120246,
                96284754,
                991190598,
                992428882,
                992428882,
                991496011,
                996587522,
                996909064,
                996362636,
                996533913,
                991288345,
                991790052,
                988165955,
                998970445,
                99759753,
                993094000,
                988784683,
                991285846,
                996631407,
                999170165,
                998405078,
                99682826,
                999140702,
                32636969,
                992367075,
                84437270,
                98980863,
                999759269,
                984513461,
                996476226,
                999381820,
                988103210,
                996833883,
                996997660,
                996997660,
                999180266,
                995464556,
                999647648,
                998932117,
                992170581,
                983814100,
                983814100,
                996312777,
                992195552,
                991940101,
                996853251,
                996411034,
                92169443,
                991276339,
                991984322
                ));

        return integers;
    }

//    public static void main(String[] args) {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            JSONObject jsonObject = new JSONObject(getjson());
//            Object o = jsonObject.get("Time Series (Daily)");
//            String replace = o.toString()
//                    .replace("1. open", "open")
//                    .replace("2. high", "high")
//                    .replace("3. low", "low")
//                    .replace("4. close", "close")
//                    .replace("5. volume", "volume");
//
//            JSONObject o1 = new JSONObject(replace);
//
//            Object o2 = o1.get("2021-10-06");
//
//            System.out.println(o2.toString());
//
//            try {
//                StockTimeSeriesDailyDTO dto = objectMapper.readValue(o2.toString(), StockTimeSeriesDailyDTO.class);
//
//                System.out.println(dto);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(o.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }

    private static String getjson(){
        return "{\n" +
                "    \"Meta Data\": {\n" +
                "        \"1. Information\": \"Daily Prices (open, high, low, close) and Volumes\",\n" +
                "        \"2. Symbol\": \"PETR4.SA\",\n" +
                "        \"3. Last Refreshed\": \"2021-10-08\",\n" +
                "        \"4. Output Size\": \"Compact\",\n" +
                "        \"5. Time Zone\": \"US/Eastern\"\n" +
                "    },\n" +
                "    \"Time Series (Daily)\": {\n" +
                "        \"2021-10-08\": {\n" +
                "            \"1. open\": \"29.0000\",\n" +
                "            \"2. high\": \"29.6100\",\n" +
                "            \"3. low\": \"28.7100\",\n" +
                "            \"4. close\": \"29.1200\",\n" +
                "            \"5. volume\": \"83793900\"\n" +
                "        },\n" +
                "        \"2021-10-07\": {\n" +
                "            \"1. open\": \"28.7000\",\n" +
                "            \"2. high\": \"28.9800\",\n" +
                "            \"3. low\": \"28.2500\",\n" +
                "            \"4. close\": \"28.6000\",\n" +
                "            \"5. volume\": \"60190700\"\n" +
                "        },\n" +
                "        \"2021-10-06\": {\n" +
                "            \"1. open\": \"28.9500\",\n" +
                "            \"2. high\": \"29.1700\",\n" +
                "            \"3. low\": \"28.4700\",\n" +
                "            \"4. close\": \"28.6400\",\n" +
                "            \"5. volume\": \"84599400\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}
