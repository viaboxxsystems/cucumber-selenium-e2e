package utils

import java.io.IOException
import java.util.*


object UtilResources {

    private var properties: Properties? = null

    private fun loadProperties() {
        try {
            properties = Properties()
            properties?.load(ClassLoader.getSystemResourceAsStream("config.properties"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getProperties(properties: String): String {
        loadProperties()
        return UtilResources.properties?.getProperty(properties).toString()
    }

}