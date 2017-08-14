package com.macbook.destroy.destroyMethod;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean implements InitializingBean {
	private File file;
	private String filePath;
	
	@Override
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
		ctx.load("META-INF/spring/app-destroyMethod.xml");
		ctx.refresh();
		
		DestructiveBean bean = ctx.getBean("destructiveBean", DestructiveBean.class);
		System.out.println("Calling destroy");
		ctx.destroy();
		System.out.println("Called destroy");
	}
}
