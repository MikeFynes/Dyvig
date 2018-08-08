package com.fynes.dyvig.services

import com.fynes.dyvig.model.SlidingWindow
import java.io.BufferedReader
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class CsvReaderServiceImpl : CsvReaderService {
    override fun readCsvWithSlidingWindow(filePath: String, window: SlidingWindow, outputPath: String) {
        var line: String?

        val fileReader = BufferedReader(FileReader(filePath))

        var time = 0.0
        line = fileReader.readLine()
        while (line != null) {
            val trimmed = line.removeSuffix("\r\r")
            if(trimmed.isEmpty()){
                line = fileReader.readLine()
                continue
            }
            val value = trimmed.toDouble()


            window.addPoint(time, value)

            val median = window.getMedian()
            appendMedianToCsv(outputPath, median)
            time += 100.0
            line = fileReader.readLine()
        }

    }

    private fun appendMedianToCsv(filePath: String, value : Double){
        var fileWriter: FileWriter? = null
        try {
            fileWriter = FileWriter(filePath, true)
            val output = "$value\r\r"
            fileWriter.append(output)
        } catch (e: Exception) {
            println("Writing CSV error!")
            e.printStackTrace()
        } finally {
            try {
                fileWriter!!.flush()
                fileWriter.close()
            } catch (e: IOException) {
                println("Flushing/closing error!")
                e.printStackTrace()
            }
        }
    }
}