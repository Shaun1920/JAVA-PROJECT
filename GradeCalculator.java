import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        System.out.print("WELCOME TO, STUDENT GRADE CALCULATOR");
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the Marks of the Following Subjects:");
        System.out.println();
        System.out.println("NOTE: Max: 100 || Min: 35");
        System.out.print("Marks in Physics : ");
        float physics = sc.nextFloat();
        System.out.print("Marks in Chemistry : ");
        float chemistry = sc.nextFloat();
        System.out.print("Marks in Maths : ");
        float maths = sc.nextFloat();
        System.out.print("Marks in Biology : ");
        float biology = sc.nextFloat();
        System.out.print("Marks in English : ");
        float english = sc.nextFloat();
        System.out.print("Marks in Lab : ");
        float lab = sc.nextFloat();
        System.out.println("Calculating the Grades please wait....");
        double sum = physics + chemistry + maths + biology + english + lab;
        double result = sum / 6.0;
        double percentage = (sum / 600.0) * 100;

        if (percentage >= 90) {
            System.out.printf("Total marks = %.2f%n", sum);
            System.out.printf("Average marks = %.2f%n", result);
            System.out.printf("Percentage = %.2f%%%n", percentage);
            System.out.println("Grade: A | Remarks: Excellent | Result: Pass");
        } else if (percentage >= 80) {
            System.out.printf("Total marks = %.2f%n", sum);
            System.out.printf("Average marks = %.2f%n", result);
            System.out.printf("Percentage = %.2f%%%n", percentage);
            System.out.println("Grade: B | Remarks: Very Good | Result: Pass");
        } else if (percentage >= 65) {
            System.out.printf("Total marks = %.2f%n", sum);
            System.out.printf("Average marks = %.2f%n", result);
            System.out.printf("Percentage = %.2f%%%n", percentage);
            System.out.println("Grade: C | Remarks: Good | Result: Pass");
        } else if (percentage >= 35) {
            System.out.printf("Total marks = %.2f%n", sum);
            System.out.printf("Average marks = %.2f%n", result);
            System.out.printf("Percentage = %.2f%%%n", percentage);
            System.out.println("Grade: D | Remarks: Need To Work Hard | Result: Pass");
        } else {
            System.out.printf("Total marks = %.2f%n", sum);
            System.out.printf("Average marks = %.2f%n", result);
            System.out.printf("Percentage = %.2f%%%n", percentage);
            System.out.println("Result: Fail | Remarks: Try Hard Next Time");
        }
    }
}
