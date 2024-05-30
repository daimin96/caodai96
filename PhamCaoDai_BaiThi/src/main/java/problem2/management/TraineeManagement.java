package problem2.management;

import problem2.dao.TraineeDao;
import problem2.entities.Trainee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TraineeManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TraineeDao traineeDao = new TraineeDao();

    public static void main(String[] args) throws SQLException {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create Trainee");
            System.out.println("2. Update Trainee");
            System.out.println("3. Remove a specific Trainee");
            System.out.println("4. Repost incomplete training");
            System.out.println("5. List  excellent trainees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewTrainee();
                    break;
                case 2:
                    updateTrainee();
                    break;
                case 3:
                    if (traineeDao.removeLeaveTrainee()) {
                        System.out.println("Delete success");
                        System.out.println("========================================");
                    } else {
                        System.out.println("Delete fail");
                        System.out.println("========================================");
                    }
                    break;
                case 4:
                    List<Trainee> femaleTrainee = traineeDao.findFemaleTrainee();
                    System.out.println(femaleTrainee);
                    break;
//                case 5:
//                    List<Trainee> excellentTrainee = traineeDao.excellentTrainee();
//                    System.out.println(excellentTrainee);
//                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        } while (choice != 6);
    }

    static void addNewTrainee() throws SQLException {
        System.out.print("Enter trainee account: ");
        String account = scanner.nextLine();
        System.out.print("Enter trainee gender (0 for female, 1 for male): ");
        int genderint = scanner.nextInt();
        boolean gender = false;
        switch (genderint) {
            case 0:
                gender = false;
                break;
            case 1:
                gender = true;
                break;
        }
        scanner.nextLine(); // Consume newline
        System.out.print("Enter trainee status(working/leave/unpaid leave): ");
        String status = scanner.nextLine();
        Trainee trainee = new Trainee();
        trainee.setAccount(account);
        trainee.setGender(gender);
        trainee.setStatus(status);
        TraineeDao traineeDao = new TraineeDao();
        if (traineeDao.save(trainee)) {
            System.out.printf("Saved successfully");
            System.out.println("========================================");
        } else {
            System.out.printf("Saved fail");
            System.out.println("========================================");
        }

    }

//    public List<Trainee> excellentTrainee() {
//        Trainee trainee = new Trainee();
//        trainee.setGpa(trainee.getGpa());
//    }
//        if()
//
//    {
//    }

    private static void updateTrainee() {
        try {
            System.out.print("Enter trainee account to update: ");
            String account = scanner.nextLine();
            System.out.print("Enter new gender (0 for female, 1 for male): ");
            int genderInt = scanner.nextInt();
            boolean gender;
            switch (genderInt) {
                case 0:
                    gender = false;
                    break;
                case 1:
                    gender = true;
                    break;
                default:
                    System.out.println("Invalid gender input. Defaulting to male.");
                    gender = true;
            }
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new status(working/leave/unpaid leave): ");
            String status = scanner.nextLine();
            Trainee updatedTrainee = new Trainee();
            updatedTrainee.setAccount(account);
            updatedTrainee.setGender(gender);
            updatedTrainee.setStatus(status);
            if (traineeDao.update(updatedTrainee)) {
                System.out.println("Trainee information updated successfully.");
                System.out.println("========================================");
            } else {
                System.out.println("Trainee not found with the given account.");
                System.out.println("========================================");
            }
        } catch (SQLException e) {
            System.out.println("Error updating Trainee: " + e.getMessage());
        }
    }
}



