package ru.job4j.tracker.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport reportJson = new JSONReport();
        String textJson = reportJson.generate("JSON-Report's name", "JSON-Report's body");
        System.out.println(textJson);
    }
}
