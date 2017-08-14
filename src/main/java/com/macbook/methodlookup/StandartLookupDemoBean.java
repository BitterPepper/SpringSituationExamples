package com.macbook.methodlookup;

public class StandartLookupDemoBean implements DemoBean {
	MyHelper myHelper;
	
	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper;
	}
	
	@Override
	public MyHelper getMyHelper() {
		return this.myHelper;
	}

	@Override
	public void someOperation() {
		myHelper.doSomethingHelpful();
	}

}
