/**
 * Description: A simple list model for storing and managing to-do items.
 * It supports adding, removing, editing, and formatting items for display.
 * 
 * @author Wonmin Song
 * @since 11/30/2025
 */

import java.util.ArrayList;

/**
 * The {@code TodoList} class represents a list of to-do items.
 * It provides methods to add, remove, edit, and display items.
 */
public class TodoList {

    /**
     * The internal list that stores the to-do items as {@code String} objects.
     */
    private ArrayList<String> items;

    /**
     * Constructs an empty {@code TodoList}.
     */
    public TodoList() {
        items = new ArrayList<String>();
    }

    /**
     * Adds a new item to the to-do list.
     *
     * @param item the description of the item to add
     * @throws IllegalArgumentException if {@code item} is null or empty
     */
    public void addItem(String item) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("Item description cannot be empty.");
        }
        items.add(item);
    }

    /**
     * Removes the item at the specified index from the list.
     *
     * @param index the zero-based index of the item to remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void removeItem(int index) {
        items.remove(index);
    }

    /**
     * Replaces the item at the specified index with a new description.
     *
     * @param index   the zero-based index of the item to edit
     * @param newItem the new description for the item
     * @throws IndexOutOfBoundsException if the index is out of range
     * @throws IllegalArgumentException  if {@code newItem} is null or empty
     */
    public void editItem(int index, String newItem) {
        if (newItem == null || newItem.trim().isEmpty()) {
            throw new IllegalArgumentException("New description cannot be empty.");
        }
        items.set(index, newItem);
    }

    /**
     * Returns the number of items currently stored in the list.
     *
     * @return the size of the to-do list
     */
    public int getSize() {
        return items.size();
    }

    /**
     * Returns the item at the specified index.
     *
     * @param index the zero-based index of the item to retrieve
     * @return the item at the given index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public String getItem(int index) {
        return items.get(index);
    }

    /**
     * Builds and returns a formatted {@code String} representation
     * of all items in the list, with each item on its own line and
     * prefixed by its number (starting from 1).
     * 
     * If the list is empty, a message "The to-do list is empty."
     * is returned instead.
     *
     * @return a formatted list of items, or a message if the list is empty
     */
    public String getFormattedList() {
        if (items.isEmpty()) {
            return "The to-do list is empty.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(i + 1)
              .append(". ")
              .append(items.get(i))
              .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
