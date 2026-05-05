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
}