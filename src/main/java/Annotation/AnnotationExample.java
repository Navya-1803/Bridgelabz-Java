package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

    // Method annotated with @Override and custom @MethodInfo.
    @Override
    @MethodInfo(
            author = "Navya",
            date = "01-Nov-2026",
            revision = 1,
            comments = "Overridden toString method"
    )
    public String toString() {

        return "Annotation Example";
    }

    // Method annotated with @Deprecated and custom @MethodInfo.
    @Deprecated
    @MethodInfo(
            author = "Navya",
            date = "01-Nov-2026",
            comments = "This method is deprecated"
    )
    public static void oldMethod() {

        System.out.println("This is an old method.");
    }

    // Method with a different revision number.
    @MethodInfo(
            date = "01-Nov-2026",
            revision = 2,
            comments = "Displays a welcome message"
    )
    public void displayMessage() {
        System.out.println("Welcome to Java Annotations!");
    }

    // Method without any custom annotation.
    public void normalMethod() {

        System.out.println("This method has no custom annotation.");
    }

    // Use Reflection to inspect methods and their annotations.
    public static void inspectAnnotations() {

        Method[] methods = AnnotationExample.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(MethodInfo.class)) {

                System.out.println("\nMethod: " + method.getName());

                // Read the custom annotation from the method.
                MethodInfo methodInfo =
                        method.getAnnotation(MethodInfo.class);

                System.out.println("Author: " + methodInfo.author());
                System.out.println("Date: " + methodInfo.date());
                System.out.println("Revision: " + methodInfo.revision());
                System.out.println("Comments: " + methodInfo.comments());

                // Read all annotations present on the method.
                Annotation[] annotations =
                        method.getDeclaredAnnotations();

                System.out.println("Annotations:");

                for (Annotation annotation : annotations) {
                    System.out.println(annotation);
                }

                // Check whether the method has revision 1.
                if (methodInfo.revision() == 1) {
                    System.out.println(
                            "This method has revision number 1."
                    );
                }
            }
        }
    }

    public static void main(String[] args) {

        AnnotationExample example = new AnnotationExample();

        System.out.println(example);

        example.displayMessage();

        oldMethod();

        inspectAnnotations();
    }
}
