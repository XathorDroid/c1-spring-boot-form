package com.xathordroid.c1springbootform.editors;

import java.beans.PropertyEditorSupport;

public class UperCaseTextEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        setValue(s.toUpperCase().trim());
    }
}
