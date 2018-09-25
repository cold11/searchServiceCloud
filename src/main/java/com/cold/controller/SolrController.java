package com.cold.controller;

import com.cold.entity.SearchEntity;
import com.cold.repository.SearchRepository;
import com.cold.solr.utils.CreateIndex;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: ohj
 * @Date: 2018/9/19 15:54
 * @Description:
 */
@Controller
@RequestMapping("/solr")
public class SolrController {
    @Autowired
    private CloudSolrClient cloudSolrClient;
    @Autowired
    private SearchRepository searchRepository;
    @RequestMapping("/addIndex")
    @ResponseBody
    public String addIndex() throws IOException, SolrServerException {
//        SearchEntity searchEntity1 = new SearchEntity();
//        searchEntity1.setId("1");
//        searchEntity1.setSource("测试1");
//        searchEntity1.setTrans("test1");
//
//        SearchEntity searchEntity2 = new SearchEntity();
//        searchEntity2.setId("2");
//        searchEntity2.setSource("测试2");
//        searchEntity2.setTrans("test2");
//
        cloudSolrClient.setDefaultCollection("zh_en");
        cloudSolrClient.connect();
        String basePath = "D:\\语料\\corpus\\zh-en";
        File srcFile = new File(basePath,"all.quchong-panduan.cn.quchong");
        File tgtFile = new File(basePath,"all.quchong-panduan.en.quchong");
//        cloudSolrClient.addBean(searchEntity1);
//        cloudSolrClient.addBean(searchEntity2);
        CreateIndex createIndex = new CreateIndex(cloudSolrClient);
        int numDocs = createIndex.createSolrIndex(srcFile,tgtFile);
        //cloudSolrClient.commit();
        return "success"+numDocs;
    }

    @RequestMapping("/delIndex")
    @ResponseBody
    public String delIndex(String id) throws IOException, SolrServerException {
        cloudSolrClient.setDefaultCollection("zh_jp");
        cloudSolrClient.connect();
        cloudSolrClient.deleteById(id);
        //cloudSolrClient.deleteByQuery("*:*");
        cloudSolrClient.commit();
        return "success";
    }

    @RequestMapping("/query")
    @ResponseBody
    public List query(String source) throws IOException, SolrServerException {
        List<SearchEntity> list = searchRepository.findByQueryAnnotation(source);
//        cloudSolrClient.setDefaultCollection("zh_jp");
//        cloudSolrClient.connect();
//        SolrQuery query = new SolrQuery();
//        query.setQuery(" source:"+source);
//        QueryResponse response = cloudSolrClient.query(query);
//        List<SearchEntity> list = response.getBeans(SearchEntity.class);
//        cloudSolrClient.commit();
        return list;
    }
}