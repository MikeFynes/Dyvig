package com.fynes.dyvig.model

class SlidingWindow(val size: Int, val timeDiffMax: Int) {
    var times: MutableList<Double> = mutableListOf()
    var values: MutableList<Double> = mutableListOf()

    private fun slideWindow() {
        if(times.size < 1 || values.size < 1){
            throw RuntimeException("Cant slide an empty window!")
        }

        times = times.subList(1, times.size)
        values = values.subList(1, values.size)
    }

    //    for len(w.times) > 0 && time - w.times[0] > w.timeDiffMax {
    fun addPoint(time: Double, value: Double) {
        // check if its time to slide
        while (times.isNotEmpty() && time - this.times.first() > this.timeDiffMax) {
            slideWindow()
        }

        // in some cases we will simply slide because we have too much data in the window
        if(times.size == size){
            slideWindow()
        }

        times.add(time)
        values.add(value)
    }

    fun getMedian() : Double {
        val sortedValues = mutableListOf<Double>()

        sortedValues.addAll(values)
        sortedValues.sort()

        return when {
            sortedValues.size == 1 -> -1.0
            sortedValues.size % 2 != 0 -> sortedValues[(sortedValues.size +1) / 2 -1]
            else -> (sortedValues[sortedValues.size /2 -1] + sortedValues[sortedValues.size / 2 ]) / 2
        }
    }
}



