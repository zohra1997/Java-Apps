package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dao.TwitterResstDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;

public class TwitterCLIApp {

    public static void main(String[] args) {
        //Create components
        HttpHelper httpHelper = new ApacheHttpHelper();
        CrdRepository dao = new TwitterResstDao(httpHelper);
        TwitterService service = new TwitterServiceImp(dao);

        //Create Runner
        TwitterCLIRunner runner = new TwitterCLIRunner(service);

        //Run Application
        runner.run(args);
    }
}
