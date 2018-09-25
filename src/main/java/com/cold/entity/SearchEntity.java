package com.cold.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @Auther: ohj
 * @Date: 2018/9/19 14:29
 * @Description:
 */
@SolrDocument
public class SearchEntity implements Serializable {

    @Id
    @Field
    private String id;
    @Field
    private String source;
    @Field
    private String trans;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    @Override
    public String toString() {
        return "SearchEntity{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", trans='" + trans + '\'' +
                '}';
    }
}