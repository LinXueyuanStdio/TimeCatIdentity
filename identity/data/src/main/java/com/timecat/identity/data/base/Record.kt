package com.timecat.identity.data.base

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020-02-17
 * @description null
 * @usage null
 */
@IntDef(
    NOTE,
    REMINDER,
    HABIT,
    GOAL
)
@Retention(AnnotationRetention.SOURCE)
annotation class Type

const val NOTE: Int = 0
const val REMINDER: Int = 1 //有时间 有提醒
const val HABIT: Int = 2 //有循环时间 有提醒
const val GOAL: Int = 3 //有时间 有长提醒

const val TEXT: Int = 4 //
const val TODO_LIST: Int = 5 //
const val Heading1: Int = 6 //
const val Heading2: Int = 7 //
const val Heading3: Int = 8 //
const val Heading4: Int = 9 //
const val Heading5: Int = 10 //
const val Heading6: Int = 11 //
const val BULLETED_LIST: Int = 12 //
const val NUMBERED_LIST: Int = 13 //
const val TOGGLE_LIST: Int = 14 //
const val QUOTE: Int = 15 //
const val DIVIDER: Int = 16 //
const val CALLOUT: Int = 17 //

const val ALL_RECORD_TYPE: Int = 18
