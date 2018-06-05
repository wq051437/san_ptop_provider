package com.jk.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jk.model.PageModel;
import com.jk.service.SolrService;
import com.jk.model.QyManagerBean;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.solr.client.solrj.SolrClient;


import org.springframework.util.StringUtils;


@Service("solrService")
public class SolrServiceImpl implements SolrService {
	@Autowired
	private SolrClient httpSolrServer;


	public PageModel<QyManagerBean> getSolrList(PageModel pageModel, QyManagerBean productAndCate) throws Exception {

		//获取query 对象
		SolrQuery query = new SolrQuery();
		StringBuffer str = new StringBuffer();
		//设置查询关键字  职位名称
		String zhiweinames = productAndCate.getQyname();
		if (!StringUtils.isEmpty(productAndCate.getQyname())) {
			str.append("qyname:" + zhiweinames);
//			str.append("xingzhi:" + zhiweinames+" OR ");
//			str.append("xinzi:" + zhiweinames+" OR ");
//			str.append("city:" + zhiweinames+" OR ");
//			str.append("jingyan:" + zhiweinames+" OR ");
//			str.append("xueli:" + zhiweinames+" OR ");
//			str.append("xingzhi:" + zhiweinames+" OR ");
//			str.append("youhuo:" + zhiweinames+" OR ");
//			str.append("comname:" + zhiweinames+" OR ");
			query.set("q",str.toString());
		} else {
			query.set("q", "*:*");
			
		}
		//开始条数   开始页数
//		query.setStart(0);
		query.setStart(pageModel.getStart());
		//每页几条
		query.setRows(pageModel.getPageSize());
		// 开启高亮
		query.setHighlight(true);
		//query.setParam("hl", "true"); //highlighting    
		query.addHighlightField("qyname");
//		query.addHighlightField("comname");
//		query.addHighlightField("xinzi");
//		query.addHighlightField("city");
//		query.addHighlightField("xingzhi");
//		query.addHighlightField("jingyan");
//		query.addHighlightField("xueli");
//		query.addHighlightField("youhuo");

		query.setHighlightSimplePre("<font color='red'>"); // 高亮单词的前缀
		
		query.setHighlightSimplePost("</font>"); // 高亮单词的后缀
		
		
		query.setSort("qyid", ORDER.desc);
		// 发起请求,获取response  
		QueryResponse queryResponse = httpSolrServer.query(query);
		//根据QueryResponse 对象获取结果集
		SolrDocumentList results = queryResponse.getResults();
		//查询总条数
		long count = results.getNumFound();
		if(count!=0) {
			pageModel.setPageSum((int)count);
		}
		
		 Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		 
		 
		//新建一个list集合承载数据
		List<QyManagerBean> products = new ArrayList<QyManagerBean>();

		for (SolrDocument solrDocument : results) {
			QyManagerBean zhiweiLittle1 =new QyManagerBean();

			
			zhiweiLittle1.setQyid(Integer.valueOf(solrDocument.get("qyid").toString()));
			 
			 if (highlighting.get(solrDocument.get("qyid")) != null
					 && highlighting.get(solrDocument.get("qyid")).get("qyname") != null
					 ) {
	             //设置高亮
               String name = highlighting.get(solrDocument.get("qyid")).get("qyname").get(0);

               zhiweiLittle1.setQyname(name);
			 }else {
				  zhiweiLittle1.setQyname(solrDocument.get("qyname").toString());
			 }

           products.add(zhiweiLittle1);
		}
		pageModel.setPageList(products);
		return pageModel;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.SolrService#deletesolr(java.lang.String)    
	 */

	public void deletesolr(String id){
		try {
			
			httpSolrServer.deleteById("3");
			httpSolrServer.commit();
			
			
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.SolrService#addsolr(com.jk.model.ZhiweiLittle)    
	 */

	public void addsolr(QyManagerBean productAndCate) {
		SolrInputDocument doc =new SolrInputDocument();
		doc.addField("id", productAndCate.getQyid());
		doc.addField("comid", productAndCate.getQyname());
		try {
			httpSolrServer.add(doc);
			httpSolrServer.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
