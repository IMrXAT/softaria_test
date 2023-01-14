package nsu.rodionov;

import java.util.*;

public class Main {
    static HashMap<String, String> yesterday;
    static HashMap<String, String> today;

    public static void main(String[] args) {
        yesterday = new HashMap<>();
        today = new HashMap<>();
        CrateAndPrintMessage();

    }

    private static void CrateAndPrintMessage() {
        MonitoringSystemMessengeCreator writer = new MonitoringSystemMessengeCreator();
        MonitoringSystemMessagePrinter printer = new MonitoringSystemMessagePrinter();
        initHashmaps();
        Checker checker = new Checker(yesterday, today, writer);
        checker.checkNewURLs();
        checker.checkLostURLs();
        checker.checkChangesHTML();
        String message = writer.makeMassage();
        printer.printMessage(message);
    }

    private static void initHashmaps() {
        yesterday.put("key1", "html1");
        yesterday.put("key2", "html2");
        yesterday.put("key3", "html3");
        yesterday.put("key4", "html4");
        yesterday.put("key5", "html5");
        yesterday.put("key6", "html6");

        today.put("key3", "html3");
        today.put("key4", "html4");
        today.put("key5", "html5.1");
        today.put("key6", "html6.2");
        today.put("key7", "html7");
        today.put("key8", "html8");
    }

}