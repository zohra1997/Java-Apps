package ca.jrvs.apps.twitter.example;

import ca.jrvs.apps.twitter.example.dto.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JsonParser {

    private static String description = "{\n" +
            "   \"symbol\":\"AAPL\",\n" +
            "   \"companyName\":\"Apple Inc.\",\n" +
            "   \"exchange\":\"Nasdaq Global Select\",\n" +
            "   \"description\":\"Apple Inc is designs, manufactures and markets mobile communication and media devices and personal computers, and sells a variety of related software, services, accessories, networking solutions and third-party digital content and applications.\",\n" +
            "   \"CEO\":\"Timothy D. Cook\",\n" +
            "   \"sector\":\"Technology\",\n" +
            "   \"financials\":[\n" +
            "      {\n" +
            "         \"reportDate\":\"2018-12-31\",\n" +
            "         \"grossProfit\":32031000000,\n" +
            "         \"costOfRevenue\":52279000000,\n" +
            "         \"operatingRevenue\":84310000000,\n" +
            "         \"totalRevenue\":84310000000,\n" +
            "         \"operatingIncome\":23346000000,\n" +
            "         \"netIncome\":19965000000\n" +
            "      },\n" +
            "      {\n" +
            "         \"reportDate\":\"2018-09-30\",\n" +
            "         \"grossProfit\":24084000000,\n" +
            "         \"costOfRevenue\":38816000000,\n" +
            "         \"operatingRevenue\":62900000000,\n" +
            "         \"totalRevenue\":62900000000,\n" +
            "         \"operatingIncome\":16118000000,\n" +
            "         \"netIncome\":14125000000\n" +
            "      }\n" +
            "   ],\n" +
            "   \"dividends\":[\n" +
            "      {\n" +
            "         \"exDate\":\"2018-02-09\",\n" +
            "         \"paymentDate\":\"2018-02-15\",\n" +
            "         \"recordDate\":\"2018-02-12\",\n" +
            "         \"declaredDate\":\"2018-02-01\",\n" +
            "         \"amount\":0.63\n" +
            "      },\n" +
            "      {\n" +
            "         \"exDate\":\"2017-11-10\",\n" +
            "         \"paymentDate\":\"2017-11-16\",\n" +
            "         \"recordDate\":\"2017-11-13\",\n" +
            "         \"declaredDate\":\"2017-11-02\",\n" +
            "         \"amount\":0.63\n" +
            "      }\n" +
            "   ]\n" +
            "}";

    /**
     * Convert a java object to JSON string
     *
     * @param object input object
     * @return JSON String
     * @throws JsonProcessingException
     */
    public static String toJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);

    }


    /**
     * Parse JSON string to a object
     *
     * @param json  JSON str
     * @param clazz object class
     * @param <T>   Type
     * @return Object
     * @throws IOException
     */
    public static <T> T toObjectFromJson(String json, Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (T) mapper.readValue(json, clazz);

    }

    public static void main(String[] args) throws IOException {
        Company company = null;
        company = toObjectFromJson(description, Company.class);
        System.out.println(toJson(company));


    }
}
