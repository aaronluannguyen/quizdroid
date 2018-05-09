package edu.wahingoton.nguyen51.quizdroid

import org.json.JSONException
import org.json.JSONObject

fun parse(json: String): JSONObject? {
    var jsonObj: JSONObject? = null
    try {
        jsonObj = JSONObject(json)
    } catch (e: JSONException) {
        e.printStackTrace()
    }
    return jsonObj
}
