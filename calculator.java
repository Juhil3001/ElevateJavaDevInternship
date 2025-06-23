import java.util.*;

class calculator{

    public static double add(double n1, double n2){
        return n1 + n2;
    }

    public static double sub(double n1, double n2){
        return n1 - n2;
    }

    public static double mul(double n1, double n2){
        return n1 * n2;
    }

    public static double div(double n1, double n2){
        if(n2 == 0){
            System.out.println("Error : you can not devide any number by zero");
        }
        return n1 / n2;
    }
    public static void main(String arcs[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Java console Calculator");
        boolean exit = true;

        while(exit){
            System.out.println("Choose an operation");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            int choose = sc.nextInt();

            if(choose == 5){
                exit = false;
                System.out.println("You are exit from calculator");
                break; 
            }

            System.out.println("Enter first number");
            double num1 = sc.nextDouble();
            System.out.println("Enter second number");
            double num2 = sc.nextDouble();

            double result = 0;

            switch(choose){
                case 1 :
                    result = add(num1 , num2);
                    break;
                case 2 :
                    result = sub(num1 , num2);
                    break;
                case 3 :
                    result = mul(num1 , num2);
                    break;
                case 4 :
                    result = div(num1 , num2);
                    break;
                default :
                System.out.println("Invalid choice");
                continue;
            }
            System.out.println("Result = " + result);
        }

    }
}