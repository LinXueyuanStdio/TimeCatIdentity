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
    ITEM_Thing,
    ITEM_Package,
    ITEM_Data,
    ITEM_Equip
)
@Retention(AnnotationRetention.SOURCE)
annotation class ItemType

const val ITEM_Thing: Int = 0 //物产，用于合成。如碎片，如装备碎片、方块碎片；如突破材料
const val ITEM_Package: Int = 1 //礼包
const val ITEM_Data: Int = 2 //数值，一个字段的加或减，如用户经验值、用户体力、方块经验值、方块突破等级
const val ITEM_Equip: Int = 3 //装备

