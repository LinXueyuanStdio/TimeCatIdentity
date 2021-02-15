package com.timecat.identity.data.block

import androidx.annotation.IntDef
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.*

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-09-08
 * @description Block title: App name, content: "icon"
 * @usage null
 */
data class AppBlock(
    val url: String,
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
        fun fromJson(jsonObject: JSONObject): AppBlock {
            val url = jsonObject.getString("url")
            val structure = jsonObject.getJSONObject("structure")
            val mediaScope: JSONObject? = jsonObject.getJSONObject("mediaScope")
            val topicScope: JSONObject? = jsonObject.getJSONObject("topicScope")
            val atScope: JSONObject? = jsonObject.getJSONObject("atScope")
            val content: JSONObject? = jsonObject.getJSONObject("content")
            val header = jsonObject.getJSONObject("header")
            return AppBlock(
                url,
                structure,
                mediaScope?.let { AttachmentTail.fromJson(it) },
                topicScope?.let { TopicScope.fromJson(it) },
                atScope?.let { AtScope.fromJson(it) },
                content?.let { NoteBody.fromJson(it) },
                PageHeader.fromJson(header)
            )
        }
    }

    override fun toJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject["structure"] = structure
        jsonObject["url"] = url
        jsonObject["header"] = header.toJsonObject()
        content?.let { jsonObject["content"] = it.toJsonObject() }
        mediaScope?.let { jsonObject["mediaScope"] = it.toJsonObject() }
        topicScope?.let { jsonObject["topicScope"] = it.toJsonObject() }
        atScope?.let { jsonObject["atScope"] = it.toJsonObject() }
        return jsonObject
    }
}

data class UpdateInfo(
    val size: String = "",
    val version_name: String = "",
    val version_code: Int = 0,
    val download_url: String = "",
    /**
     * 更新信息
     */
    val updateInfo: String = "",
    /**
     * 更新时间
     */
    val lastUpdateTime: Long = 0L
) {
    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): UpdateInfo {
            val size = jsonObject.getString("size")
            val version_name = jsonObject.getString("version_name")
            val version_code = jsonObject.getInteger("version_code")
            val download_url = jsonObject.getString("download_url")
            val updateInfo = jsonObject.getString("updateInfo")
            val lastUpdateTime = jsonObject.getLong("lastUpdateTime")
            return UpdateInfo(
                size,
                version_name,
                version_code,
                download_url,
                updateInfo,
                lastUpdateTime
            )
        }
    }
}

@IntDef(
    APP_AndroidApp,
    APP_WebApp,
    APP_iOS,
    APP_Mac,
    APP_Linux,
    APP_Windows,
    APP_PluginManager,
    APP_Plugin
)
@Retention(AnnotationRetention.SOURCE)
annotation class AppType

const val BLOCK_APP_AndroidApp: Int = 10 // Android
const val BLOCK_APP_WebApp: Int = 11 // Web
const val BLOCK_APP_iOS: Int = 12 // iOS
const val BLOCK_APP_Mac: Int = 13 // Mac
const val BLOCK_APP_Linux: Int = 14 // Linux
const val BLOCK_APP_Windows: Int = 15 // Windows
const val BLOCK_APP_PluginManager: Int = 16 // plugin manager
const val BLOCK_APP_Plugin: Int = 17 // plugin

const val APP_AndroidApp: Int = BLOCK_APP_AndroidApp // Android
const val APP_WebApp: Int = BLOCK_APP_WebApp // Web
const val APP_iOS: Int = BLOCK_APP_iOS // iOS
const val APP_Mac: Int = BLOCK_APP_Mac // Mac
const val APP_Linux: Int = BLOCK_APP_Linux // Linux
const val APP_Windows: Int = BLOCK_APP_Windows // Windows
const val APP_PluginManager: Int = BLOCK_APP_PluginManager // plugin manager
const val APP_Plugin: Int = BLOCK_APP_Plugin // plugin

data class AndroidApp(
    /**
     * 应用包名
     */
    val packageName: String,
    /**
     * 最新版本
     */
    val latestVersion: String? = "",
    /**
     * 软件大小
     */
    val packageSize: String? = "",
    /**
     * 最小支持的ROM
     */
    val minROM: String? = "",
    /**
     * 更新信息
     */
    val updateInfo: String? = "",
    /**
     * 更新时间
     */
    val lastUpdateTime: Long = 0L,
) : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        j["packageName"] = packageName
        j["latestVersion"] = latestVersion
        j["packageSize"] = packageSize
        j["minROM"] = minROM
        j["updateInfo"] = updateInfo
        j["lastUpdateTime"] = lastUpdateTime
        return j
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): AndroidApp {
            val packageName = jsonObject.getString("packageName")
            val latestVersion = jsonObject.getString("latestVersion")
            val packageSize = jsonObject.getString("packageSize")
            val minROM = jsonObject.getString("minROM")
            val updateInfo = jsonObject.getString("updateInfo")
            val lastUpdateTime = jsonObject.getLong("lastUpdateTime")
            return AndroidApp(
                packageName,
                latestVersion,
                packageSize,
                minROM,
                updateInfo,
                lastUpdateTime
            )
        }
    }
}

