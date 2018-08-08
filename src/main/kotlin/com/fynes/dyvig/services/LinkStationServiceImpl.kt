package com.fynes.dyvig.services

import com.fynes.dyvig.model.Device
import com.fynes.dyvig.model.LinkStation
import  kotlin.math.*

class LinkStationServiceImpl : LinkStationService {

    override fun findNearestStation(device: Device, linkStations: List<LinkStation>): LinkStation? {
        var bestLinkStation : LinkStation? = null
        linkStations.forEach {
            val distance = sqrt((it.x - device.x).pow(2) + (it.y - device.y).pow(2))

           it.power = if (it.reach >= distance)  (it.reach - distance).pow(2)  else 0.0

            if (bestLinkStation != null) {
                if (it.power > bestLinkStation!!.power) {
                    bestLinkStation = it
                }

            } else {
                bestLinkStation = it
            }
        }

        if (bestLinkStation!!.power == 0.0) return null

        return bestLinkStation!!.copy()
    }
}