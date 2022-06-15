package com.insightfullogic.java8.answers.chapter2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.ThreadLocal.withInitial;

public class Question2 {

     public static void main(String[] args) {
          System.out.println(getFormat().get().format(new Date()));
     }

     public static ThreadLocal<DateFormat> getFormat() {
          return ThreadLocal.withInitial(()-> DateFormat.getDateInstance(
                  DateFormat.MEDIUM, Locale.CANADA));
     }
}
