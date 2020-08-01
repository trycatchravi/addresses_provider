package com.address.provider

import com.google.gson.JsonObject
import org.junit.Assert.assertEquals
import org.junit.Test

class AddressProviderTest {

    @Test
    fun addressProviderExample1() {
        val jsonObject = JsonObject()
        jsonObject.addProperty("street", "Blaufeldweg")
        jsonObject.addProperty("housenumber", "123B")
        assertEquals(AddressProvider().addressProvider("Blaufeldweg 123B"), jsonObject.toString())
    }

    @Test
    fun addressProviderExample2() {
        val jsonObject = JsonObject()
        jsonObject.addProperty("street", "Auf der Vogelwiese")
        jsonObject.addProperty("housenumber", "23 b")
        assertEquals(AddressProvider().addressProvider("Auf der Vogelwiese 23 b"), jsonObject.toString())
    }

    @Test
    fun addressProviderExample3() {
        val jsonObject = JsonObject()
        jsonObject.addProperty("street", "rue de la revolution")
        jsonObject.addProperty("housenumber", "4")
        assertEquals(AddressProvider().addressProvider("4, rue de la revolution"), jsonObject.toString())
    }

    @Test
    fun addressProviderFormatType4() {
        val jsonObject = JsonObject()
        jsonObject.addProperty("street", "Calle 39")
        jsonObject.addProperty("housenumber", "No 1540")
        assertEquals(AddressProvider().addressProvider("Calle 39 No 1540"), jsonObject.toString())
    }

    @Test
    fun addressProviderEmptyAddressLine() {
        assertEquals(AddressProvider().addressProvider(""), "Address Line is empty")
    }
}