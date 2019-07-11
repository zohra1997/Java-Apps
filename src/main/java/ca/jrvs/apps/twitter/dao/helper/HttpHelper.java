package ca.jrvs.apps.twitter.dao.helper;

import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.net.URI;

public interface HttpHelper {
    /**
     *
     * @param uri
     * @return HttpResponse
     * this methods accepts a url to post a tweet and returns the http response
     */
    HttpResponse httpPost(URI uri);

    /**
     *
     * @param uri
     * @param stringEntity
     * @return http response
     * this method accepts a url to post a tweet and return the specified http response entities
     */
    HttpResponse httpPost(URI uri, StringEntity stringEntity);

    /**
     *
     * @param uri
     * @return Http response
     * this methid returns the http response to a show tweet request
     */
    HttpResponse httpGet(URI uri);

}
