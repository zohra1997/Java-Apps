package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceImpTestMockito {
    @InjectMocks
    private TwitterServiceImp service;
     @Mock
     private CrdRepository mockDao;
     @Test
    public void postTweet() {
         Tweet mockTweet = new Tweet();
         mockTweet.setText("this is a mock tweet");
         when (mockDao.create(any())).thenReturn(mockTweet);
         service.postTweet("some Tweet", 0.0 , 0.0);
         try {
             service.postTweet("", 0.0 , 0.0);
            fail();
         }catch (IllegalArgumentException e){
             e.getStackTrace();
         }
    }
}