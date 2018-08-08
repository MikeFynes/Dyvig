package com.fynes.dyvig.services

import com.fynes.dyvig.model.Device
import com.fynes.dyvig.model.LinkStation


interface LinkStationService {

    fun findNearestStation(device : Device, linkStations : List<LinkStation>) : LinkStation?

}