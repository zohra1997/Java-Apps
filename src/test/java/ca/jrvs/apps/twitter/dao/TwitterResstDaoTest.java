package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TwitterResstDaoTest {
     private HttpHelper helper ;
     private TwitterResstDao dao ;
     private Tweet expectedTweet = new Tweet();
     private String id;

     @Before
     public void setup (){
         helper = new ApacheHttpHelper();
         dao = new TwitterResstDao(helper);
         String TweetText = "this is a test tweet"+System.currentTimeMillis();
         this.expectedTweet.setText(TweetText);
     }

    @Test
    public void save() {
       Coordinates coordinates = new Coordinates();
       List<Double> myList = new ArrayList<>();
       myList.add(45.0);
       myList.add(89.0);
       coordinates.setCoordinates(myList);
       expectedTweet.setCoordinates(coordinates);
       System.out.println(expectedTweet);
       Tweet actualTweet = dao.create(expectedTweet);
       assertNotNull(actualTweet);
       assertEquals(expectedTweet.getText(),actualTweet.getText());
       this.id = actualTweet.getIdStr();
       Tweet showTweet = dao.FindByID(this.id);
       assertEquals(actualTweet.getIdStr(), showTweet.getIdStr());
    }

    @After
    public void cleanup(){
         dao.deleteByID(this.id);
    }
}