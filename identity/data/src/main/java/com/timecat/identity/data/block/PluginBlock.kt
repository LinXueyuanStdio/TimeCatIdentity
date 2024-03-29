package com.timecat.identity.data.block

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.base.IJson
import com.timecat.identity.data.getStringList
import com.timecat.identity.data.getUpdateInfoList

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/4/15
 * @description 插件
 * @usage null
 */
data class PluginApp(
    var packageName: String = "",
    /**
     * 开发者
     */
    var developer: String = "",
    var partKey: String = "",
    /**
     * 开源地址
     */
    var openSourceUrl: String = "",
    /**
     * 历次更新的版本信息
     * 每次更新都要修改一次，需要保持历史
     */
    var updateInfo: MutableList<UpdateInfo> = mutableListOf(),
    /**
     * 提供的 Activity 列表
     * 每一项是 Activity 的完整名字
     */
    var activity_class_names: MutableList<String> = mutableListOf(),
    /**
     * 提供的 Service 列表
     * 每一项是 Service 的完整名字
     */
    var service_class_names: MutableList<String> = mutableListOf()
) : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        j["packageName"] = packageName
        j["developer"] = developer
        j["openSourceUrl"] = openSourceUrl
        j["partKey"] = partKey
        j["updateInfo"] = updateInfo
        j["activity_class_names"] = activity_class_names
        j["service_class_names"] = service_class_names
        return j
    }

    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): PluginApp {
            val packageName = jsonObject.getString("packageName")
            val developer = jsonObject.getString("developer")
            val openSourceUrl = jsonObject.getString("openSourceUrl")
            val partKey = jsonObject.getString("partKey")
            val updateInfo = jsonObject.getUpdateInfoList("updateInfo")
            val activity_class_names = jsonObject.getStringList("activity_class_names")
            val service_class_names = jsonObject.getStringList("service_class_names")
            return PluginApp(
                packageName,
                developer,
                partKey,
                openSourceUrl,
                updateInfo,
                activity_class_names,
                service_class_names
            )
        }
    }
}
