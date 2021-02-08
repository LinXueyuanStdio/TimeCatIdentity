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
    IDENTITY_Base,
    IDENTITY_Cube
)
@Retention(AnnotationRetention.SOURCE)
annotation class IdentityType

const val IDENTITY_Base: Int = 0 //基础，不可养成，用于简单的权限控制
const val IDENTITY_Cube: Int = 1 //方块，没有动画形象、语音等其他资源，而只有工具属性，用于功能的打包组织和出售

