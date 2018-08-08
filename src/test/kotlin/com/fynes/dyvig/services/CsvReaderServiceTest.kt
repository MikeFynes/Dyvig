package com.fynes.dyvig.services

import com.fynes.dyvig.model.SlidingWindow
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths

class CsvReaderServiceTest {

    private val csvReaderService = CsvReaderServiceImpl()


    @Test
    fun readCsvWithSlidingWindowTestShort(){
        val slidingWindow = SlidingWindow(5, 25000)

        val input = this.javaClass.getResource("/test1-short.csv").path

        val output = "output1.csv"
        if(Files.exists(Paths.get(output))) Files.delete(Paths.get(output))
        csvReaderService.readCsvWithSlidingWindow(input, slidingWindow, output)
    }

    @Test
    fun readCsvWithSlidingWindowTestMedium(){
        val slidingWindow = SlidingWindow(5, 25000)

        val input = this.javaClass.getResource("/test2-medium.csv").path

        val output = "output2.csv"
        if(Files.exists(Paths.get(output))) Files.delete(Paths.get(output))
        csvReaderService.readCsvWithSlidingWindow(input, slidingWindow, output)
    }

    @Test
    fun readCsvWithSlidingWindowTestLong(){
        val slidingWindow = SlidingWindow(5, 25000)

        val input = this.javaClass.getResource("/test3-long.csv").path

        val output = "output3.csv"
        if(Files.exists(Paths.get(output))) Files.delete(Paths.get(output))
        csvReaderService.readCsvWithSlidingWindow(input, slidingWindow, output)
    }


}