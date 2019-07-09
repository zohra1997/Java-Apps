package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIRunner;
import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dao.TwitterResstDao;
import ca.jrvs.apps.twitter.dao.helper.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TwitterCliBean {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TwitterCliBean.class);
        TwitterCLIRunner runner = context.getBean(TwitterCLIRunner.class);
        runner.run(args);
    }

    @Bean
    public TwitterCLIRunner twitterCLIRunner (TwitterService service){
        return new TwitterCLIRunner(service);
    }

    @Bean
    public TwitterService twitterService (CrdRepository dao ){
        return new TwitterServiceImp(dao) ;
    }
    @Bean
    public CrdRepository crdRepository (HttpHelper helper ){
        return new TwitterResstDao(helper);
    }

    @Bean
    HttpHelper helper (){
        return new ApacheHttpHelper();
    }
}

