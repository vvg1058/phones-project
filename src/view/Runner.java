package view;

import java.time.LocalDate;
import java.util.Scanner;

import presenter.HandlingCalls;

public class Runner {

    private HandlingCalls handlingCalls;
    private Scanner scanner;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.scanner = new Scanner(System.in);
        runner.handlingCalls = new HandlingCalls();
        runner.mainMenu();
    }

    public void mainMenu() {
        String menu = "\n ------------- MAIN MENU -------------\n" +
                "       Type the desired option       \n\n" +
                "1. Add phone\n" +
                "2. Get detail of phone\n" +
                "3. Add minutes to phone\n" +
                "4. Call\n" +
                "5. Exit\n";
        boolean isRunning = true;
        do {
            System.out.println(menu);
            char option = scanner.nextLine().charAt(0);
            switch (option) {
                case '1':
                    addPhone();
                    break;
                case '2':
                    findPhone();
                    break;
                case '3':
                    addMinutes();
                    break;
                case '4':
                    registryCall();
                    break;
                case '5':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    isRunning = true;
                    break;
            }
        } while (isRunning);
    }

    public void addPhone() {
        boolean isRunning = false;
        do {
            try {
                System.out.println("Enter the IMEI: ");
                String imei = scanner.nextLine();
                System.out.println("Enter the number: ");
                String number = scanner.nextLine();
                System.out.println("Enter the manufacturing date with next formatting DD/MM/YYYY: ");
                String manufacturingDate = scanner.nextLine();
                String[] date = manufacturingDate.split("/");
                System.out.println("Enter the description of cell plan: ");
                String description = scanner.nextLine();
                System.out.println("Enter the minutes of cell plan: ");
                String minutes = scanner.nextLine();
                boolean canAdded = this.handlingCalls.addPhone(imei, number,
                        LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])),
                        description, Integer.parseInt(minutes));
                if (canAdded) {
                    System.out.println("\n The phone was added");
                    isRunning = false;
                } else {
                    System.out.println("\n The phone was not added, verify the IMEI with option 2");
                }
            } catch (Exception e) {
                System.out.println("\n Invalid data, please try again");
                isRunning = true;
            }
        } while (isRunning);
    }

    public void findPhone() {
        System.out.println("Enter the IMEI: ");
        String imei = scanner.nextLine();
        System.out.println(this.handlingCalls.findPhone(imei));
    }

    public void addMinutes() {
        boolean hasContinue = false;
        do {
            try {
                System.out.println("Enter the IMEI: ");
                String imei = scanner.nextLine();
                System.out.println("Enter the minutes to add: ");
                String minutes = scanner.nextLine();
                int newMinutes = this.handlingCalls.addMinutes(imei, Integer.parseInt(minutes));
                if (newMinutes > 0) {
                    System.out.println("\n The new minutes are: " + newMinutes);
                } else {
                    System.out.println("\n The phone was not found, verify the IMEI with option 2");
                }
            } catch (Exception e) {
                System.out.println("\n Invalid data, please try again");
                hasContinue = true;
            }
        } while (hasContinue);
    }

    public void registryCall() {
        boolean hasContinue = false;
        do {
            try {
                System.out.println("Enter the IMEI: ");
                String imei = scanner.nextLine();
                System.out.println("Enter the number to call: ");
                String numberToCall = scanner.nextLine();
                System.out.println("Enter the minutes of call: ");
                String minutes = scanner.nextLine();
                boolean isRegistered = this.handlingCalls.registryCall(imei, numberToCall, Integer.parseInt(minutes));
                if (isRegistered) {
                    System.out.println("\n The call was registered");
                } else {
                    System.out.println("\n The call was not registered, verify the IMEI with option 2");
                }
            } catch (Exception e) {
                System.out.println("\n Invalid data, please try again");
                hasContinue = true;
            }
        } while (hasContinue);
    }
}
