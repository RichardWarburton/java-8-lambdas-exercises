package com.insightfullogic.java8.answers.chapter2;

import java.text.SimpleDateFormat;
import javax.swing.text.DateFormatter;

import static java.lang.ThreadLocal.withInitial;

public class Question2 {

     public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

}
