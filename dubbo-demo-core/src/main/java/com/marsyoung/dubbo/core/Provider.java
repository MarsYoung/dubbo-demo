package com.marsyoung.dubbo.core;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Provider {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext appContext=new ClassPathXmlApplicationContext(new String[]{"spring/spring.xml"});
		appContext.start();
		System.in.read();
	}
	
}
