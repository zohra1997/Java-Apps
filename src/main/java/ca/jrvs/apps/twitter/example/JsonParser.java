package ca.jrvs.apps.twitter.example;

import ca.jrvs.apps.twitter.example.dto.Company;
import ca.jrvs.apps.twitter.example.dto.Financial;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private static String company = "";

    /**
     * Convert a java object to JSON string
     * @param object input object
     * @return JSON String
     * @throws JsonProcessingException
     */
    public static String toJson(Object object, boolean prettyJson, boolean includeNullValues) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
       return mapper.writeValueAsString(object);

    }


    /**
     * Parse JSON string to a object
     * @param json JSON str
     * @param clazz object class
     * @param <T> Type
     * @return Object
     * @throws IOException
     */
    public static <T> T toObjectFromJson(String json, Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return  (T) mapper.readValue(json,clazz);

    }

    public static void main(String[] args) throws JsonProcessingException {
       Company company = new Company();
       company.setCompanyName("Jarvis Consulting");
       company.setDescription("pretty awesome!");
       Financial financial = new Financial();
       financial.setCostOfRevenue(100000);
       List<Financial> myList = new ArrayList<>();
       myList.add(financial);
       company.setFinancials(myList);
       System.out.println(toJson(company, true, true));



    }
}
