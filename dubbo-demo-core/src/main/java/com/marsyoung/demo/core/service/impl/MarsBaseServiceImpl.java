package com.marsyoung.demo.core.service.impl;

import com.marsyoung.demo.core.constants.DubboDemoConstans;
import com.marsyoung.dubbo.api.service.MarsBaseService;

public class MarsBaseServiceImpl implements MarsBaseService{

	public void sayHello() {
		System.out.println(DubboDemoConstans.HELLO);
	}

}
