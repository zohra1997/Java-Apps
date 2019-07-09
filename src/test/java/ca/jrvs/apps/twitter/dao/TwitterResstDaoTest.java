package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TwitterResstDaoTest {

    @Test
    public void save() {
       String TweetText = "this is a test tweet"+System.currentTimeMillis();
       Tweet ExpectedTweet = new Tweet();
        ExpectedTweet.setText(TweetText);
       Coordinates coordinates = new Coordinates();
       List<Double> myList = new ArrayList<>();
       myList.add(45.0);
       myList.add(89.0);
       coordinates.setCoordinates(myList);
        ExpectedTweet.setCoordinates(coordinates);
        System.out.println(ExpectedTweet);
       HttpHelper helper = new ApacheHttpHelper();
       TwitterResstDao dao = new TwitterResstDao(helper);
       Tweet actualTweet = dao.save(ExpectedTweet);
       assertNotNull(actualTweet);
       assertEquals(ExpectedTweet.getText(),actualTweet.getText());
    }

    @Test
    public void findByID() {
    }

    @Test
    public void deleteByID() {
    }
}