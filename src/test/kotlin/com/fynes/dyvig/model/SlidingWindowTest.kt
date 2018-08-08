package com.fynes.dyvig.model

import org.junit.Assert
import org.junit.Test

class SlidingWindowTest {

    /*
    *
    * var expected = []int{-1, 101, 101, 102, 110, 115}
	* var time = []int{100, 200, 300, 400, 500, 600}
	* var input = []int{100, 102, 101, 110, 120, 115}
    * */

    @Test
    fun testSlidingWindow()
    {
        val expected = arrayListOf<Double>(-1.0, 101.0, 101.0, 102.0, 110.0, 115.0)
        val times = arrayListOf<Double>(100.0, 200.0, 300.0, 400.0, 500.0, 600.0)
        val input = arrayListOf<Double>(100.0, 102.0, 101.0, 110.0, 120.0, 115.0)


        val output = mutableListOf<Double>()
        val slidingWindow = SlidingWindow(3, 25000)

        for ((index, it) in input.withIndex()) {
            slidingWindow.addPoint(times[index], it)
            output.add(slidingWindow.getMedian())
        }

        Assert.assertEquals(expected, output)

    }
}