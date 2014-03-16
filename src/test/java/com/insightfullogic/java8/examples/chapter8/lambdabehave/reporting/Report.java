package com.insightfullogic.java8.examples.chapter8.lambdabehave.reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class Report {

    private final List<SuiteReport> suites;

    private SuiteReport currentSuite;

    public Report() {
        suites = new ArrayList<>();
    }

    private void newSuite(String name) {
        currentSuite = new SuiteReport(name);
        suites.add(currentSuite);
    }

    public void newSpecification(String suiteName, SpecificationReport report) {
        if (noSuite() || seenNewSuite(suiteName)) {
            newSuite(suiteName);
        }
        currentSuite.add(report);
    }

    private boolean seenNewSuite(String suite) {
        return !currentSuite.getName().equals(suite);
    }

    private boolean noSuite() {
        return currentSuite == null;
    }

    public Stream<SuiteReport> suites() {
        return suites.stream();
    }

}
