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
    BUTTON_Duplicate,
)
@Retention(AnnotationRetention.SOURCE)
annotation class ButtonType

const val BUTTON_Duplicate: Int = 0 //复读机

