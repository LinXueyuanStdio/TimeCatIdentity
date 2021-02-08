package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*
import com.timecat.identity.data.block.type.IDENTITY_Base
import com.timecat.identity.data.block.type.IdentityType

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/2/5
 * @description null
 * @usage null
 */
data class IdentityBlock(
    @IdentityType
    val type: Int = IDENTITY_Base,
    val structure: String = "",
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
        fun fromJson(jsonObject: JSONObject): IdentityBlock {
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val content = jsonObject.getJSONObject("content")
            val header = jsonObject.getJSONObject("header") ?: PageHeader().toJsonObject()
            val type = jsonObject.getInteger("type")
            val structure = jsonObject.getString("structure")
            return IdentityBlock(
                type, structure,
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
        jsonObject["type"] = type
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
 * 方块，可养成
 */
data class CubeBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): CubeBlock {
            val type = jsonObject.getInteger("type")
            return CubeBlock(
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