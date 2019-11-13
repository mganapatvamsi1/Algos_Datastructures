package javaDesignPatterns.builderCreational;

import org.thymeleaf.util.StringUtils;

public class Dinner implements MultiCourseDinner {
    @Override
    public void drinks() {
        System.out.println("Give various drinks to the customer according to his needs.");
    }

    @Override
    public void appetizers(String firstValue, String secondValue) {
        if (!StringUtils.isEmptyOrWhitespace(firstValue) && firstValue.contains("Vegetarian")) {
            System.out.println("Serve various vegan items");
        } else if (!StringUtils.isEmptyOrWhitespace(secondValue) && secondValue.contains("Meat items")) {
            System.out.println("Serve different meat entries");
        } else {
            System.out.println("Serve then whatever they would like to have..!");
        }
    }

    @Override
    public void mainCourse(String value1, String value2) {
        if (!StringUtils.isEmpty(value1) && value1.contains("Vegetarian")) {
            System.out.println("vegan food");
        } else if (!StringUtils.isEmpty(value2) && value2.contains("Meat")) {
            System.out.println("meat food");
        } else {
            System.out.println("Serve food of their choice..!");
        }
    }

    @Override
    public void desserts() {
        System.out.println("Serve them all the desserts");
    }
}
