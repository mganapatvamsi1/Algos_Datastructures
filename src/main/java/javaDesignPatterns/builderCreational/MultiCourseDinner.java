package javaDesignPatterns.builderCreational;

public interface MultiCourseDinner {
    void drinks();
    void appetizers(String firstValue, String secondValue);
    void mainCourse(String value1, String value2);
    void desserts();
}
