#Text Editor:
This project is a text editor implemented using Java, leveraging data structures like stack and queue. It supports multiple functionalities including inserting text, inserting text at a specific index, deleting characters, cutting characters, and pasting cut characters at a current index.

#Features:
- Insert Text: Allows the user to insert text at a specified index.
- Delete Characters: Allows the user to delete a specified number of characters from the end.
- Print Text: Displays the current text.
- Undo: Reverts to the previous state of the text.
- Cut Characters: Allows the user to cut a specified number of characters from the end and store them in a clipboard.
- Paste Characters: Allows the user to paste the characters stored in the clipboard at a specified index.

#Algorithms Used:
- Stack: Used to implement undo functionality, allowing the user to revert to previous states.
- Queue: Used for handling cut and paste operations, allowing the user to store and retrieve cut text.

#Here's how you can use the different functionalities of the text editor:
- Insert Text:
Enter 1 for the insert operation.
Provide the text to insert and the index at which to insert it.
- Delete Characters:
Enter 2 for the delete operation.
Specify the number of characters to delete from the end of the text.
- Print Text:
Enter 3 to print the current text.
- Undo:
Enter 4 to undo the last operation.
- Cut Characters:
Enter 5 to cut characters.
Specify the number of characters to cut from the end of the text.
- Paste Characters:
Enter 6 to paste the last cut text.
Provide the index at which to paste the text.

#Contributing:
Contributions are welcome! Please open an issue or submit a pull request for any enhancements, bug fixes, or documentation improvements.

#Acknowledgements:
Stack Data Structure
Queue Data Structure
