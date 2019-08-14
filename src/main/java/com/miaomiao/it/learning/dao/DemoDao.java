package com.miaomiao.it.learning.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.miaomiao.it.learning.entity.ProcedurePojo;





public interface DemoDao {
	public void count(ProcedurePojo pojo);
	public List<Map<String,Object>> findParameterValue(
			@Param("boqID")String boqID,
			@Param("moduleCodes")List<String>moduleCodes,
			@Param("productCodes")List<String>productCodes,
			@Param("parameterCode")String parameterCode,
			@Param("siteName")String siteName,
			@Param("dimensionProductTypeID")int dimensionProductTypeID,
			@Param("qtyTpye")int qtyTpye);
//	public List<BoqAuthInfoVO> findBoqAuthInfo(Map<String,Object> map);
//	public void insert(List<BoqAuthInfoVO>authInfoVOs);
//	public List<BoqInfoVO> findLeftOperatorList(String countryCode,Integer startIndex,Integer endIndex,String customerName);
//	public List<BoqInfoVo> findOperatorListByPage(String customerName,Integer startIndex,Integer endIndex,String countryCode);
//	public void copyBoq(Map<String,Object> map);
}
