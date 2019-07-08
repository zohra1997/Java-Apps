package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.CrdRespiratory;
import ca.jrvs.apps.twitter.dao.TwitterResstDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;

public class TwitterCLIRunner {
    public static void main(String[] args) {
        HttpHelper helper = new ApacheHttpHelper();
        CrdRespiratory dao = new TwitterResstDao(helper);
        TwitterServiceImp service = new TwitterServiceImp(dao);
        if (args.length<2){
            throw new RuntimeException("Enter Valid Arguments");
        }

        System.out.println("USage: show|Delete|post");
        String  argument = args[0].toLowerCase();
        if (argument.equals("show")){
            service.showTweet(args[1], null);


        }


    }
}