class WebApp() : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        return j
    }

    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))
        fun fromJson(jsonObject: JSONObject): WebApp {
            return WebApp()
        }
    }
}

data class iOSApp(
    /**
     * 应用包名
     */
    val packageName: String,
    /**
     * 最新版本
     */
    val latestVersion: String? = "",
    /**
     * 软件大小
     */
    val packageSize: String? = "",
    /**
     * 更新信息
     */
    val updateInfo: String? = "",
    /**
     * 更新时间
     */
    val lastUpdateTime: Long = 0L,
) : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        j["packageName"] = packageName
        j["latestVersion"] = latestVersion
        j["packageSize"] = packageSize
        j["updateInfo"] = updateInfo
        j["lastUpdateTime"] = lastUpdateTime
        return j
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): iOSApp {
            val packageName = jsonObject.getString("packageName")
            val latestVersion = jsonObject.getString("latestVersion")
            val packageSize = jsonObject.getString("packageSize")
            val updateInfo = jsonObject.getString("updateInfo")
            val lastUpdateTime = jsonObject.getLong("lastUpdateTime")
            return iOSApp(
                packageName,
                latestVersion,
                packageSize,
                updateInfo,
                lastUpdateTime
            )
        }
    }
}

data class MacApp(
    /**
     * 应用包名
     */
    val packageName: String,
    /**
     * 最新版本
     */
    val latestVersion: String? = "",
    /**
     * 软件大小
     */
    val packageSize: String? = "",
    /**
     * 更新信息
     */
    val updateInfo: String? = "",
    /**
     * 更新时间
     */
    val lastUpdateTime: Long = 0L,
) : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        j["packageName"] = packageName
        j["latestVersion"] = latestVersion
        j["packageSize"] = packageSize
        j["updateInfo"] = updateInfo
        j["lastUpdateTime"] = lastUpdateTime
        return j
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): MacApp {
            val packageName = jsonObject.getString("packageName")
            val latestVersion = jsonObject.getString("latestVersion")
            val packageSize = jsonObject.getString("packageSize")
            val updateInfo = jsonObject.getString("updateInfo")
            val lastUpdateTime = jsonObject.getLong("lastUpdateTime")
            return MacApp(
                packageName,
                latestVersion,
                packageSize,
                updateInfo,
                lastUpdateTime
            )
        }
    }
}

data class LinuxApp(
    /**
     * 应用包名
     */
    val packageName: String,
    /**
     * 最新版本
     */
    val latestVersion: String? = "",
    /**
     * 软件大小
     */
    val packageSize: String? = "",
    /**
     * 更新信息
     */
    val updateInfo: String? = "",
    /**
     * 更新时间
     */
    val lastUpdateTime: Long = 0L,
) : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        j["packageName"] = packageName
        j["latestVersion"] = latestVersion
        j["packageSize"] = packageSize
        j["updateInfo"] = updateInfo
        j["lastUpdateTime"] = lastUpdateTime
        return j
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): LinuxApp {
            val packageName = jsonObject.getString("packageName")
            val latestVersion = jsonObject.getString("latestVersion")
            val packageSize = jsonObject.getString("packageSize")
            val updateInfo = jsonObject.getString("updateInfo")
            val lastUpdateTime = jsonObject.getLong("lastUpdateTime")
            return LinuxApp(
                packageName,
                latestVersion,
                packageSize,
                updateInfo,
                lastUpdateTime
            )
        }
    }
}

data class WindowsApp(
    /**
     * 应用包名
     */
    val packageName: String,
    /**
     * 最新版本
     */
    val latestVersion: String? = "",
    /**
     * 软件大小
     */
    val packageSize: String? = "",
    /**
     * 更新信息
     */
    val updateInfo: String? = "",
    /**
     * 更新时间
     */
    val lastUpdateTime: Long = 0L,
) : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        j["packageName"] = packageName
        j["latestVersion"] = latestVersion
        j["packageSize"] = packageSize
        j["updateInfo"] = updateInfo
        j["lastUpdateTime"] = lastUpdateTime
        return j
    }

    companion object {
        fun fromJson(json: String) =
            fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): WindowsApp {
            val packageName = jsonObject.getString("packageName")
            val latestVersion = jsonObject.getString("latestVersion")
            val packageSize = jsonObject.getString("packageSize")
            val updateInfo = jsonObject.getString("updateInfo")
            val lastUpdateTime = jsonObject.getLong("lastUpdateTime")
            return WindowsApp(
                packageName,
                latestVersion,
                packageSize,
                updateInfo,
                lastUpdateTime
            )
        }
    }
}