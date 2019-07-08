package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.CrdRespiratory;
import ca.jrvs.apps.twitter.dao.TwitterResstDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;

import java.util.Arrays;

public class TwitterCLIRunner {
    public static void main(String[] args) {
        HttpHelper helper = new ApacheHttpHelper();
        CrdRespiratory dao = new TwitterResstDao(helper);
        TwitterServiceImp service = new TwitterServiceImp(dao);
        if (args.length < 2) {
            throw new RuntimeException("Enter Valid Arguments");
        }

        System.out.println("USage: show|Delete|post");
        String argument = args[0].toLowerCase();
        if (argument.equals("show")) {
            service.showTweet(args[1], null);
        }
        if (argument.equals("post")) {
            String tweet_txt = args[1];
            Double lat = Double.parseDouble(args[2]);
            Double lon = Double.parseDouble(args[3]);
            service.postTweet(tweet_txt, lat, lon);
        }
        if (argument.equals("delete")){
            String tweetIds = args[1];
            String[] ids = tweetIds.split(" ");
            service.deleteTweet(ids);
        }

    }
}