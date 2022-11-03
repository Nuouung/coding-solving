package designPattern.create.factoryMethod.ex1;

public class Main {

    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        // 로직 돌리기
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }
}
