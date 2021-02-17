package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*
import com.timecat.identity.data.getRewardList

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/2/5
 * @description null
 * @usage null
 */
data class ItemBlock(
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
        fun fromJson(jsonObject: JSONObject): ItemBlock {
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val content: JSONObject? = jsonObject.getJSONObject("content")
            val header = jsonObject.getJSONObject("header") ?: PageHeader().toJsonObject()
            val structure = jsonObject.getJSONObject("structure")
            return ItemBlock(
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
 * 物产
 */
data class ThingItemBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): BuffItemBlock {
            val type = jsonObject.getInteger("type")
            return BuffItemBlock(
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

/**
 * 礼包
 */
data class PackageItemBlock(
    val items: List<Reward>,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): PackageItemBlock {
            val items = jsonObject.getRewardList("items")
            return PackageItemBlock(
                items,
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["items"] = items
        return jsonObject
    }
}

/**
 * 数值
 */
data class DataItemBlock(
    val tableName: String,
    val where: String,
    val num: Long = 0,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): DataItemBlock {
            val tableName = jsonObject.getString("tableName")
            val where = jsonObject.getString("where")
            val num = jsonObject.getLong("num")
            return DataItemBlock(
                tableName, where, num,
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["tableName"] = tableName
        jsonObject["where"] = where
        jsonObject["num"] = num
        return jsonObject
    }
}


/**
 * 装备
 */
data class EquipItemBlock(
    val type: Int? = 0,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): EquipItemBlock {
            val type = jsonObject.getInteger("type")
            return EquipItemBlock(
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


/**
 * Buff
 */
data class BuffItemBlock(
    val type: Int = 0,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): BuffItemBlock {
            val type = jsonObject.getIntValue("type")
            return BuffItemBlock(
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


/**
 * 方块
 */
data class CubeItemBlock(
    val uuid: String,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): CubeItemBlock {
            val uuid = jsonObject.getString("uuid")
            return CubeItemBlock(
                uuid
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["uuid"] = uuid
        return jsonObject
    }
}
