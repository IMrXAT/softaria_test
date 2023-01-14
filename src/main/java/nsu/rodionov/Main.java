package nsu.rodionov;

import java.util.*;


/*Есть две хэш таблицы.

Ключами являются URLы.
Значениями - html код страниц, находящихся по этим урлам.

Обе таблицы отражают состояние всех страниц некоторого заданного
множества веб сайтов.

Первая таблица - состояние этих сайтов на вчера.
Вторая - на сегодня.

Задача - написать код который бы, пользуясь этими таблицами составил
письмо следующего формата:

Здравствуйте, дорогая и.о. секретаря

За последние сутки во вверенных Вам сайтах произошли следующие изменения:

Исчезли следующие страницы:{здесь список урлов}
Появились следующие новые страницы {здесь список урлов}
Изменились следующие страницы {здесь список урлов}

С уважением,
автоматизированная система
мониторинга.
*/

public class Main {
    static HashMap<String, String> yesterday;
    static HashMap<String, String> today;

    public static void main(String[] args) {
        yesterday = new HashMap<>();
        today = new HashMap<>();
        MessageWriter writer = new MessageWriter();
        MessagePrinter printer = new MessagePrinter();

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