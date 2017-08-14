package com.macbook.propertyEditorSupport;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text){
		String[] name = text.split("\\s");
		setValue(new Name(name[0], name[1]));
	}
}
