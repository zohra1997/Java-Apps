package ca.jrvs.apps.twitter.service;

public interface TwitterService {
    /**
     *
     * @param text
     * @param latitude
     * @param longitude
     * this methods creates a tweet object and passes it to Dao layer
     *
     */
    void postTweet(String text, Double latitude, Double longitude);

    /**
     *
     * @param id
     * @param field
     * This method accepts tweet Id from user and returns specific entities regarding that tweet
     *
     */
    void showTweet (String id, String [] field);

    /**
     *
     * @param ids
     * this method deletes tweets with the given ids
     */
    void deleteTweet (String [] ids);
}
