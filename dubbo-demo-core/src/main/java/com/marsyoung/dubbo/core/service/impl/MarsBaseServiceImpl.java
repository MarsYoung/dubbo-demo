package com.marsyoung.dubbo.core.service.impl;

import org.springframework.stereotype.Service;

import com.marsyoung.dubbo.api.service.MarsBaseService;
import com.marsyoung.dubbo.core.constants.DubboDemoConstans;

@Service("marsBaseService")
public class MarsBaseServiceImpl implements MarsBaseService{

	public void sayHello() {
		System.out.println(DubboDemoConstans.HELLO);
	}

}
