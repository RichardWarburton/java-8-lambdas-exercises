package com.insightfullogic.java8.examples.chapter8.lambdabehave.reporting;

import java.io.PrintStream;

public class ConsoleFormatter implements ReportFormatter {

    @Override
    public void format(Report report) {
        report.suites().forEach(suite -> {
            System.out.print(suite.getName());
            System.out.println();
            suite.specifications().forEach(this::printSpecification);
        });
    }

    private void printSpecification(SpecificationReport specification) {
        boolean isSuccess = specification.getResult() == Result.SUCCESS;
        PrintStream out = isSuccess ? System.out : System.err;

        out.print("\tshould ");
        out.print(specification.getDescription());
        if (!isSuccess) {
            out.print("[");
            out.print(specification.getMessage());
            out.print("]");
        }
        out.println();
    }

}
