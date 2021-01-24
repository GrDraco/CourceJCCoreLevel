package homework.lesson_6;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        // Тестирование клиента
        try {
            new ChatClient(new IChatViewModel() {
                @Override
                public void onNewMessage(Message message) {
                    System.out.println(message.toString());
                }

                @Override
                public String getMessageText() {
                    return scanner.nextLine();
                }

                @Override
                public String getHost() {
                    return "localhost";
                }

                @Override
                public int getPort() {
                    return 8081;
                }

                @Override
                public String getNickName() {
                    return "ititov";
                }

                @Override
                public void onStart() {
                    scanner = new Scanner(System.in);
                }

                @Override
                public void onClose() {
                    scanner.close();
                }

                @Override
                public void onSetLog(String message) {
                    System.out.println(message);
                }
            }).Start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Scanner scanner;
}
