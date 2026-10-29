public class LinearSearchSentenceWord {

    static String findSentence(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            // Split the sentence into words and check each word
            String[] words = sentence.split("[^\\p{L}\\p{N}]+");

            for (String word : words) {
                if (word.equalsIgnoreCase(targetWord)) {
                    return sentence;
                }
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "I am learning Python.",
                "Java supports object-oriented programming.",
                "JavaScript is used for web development."
        };

        String targetWord = "java";

        String result = findSentence(sentences, targetWord);

        System.out.println("Search result: " + result);
    }
}