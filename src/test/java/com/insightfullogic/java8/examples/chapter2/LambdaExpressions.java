package com.insightfullogic.java8.examples.chapter2;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author richard
 */
public class LambdaExpressions {

    public void first_lambda_1() {
        JButton button = new JButton();
        // BEGIN lambda_button_class
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        System.out.println("button clicked");
    }
});
        // END lambda_button_class
    }

    public void first_lambda_2() {
        JButton button = new JButton();
        // BEGIN lambda_button_lambda
button.addActionListener(event -> System.out.println("button clicked"));
        // END lambda_button_lambda
    }

    public void first_lambda_3() {
        JButton button = new JButton();
        // BEGIN lambda_button_lambda2
button.addActionListener((ActionEvent event) -> {
    System.out.println("button clicked");
});
        // END lambda_button_lambda2
    }

    public void allLambdaForms() {
        // BEGIN all_lambda_forms
     Runnable noArguments = () -> System.out.println("Hello World"); // <1>

     ActionListener oneArgument = event -> System.out.println("button clicked"); // <2>

     Runnable multiStatement = () -> { // <3>
        System.out.print("Hello");
        System.out.println(" World");
     };

     BinaryOperator<Long> add = (x, y) -> x + y; // <4>

     BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y; // <5>
        // END all_lambda_forms
    }

    public void first_lambda_5() {
        JButton button = new JButton();
        // BEGIN variable_capture1
final String name = getUserName();
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        System.out.println("hi " + name);
    }
});
        // END variable_capture1
    }

    public void first_lambda_6() {
        JButton button = new JButton();
        // BEGIN variable_capture2
String name = getUserName();
button.addActionListener(event -> System.out.println("hi " + name));
        // END variable_capture2
    }

    public void diamondInference() {
        // BEGIN diamond_inference
Map<String, Integer> oldWordCounts = new HashMap<String, Integer>(); // <1>
Map<String, Integer> diamondWordCounts = new HashMap<>(); // <2>
        // END diamond_inference
    }

    public void diamondInferenceMethod() {
        // BEGIN diamond_inference_method
    useHashmap(new HashMap<>());
}

private void useHashmap(Map<String, String> values) {
        // END diamond_inference_method
    }

    public void firstBiFunction() {
        // BEGIN first_bifunction
BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        // END first_bifunction
    }
    
    public void biFunctionDeclaration() {
        // BEGIN bifunction_declaration
BiFunction<Integer, Integer, Integer> add;
        // END bifunction_declaration
    }

    public void typeInferenceExamples() {
        // BEGIN type_inference_examples
Predicate<Integer> atLeast5 = x -> x > 5;
        // END type_inference_examples
    }

    public void typeInferenceExamples2() {
        // BEGIN type_inference_examples2
BinaryOperator<Long> addLongs = (x, y) -> x + y;
        // END type_inference_examples2
    }

    @Test
    public void mostSpecific() {
// BEGIN most_specific_overload_call
overloadedMethod("abc");
// END most_specific_overload_call
    }

// BEGIN most_specific_overload
private void overloadedMethod(Object o) {
    System.out.print("Object");
}

private void overloadedMethod(String s) {
    System.out.print("String");
}
    // END most_specific_overload

    @Test
    public void mostSpecificBiFunction() {

    overloadedMethod((x, y) -> x + y);
}

// BEGIN most_specific_bifunction
private interface IntegerBiFunction extends BinaryOperator<Integer> {

}

private void overloadedMethod(BinaryOperator<Integer> lambda) {
    System.out.print("BinaryOperator");
}

private void overloadedMethod(IntegerBiFunction lambda) {
    System.out.print("IntegerBinaryOperator");
}
    // END most_specific_bifunction

//    @Test
//    public void mostSpecificPredicate() {
//        overloadedMethod((x) -> true);
//    }

//    private interface IntPredicate  {
//        public boolean test(int value);
//    }

//    private void overloadedMethod(Predicate<Integer> predicate) {
//        System.out.print("Predicate");
//    }

//    private void overloadedMethod(IntPredicate predicate) {
//        System.out.print("IntPredicate");
//    }

    private String getUserName() {
        return "Richard";
    }

}
