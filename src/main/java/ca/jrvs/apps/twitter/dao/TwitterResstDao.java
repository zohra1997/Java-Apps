package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dto.Tweet;
import ca.jrvs.apps.twitter.example.JsonParser;
import com.google.gdata.util.common.base.PercentEscaper;
import com.sun.jndi.toolkit.url.Uri;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class TwitterResstDao implements CrdRespiratory <Tweet, String>  {

    public static String SearchUri="https://api.twitter.com/1.1/statuses/show.json?id=";
    public static String PostUri = "https://api.twitter.com/1.1/statuses/update.json?status=";
    @Override
    public Tweet save(Tweet entity) {
        String text = entity.getText();
        Double latitude = entity.getCoordinates().getCoordinates().get(0);
        Double longiyude = entity.getCoordinates().getCoordinates().get(1);
        PercentEscaper percentEscaper = new PercentEscaper("",false);
        String post = PostUri+percentEscaper.escape(text);
        URI uri = null;
        try {
            uri = new URI(post);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not Construct the URL.");
        }

        HttpResponse response = (new ApacheHttpHelper().httpPost(uri));
        CheckResponse(response, 200);
        return  ParseObject(response);

    }

    @Override
    public Tweet FindByID(String s) {
        String request = SearchUri + s;
        URI Uri = null;
        try {
            Uri = new URI(request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpResponse response = (new ApacheHttpHelper().httpGet(Uri));
        CheckResponse(response, 200);
        return ParseObject(response);

    }

    @Override
    public Tweet deleteByID(String s) {
        return null;
    }
   protected void CheckResponse (HttpResponse response, int expectedStatusCode){
        int status = response.getStatusLine().getStatusCode();
        if (status != expectedStatusCode){
            throw new RuntimeException("Not recognized HTTP response:"+status);
        }

   }

  protected Tweet ParseObject (HttpResponse response){
        String result;
      try {
          result = EntityUtils.toString(response.getEntity());
      } catch (IOException e) {
          throw new RuntimeException("could not convert HTTP response to a string");
      }
      Tweet tweet = null;
      try {
          tweet =(Tweet) JsonParser.toObjectFromJson(result, Tweet.class);
      } catch (IOException e) {
          throw new RuntimeException("Could not Parse the string to Tweet Object");
      }
      return tweet;

  }


}
