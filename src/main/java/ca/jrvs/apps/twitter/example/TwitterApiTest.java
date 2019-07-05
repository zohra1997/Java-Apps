package ca.jrvs.apps.twitter.example;

import com.google.gdata.util.common.base.PercentEscaper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.util.Arrays;

public class TwitterApiTest {
    private static String ConsumerKey = System.getenv("ConsumerKey");
    private static String ConsumerSecret=System.getenv("ConsumerSecret");
    private static String AccessToken = System.getenv("AccessKey");
    private static String AccessSecret=System.getenv("AccessToken");
    public static void main(String[] args) throws Exception {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey,ConsumerSecret);
        consumer.setTokenWithSecret(AccessToken,AccessSecret);
        // Request
//        HttpGet request = new HttpGet("https://api.twitter.com/1.1/users/search.json?q=realDonaldTrump");
//        consumer.sign(request);
//        System.out.println("HTTP Header:");
//        Arrays.stream(request.getAllHeaders()).forEach(System.out::println);
//        HttpClient client = new DefaultHttpClient();
//        HttpResponse response = client.execute(request);
//        System.out.println(EntityUtils.toString(response.getEntity()));
//
        // Post
//        String myPost= "July 5th post";
//        PercentEscaper percentEscaper = new PercentEscaper("",false);
//        HttpPost post = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=" + percentEscaper.escape(myPost));
//        consumer.sign(post);
//        Arrays.stream(post.getAllHeaders()).forEach(System.out::println);
//        HttpClient client = new DefaultHttpClient();
//        HttpResponse response = client.execute(post);
//        System.out.println(EntityUtils.toString(response.getEntity()));


        //Delete
         String myId = "1147178071470084097";
        HttpPost delete = new HttpPost("https://api.twitter.com/1.1/statuses/destroy/"+ myId +".json");
        consumer.sign(delete);
        Arrays.stream(delete.getAllHeaders()).forEach(System.out::println);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(delete);
       System.out.println(EntityUtils.toString(response.getEntity()));

    }
}
