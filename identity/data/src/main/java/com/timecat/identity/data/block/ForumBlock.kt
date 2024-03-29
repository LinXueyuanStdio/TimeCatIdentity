package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/10/4
 * @description 论坛控制块
 * @usage null
 */
data class ForumBlock(
    val content: NoteBody = NoteBody(),
    val header: PageHeader? = null,
    /**
     * 话题域
     */
    val topicScope: TopicScope? = null,
    /**
     * @ 域
     */
    val atScope: AtScope? = null,
    /**
     * 媒体域
     */
    val mediaScope: AttachmentTail? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ForumBlock {
            val content = jsonObject.getJSONObject("content") ?: NoteBody().toJsonObject()
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val header: JSONObject? = jsonObject.getJSONObject("header")
            return ForumBlock(
                NoteBody.fromJson(content),
                header?.let { PageHeader.fromJson(it) },
                topicScope?.let { TopicScope.fromJson(it) },
                atScope?.let { AtScope.fromJson(it) },
                mediaScope?.let { AttachmentTail.fromJson(it) },
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["content"] = content.toJsonObject()
        mediaScope?.let { jsonObject["mediaScope"] = it.toJsonObject() }
        topicScope?.let { jsonObject["topicScope"] = it.toJsonObject() }
        atScope?.let { jsonObject["atScope"] = it.toJsonObject() }
        header?.let { jsonObject["header"] = it.toJsonObject() }
        return jsonObject
    }
}
