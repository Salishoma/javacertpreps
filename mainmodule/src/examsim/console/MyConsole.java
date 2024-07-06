package examsim.console;

public class MyConsole {
    public static void readConsole() {
        String text = System.console().readLine("What do you want to do?");
        System.out.println("Text: " + text);
    }

    public static void main(String[] args) {
//        readConsole();
    }
}
