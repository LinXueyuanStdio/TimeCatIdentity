package com.timecat.identity.data.block.type

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/1/19
 * @description null
 * @usage null
 */
@IntDef(
    DATABASE_Identity,
    DATABASE_Card
)
@Retention(AnnotationRetention.SOURCE)
annotation class DatabaseType

const val DATABASE_Identity = 0 //递归数据库，递归地嵌入到其他数据库中，只支持符文列表（文件系统）
const val DATABASE_Card = 1 //卡片数据库，可以统计，支持表格、看板等
