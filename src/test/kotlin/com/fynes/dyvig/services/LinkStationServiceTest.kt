package com.fynes.dyvig.services

import com.fynes.dyvig.model.Device
import com.fynes.dyvig.model.LinkStation
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class LinkStationServiceTest {

    val linkStationService : LinkStationService = LinkStationServiceImpl()


    //         var input = [ [0,0] , [100, 100] , [15,10] , [18, 18]];
    //         var linkStations = [[0, 0, 10], [20, 20, 5], [10, 0, 12]];
    /*
    *         var expectedOutput = ["Best link station for point 0,0 is 0,0 with power 100",
            "No link station within reach for point 100,100",
        "Best link station for point 15,10 is 10,0 with power 0.6718427000252355",
        "Best link station for point 18,18 is 20,20 with power 4.715728752538098"]
    * */
    @Test
    fun testLinkStationFinder(){
        val input : List<Device> = listOf(Device(0.0,0.0), Device(100.0, 100.0), Device(15.0,10.0), Device(18.0,18.0))
        val stations : List<LinkStation> = listOf(LinkStation(0.0, 0.0, 10.0, 0.0), LinkStation(20.0, 20.0, 5.0, 0.0), LinkStation(10.0, 0.0, 12.0, 0.0))

        val expectedOutput : Map<Device, LinkStation?> = mutableMapOf(
                Pair(Device(0.0,0.0), LinkStation(0.0, 0.0, 10.0, 100.0)),
                Pair(Device(100.0, 100.0), null),
                Pair(Device(15.0,10.0), LinkStation(10.0, 0.0, 12.0, 0.6718427000252355)),
                Pair(Device(18.0,18.0), LinkStation(20.0, 20.0, 5.0, 4.715728752538098))
                )

        val outputs: Map<Device, LinkStation?> = input.map {
            val station = linkStationService.findNearestStation(it, stations)

            it to station
        }.toMap()

        Assert.assertEquals(expectedOutput, outputs)
    }

}