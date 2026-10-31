package Annotation;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class AnnotationExampleTest {

    // Test whether the custom annotation is available at runtime.
    @Test
    void testAnnotationAvailableAtRuntime() throws NoSuchMethodException {

        Method method = AnnotationExample.class
                .getDeclaredMethod("displayMessage");

        assertTrue(method.isAnnotationPresent(MethodInfo.class));
    }

    // Test the explicitly assigned annotation values.
    @Test
    void testAnnotationValues() throws NoSuchMethodException {

        Method method = AnnotationExample.class
                .getDeclaredMethod("toString");

        MethodInfo annotation = method.getAnnotation(MethodInfo.class);

        assertNotNull(annotation);
        assertEquals("Navya", annotation.author());
        assertEquals("01-Nov-2026", annotation.date());
        assertEquals(1, annotation.revision());
        assertEquals("Overridden toString method", annotation.comments());
    }

    // Test default annotation values.

    @Test
    void testDefaultAnnotationValues() throws NoSuchMethodException {

        Method method = AnnotationExample.class
                .getDeclaredMethod("displayMessage");

        MethodInfo annotation = method.getAnnotation(MethodInfo.class);

        assertNotNull(annotation);

        // Verify the default author value.
        assertEquals("Narayan", annotation.author());

        // Verify the explicitly assigned revision value.
        assertEquals(2, annotation.revision());

        assertEquals("01-Nov-2026", annotation.date());

        assertEquals(
                "Displays a welcome message",
                annotation.comments()
        );
    }


    // Test whether a method without the annotation is detected correctly.
    @Test
    void testMethodWithoutAnnotation() throws NoSuchMethodException {

        Method method = AnnotationExample.class
                .getDeclaredMethod("normalMethod");

        assertFalse(method.isAnnotationPresent(MethodInfo.class));
    }

    // Test whether the deprecated method also contains the custom annotation.
    @Test
    void testDeprecatedMethodAnnotation() throws NoSuchMethodException {

        Method method = AnnotationExample.class
                .getDeclaredMethod("oldMethod");

        assertTrue(method.isAnnotationPresent(Deprecated.class));
        assertTrue(method.isAnnotationPresent(MethodInfo.class));
    }

    // Test whether revision number is correctly retrieved.
    @Test
    void testRevisionNumber() throws NoSuchMethodException {

        Method method = AnnotationExample.class
                .getDeclaredMethod("displayMessage");

        MethodInfo annotation = method.getAnnotation(MethodInfo.class);

        assertEquals(2, annotation.revision());
    }

    // Test whether all expected methods have the custom annotation.
    @Test
    void testAnnotatedMethods() {

        int annotatedMethodCount = 0;

        for (Method method :
                AnnotationExample.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(MethodInfo.class)) {
                annotatedMethodCount++;
            }
        }

        assertEquals(3, annotatedMethodCount);
    }

    // Test the toString method output.
    @Test
    void testToStringMethod() {

        AnnotationExample example = new AnnotationExample();

        assertEquals("Annotation Example", example.toString());
    }
}

