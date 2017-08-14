package com.macbook.propertyEditor;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorBean {
	private byte[] bytes;
	private Class cls;
	private Boolean trueOrFalse;
	private List<String> stringList;
	private Date date;
	private Float floatValue;
	private File file;
	private Locale locale;
	private Pattern pattern;
	private Properties properties;
	private String trimString;
	private String test;
	private URL url;

	public void setTest(String test) {
		this.test = test;
	}

	public void setCls(Class cls) {
		System.out.println("Setting class: " + cls.getName());
		this.cls = cls;
	}

	public void setFile(File file) {
		System.out.println("Setting file: " + file.getName());
		this.file = file;
	}

	public void setLocale(Locale locale) {
		System.out.println("Setting locale: " + locale.getDisplayName());
		this.locale = locale;
	}

	public void setProperties(Properties properties) {
		System.out.println("Loaded propperties: " + properties);
		this.properties = properties;
	}

	public void setUrl(URL url) {
		System.out.println("Setting URL: " + url.toExternalForm());
		this.url = url;
	}

	public void setBytes(byte[] bytes) {
		System.out.println("Adding " + bytes.length + " bytes");
		this.bytes = bytes;
	}

	public void setTrueOrFalse(Boolean trueOrFalse) {
		System.out.println("Setting Boolean: " + trueOrFalse);
		this.trueOrFalse = trueOrFalse;
	}

	public void setStringList(List<String> stringList) {
		System.out.println("Setting string list with size: " + stringList.size());
		this.stringList = stringList;
		for (String string : stringList) {
			System.out.println("String memЬer: " + string);
		}
	}

	public void setDate(Date date) {
		System.out.println("Setting date: " + date);
		this.date = date;
	}

	public void setFloatValue(Float floatValue) {
		System.out.println("Setting float value: " + floatValue);
		this.floatValue = floatValue;
	}

	public void setPattern(Pattern pattern) {
		System.out.println("Setting pattern: " + pattern);
		this.pattern = pattern;
	}

	public void setTrimString(String trimString) {
		System.out.println("Setting trim string: " + trimString);
		this.trimString = trimString;
	}

	public static class CustomPropertyEditorRegistrar implements
	PropertyEditorRegistrar{
		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry){
			SimpleDateFormat dateFormater = new SimpleDateFormat("mm/dd/yyyy");
			registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormater, true));
			registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		}
	}
	
	public static void main(String[] args) throws Exception{
		File file = File.createTempFile("test", "txt");
		file.deleteOnExit();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-propertyEditor.xml");
		ctx.refresh();
		
		PropertyEditorBean bean = ctx.getBean("builtInSample", PropertyEditorBean.class);
	}
}
