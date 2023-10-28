package Task_2;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    public String[] keywords;
    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    public String[] getKeywords() {
        return keywords;
    }

    @Override
    public Label getLabel() {
        return Label.SPAM;
    }
}