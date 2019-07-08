package ca.jrvs.apps.twitter.dao;

import java.io.IOException;

public interface CrdRespiratory <T, ID>{
    T save (T entity);
    T FindByID (ID id) ;
    T deleteByID (ID id);
}
