package com.insightfullogic.java8.examples.chapter8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class OpenClosedPrinciple {

    public void asHigherOrderFunctions() {
// BEGIN local_formatter
// One implementation
ThreadLocal<DateFormat> localFormatter
    = ThreadLocal.withInitial(() -> new SimpleDateFormat());

// Usage
DateFormat formatter = localFormatter.get();
// END local_formatter

// BEGIN local_thread_id
// Or...
AtomicInteger threadId = new AtomicInteger();
ThreadLocal<Integer> localId
    = ThreadLocal.withInitial(() -> threadId.getAndIncrement());

// Usage
int idForThisThread = localId.get();
// END local_thread_id
    }



}
