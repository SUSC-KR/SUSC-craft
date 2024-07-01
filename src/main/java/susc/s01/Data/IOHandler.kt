package susc.s01.Data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.bukkit.Bukkit
import susc.s01.Data.Log.Log
import susc.s01.IOHandler.FileMap
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class IOHandler {
    fun <E : Log?> importData(filePath: FileMap, affiliatedFunction: String): ArrayList<E> {
        var totalData = ArrayList<E>()

        try {
            FileReader(filePath.filePathInstance).use { reader ->
                totalData = Gson().fromJson(
                    reader, TypeToken.getParameterized(
                        ArrayList::class.java, filePath.fileInstanceType
                    ).type
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Bukkit.getLogger().info("$affiliatedFunction Fail to ImportData")
        }

        Bukkit.getLogger().info("$affiliatedFunction Success to ImportData")
        return totalData
    }

    fun <E : Log?> exportData(filePath: FileMap, affiliatedFunction: String, totalDataValue: ArrayList<E>?) {
        try {
            FileWriter(filePath.filePathInstance).use { writer ->
                GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(totalDataValue, writer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Bukkit.getLogger().info("$affiliatedFunction Fail to ExportData")
        }

        Bukkit.getLogger().info("$affiliatedFunction Success to ExportData")
    }
}
