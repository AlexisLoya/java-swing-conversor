package com.alura.type.currency;

import com.alura.type.currency.utils.CurrencySlugs;
import com.alura.type.currency.utils.CurrencyTypes;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Coin {

    private String APIKEY = "qXJtCp1WaTZMKKtIiDouD10hCL4MIgdC";

    public class ExchangeRatesResponse {
        Map<String, Double> rates;
    }

    public Map<String, Double> updateCurrencyRates() throws Exception {
        Map<String, Double> currencyRates = new HashMap<>();
        String apiUrl = "https://api.apilayer.com/exchangerates_data/latest?symbols=GBP,MXN,EUR,JPY&base=USD";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // add api key to header
        connection.setRequestProperty("apikey", APIKEY);

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Parse JSON
            Gson gson = new Gson();
            ExchangeRatesResponse response = gson.fromJson(content.toString(), ExchangeRatesResponse.class);

            currencyRates.put(CurrencyTypes.DOLLAR.name(), 1.0);
            currencyRates.put(CurrencyTypes.MEXICAN_PESO.name(), response.rates.get(CurrencySlugs.MXN.name()));
            currencyRates.put(CurrencyTypes.BRITISH_POUND.name(), response.rates.get(CurrencySlugs.GBP.name()));
            currencyRates.put(CurrencyTypes.EURO.name(), response.rates.get(CurrencySlugs.EUR.name()));
            currencyRates.put(CurrencyTypes.YEN.name(), response.rates.get(CurrencySlugs.JPY.name()));
            // print result
            System.out.println(content.toString());
            // for each key in the map
            for (String key : currencyRates.keySet()) {
                // print the key and value
                System.out.println("Key: " + key + " Value: " + currencyRates.get(key));
            }
            return currencyRates;
        } else {
            throw new Exception("Error fetching currency rates");
        }

    }
    public double convertCurrency(double value, Map<String, Double> currencyRates, int fromUnit, int toUnit) {
        CurrencyTypes fromCurrency = CurrencyTypes.values()[fromUnit];
        CurrencyTypes toCurrency = CurrencyTypes.values()[toUnit];

        Double fromRate = currencyRates.get(fromCurrency.name());
        Double toRate = currencyRates.get(toCurrency.name());

        if (fromRate == null || toRate == null) {
            throw new IllegalStateException("Currency rates not initialized properly");
        }

        return value * (toRate / fromRate);
    }

}
