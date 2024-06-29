package dataStructure;

import java.util.Scanner;

public class TextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        CustomStack<StringBuilder> undoStack = new CustomStack<>();
        CustomQueue<StringBuilder> cutQueue = new CustomQueue<>();

        System.out.print("Enter number of operations: ");
        int numOperations = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numOperations; i++) {
            System.out.println("1-insert\n2-delete\n3-print\n4-undo\n5-cut\n6-paste");
            System.out.print("Select the operation: ");
            int operation = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (operation) {
                case 1:
                    System.out.print("Enter text to insert: ");
                    String insertText = scanner.nextLine();
                    System.out.print("Enter index to insert at: ");
                    int insertIndex = scanner.nextInt();
                    insert(text, undoStack, insertText, insertIndex);
                    break;
                case 2:
                    System.out.print("Enter number of characters to delete: ");
                    int deleteCount = scanner.nextInt();
                    delete(text, undoStack, cutQueue, deleteCount);
                    break;
                case 3:
                    print(text);
                    break;
                case 4:
                    undo(text, undoStack);
                    break;
                case 5:
                    System.out.print("Enter number of characters to cut: ");
                    int cutCount = scanner.nextInt();
                    cut(text, cutQueue, undoStack, cutCount);
                    break;
                case 6:
                    System.out.print("Enter index to paste: ");
                    int pasteIndex = scanner.nextInt();
                    paste(text, cutQueue, undoStack, pasteIndex);
                    break;
                default:
                    System.out.println("Invalid operation. Please select a valid operation.");
            }
        }

        System.out.println("Your operations are over");
        scanner.close();
    }

    private static void insert(StringBuilder text, CustomStack<StringBuilder> undoStack, String insertText, int insertIndex) {
        undoStack.push(new StringBuilder(text));
        text.insert(insertIndex, insertText);
    }

    private static void delete(StringBuilder text, CustomStack<StringBuilder> undoStack, CustomQueue<StringBuilder> cutQueue, int deleteCount) {
    	//error handling
        if (deleteCount > text.length()) {
            System.out.println("Error: Cannot delete more characters than available.");
        } else {
            undoStack.push(new StringBuilder(text));
            //String cutText = text.substring(text.length() - deleteCount);
            //cutQueue.enqueue(new StringBuilder(cutText));
            text.delete(text.length() - deleteCount, text.length());
        }
    }

    private static void print(StringBuilder text) {
        System.out.println(text);
    }

    private static void undo(StringBuilder text, CustomStack<StringBuilder> undoStack) {
    	//error handling
        if (!undoStack.isEmpty()) {
            text.delete(0, text.length());
            text.append(undoStack.pop());
        } else {
            System.out.println("Error: No previous state to undo.");
        }
    }

    private static void cut(StringBuilder text, CustomQueue<StringBuilder> cutQueue, CustomStack<StringBuilder> undoStack, int cutCount) {
    	//error handling
        if (cutCount > text.length()) {
            System.out.println("Error: Cannot cut more characters than available.");
        } else {
            undoStack.push(new StringBuilder(text));
            String cutText = text.substring(text.length() - cutCount);
            cutQueue.enqueue(new StringBuilder(cutText));
            text.delete(text.length() - cutCount, text.length());
        }
    }

    private static void paste(StringBuilder text, CustomQueue<StringBuilder> cutQueue, CustomStack<StringBuilder> undoStack, int pasteIndex) {
    	//error handling
        if (!cutQueue.isEmpty()) {
            undoStack.push(new StringBuilder(text));
            StringBuilder cutText = cutQueue.dequeue();
            text.insert(pasteIndex, cutText);
        } else {
            System.out.println("Error: Nothing to paste.");
        }
    }
}
