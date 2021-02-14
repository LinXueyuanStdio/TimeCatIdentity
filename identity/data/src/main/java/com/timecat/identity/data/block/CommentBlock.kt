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
//region 高级结构：评论
// 评论
data class CommentBlock(
    val structure: JSONObject = JSONObject(),
    val content: NoteBody? = null,
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
    /**
     * 地域
     */
    val posScope: PosScope? = null
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): CommentBlock {
            val structure = jsonObject.getJSONObject("structure")
            val content: JSONObject? = jsonObject.getJSONObject("content")
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val posScope: JSONObject? = jsonObject.getJSONObject("posScope")
            return CommentBlock(
                structure,
                content?.let { NoteBody.fromJson(it) },
                mediaScope?.let { AttachmentTail.fromJson(it) },
                topicScope?.let { TopicScope.fromJson(it) },
                atScope?.let { AtScope.fromJson(it) },
                posScope?.let { PosScope.fromJson(it) },
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["structure"] = structure
        content?.let { jsonObject["content"] = it.toJsonObject() }
        mediaScope?.let { jsonObject["mediaScope"] = it.toJsonObject() }
        topicScope?.let { jsonObject["topicScope"] = it.toJsonObject() }
        atScope?.let { jsonObject["atScope"] = it.toJsonObject() }
        posScope?.let { jsonObject["posScope"] = it.toJsonObject() }
        return jsonObject
    }
}

@IntDef(
    COMMENT_SIMPLE,
    COMMENT_REPLY,
    COMMENT_SCORE,
    COMMENT_TEXT,
    COMMENT_VIDEO
)
@Retention(AnnotationRetention.SOURCE)
annotation class CommentType

//评论的子类
const val COMMENT_SIMPLE: Int = 0 // 普通评论
const val COMMENT_REPLY: Int = 1 // 回复
const val COMMENT_SCORE: Int = 2 // 评分
const val COMMENT_TEXT: Int = 3 // 划线、本章说
const val COMMENT_VIDEO: Int = 4 // 弹幕

// 普通评论或回复
class SimpleComment() : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): SimpleComment {
            return SimpleComment()
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        return jsonObject
    }
}

// 长评+评分
data class ScoreComment(
    val score: Int
) : IJson {
    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["score"] = score
        return jsonObject
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): ScoreComment {
            val score = jsonObject.getInteger("score")
            return ScoreComment(
                score
            )
        }
    }
}

// 划线、本章说
data class TextComment(
    val from: Int,
    val to: Int,
    val content: String
) : IJson {
    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["from"] = from
        jsonObject["to"] = to
        jsonObject["content"] = content
        return jsonObject
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): TextComment {
            val from = jsonObject.getInteger("from")
            val to = jsonObject.getInteger("to")
            val content = jsonObject.getString("content")
            return TextComment(
                from,
                to,
                content
            )
        }
    }
}

// 弹幕
data class VideoComment(
    val theme: Int,
    val begin: Long,
    val content: String
) : IJson {
    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["theme"] = theme
        jsonObject["begin"] = begin
        jsonObject["content"] = content
        return jsonObject
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): VideoComment {
            val theme = jsonObject.getInteger("theme")
            val begin = jsonObject.getLong("begin")
            val content = jsonObject.getString("content")
            return VideoComment(
                theme,
                begin,
                content
            )
        }
    }
}
//endregion