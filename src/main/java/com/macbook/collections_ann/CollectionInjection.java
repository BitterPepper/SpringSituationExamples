package com.macbook.collections_ann;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import javax.annotation.*;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectCollection")
public class CollectionInjection {
	@Resource(name="map")
	private Map<String, Object> map;
	@Resource(name="props")
	private Properties props;
	@Resource(name="set")
	private Set set;
	@Resource(name="list")
	private List list; 
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-collections_ann.xml");
		ctx.refresh();
		
		CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public void displayInfo() {
		System.out.println("Map content:\n");
		for(Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + 
					" - Value: " + entry.getValue());
		}
		System.out.println("\nProperties contents:\n");
		for(Entry<Object, Object> entry : props.entrySet()) {
			System.out.println("Key: " + entry.getKey() + 
					" - Value: " + entry.getValue());
		}
		System.out.println("\nSet contents:\n");
		for(Object obj : set) {
			System.out.println("Value: "+obj);
		}
		System.out.println("\nList contents:\n");
		for(Object obj : list) {
			System.out.println("Value: "+obj);
		}
	}
}
