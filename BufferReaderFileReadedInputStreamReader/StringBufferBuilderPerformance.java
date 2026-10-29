public class StringBufferBuilderPerformance {
    public static void main(String[] args) {
        int repetitions = 1_000_000;
        String value = "hello";

        // Measure StringBuilder
        StringBuilder builder = new StringBuilder();
        long builderStart = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            builder.append(value);
        }

        long builderEnd = System.nanoTime();

        // Measure StringBuffer
        StringBuffer buffer = new StringBuffer();
        long bufferStart = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            buffer.append(value);
        }

        long bufferEnd = System.nanoTime();

        long builderTime = builderEnd - builderStart;
        long bufferTime = bufferEnd - bufferStart;

        System.out.println("Strings appended: " + repetitions);
        System.out.println("StringBuilder length: " + builder.length());
        System.out.println("StringBuffer length: " + buffer.length());

        System.out.printf("StringBuilder time: %.3f ms%n",
                builderTime / 1_000_000.0);

        System.out.printf("StringBuffer time: %.3f ms%n",
                bufferTime / 1_000_000.0);
    }
}