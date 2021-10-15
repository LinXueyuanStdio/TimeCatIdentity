package com.timecat.identity.data.block.type

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/2/6
 * @description 方块
 * 方块就是身份，identity
 * 最基本的方块是身份
 * 然后有可养成的方块
 * @usage null
 */

@IntDef(
    SKIN_AppSkin,
    SKIN_CubeSkin
)
@Retention(AnnotationRetention.SOURCE)
annotation class SkinType

const val SKIN_AppSkin: Int = 0 //基础，app apk皮肤
const val SKIN_CubeSkin: Int = 1 //方块皮肤

