package com.cold.searchService.server;


import com.cold.entity.SearchEntity;
import com.cold.searchService.parameter.*;
import com.cold.util.Base64Utils;
import com.cold.util.CommonConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.jws.WebService;
import java.io.IOException;
import java.util.*;

/**
 * Created by ohj on 2016/8/2.
 */
@WebService(targetNamespace="http://server.searchService.cold.com/",endpointInterface = "com.cold.searchService.server.ISearchService")
@Component
public class SearchServiceImpl implements ISearchService {
    private static final Logger LOG = LoggerFactory.getLogger(SearchServiceImpl.class);
    @Autowired
    private CloudSolrClient cloudSolrClient;
    @Override
    public SearchResult search(SearcherParameter parameter) {
        //LOG.info(parameter);
        SearchResult searchResult = new SearchResult();
        ArrayList<Result> results = new ArrayList<Result>();
        searchResult.setResults(results);
        String source = parameter.getOriginalText();
        if(StringUtils.isEmpty(source))return searchResult;
        source = Base64Utils.decode(source).toLowerCase();
        if(StringUtils.isEmpty(source))return searchResult;
        source = source.replaceAll("\\<t\\d+/\\>","");
        //System.out.println(source);
        //String querySource = escape(source);
        LanguageOptions languageOptions = parameter.getLanguageOptions();
        LanguageOption sourceLan = languageOptions.getSource();
        LanguageOption targetLan = languageOptions.getTarget();
        String from = "";
        String collection = "zh_en";
        String srcField = CommonConstants.INDEX_SEARCH_NAME;
        //String tgtField = CommonConstants.INDEX_TRANS;
        int searchCount = parameter.getSearchCount();
        searchCount = searchCount<=0? CommonConstants.SEARCH_COUNT:searchCount;
        if(searchCount>200)searchCount=200;
        if(sourceLan==LanguageOption.EN&&targetLan==LanguageOption.ZH){
            from = "英译中";
            srcField = CommonConstants.INDEX_TRANS;
            //tgtField = CommonConstants.INDEX_SEARCH_NAME;
        }else if(sourceLan==LanguageOption.ZH&&targetLan==LanguageOption.EN){
            from = "中译英";

        }else if(sourceLan==LanguageOption.ZH&&targetLan==LanguageOption.JP){
            from = "中译日";
            collection = "zh_jp";
        }else if(sourceLan==LanguageOption.JP&&targetLan==LanguageOption.ZH){
            from = "日译中";
            srcField = CommonConstants.INDEX_TRANS;
            //tgtField = CommonConstants.INDEX_SEARCH_NAME;
            collection = "zh_jp";
        }
        SolrQuery query = new SolrQuery();
        query.setQuery(srcField+":" + source);
        query.setRows(searchCount);
        cloudSolrClient.connect();
        try {
            LOG.info(String.format("检索服务IFOX,来源:"+from+" %s\t%s\t%s\t%d", sourceLan,targetLan,srcField+":"+source,searchCount));
            QueryResponse response = cloudSolrClient.query(collection,query);
            List<SearchEntity> list = response.getBeans(SearchEntity.class);
            list.forEach(searchEntity -> {
                Result result = new Result();
                result.setSrc(searchEntity.getSource());
                result.setTgt(searchEntity.getTrans());
                results.add(result);
            });
        } catch (SolrServerException e) {
            LOG.error("检索"+source+"出现错误!",e);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("检索"+source+"出现错误!",e);
        }


        return searchResult;
    }

}
