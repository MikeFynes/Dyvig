package com.fynes.dyvig.services

import com.fynes.dyvig.model.SlidingWindow

interface CsvReaderService {

    fun readCsvWithSlidingWindow(filePath : String, window : SlidingWindow, outputPath : String)
}