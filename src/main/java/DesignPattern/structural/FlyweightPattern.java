package DesignPattern.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {

    static class Font {

        private final String fontName;
        private final int size;
        private final String color;

        public Font(String fontName, int size, String color) {
            this.fontName = fontName;
            this.size = size;
            this.color = color;
        }

        public void display(int position) {
            System.out.println(
                    "Font: " + fontName
                            + ", Size: " + size
                            + ", Color: " + color
                            + ", Position: " + position
            );
        }
    }

    static class FontFactory {

        private static final Map<String, Font> fonts = new HashMap<>();

        public static Font getFont(
                String fontName, int size, String color) {

            String key = fontName + "-" + size + "-" + color;

            if (!fonts.containsKey(key)) {
                fonts.put(key, new Font(fontName, size, color));
                System.out.println("Creating new font: " + key);
            }

            return fonts.get(key);
        }
    }

    static class Character {

        private final int position;
        private final Font font;

        public Character(int position, Font font) {
            this.position = position;
            this.font = font;
        }

        public void display() {
            font.display(position);
        }
    }

    public static void main(String[] args) {

        Font font1 = FontFactory.getFont("Arial", 12, "Black");
        Font font2 = FontFactory.getFont("Arial", 12, "Black");
        Font font3 = FontFactory.getFont("Times New Roman", 14, "Blue");

        Character character1 = new Character(1, font1);
        Character character2 = new Character(2, font2);
        Character character3 = new Character(3, font3);

        character1.display();
        character2.display();
        character3.display();

        System.out.println("Are font1 and font2 same? "
                + (font1 == font2));
    }
}