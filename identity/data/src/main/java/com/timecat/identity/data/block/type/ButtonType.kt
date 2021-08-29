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
    BUTTON_Stop,
    BUTTON_Notifier,
    BUTTON_Timer,
    BUTTON_Duplicate,
    BUTTON_Runner,
    BUTTON_LoopRunner,
)
@Retention(AnnotationRetention.SOURCE)
annotation class ButtonType

const val BUTTON_Stop = 0 //直接终止，啥也不干
const val BUTTON_Notifier = 1 //通知器，多种通知手段
const val BUTTON_Timer = 2 //计时器
const val BUTTON_Duplicate = 3 //复读机
const val BUTTON_Runner = 4 //执行者，可自动组合执行其他机械符文
const val BUTTON_LoopRunner = 5 //循环执行者，比执行者多一个循环功能
