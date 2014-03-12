package com.insightfullogic.java8.patterns.template_method.lambdas;

import com.insightfullogic.java8.patterns.template_method.ApplicationDenied;

// BEGIN Criteria
public interface Criteria {

    public void check() throws ApplicationDenied;

}
// END Criteria
