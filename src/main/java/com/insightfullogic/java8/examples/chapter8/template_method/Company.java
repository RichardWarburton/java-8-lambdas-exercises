package com.insightfullogic.java8.examples.chapter8.template_method;

public interface Company {

    // BEGIN checkSignatures
    public void checkIdentity() throws ApplicationDenied;

    public void checkProfitAndLoss() throws ApplicationDenied;

    public void checkHistoricalDebt() throws ApplicationDenied;
    // END checkSignatures

}
