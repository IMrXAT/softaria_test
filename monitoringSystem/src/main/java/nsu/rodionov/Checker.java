package nsu.rodionov;

import java.util.*;

public class Checker {
    private final HashMap<String, String> yesterday;
    private final HashMap<String, String> today;
    private final MonitoringSystemMessengeCreator writer;
    private final ArrayList<String> newPageURL;
    private final ArrayList<String> missPageURL;
    private final ArrayList<String> changedPageURL;

    Checker(HashMap<String, String> yesterday, HashMap<String, String> today, MonitoringSystemMessengeCreator writer) {
        this.yesterday = yesterday;
        this.today = today;
        this.writer = writer;
        newPageURL = new ArrayList<>();
        missPageURL = new ArrayList<>();
        changedPageURL = new ArrayList<>();
    }

    public void checkNewURLs() {
        //yesterday minus today URLs
        newPageURL.addAll(yesterday.keySet());
        newPageURL.removeAll(today.keySet());
        writer.addOnlyYesterdaySiteURL(newPageURL);
    }

    public void checkLostURLs() {
        // today minus yesterday URLs
        missPageURL.addAll(today.keySet());
        missPageURL.removeAll(yesterday.keySet());
        writer.addOnlyTodaySiteURL(missPageURL);
    }

    public void checkChangesHTML() {
        // intersection
        changedPageURL.addAll(today.keySet());
        changedPageURL.retainAll(yesterday.keySet());
        for (String key : changedPageURL) {
            String todayHTML = today.get(key);
            String yesterdayHTML = yesterday.get(key);
            if (yesterdayHTML.hashCode() != todayHTML.hashCode()) {
                writer.addChangedSiteURL(key);
            } else if (!yesterdayHTML.equals(todayHTML)) {
                writer.addChangedSiteURL(key);
            }
        }

    }
}
