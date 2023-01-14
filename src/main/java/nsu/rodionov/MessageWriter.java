package nsu.rodionov;

import java.util.ArrayList;

public class MonitoringSystemMessenger implements MessageCreator {

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
                "Исчезли следующие страницы: " + missPageURL/*.stream().distinct().map(String::valueOf).toList()*/ + "\n" +
                "Появились следующие новые страницы: " + newPageURL/*.stream().distinct().map(String::valueOf).toList()*/ + "\n" +
                "Изменились следующие страницы: " + changedPageURL/*.stream().distinct().map(String::valueOf).toList()*/ + "\n" +
                "\n" +
                "С уважением,\n" +
                "автоматизированная система\n" +
                "мониторинга.";
    }
}
