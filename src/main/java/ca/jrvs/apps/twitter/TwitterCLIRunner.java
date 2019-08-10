package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwitterCLIRunner {

    private TwitterService service;
    @Autowired
    public TwitterCLIRunner(TwitterService service) {
        this.service = service;
    }
    public void run(String[] args) {
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
        if (argument.equals("delete")) {
            String tweetIds = args[1];
            String[] ids = tweetIds.split(" ");
            service.deleteTweet(ids);
        }
    }
}