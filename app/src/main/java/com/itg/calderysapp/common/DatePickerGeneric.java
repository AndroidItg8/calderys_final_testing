package com.itg.calderysapp.common;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerGeneric {


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            listener.onDateSelect(CommonMethod.convertDateToString(myCalendar));
        }

    };
    private Calendar myCalendar;
    private DatePickerListener listener;

    public DatePickerGeneric(Calendar myCalendar,DatePickerListener listener) {

        this.myCalendar = myCalendar;
        this.listener = listener;
    }

    public void showPicker(Context context){
        new DatePickerDialog(context, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }


    public interface DatePickerListener{
        void onDateSelect(String date);
    }
}
