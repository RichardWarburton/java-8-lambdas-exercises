package com.insightfullogic.java8.exercises.chapter2;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import static java.lang.ThreadLocal.withInitial;

public class Question2 {

    public static ThreadLocal<SimpleDateFormat> formatter
            = withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy"));

}
