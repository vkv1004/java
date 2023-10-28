package Task_2;

public class TooLongTextAnalyzer implements TextAnalyzer {

    public int maxLength;
    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength){
            return Label.TOO_LONG;
        } else {
            return Label.OK;
        }
    }
}