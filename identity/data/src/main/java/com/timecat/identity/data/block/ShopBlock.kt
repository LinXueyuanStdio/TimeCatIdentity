package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*
import com.timecat.identity.data.getGoodList

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

data class Good(
    var itemId: String,
    var value: Long,
    var max: Int,
) {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): Good {
            val itemId = jsonObject.getString("itemId")
            val value = jsonObject.getLong("value")
            val max = jsonObject.getInteger("max")
            return Good(
                itemId,
                value,
                max,
            )
        }
    }
}

/**
 * 基础
 */
data class BasicShopBlock(
    val moneyId: String,
    val goods: List<Good>
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): BasicShopBlock {
            val money = jsonObject.getString("moneyId")
            val goods = jsonObject.getGoodList("goods")
            return BasicShopBlock(
                money,
                goods
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["moneyId"] = moneyId
        jsonObject["goods"] = goods
        return jsonObject
    }
}
