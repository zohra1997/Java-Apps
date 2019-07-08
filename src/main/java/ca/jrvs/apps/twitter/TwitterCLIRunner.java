package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.service.TwitterServiceImp;

public class TwitterCLIRunner {
    public static void main(String[] args) {
        if (args.length<2){
            throw new RuntimeException("Enter Valid Arguments");
        }
        TwitterServiceImp twitterServiceImp = new TwitterServiceImp();
        System.out.println("USage: show|Delete|post");
        String  argument = args[0].toLowerCase();
        if (argument.equals("show")){
            twitterServiceImp.showTweet(args[1], null);


        }


    }
}
