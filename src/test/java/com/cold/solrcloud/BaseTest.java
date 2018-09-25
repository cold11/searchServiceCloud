package com.cold.solrcloud;

/**
 * @Auther: ohj
 * @Date: 2018/9/19 15:27
 * @Description:
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)
public class BaseTest {
//
//    @Autowired
//    private SearchRepository searchRepository;
//
//    @Autowired
//    private CloudSolrClient cloudSolrClient;
//
////    @Autowired
////    private BaseSolr baseSolr;
//
////    /**
////     * 使用 searchRepository 方式新增
////     *
////     * @throws Exception
////     */
////    @Test
////    public void testAddYmqRepository() {
////
////        SearchEntity searchEntity1 = new SearchEntity();
////        searchEntity1.setId("1");
////        searchEntity1.setSource("测试1");
////        searchEntity1.setTrans("test1");
////
////        SearchEntity searchEntity2 = new SearchEntity();
////        searchEntity2.setSource("测试2");
////        searchEntity2.setTrans("test2");
////
////        searchRepository.save(searchEntity1);
////        searchRepository.save(searchEntity2);
////    }
//
//
//    /**
//     * 使用 cloudSolrClient 方式新增
//     *
//     * @throws Exception
//     */
//    @Test
//    public void testAddCloudSolrClient() throws IOException, SolrServerException {
//
//        SearchEntity searchEntity1 = new SearchEntity();
//        searchEntity1.setId("1");
//        searchEntity1.setSource("测试1");
//        searchEntity1.setTrans("test1");
//
//        SearchEntity searchEntity2 = new SearchEntity();
//        searchEntity2.setSource("测试2");
//        searchEntity2.setTrans("test2");
//
//        cloudSolrClient.setDefaultCollection("zh_en");
//        cloudSolrClient.connect();
//
//        cloudSolrClient.addBean(searchEntity1);
//        cloudSolrClient.addBean(searchEntity2);
//        cloudSolrClient.commit();
//    }
//
////    /**
////     * 删除数据
////     */
////    @Test
////    public void testDelete() {
////
////        SearchEntity searchEntity1 = new SearchEntity();
////        searchEntity1.setId("3");
////        searchEntity1.setSource("测试3");
////        searchEntity1.setTrans("test3");
////
////        // 添加一条测试数据，用于删除的测试数据
////        searchRepository.save(searchEntity1);
////        // 通过标题查询数据ID
////        List<SearchEntity> list = searchRepository.findByQueryAnnotation("delete_penglei");
////
////        for (SearchEntity searchEntity : list) {
////
////            System.out.println("查询响应 :" + searchEntity);
////
////            //通过主键 ID 删除
////            searchRepository.delete(searchEntity);
////        }
////
////    }
//
////    /**
////     * data JPA 方式查询
////     *
////     * @throws Exception
////     */
////    @Test
////    public void testYmqRepositorySearch() throws Exception {
////
////        List<Ymq> list = ymqRepository.findByQueryAnnotation("penglei");
////
////        for (Ymq item : list) {
////            System.out.println(" data JPA 方式查询响应 :" + JSONObject.toJSONString(item));
////        }
////    }
////
////    /**
////     * SolrQuery 语法查询
////     *
////     * @throws Exception
////     */
////    @Test
////    public void testYmqSolrQuery() throws Exception {
////
////        SolrQuery query = new SolrQuery();
////
////        String ymqTitle = "penglei";
////
////        query.setQuery(" ymqTitle:*" + ymqTitle + "* ");
////
////        cloudSolrClient.setDefaultCollection("test_collection");
////        cloudSolrClient.connect();
////        QueryResponse response = cloudSolrClient.query(query);
////
////        List<Ymq> list = response.getBeans(Ymq.class);
////
////        for (Ymq item : list) {
////            System.out.println("SolrQuery 语法查询响应 :" + JSONObject.toJSONString(item));
////        }
////    }
////
////    /**
////     * 使用 baseSolr 工具类 查询
////     *
////     * @throws Exception
////     */
////    @Test
////    public void testBaseSolrQuery() throws Exception {
////
////        SolrQuery query = new SolrQuery();
////
////        String ymqTitle = "penglei";
////        String defaultCollection = "test_collection";
////
////        query.setQuery(" ymqTitle:*" + ymqTitle + "* ");
////
////        List<Ymq> list = baseSolr.query(defaultCollection, Ymq.class, query);
////
////        for (Ymq item : list) {
////            System.out.println("baseSolr 工具类  查询响应 :" + JSONObject.toJSONString(item));
////        }
////    }
////
////    /**
////     * 使用 baseSolr 工具类 分页 查询
////     *
////     * @throws Exception
////     */
////    @Test
////    public void testBaseSolrPageInfoQuery() throws Exception {
////
////        SolrQuery query = new SolrQuery();
////
////        String ymqTitle = "penglei";
////        String defaultCollection = "test_collection";
////
////        query.setQuery(" ymqTitle:*" + ymqTitle + "* ");
////
////        PageInfo pageInfo = baseSolr.query(defaultCollection, Ymq.class, query,new RowBounds(0,2));
////
////        System.out.println("使用 baseSolr 工具类 分页 查询响应 :" + JSONObject.toJSONString(pageInfo));
////    }
}