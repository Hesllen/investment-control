package br.com.investmentcontrol.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockTimeSeriesDailyDTO {

    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal dividendAmount;
    private BigDecimal adjustedClose;
    private Integer splitCoefficient;

    public static String getLastDate(JSONObject jsonObject){
        String last = null;
        try {
            JSONObject meta_data = jsonObject.getJSONObject("Meta Data");
             last = meta_data.get("3. Last Refreshed").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return last;
    }

    public static String getLastStockPriceUpdated(String jsonToConvert) {
        String result = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonToConvert);
            String lastDate = getLastDate(jsonObject);

            Object o = jsonObject.get("Time Series (Daily)");

            String daily = getDaily(o.toString(), lastDate);

        result = daily.toString()
                .replace("1. open", "open")
                .replace("2. high", "high")
                .replace("3. low", "low")
                .replace("4. close", "close")
                .replace("5. adjusted close", "adjustedClose")
                .replace("6. volume", "volume")
                .replace("7. dividend amount", "dividendAmount")
                .replace("8. split coefficient", "splitCoefficient");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String getDaily(String jsonDaily, String lastDate) {
        String daily = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonDaily);
             daily = jsonObject.get(lastDate).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return daily;
    }

}


