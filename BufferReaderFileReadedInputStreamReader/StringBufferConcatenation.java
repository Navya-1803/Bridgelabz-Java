public class StringBufferConcatenation {

    static String concatenate(String[] words) {
        StringBuffer buffer = new StringBuffer();

        // Append every string to the same buffer
        for (String word : words) {
            buffer.append(word);
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "Java", " ", "World"};

        String result = concatenate(words);

        System.out.println("Concatenated string: " + result);
    }
}