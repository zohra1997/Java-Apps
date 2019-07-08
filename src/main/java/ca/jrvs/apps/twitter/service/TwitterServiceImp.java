package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterResstDao;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;



public class TwitterServiceImp  implements  TwitterService{



    @Override
    public void postTweet(String text, Double latitude, Double longitude) {


    }

    @Override
    public void showTweet(String id, String[] field) {
   if (!(IdCheck(id))){
      throw new RuntimeException("Please Enter a valid ID:");
   }
     Tweet tweet = (new TwitterResstDao().FindByID(id));
        System.out.println(tweet);
    }

    @Override
    public void deleteTweet(String[] ids) {

    }

    public  Boolean IdCheck(String Id){
        char [] characters = Id.toCharArray();
        for (char c: characters){
            if(((c>='A'&& c <='Z')|| ((c>='a' && c <='z')))){

                return false;
            }

        }

        return true;
    }
}
