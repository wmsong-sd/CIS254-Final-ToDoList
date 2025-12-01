/**
 * A console-based to-do list application.
 * This program lets the user add, remove, edit, and display to-do items
 * using a simple text menu.
 * 
 * @author Wonmin Song
 * @since 11/30/2025
*/

import java.util.Scanner;
import java.util.InputMismatchException; 

/**
 * The {@code App} class contains the {@code main} method
 * and handles all user interactions for the to-do list program.
 */
public class App {

    /**
     * The entry point of the application.
     * It creates the {@code TodoList} and a {@code Scanner},
     * then repeatedly shows a menu until the user chooses to exit.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        boolean running = true;

        System.out.println("Welcome to the To-Do List App!");

        while (running) {
            printMenu();

            try {
                System.out.print("Choose an option (1-5): ");
                int choice = scanner.nextInt();
                scanner.nextLine();  

                switch (choice) {
                    case 1:
                        handleAddItem(scanner, todoList);
                        break;
                    case 2:
                        handleRemoveItem(scanner, todoList);
                        break;
                    case 3:
                        handleEditItem(scanner, todoList);
                        break;
                    case 4:
                        handleDisplayItems(todoList);
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number from 1 to 5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Please choose a number from 1 to 5.");
                scanner.nextLine();   
            } catch (IndexOutOfBoundsException e) { 
                System.out.println("That item number does not exist.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }

    /**
     * Prints the main menu of options for the to-do list application.
     */
    public static void printMenu() {
        System.out.println("==== TO-DO LIST MENU ====");
        System.out.println("1. Add new item");
        System.out.println("2. Remove an item");
        System.out.println("3. Edit an item");
        System.out.println("4. Display all items");
        System.out.println("5. Exit");
    } 

    /**
     * Handles the process of adding a new item to the to-do list.
     * It prompts the user for the item description, adds it to the list,
     * and then displays the updated list.
     *
     * @param scanner  the {@code Scanner} used to read user input
     * @param todoList the {@code TodoList} to which the item will be added
     */
    public static void handleAddItem(Scanner scanner, TodoList todolist) {
        System.out.print("Enter the new to-do item: ");
        String item = scanner.nextLine();
        
        todolist.addItem(item);

        System.out.println("Item added.");
        handleDisplayItems(todolist);
    }
    
    /**
     * Handles the process of removing an item from the to-do list.
     * It first checks if the list is empty. If not, it shows all items,
     * prompts the user for an item number, and removes the corresponding item.
     *
     * @param scanner  the {@code Scanner} used to read user input
     * @param todoList the {@code TodoList} from which the item will be removed
     * @throws IndexOutOfBoundsException if the user enters an invalid item number
     */
    public static void handleRemoveItem(Scanner scanner, TodoList todolist) {
        if (todolist.getSize() == 0) { 
            System.out.println("The to-do list is empty. Nothing to remove.");
            return;
        }

        handleDisplayItems(todolist); 
        System.out.print("Enter the item number to remove: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        todolist.removeItem(number - 1);

        System.out.println("Item removed.");
        handleDisplayItems(todolist);
    }

    /**
     * Displays the current items in the to-do list.
     * It prints a heading followed by the formatted list of items.
     *
     * @param todoList the {@code TodoList} whose items will be displayed
     */
    public static void handleDisplayItems(TodoList todoList) {
        String list = todoList.getFormattedList();
        System.out.println("Current to-do list:");
        System.out.println(list);
    }
    
    /**
     * Handles the process of editing an existing item in the to-do list.
     * It first checks if the list is empty. If not, it shows all items,
     * prompts the user for an item number, and then asks for the new description.
     * Finally, it updates the item and shows the updated list.
     *
     * @param scanner  the {@code Scanner} used to read user input
     * @param todoList the {@code TodoList} whose item will be edited
     * @throws IndexOutOfBoundsException if the user enters an invalid item number
     * @throws IllegalArgumentException  if the new description is empty
     */
    public static void handleEditItem(Scanner scanner, TodoList todolist) {
        if (todolist.getSize() == 0) { 
            System.out.println("The to-do list is empty. Nothing to edit.");
            return;
        }

        handleDisplayItems(todolist);

        System.out.print("Enter the item number to edit: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the new description: ");
        String newItem = scanner.nextLine();

        todolist.editItem(number - 1, newItem);

        System.out.println("Item updated.");
        handleDisplayItems(todolist);
    }
}
