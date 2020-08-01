package com.address.provider

import com.google.gson.JsonObject

class AddressProvider {

    fun addressProvider(addressLine: String?): String? {
        if (addressLine != null && !addressLine.isEmpty()) {
            var housenumber: String
            val strArr: Array<String> = addressLine.split(" ").toTypedArray()
            if (Character.isDigit(addressLine[0])) {
                housenumber = strArr[0]
                return getStreetAndJsonString(addressLine, housenumber)
            }
            housenumber = strArr[strArr.size - 2] + " " + strArr[strArr.size - 1]
            return if (housenumber.matches(Regex("No\\s\\d+")) || Character.isDigit(housenumber[0])) {
                getStreetAndJsonString(addressLine, housenumber)
            } else if (Character.isDigit(strArr[strArr.size - 1][0])) {
                housenumber = strArr[strArr.size - 1]
                getStreetAndJsonString(addressLine, housenumber)
            } else {
                "Not Found"
            }
        }
        return "Address Line is empty"
    }

    private fun getStreetAndJsonString(addressLine: String, housenumber: String): String? {
        val jsonObject = JsonObject()
        val street: String
        street = addressLine.replace(housenumber.toRegex(), " ")
        jsonObject.addProperty("street", street.trim { it <= ' ' })
        jsonObject.addProperty("housenumber", housenumber.replace(",".toRegex(), ""))
        println(jsonObject.toString())
        return jsonObject.toString()
    }

}