package com.miaomiao.it.learning.common;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import com.miaomiao.it.learning.entity.Emp;

public class ClassUtil {
	public static void listPropertyNames(Class c){
		PropertyDescriptor[] pd;
		try {
			pd = Introspector.getBeanInfo(c).getPropertyDescriptors();
			for(int i=0;i<pd.length;i++){
				System.out.println(pd[i].getName()+"("+pd[i].getPropertyType().getName()+")");
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		listPropertyNames(Emp.class);
	}
}
