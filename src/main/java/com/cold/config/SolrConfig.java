package com.cold.config;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * @Auther: ohj
 * @Date: 2018/9/18 16:26
 * @Description:
 */
@Configuration
@EnableSolrRepositories(basePackages = {"com.cold.repository"})
public class SolrConfig {
    @Value("${spring.data.solr.zk-host}")
    private String zkHost;

    @Bean
    public CloudSolrClient solrClient() {
        return new CloudSolrClient.Builder().withZkHost(zkHost).build();
    }

    @Bean
    public SolrTemplate solrTemplate(CloudSolrClient solrClient)  {
        return new SolrTemplate(solrClient);
    }
}