package com.amaranth10.cr.util;

import klago.log.service.KlagoLog;
import klago.log.utils.RequestInfo;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.SqlSession;

import java.util.*;


/**
 * SQL 쿼리 관련 객체입니다. 쿼리를 조회할때 사용됩니다.
 * 
 * @author
 *
 */
public class QueryManager {
	
	/**
	 * sqlSession의 맵핑되어있는 쿼리 아이디 리스트를 반환하는 메소드
	 * @param sqlSession
	 * @return
	 */
	public static List<String> getQueryIdList(SqlSession sqlSession){
		List<String> queryList = new ArrayList<String>();
		Collection<String> coll = sqlSession.getConfiguration().getMappedStatementNames();
		Iterator<String> iter = coll.iterator();

		while(iter.hasNext()){
			String id = iter.next();
			queryList.add(id);
		}
		
		return queryList;
	}
	
	/**
	 * 쿼리 아이디, 파라미터 정보를 사용하여 완성된 쿼리를 반환하는 메소드
	 * @param sqlSession
	 * @param queryId
	 * @param paramMap
	 * @return
	 */
	public static String getQueryString(RequestInfo requestInfo, SqlSession sqlSession, String queryId, Map<String, Object> paramMap) {
		KlagoLog.logSql(requestInfo, (HashMap<String, Object>) paramMap, "쿼리를 찾는 로그입니다.");
		String sql = "";
		try {
			BoundSql bSql = sqlSession.getConfiguration().getMappedStatement(queryId).getBoundSql(paramMap);
			MetaObject metaObject = sqlSession.getConfiguration().newMetaObject(paramMap);
			sql = bSql.getSql();
			Object pObj = bSql.getParameterObject();
			if (pObj != null) {
				List<ParameterMapping> paramMapping = bSql.getParameterMappings();
				for (ParameterMapping mapping : paramMapping) {
					String prop = mapping.getProperty();

					Object o = metaObject.getValue(prop);
					if (o == null)
						o = bSql.getAdditionalParameter(prop);

					if (o == null)
						sql = sql.replaceFirst("\\?", "''");
					else if (o instanceof String)
						sql = sql.replaceFirst("\\?", "'" + o + "'");
					else
						sql = sql.replaceFirst("\\?", o + "");
				}
			}
		} catch (Exception e) {
			KlagoLog.logError(requestInfo, "print err....." + e.toString());
			return null;
		}		

		return sql;
	}
}
