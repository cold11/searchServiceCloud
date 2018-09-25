package com.cold.repository;

import com.cold.entity.SearchEntity;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * @Auther: ohj
 * @Date: 2018/9/19 15:23
 * @Description:
 */
public interface SearchRepository extends SolrCrudRepository<SearchEntity, String> {
    /**
     * 通过标题查询
     *
     * @param source
     * @return
     */
    @Query(" source:*?0* ")
    public List<SearchEntity> findByQueryAnnotation(String source);
}
