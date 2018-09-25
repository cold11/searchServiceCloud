package com.cold.solr.utils;

import com.cold.entity.SearchEntity;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ohj
 * @Date: 2018/9/20 08:24
 * @Description:
 */
public class CreateIndex {
    private CloudSolrClient cloudSolrClient;

    public CreateIndex(CloudSolrClient cloudSolrClient) {
        this.cloudSolrClient = cloudSolrClient;
    }

    public int createSolrIndex(File srcFile, File tgtFile) throws IOException, SolrServerException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"UTF-8"),10*1024*1024);
        fis = new BufferedInputStream(new FileInputStream(tgtFile));
        BufferedReader tgtReader = new BufferedReader(new InputStreamReader(fis,"UTF-8"),10*1024*1024);
        String line = "";
        int i = 0;
        List<SearchEntity> list = new ArrayList<>();
        while((line = reader.readLine()) != null){
            ++i;
            if(i>1000000)break;
            String tgtLine = tgtReader.readLine();
            SearchEntity searchEntity = new SearchEntity();
            searchEntity.setSource(line);
            searchEntity.setTrans(tgtLine);
            searchEntity.setId(i+"");
            list.add(searchEntity);
            if(i%100000==0){
                System.out.println(i+">>>"+line);
                cloudSolrClient.addBeans(list,1000);
                cloudSolrClient.commit();
                list = new ArrayList<>();
            }

        }
        fis.close();
        reader.close();
        tgtReader.close();
        if(!list.isEmpty()){
            cloudSolrClient.addBeans(list,1000);
            cloudSolrClient.commit();
        }
        return i;
    }
}