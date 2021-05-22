package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*
import com.timecat.identity.data.getStringList
import com.timecat.identity.data.getUpdateInfoList

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-09-05
 * @description null
 * @usage null
 */
data class ShopBlock(
    val structure: JSONObject,
    /**
     * 媒体域
     */
    val mediaScope: AttachmentTail? = null,
    /**
     * 话题域
     */
    val topicScope: TopicScope? = null,
    /**
     * @ 域
     */
    val atScope: AtScope? = null,
    val content: NoteBody? = null,
    val header: PageHeader = PageHeader()
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ShopBlock {
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val content: JSONObject? = jsonObject.getJSONObject("content")
            val header = jsonObject.getJSONObject("header") ?: PageHeader().toJsonObject()
            val structure = jsonObject.getJSONObject("structure")
            return ShopBlock(
                structure,
                mediaScope?.let { AttachmentTail.fromJson(it) },
                topicScope?.let { TopicScope.fromJson(it) },
                atScope?.let { AtScope.fromJson(it) },
                content?.let { NoteBody.fromJson(it) },
                PageHeader.fromJson(header),
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["structure"] = structure
        jsonObject["header"] = header.toJsonObject()
        content?.let { jsonObject["content"] = it.toJsonObject() }
        mediaScope?.let { jsonObject["mediaScope"] = it.toJsonObject() }
        topicScope?.let { jsonObject["topicScope"] = it.toJsonObject() }
        atScope?.let { jsonObject["atScope"] = it.toJsonObject() }
        return jsonObject
    }
}

/**
 * 基础
 */
data class BasicShopBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): BasicShopBlock {
            val type = jsonObject.getInteger("type")
            return BasicShopBlock(
                type
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["type"] = type
        return jsonObject
    }
}
