package src.repositories;

import src.utils.JsonHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Base repository class for all data repositories
 * Provides common CRUD operations
 */
public abstract class BaseRepository<T> {
    
    protected List<T> items;
    protected final String fileName;
    
    public BaseRepository(String fileName) {
        this.fileName = fileName;
        this.items = new ArrayList<>();
        load();
    }
    
    // Load data from JSON file
    @SuppressWarnings("unchecked")
    public void load() {
        List<T> loaded = JsonHandler.loadListFromFile(fileName, getType());
        this.items = loaded != null ? loaded : new ArrayList<>();
    }
    
    // Save data to JSON file
    public void save() {
        JsonHandler.saveListToFile(fileName, items);
    }
    
    // Get all items
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
    
    // Add an item
    public void add(T item) {
        items.add(item);
        save();
    }
    
    // Remove an item
    public void remove(T item) {
        items.remove(item);
        save();
    }
    
    // Clear all items
    public void clear() {
        items.clear();
        save();
    }
    
    // Get the class type (must be implemented by subclasses)
    protected abstract Class<T> getType();
}
