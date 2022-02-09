package reflection;

import org.testng.annotations.Test;
import tests.CityTest;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;


/**
 * 3.1. Используя Java Reflection посчитать количество тестовых методов в проекте (по аннотации @Test)
 * 3.2. Сохранить найденные методы списком через запятую в текстовом файле (.txt).
 */
public class ReflectionClass {

    public static void main(String[] args) {

        StringBuilder annotatedMethodsList = new StringBuilder();
        String fileName = "textFile.txt";
        int count = 0;

        CityTest cityTest = new CityTest();
        final Method[] methods = cityTest.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                annotatedMethodsList.append(method.getName()).append(", \n");
                count++;
            }
        }
        writeToTxtFile(fileName, annotatedMethodsList.toString());
        System.out.println("Totally " + count + " methods have @Test annotation.");
    }

    public static void writeToTxtFile(String txtFileName, String text) {
        try (FileWriter writer = new FileWriter(txtFileName, false)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}