package com.cz.extern;

import com.cz.testExtern.Test4;

public class MyObj extends Test4{

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public void name() throws CloneNotSupportedException {
		this.clone();//protected 方法自己 访问
	}
}
