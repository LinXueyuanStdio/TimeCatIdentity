package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*
import com.timecat.identity.data.block.type.ActivityType

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/2/6
 * @description 活动
 * 决定task的组织形式：列表、双线、回归、梦境、翻页书、大富翁玩法等等
 * @usage null
 */

data class ActivityBlock(
    @ActivityType
    val type: Int,
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
        fun fromJson(jsonObject: JSONObject): ActivityBlock {
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val content = jsonObject.getJSONObject("content")
            val header = jsonObject.getJSONObject("header") ?: PageHeader().toJsonObject()
            val type = jsonObject.getInteger("type")
            val structure = jsonObject.getJSONObject("structure")
            return ActivityBlock(
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
 * 外链
 */
data class ActivityUrlBlock(
    val url: String,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityUrlBlock {
            val url = jsonObject.getString("url")
            return ActivityUrlBlock(
                url
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["url"] = url
        return jsonObject
    }
}

/**
 * 玩家自定义活动和任务
 */
data class ActivityCustomBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityCustomBlock {
            val type = jsonObject.getInteger("type")
            return ActivityCustomBlock(
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
 * 梦境，高价值目标，时间较长
 */
data class ActivityDreamBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityDreamBlock {
            val type = jsonObject.getInteger("type")
            return ActivityDreamBlock(
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
 * 双线，月任务，时间较长
 */
data class ActivityDoubleBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityDoubleBlock {
            val type = jsonObject.getInteger("type")
            return ActivityDoubleBlock(
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
 * 卡池
 */
data class ActivityCardBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityCardBlock {
            val type = jsonObject.getInteger("type")
            return ActivityCardBlock(
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
 * 悬赏，由第三方或官方虚拟发起
 */
data class ActivityPriceBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityPriceBlock {
            val type = jsonObject.getInteger("type")
            return ActivityPriceBlock(
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
 * 成长、生涯
 */
data class ActivityLifeBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityLifeBlock {
            val type = jsonObject.getInteger("type")
            return ActivityLifeBlock(
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
 * 成就
 */
data class ActivityAchievementBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityAchievementBlock {
            val type = jsonObject.getInteger("type")
            return ActivityAchievementBlock(
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
 * 回归
 */
data class ActivityGet_backBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityGet_backBlock {
            val type = jsonObject.getInteger("type")
            return ActivityGet_backBlock(
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
 * 7日签到
 */
data class ActivitySevenDaySignBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivitySevenDaySignBlock {
            val type = jsonObject.getInteger("type")
            return ActivitySevenDaySignBlock(
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
 * 每日系列任务
 */
data class ActivityEverydayMainBlock(
    val type: Int? = null,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityEverydayMainBlock {
            val type = jsonObject.getInteger("type")
            return ActivityEverydayMainBlock(
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
 * 一张图片，一个任务
 */
data class ActivityOneTaskBlock(
    val taskId: String,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): ActivityOneTaskBlock {
            val taskId = jsonObject.getString("taskId")
            return ActivityOneTaskBlock(
                taskId
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["taskId"] = taskId
        return jsonObject
    }
}
