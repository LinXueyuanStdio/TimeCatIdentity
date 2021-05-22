package com.timecat.identity.data.block.type

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/1/24
 * @description 道具、物品
 * @usage null
 */
@IntDef(
    SHOP_Basic,
    SHOP_User_Basic,
    SHOP_User_Rend
)
@Retention(AnnotationRetention.SOURCE)
annotation class ShopType

const val SHOP_Basic: Int = 0 //基本版，游戏化的永久商店，用于提供基本的物质交换
const val SHOP_User_Basic: Int = 1 //用户自己开店，卖游戏数值
const val SHOP_User_Rend: Int = 2 //用户自己开店，出租头像、出租他们的造物
