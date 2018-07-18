/**
 * A thread-safe DateFormatter via ThreadLocal
 * 
 * @author manny egalli64@gmail.com
 * based on Java 8 Lambdas, Richard Warburton - exercise 2-b, chapter two
 * 
 * @see http://thisthread.blogspot.com/2018/07/a-thread-safe-dateformatter-via.html
 *      https://github.com/RichardWarburton/java-8-lambdas-exercises
 */
package com.insightfullogic.java8.exercises.chapter2;

import javax.swing.text.DateFormatter;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Question2 {
    public final static ThreadLocal<DateFormatter> formatter = //
            ThreadLocal.withInitial(() -> new DateFormatter( //
                    new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)));

    public final static DateTimeFormatter formatter8 = //
            DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
}
