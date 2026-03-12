/**
 * OOPSBannerApp UC7 – Store Character Pattern in a Class
 */

public class OOPSBannerApp {

    /**
     * Inner class to store character and its banner pattern
     */
    static class CharacterPatternMap {

        private char character;
        private String[] pattern;

        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Create and initialize character patterns
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        CharacterPatternMap[] maps = new CharacterPatternMap[4];

        String[] oPattern = {
                " *** ",
                "*   *",
                "*   *",
                "*   *",
                "*   *",
                "*   *",
                " *** "
        };

        String[] pPattern = {
                "**** ",
                "*   *",
                "*   *",
                "**** ",
                "*    ",
                "*    ",
                "*    "
        };

        String[] sPattern = {
                " ****",
                "*    ",
                "*    ",
                " *** ",
                "    *",
                "    *",
                "**** "
        };

        String[] spacePattern = {
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        };

        maps[0] = new CharacterPatternMap('O', oPattern);
        maps[1] = new CharacterPatternMap('P', pPattern);
        maps[2] = new CharacterPatternMap('S', sPattern);
        maps[3] = new CharacterPatternMap(' ', spacePattern);

        return maps;
    }

    /**
     * Get pattern for a character
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {

        for (CharacterPatternMap map : maps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }

        return maps[3].getPattern(); // return space if not found
    }

    /**
     * Print banner message
     */
    public static void printMessage(String message, CharacterPatternMap[] maps) {

        int height = 7;

        for (int i = 0; i < height; i++) {

            StringBuilder line = new StringBuilder();

            for (char ch : message.toCharArray()) {

                String[] pattern = getCharacterPattern(ch, maps);
                line.append(pattern[i]).append(" ");
            }

            System.out.println(line);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        CharacterPatternMap[] maps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, maps);
    }
}