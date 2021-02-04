package com.timecat.identity.data.block.type

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/8/17
 * @description null
 * @usage null
 */
@IntDef(
    MEDIA_IMAGE,
    MEDIA_URL,
    MEDIA_AUDIO,
    MEDIA_VIDEO,
    MEDIA_CODE,
    MEDIA_FILE,
    MEDIA_DIRECTORY,
    MEDIA_BLOCK
)
@Retention(AnnotationRetention.SOURCE)
annotation class MediaType

const val MEDIA_IMAGE = 0
const val MEDIA_URL = 1
const val MEDIA_AUDIO = 2
const val MEDIA_VIDEO = 3
const val MEDIA_CODE = 4
const val MEDIA_FILE = 5

const val MEDIA_ModuleFile = 6 // 文件路径
const val MEDIA_ModuleGit = 7 // Git
const val MEDIA_ModuleReader = 8 // 阅读

const val MEDIA_DIRECTORY = 9
const val MEDIA_BLOCK = 10
