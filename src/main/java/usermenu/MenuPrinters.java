package usermenu;

public class MenuPrinters {
    public static void LogMenu(){
        System.out.println(
                "Welcome to our Train Company!\n" +
                        "===== MENU =====\n" +
                        "1 Log in\n" +
                        "2 Sign up\n" +
                        "3 Exit\n"
        );
    }
    public static void ActionMenu(){
        System.out.println(
                "\n" +
                        "===== MENU =====\n" +
                        "1 Create train\n" +
                        "2 See all trains\n" +
                        "3 Log out\n"
        );
    }

    public static void TrainMenu() {
        System.out.println(
                "\n" +
                        "===== TRAIN =====\n" +
                        "1 Sort train cars\n" +
                        "2 Find train car by range\n" +
                        "3 Go back to action menu\n"
        );
    }
}
