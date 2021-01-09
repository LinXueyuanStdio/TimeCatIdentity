package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.IJson
import com.timecat.identity.data.getStringList
import java.io.Serializable

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-09-07
 * @description 使用 child 字段实现 list
 * @usage null
 */
class ListBlock(
    val list: MutableList<String> = mutableListOf()
) : IJson, Serializable {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ListBlock {
            val list = jsonObject.getStringList("list")
            return ListBlock(list)
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        val jsonArray = JSONArray()
        jsonArray.addAll(list)
        jsonObject["list"] = jsonArray
        return jsonObject
    }
}