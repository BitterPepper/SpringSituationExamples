package com.macbook.methodReplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-method_replacement.xml");
		ctx.refresh();

		ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
		ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");

		displayInfo(replacementTarget);
		displayInfo(standardTarget);
	}

	public static void displayInfo(ReplacementTarget target) {
		System.out.println(target.formatMessage("Hello world"));

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("perfTest");

		for (int x = 0; x < 100000; x++) {
			String out = target.formatMessage("foo");
		}
		stopWatch.stop();

		System.out.println("100000 ivocations took " + stopWatch.getTotalTimeMillis() + " ms");
	}
}
