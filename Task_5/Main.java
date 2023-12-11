package Task_5;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        String text = "This is a sample sentence demonstrating custom Spliterator implementation";
        Stream<String> wordStream = StreamSupport.stream(new WordSpliterator(text), false);
        wordStream.forEach(System.out::println);
    }
}

class WordSpliterator implements Spliterator<String> {
    private final String text;
    private int curChar = 0;

    public WordSpliterator(String text) {
        this.text = text;
    }

    @Override
    public long estimateSize() {
        return text.length() - curChar;
    }

    @Override
    public int characteristics() {
        return SIZED | SUBSIZED | CONCURRENT | IMMUTABLE | ORDERED;
    }

    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        while (curChar < text.length() && Character.isWhitespace(text.charAt(curChar))) {
            curChar++;
        }
        if (curChar >= text.length()) {
            return false;
        }
        int start = curChar;
        while (curChar < text.length() && !Character.isWhitespace(text.charAt(curChar))) {
            curChar++;
        }
        action.accept(text.substring(start, curChar));
        return true;
    }

    @Override
    public Spliterator<String> trySplit() {
        if (estimateSize() <= 1) {
            return null;
        }
        for (int splitPos = Math.toIntExact(estimateSize() / 2 + curChar); splitPos < text.length(); splitPos++) {
            if (Character.isWhitespace(text.charAt(splitPos))) {
                Spliterator<String> spliterator = new WordSpliterator(text.substring(curChar, splitPos));
                curChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }
}