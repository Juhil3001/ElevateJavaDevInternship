import java.io.*;
import java.util.Scanner;
public class FileIoNotesApp{
    static final String FILE_NAME="notes.txt";
    public static void addNote(String note){
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + "\n");
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the note.");
        }

    }
    public static void viewNotes(){
        try(BufferedReader reader=new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line=reader.readLine())!=null){
                System.out.println("-"+line);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("No notes found. Start by adding a new note.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading notes.");
        }
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Notes Manager ===");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
 switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    addNote(note);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}










    