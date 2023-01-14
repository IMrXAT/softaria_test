package nsu.rodionov;

import java.util.ArrayList;

public class MonitoringSystemMessengeCreator implements MessageCreator {

    ArrayList<String> missPageURL;
    ArrayList<String> newPageURL;
    ArrayList<String> changedPageURL;

    MonitoringSystemMessenger(){
        this.missPageURL = new ArrayList<>();
        this.newPageURL = new ArrayList<>();
        this.changedPageURL = new ArrayList<>();
    }
    public void addOnlyTodaySiteURL(ArrayList<String> onlyTodayURLs) {
        newPageURL = onlyTodayURLs;
    }

    public void addOnlyYesterdaySiteURL(ArrayList<String> onlyYesterdayURL){
        missPageURL = onlyYesterdayURL;
    }

    public void addChangedSiteURL(String changedURL){
        changedPageURL.add(changedURL);
    }

    public String makeMassage() {
        return "Здравствуйте, дорогая и.о. секретаря\n" +
                "\n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n" +
                "\n" +
                "Исчезли следующие страницы: " + missPageURL + "\n" +
                "Появились следующие новые страницы: " + newPageURL + "\n" +
                "Изменились следующие страницы: " + changedPageURL + "\n" +
                "\n" +
                "С уважением,\n" +
                "автоматизированная система\n" +
                "мониторинга.";
    }
}
