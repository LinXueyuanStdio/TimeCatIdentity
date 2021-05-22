package com.timecat.identity.data

import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.timecat.identity.data.block.Good
import com.timecat.identity.data.block.Reward
import com.timecat.identity.data.block.TaskRule
import com.timecat.identity.data.block.UpdateInfo

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-09-08
 * @description null
 * @usage null
 */
fun JSONObject.getUpdateInfoList(key: String): MutableList<UpdateInfo> {
    return getJSONArray(key)?.toUpdateInfoList() ?: mutableListOf()
}

fun JSONObject.getStringList(key: String): MutableList<String> {
    return getJSONArray(key)?.toListString() ?: mutableListOf()
}

fun JSONObject.getGoodList(key: String): MutableList<Good> {
    return getJSONArray(key)?.toGoodList() ?: mutableListOf()
}
fun JSONObject.getTaskRuleList(key: String): MutableList<TaskRule> {
    return getJSONArray(key)?.toTaskRuleList() ?: mutableListOf()
}
fun JSONObject.getRewardList(key: String): MutableList<Reward> {
    return getJSONArray(key)?.toRewardList() ?: mutableListOf()
}

fun JSONArray.toUpdateInfoList(): MutableList<UpdateInfo> {
    val list: MutableList<UpdateInfo> = mutableListOf()
    for (i in this) {
        list.add(UpdateInfo.fromJson(i as JSONObject))
    }
    return list
}

fun JSONArray.toListString(): MutableList<String> {
    val list: MutableList<String> = mutableListOf()
    for (i in this) {
        list.add((i as JSONObject).toString())
    }
    return list
}
fun JSONArray.toGoodList(): MutableList<Good> {
    val list: MutableList<Good> = mutableListOf()
    for (i in this) {
        list.add(Good.fromJson(i as JSONObject))
    }
    return list
}
fun JSONArray.toTaskRuleList(): MutableList<TaskRule> {
    val list: MutableList<TaskRule> = mutableListOf()
    for (i in this) {
        list.add(TaskRule.fromJson(i as JSONObject))
    }
    return list
}
fun JSONArray.toRewardList(): MutableList<Reward> {
    val list: MutableList<Reward> = mutableListOf()
    for (i in this) {
        list.add(Reward.fromJson(i as JSONObject))
    }
    return list
}