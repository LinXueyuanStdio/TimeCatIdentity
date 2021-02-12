package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*
import com.timecat.identity.data.block.type.TaskType
import com.timecat.identity.data.getRewardList
import com.timecat.identity.data.getTaskRuleList

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/2/6
 * @description null
 * @usage null
 */
data class TaskBlock(
    @TaskType
    val type: Int,
    val structure: String,
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
    val rewards: List<Reward> = mutableListOf(),
    val header: PageHeader = PageHeader()
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): TaskBlock {
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val content = jsonObject.getJSONObject("content")
            val header = jsonObject.getJSONObject("header") ?: PageHeader().toJsonObject()
            val type = jsonObject.getInteger("type")
            val structure = jsonObject.getString("structure")
            val rewards = jsonObject.getRewardList("rewards")
            return TaskBlock(
                type, structure,
                mediaScope?.let { AttachmentTail.fromJson(it) },
                topicScope?.let { TopicScope.fromJson(it) },
                atScope?.let { AtScope.fromJson(it) },
                content?.let { NoteBody.fromJson(it) },
                rewards,
                PageHeader.fromJson(header),
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["type"] = type
        jsonObject["structure"] = structure
        jsonObject["rewards"] = rewards
        jsonObject["header"] = header.toJsonObject()
        content?.let { jsonObject["content"] = it.toJsonObject() }
        mediaScope?.let { jsonObject["mediaScope"] = it.toJsonObject() }
        topicScope?.let { jsonObject["topicScope"] = it.toJsonObject() }
        atScope?.let { jsonObject["atScope"] = it.toJsonObject() }
        return jsonObject
    }
}

/**
 * 剧情任务
 */
data class TaskStoryBlock(
    val storyId: String,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): TaskStoryBlock {
            val storyId = jsonObject.getString("storyId")
            return TaskStoryBlock(
                storyId
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["storyId"] = storyId
        return jsonObject
    }
}


data class TaskRule(
    val where: String,
    val targetCount: Long,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): TaskRule {
            val where = jsonObject.getString("where")
            val targetCount = jsonObject.getLongValue("targetCount")
            return TaskRule(
                where, targetCount
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["where"] = where
        jsonObject["targetCount"] = targetCount
        return jsonObject
    }
}
data class Reward(
    val uuid: String,
    val count: Long,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): Reward {
            val uuid = jsonObject.getString("uuid")
            val count = jsonObject.getLongValue("count")
            return Reward(
                uuid, count
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["uuid"] = uuid
        jsonObject["count"] = count
        return jsonObject
    }
}
/**
 * 统计数据任务，如：登录0/1，战斗2／5，胜利3／7
 */
data class TaskDataBlock(
    val rules: List<TaskRule>,
) : IJson {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): TaskDataBlock {
            val rules = jsonObject.getTaskRuleList("rules")
            return TaskDataBlock(
                rules
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["rules"] = rules
        return jsonObject
    }
}


