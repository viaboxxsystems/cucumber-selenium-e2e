package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.BrowserType
import java.io.FileInputStream
import java.io.IOException
import java.util.*


object UtilResources {

    private var properties: Properties? = null

    fun loadProperties() {
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