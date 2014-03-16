package com.insightfullogic.java8.examples.patterns.template_method.lambdas;

import com.insightfullogic.java8.examples.patterns.template_method.ApplicationDenied;

// BEGIN Criteria
public interface Criteria {

    public void check() throws ApplicationDenied;

}
// END Criteria
