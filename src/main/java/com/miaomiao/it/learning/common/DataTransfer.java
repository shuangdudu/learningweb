package com.miaomiao.it.learning.common;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xiaoshuang
 * 金额转繁体
 */
public class DataTransfer {
	public static String numTransFanTi(String amount){
		//定义转换后的单位
		String[] strChnUnit = {"","","點","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","万","拾","佰","仟"};
		//定义转换后的数字
		String[] strChnNumber = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		BigDecimal bdAmout = new BigDecimal(amount);
		String strChnCur = "";//返回字符串
		if(bdAmout.doubleValue()==0){
			return "";
		}
		int iMod = 0;
		int iIndex = 0;
		long iAmount = 0;
		int iOne = 0;
		boolean bZero = true;
		double dAmountNum = Math.round(bdAmout.doubleValue()*100);
		dAmountNum = Math.abs(dAmountNum);
		iAmount = (long) dAmountNum; //取小数点后两位并转换为整数
		if(iAmount<=99 && iAmount>0){
			iMod = (int) (iAmount%10);
			iOne = (int) (iAmount/10);
			if(iMod != 0){
				strChnCur = "零點"+strChnNumber[iOne]+strChnNumber[iMod];
			}
			if(iMod == 0){
				strChnCur = "零點"+strChnNumber[iOne];
			}
			return strChnCur;
		}
		while(iAmount>0){
			iMod = (int) (iAmount%10);
			if(iMod > 0){
				if(iIndex == 2 && StringUtils.isEmpty(strChnCur)){
					strChnCur = strChnNumber[iMod];
				}else{
					strChnCur = strChnNumber[iMod] + strChnUnit[iIndex]+strChnCur;
				}
				bZero = false;
			}else{
				if(iIndex == 2){
					if(iAmount > 0){
						if(!StringUtils.isEmpty(strChnCur)){
							strChnCur = strChnUnit[iIndex]+strChnCur;
						}
						bZero = true;
					}
				}else if(iIndex == 6 || iIndex == 10 || iIndex == 14){
					if(iAmount/10 >0){//对含千，万零X的处理
						strChnCur = strChnUnit[iIndex] + strChnCur;
						bZero = true;
					}
				}
				if(!bZero){
					strChnCur = strChnNumber[0]+strChnCur;}
					bZero = true;
			}
				iAmount = iAmount / 10;
				iIndex++;
				if((iIndex == 2) && (strChnCur.length() == 0)){
					strChnCur = strChnCur + "";
				
			}
		}
		return strChnCur;
	}
	public static void main(String[] args) {
		System.out.println(numTransFanTi("1100.02"));
	}
}
