package com.mlj.dangdang.util;

import java.math.BigDecimal;

public class BigdecimalUtil {

	public  static  double add(double a,double b){
		   BigDecimal aa = new BigDecimal(a+"");
		   BigDecimal bb = new BigDecimal(b+"");
		   BigDecimal result = aa.add(bb);
		  //把BigDecimal类型转化为double类型
		   return  result.doubleValue();
	}
	
	
}
