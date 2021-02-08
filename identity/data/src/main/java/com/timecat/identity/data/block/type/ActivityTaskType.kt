package com.timecat.identity.data.block.type

import androidx.annotation.IntDef

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/2/5
 * @description 活动、任务类型
 * 所有任务都有任务起始时间和任务截止时间、领取奖励起始时间、领取奖励截止时间
 * @usage null
 */
@IntDef(
    ACTIVITY_Url,
    ACTIVITY_Text_url,
    ACTIVITY_Custom,
    ACTIVITY_Dream,
    ACTIVITY_Double,
    ACTIVITY_Card,
    ACTIVITY_Price,
    ACTIVITY_Life,
    ACTIVITY_Achievement,
    ACTIVITY_Get_back,
    ACTIVITY_Seven_day_sign,
    ACTIVITY_Everyday_main,
    ACTIVITY_One_task
)
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityType

const val ACTIVITY_Url: Int = 0 //外链
const val ACTIVITY_Text_url: Int = 1 //公告
const val ACTIVITY_Custom: Int = 2 //玩家自定义活动和任务
const val ACTIVITY_Dream: Int = 3 //梦境，高价值目标，时间较长
const val ACTIVITY_Double: Int = 4 //双线，月任务，时间较长
const val ACTIVITY_Card: Int = 5 //卡池
const val ACTIVITY_Price: Int = 6 //悬赏，由第三方或官方虚拟发起
const val ACTIVITY_Life: Int = 7 //成长、生涯、主线剧情
const val ACTIVITY_Achievement: Int = 8 //成就
const val ACTIVITY_Get_back: Int = 9 //回归
const val ACTIVITY_Seven_day_sign: Int = 10 //7日签到
const val ACTIVITY_Everyday_main: Int = 11 //每日系列任务
const val ACTIVITY_One_task: Int = 12 //一张图片，一个任务
// 每日任务、签到、分享、定时登录等等

@IntDef(
    TASK_Data,
    TASK_Story,
)
@Retention(AnnotationRetention.SOURCE)
annotation class TaskType

const val TASK_Data: Int = 0 //统计数据任务，如：登录0/1，战斗2／5，胜利3／7
const val TASK_Story: Int = 1 //剧情任务


