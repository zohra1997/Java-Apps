package ca.jrvs.apps.twitter.dao;

public interface CrdRepository<T, ID>{
    /**
     *
     * @param entity
     * @return http response converted in object T format
     */
    T create(T entity);

    /**
     *
     * @param id
     * @return http response in object T format
     */
    T FindByID (ID id) ;

    /**
     *
     * @param id
     * @return http reponse in object T format
     */
    T deleteByID (ID id);
}
