package com.timecat.identity.data.block.type

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020-01-23
 * @description BLOCK_CONTAINER 容器类型的 subType
 * @usage null
 */
@IntDef(
    CONTAINER_BLOCK_UNIVERSAL,
    CONTAINER_BLOCK_RECORD,
    CONTAINER_BLOCK_DATABASE,
    CONTAINER_BLOCK_CARD,
    CONTAINER_BLOCK_MARKDOWN,
    CONTAINER_BLOCK_MESSAGE,
    CONTAINER_BLOCK_ABOUT,
    CONTAINER_BLOCK_TAG,
    CONTAINER_BLOCK_TOPIC,
    CONTAINER_BLOCK_CONTAINER,
    CONTAINER_BLOCK_LEADER_BOARD,
    CONTAINER_BLOCK_APP,
    CONTAINER_BLOCK_COMMENT,
    CONTAINER_BLOCK_RECOMMEND,
    CONTAINER_BLOCK_CONVERSATION,
    CONTAINER_BLOCK_IDENTITY,
    CONTAINER_BLOCK_FOCUS,
    CONTAINER_BLOCK_PATH,
    CONTAINER_BLOCK_TASK,
    CONTAINER_BLOCK_MOMENT,
    CONTAINER_BLOCK_DIALOG,
    CONTAINER_BLOCK_PLUGIN,

    CONTAINER_BLOCK_MEDIA_IMAGE,
    CONTAINER_BLOCK_MEDIA_URL,
    CONTAINER_BLOCK_MEDIA_AUDIO,
    CONTAINER_BLOCK_MEDIA_VIDEO,
    CONTAINER_BLOCK_MEDIA_CODE,
    CONTAINER_BLOCK_MEDIA_FILE,

    CONTAINER_BLOCK_MEDIA_MODULE_FILE,
    CONTAINER_BLOCK_MEDIA_MODULE_GIT,
    CONTAINER_BLOCK_MEDIA_MODULE_NOVEL,
)
@Retention(AnnotationRetention.SOURCE)
annotation class ContainerType

const val CONTAINER_BLOCK_UNIVERSAL = -1

//专用类型只允许创建以下子类型
const val BLOCK_RECORD_OFFSET = 100 * BLOCK_RECORD
const val CONTAINER_BLOCK_RECORD = BLOCK_RECORD_OFFSET + BLOCK_RECORD
const val CONTAINER_BLOCK_DATABASE = BLOCK_RECORD_OFFSET + BLOCK_DATABASE
const val CONTAINER_BLOCK_CARD = BLOCK_RECORD_OFFSET + BLOCK_CARD //卡片类型会忽略父符文
const val CONTAINER_BLOCK_MARKDOWN = BLOCK_RECORD_OFFSET + BLOCK_MARKDOWN
const val CONTAINER_BLOCK_MESSAGE = BLOCK_RECORD_OFFSET + BLOCK_MESSAGE
const val CONTAINER_BLOCK_ABOUT = BLOCK_RECORD_OFFSET + BLOCK_ABOUT
const val CONTAINER_BLOCK_TAG = BLOCK_RECORD_OFFSET + BLOCK_TAG
const val CONTAINER_BLOCK_TOPIC = BLOCK_RECORD_OFFSET + BLOCK_TOPIC
const val CONTAINER_BLOCK_CONTAINER = BLOCK_RECORD_OFFSET + BLOCK_CONTAINER
const val CONTAINER_BLOCK_LEADER_BOARD = BLOCK_RECORD_OFFSET + BLOCK_LEADER_BOARD
const val CONTAINER_BLOCK_APP = BLOCK_RECORD_OFFSET + BLOCK_APP
const val CONTAINER_BLOCK_COMMENT = BLOCK_RECORD_OFFSET + BLOCK_COMMENT
const val CONTAINER_BLOCK_RECOMMEND = BLOCK_RECORD_OFFSET + BLOCK_RECOMMEND
const val CONTAINER_BLOCK_CONVERSATION = BLOCK_RECORD_OFFSET + BLOCK_CONVERSATION
const val CONTAINER_BLOCK_IDENTITY = BLOCK_RECORD_OFFSET + BLOCK_IDENTITY
const val CONTAINER_BLOCK_FOCUS = BLOCK_RECORD_OFFSET + BLOCK_FOCUS
const val CONTAINER_BLOCK_PATH = BLOCK_RECORD_OFFSET + BLOCK_PATH
const val CONTAINER_BLOCK_TASK = BLOCK_RECORD_OFFSET + BLOCK_TASK
const val CONTAINER_BLOCK_MOMENT = BLOCK_RECORD_OFFSET + BLOCK_MOMENT
const val CONTAINER_BLOCK_DIALOG = BLOCK_RECORD_OFFSET + BLOCK_DIALOG
const val CONTAINER_BLOCK_PLUGIN = BLOCK_RECORD_OFFSET + BLOCK_PLUGIN

const val BLOCK_MEDIA_OFFSET = 100 * BLOCK_MEDIA
const val CONTAINER_BLOCK_MEDIA_IMAGE = BLOCK_MEDIA_OFFSET + MEDIA_IMAGE
const val CONTAINER_BLOCK_MEDIA_URL = BLOCK_MEDIA_OFFSET + MEDIA_URL
const val CONTAINER_BLOCK_MEDIA_AUDIO = BLOCK_MEDIA_OFFSET + MEDIA_AUDIO
const val CONTAINER_BLOCK_MEDIA_VIDEO = BLOCK_MEDIA_OFFSET + MEDIA_VIDEO
const val CONTAINER_BLOCK_MEDIA_CODE = BLOCK_MEDIA_OFFSET + MEDIA_CODE
const val CONTAINER_BLOCK_MEDIA_FILE = BLOCK_MEDIA_OFFSET + MEDIA_FILE
const val CONTAINER_BLOCK_MEDIA_MODULE_FILE = BLOCK_MEDIA_OFFSET + MEDIA_ModuleFile
const val CONTAINER_BLOCK_MEDIA_MODULE_GIT = BLOCK_MEDIA_OFFSET + MEDIA_ModuleGit
const val CONTAINER_BLOCK_MEDIA_MODULE_NOVEL = BLOCK_MEDIA_OFFSET + MEDIA_ModuleReader
const val CONTAINER_BLOCK_MEDIA_MODULE_BROWSER = BLOCK_MEDIA_OFFSET + MEDIA_ModuleBrowser
const val CONTAINER_BLOCK_MEDIA_MODULE_ONLINE = BLOCK_MEDIA_OFFSET + MEDIA_ModuleOnline
const val CONTAINER_BLOCK_MEDIA_MODULE_CATEGORY = BLOCK_MEDIA_OFFSET + MEDIA_ModuleCategory
