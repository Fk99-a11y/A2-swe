import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class ExpenseRepository {

    private String filePath = "data/expenses.json";
    private Gson gson = new Gson();

    public List<Expense> loadAll() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(file));

            Type type = new TypeToken<List<Expense>>(){}.getType();

            List<Expense> list = gson.fromJson(br, type);

            br.close();

            return list != null ? list : new ArrayList<>();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void save(Expense e) {
        try {
            List<Expense> list = loadAll();
            list.add(e);

            FileWriter writer = new FileWriter(filePath);
            gson.toJson(list, writer);

            writer.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
