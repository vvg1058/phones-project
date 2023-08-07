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
        runner.addPhone();
    }

    public void mainMenu() {
    }

    public void addPhone() {
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
        int minutes = scanner.nextInt();
        this.handlingCalls.addPhone(imei, number,
                LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])),
                description, minutes);
    }

    public void findPhone() {
    }

    public void addMinutes() {
    }

    public void registryCall() {
    }
}
