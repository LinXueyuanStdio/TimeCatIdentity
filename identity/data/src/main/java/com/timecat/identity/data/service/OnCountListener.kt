package com.timecat.identity.data.service

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-09-09
 * @description null
 * @usage null
 */
interface OnCountListener {
    fun success(count: Int)
    fun error(e: DataError)
}