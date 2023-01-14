package nsu.rodionov;

public class MonitoringSystemMessagePrinter implements MessagePrint{

    public void printMessage(String message) {
        System.out.println(message);
    }
}
