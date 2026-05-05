package src.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHandler {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // SAVE
    public static <T> void saveToFile(String fileName, T data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // READ SINGLE OBJECT
    public static <T> T loadFromFile(String fileName, Class<T> clazz) {
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            return null;
        }
    }

    // READ LIST (IMPORTANT)
    public static <T> List<T> loadListFromFile(String fileName, Type type) {
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return null;
        }
    }

    // ========== Added for Backend Core ==========
    
    private static final String DATA_DIR = "src/main/resources/data/";

    // Ensure data directory exists
    public static void ensureDataDirectoryExists() {
        java.io.File dir = new java.io.File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // Save list to file (for repositories)
    public static <T> void saveListToFile(String fileName, List<T> data) {
        ensureDataDirectoryExists();
        String fullPath = DATA_DIR + fileName;
        try (FileWriter writer = new FileWriter(fullPath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load list from file with Class type (easier for repositories)
    public static <T> List<T> loadListFromFile(String fileName, Class<T> classType) {
        ensureDataDirectoryExists();
        String fullPath = DATA_DIR + fileName;
        java.io.File file = new java.io.File(fullPath);
        if (!file.exists()) {
            return new java.util.ArrayList<>();
        }
        try (FileReader reader = new FileReader(fullPath)) {
            Type type = TypeToken.getParameterized(List.class, classType).getType();
            List<T> result = gson.fromJson(reader, type);
            return result != null ? result : new java.util.ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }
}
