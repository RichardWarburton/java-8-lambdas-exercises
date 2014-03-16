package com.insightfullogic.java8.examples.chapter8.lambdabehave.reporting;

public final class SpecificationReport {

    private final String description;
    private final Result result;
    private final String message;

    public SpecificationReport(String description, Result result, String message) {
        this.description = description;
        this.result = result;
        this.message = message;
    }

    public SpecificationReport(String specification) {
        this(specification, Result.SUCCESS, null);
    }

    public String getDescription() {
        return description;
    }

    public Result getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

}
