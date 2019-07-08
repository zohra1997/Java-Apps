package ca.jrvs.apps.twitter.service;

public interface TwitterService {
    void postTweet(String text, Double latitude, Double longitude);
    void showTweet (String id, String [] field);
    void deleteTweet (String [] ids);
}
