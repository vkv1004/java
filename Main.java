public class Main {
    public static void main(String[] args) {
    }
    //Task 1
    static boolean equals(String s, String t) {
        return s.equalsIgnoreCase(t);
    }

    static String replace(String str, String oldStr, String newStr) {
        return str.replaceAll(oldStr, newStr);
    }

    static String format(String surname, int mark, String subject) {
        return String.format("Студент %s получил %d по %s", surname, mark, subject);
    }

    static boolean isPalindrome(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return str.equalsIgnoreCase(reversed.toString());
    }
}

