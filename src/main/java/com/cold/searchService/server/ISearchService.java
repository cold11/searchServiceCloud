package com.cold.searchService.server;



import com.cold.searchService.parameter.SearchResult;
import com.cold.searchService.parameter.SearcherParameter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by ohj on 2016/8/2.
 */
@WebService(targetNamespace="http://server.searchService.cold.com/")
public interface ISearchService {

    @WebMethod
    public SearchResult search(@WebParam(name = "parameter") SearcherParameter parameter);
}
