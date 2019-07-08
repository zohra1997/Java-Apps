package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRespiratory;
import ca.jrvs.apps.twitter.dao.TwitterResstDao;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;

import java.util.Arrays;


public class TwitterServiceImp  implements  TwitterService{
    public static int LAT_MIN = -90;
    public static int LAT_MAX =  90;
    public static int LONG_MIN = -180;
    public static int LONG_MAX = 180;
   private CrdRespiratory TwitterDao;

   public TwitterServiceImp (CrdRespiratory TwitterDao){
       this.TwitterDao=TwitterDao;
   }

    @Override
    public void postTweet(String text, Double latitude, Double longitude) {
        tweetPostCheck(text, latitude, longitude);
        Tweet tweet = new Tweet();
        tweet.setText(text);
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(Arrays.asList(latitude,longitude));
        tweet.setCoordinates(coordinates);
        TwitterDao.save(tweet);

    }

    @Override
    public void showTweet(String id, String[] field) {
   if (!(IdCheck(id))){
      throw new RuntimeException("Please Enter a valid ID:");
   }
     Tweet tweet = (Tweet) TwitterDao.FindByID(id);
        System.out.println(tweet);
    }

    @Override
    public void deleteTweet(String[] ids) {

    }

    protected static  Boolean IdCheck(String Id){
        char [] characters = Id.toCharArray();
        for (char c: characters){
            if(((c>='A'&& c <='Z')|| ((c>='a' && c <='z')))){

                return false;
            }

        }

        return true;
    }

    protected static void tweetPostCheck (String text, Double latitude, Double longitude){
        char [] characters = text.toCharArray();
        if (characters.length>150){
            throw new IllegalArgumentException("Can not Post more than 150 characters");
        }
        if (latitude>=LAT_MAX || latitude<=LAT_MIN){
            throw new IllegalArgumentException("Ltitude should be between [-90 90]");

        }
        if (longitude>=LONG_MAX || longitude<= LONG_MIN){

            throw new IllegalArgumentException("Logitude should be between [-180 180]");
        }


    }
}
