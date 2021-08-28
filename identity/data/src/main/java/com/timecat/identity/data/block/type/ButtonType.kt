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
    BUTTON_Loop,
    BUTTON_Runner,
    BUTTON_AbsoluteRunner,
)
@Retention(AnnotationRetention.SOURCE)
annotation class ButtonType

const val BUTTON_Stop = 0 //直接终止，啥也不干
const val BUTTON_Notifier = 1 //通知器，多种通知手段
const val BUTTON_Timer = 2 //计时器
const val BUTTON_Duplicate = 3 //复读机
const val BUTTON_Loop = 4 //循环机
const val BUTTON_Runner = 5 //执行者，可自动组合执行其他机械符文
const val BUTTON_AbsoluteRunner = 6 //绝对执行者，在绝对时间点自动执行指定的机械符文
