package susc.s01.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Bukkit;
import susc.s01.IOHandler.FilePathMap;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOHandler<E> {

    public ArrayList<E> importData(FilePathMap filePath, String affiliatedFunction) {
        ArrayList<E> totalData = new ArrayList<>();

        try(FileReader reader = new FileReader(filePath.getFilePathInstance())) {
            totalData = new Gson().fromJson(reader, new TypeToken<ArrayList<E>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().info(affiliatedFunction + " Fail to ImportData");
        }

        Bukkit.getLogger().info(affiliatedFunction + " Success to ImportData");
        return totalData;
    }

    public void exportData(FilePathMap filePath, String affiliatedFunction,  ArrayList<E> totalDataValue) {
        try (FileWriter writer = new FileWriter(filePath.getFilePathInstance())) {
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(totalDataValue,writer);

        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().info(affiliatedFunction + " Fail to ExportData");
        }

        Bukkit.getLogger().info(affiliatedFunction + " Success to ExportData");
    }
}
