package susc.s01.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Bukkit;
import susc.s01.Data.Log.Log;
import susc.s01.IOHandler.FileMap;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOHandler {

    public <E extends Log> ArrayList<E> importData(FileMap filePath, String affiliatedFunction, Class<E> logObj) {
        ArrayList<E> totalData = new ArrayList<>();

        try(FileReader reader = new FileReader(filePath.getFilePathInstance())) {
            totalData = new Gson().fromJson(reader, TypeToken.getParameterized(
                    ArrayList.class, logObj).getType());
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().info(affiliatedFunction + " Fail to ImportData");
        }

        Bukkit.getLogger().info(affiliatedFunction + " Success to ImportData");
        return totalData;
    }

    public <E extends Log> void exportData(FileMap filePath, String affiliatedFunction, ArrayList<E> totalDataValue) {
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
