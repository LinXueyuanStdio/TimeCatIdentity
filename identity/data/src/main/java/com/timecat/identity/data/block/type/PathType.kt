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
    PATH_File,
    PATH_Git,
    PATH_Novel
)
@Retention(AnnotationRetention.SOURCE)
annotation class PathType

const val PATH_File: Int = 0 //文件组件，如某个文件夹
const val PATH_Git: Int = 1 //git组件，如仓库主页
const val PATH_Novel: Int = 2 //阅读组件，如书架
