package com.itg.calderysapp.common;

import android.text.Editable;
import android.text.TextWatcher;

import java.lang.reflect.Field;

public class TextSetWatcher implements TextWatcher {

    private Field field;
    private String fieldString;
    private Object object;
//
//    public TextSetWatcher(String fieldString,OnTextListener listener) {
//        this.fieldString = fieldString;
//        this.listener = listener;
//    }
    public TextSetWatcher(Object object, String fieldName) {
        this.object = object;
        Class<?> clazz = object.getClass();
        if (clazz != null) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(s.length()>0){
//            field=s.toString();
//            listener.onTextChange(field);
            if(field!=null) {
                try {
                    field.set(object, s.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }

//    public interface OnTextListener{
//        void onTextChange(String text);
//    }
}
