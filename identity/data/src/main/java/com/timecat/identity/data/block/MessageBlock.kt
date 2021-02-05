package com.timecat.identity.data.block

import androidx.annotation.IntDef
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-09-07
 * @description null
 * @usage null
 */
//region 高级结构：消息、私信
data class MessageBlock(val message: String)


@IntDef(
    BLOCK_FILE,
    BLOCK_WEB,
    BLOCK_TEXT,
    BLOCK_IMAGE,
    BLOCK_VIDEO,
    BLOCK_LOCATION,
    BLOCK_VOICE,
    BLOCK_CMD,
    BLOCK_CALL,
    BLOCK_BIG_EMOTION,
    BLOCK_MAIL
)
@Retention(AnnotationRetention.SOURCE)
annotation class MessageType


const val BLOCK_FILE: Int = 0 // 文件 url
const val BLOCK_WEB: Int = 1 // 网页 url
const val BLOCK_TEXT: Int = 2 // 简单文本块
const val BLOCK_IMAGE: Int = 3 // 图片文件
const val BLOCK_VIDEO: Int = 4 // 视频文件
const val BLOCK_LOCATION: Int = 5 // 地理位置
const val BLOCK_VOICE: Int = 6 // 语音文件
const val BLOCK_CMD: Int = 7 // 控制型消息
const val BLOCK_CALL: Int = 8 // 打电话
const val BLOCK_BIG_EMOTION: Int = 9 // 表情包
const val BLOCK_MAIL: Int = 10 // 表情包
//endregion


data class MailBlock(
    val type: Int = 0,
    val structure: String? = null,
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
            val content = jsonObject.getJSONObject("content")
            val header = jsonObject.getJSONObject("header") ?: PageHeader().toJsonObject()
            val type = jsonObject.getInteger("type")
            val structure = jsonObject.getString("structure")
            return ItemBlock(
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