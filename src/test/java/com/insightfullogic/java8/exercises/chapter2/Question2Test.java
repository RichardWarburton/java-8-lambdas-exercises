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

import java.time.LocalDate;
import java.util.Calendar;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Question2Test {
    @Test
    public void exampleInB() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String formatted = Question2.formatter.get().getFormat().format(cal.getTime());
        assertEquals("01-Jan-1970", formatted);
    }

    @Test
    public void modernFormatter() {
        LocalDate aDate = LocalDate.of(1970, 1, 1);
        assertEquals("01-Jan-1970", Question2.formatter8.format(aDate));
    }
}
