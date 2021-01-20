package com.timecat.identity.data.block.type

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/1/19
 * @description 路径、传送门，传送到一个组件、一个app、一个插件等等
 * @usage 路径类型，该类型包含了组件里的一列数据结构
 */
@IntDef(
    PATH_OpenRouteUrl,
    PATH_AppInPhone,
    PATH_PluginOfTimeCat
)
@Retention(AnnotationRetention.SOURCE)
annotation class PathType

const val PATH_OpenRouteUrl: Int = 0 //时光猫开放路径
const val PATH_AppInPhone: Int = 1 //本机已安装的应用
const val PATH_PluginOfTimeCat: Int = 2 //时光猫已安装插件


