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
data class SkinApp(
    var packageName: String = "",
    /**
     * 开发者
     */
    var developer: String = "",
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
     * 提供的 皮肤图片 列表
     * 每一项是 皮肤图片url
     */
    var imageList: MutableList<String> = mutableListOf(),
) : IJson {
    override fun toJsonObject(): JSONObject {
        val j = JSONObject()
        j["packageName"] = packageName
        j["developer"] = developer
        j["openSourceUrl"] = openSourceUrl
        j["updateInfo"] = updateInfo
        j["imageList"] = imageList
        return j
    }

    companion object {
        fun fromJson(json: String) = fromJson(JSON.parseObject(json))

        fun fromJson(jsonObject: JSONObject): SkinApp {
            val packageName = jsonObject.getString("packageName")
            val developer = jsonObject.getString("developer")
            val openSourceUrl = jsonObject.getString("openSourceUrl")
            val updateInfo = jsonObject.getUpdateInfoList("updateInfo")
            val imageList = jsonObject.getStringList("imageList")
            return SkinApp(
                packageName,
                developer,
                openSourceUrl,
                updateInfo,
                imageList,
            )
        }
    }
}
