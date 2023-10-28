package Task_2;

public class Test {
    public static void main(String[] args) {
        TextAnalyzer[] analyzers = {
                new SpamAnalyzer(new String[]{"текст"}),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(25)
        };

        String[] comments = {
                "Этот текст какой-то спам",
                "А этот негативный :( ",
                "Этот комментарий слищком длинный"
        };

        for (String comment : comments) {
            Label label = checkLabels(analyzers, comment);
            System.out.println(comment + " - " + label);
        }
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            if (analyzer.processText(text) != Label.OK)
                return analyzer.processText(text);
        }
        return Label.OK;
    }
}
