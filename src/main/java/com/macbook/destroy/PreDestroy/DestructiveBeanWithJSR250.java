package com.macbook.destroy.PreDestroy;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithJSR250{
	private File file;
	private String filePath;
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception{
		System.out.println("Initializing bean");
		
		if (filePath == null){
			throw new IllegalArgumentException("Specify file path");
		}
		
		this.file = new File(filePath);
		this.file.createNewFile();
		System.out.println("File exists: " + file.exists());
		System.out.println(file.getAbsolutePath());
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Destroy bean");
		
		if (!file.delete()){
			System.err.println("ERROR: failed to delete file. ");
		}
		
		System.out.println("File exists: " + file.exists());
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-destructAnnPreDestroy.xml");
		ctx.registerShutdownHook();
		//analog
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			@Override
//			public void run() {
//			}
//		});
		
		ctx.refresh();
		
		DestructiveBeanWithJSR250 bean = ctx.getBean("destructiveBean", DestructiveBeanWithJSR250.class);
	}
}
