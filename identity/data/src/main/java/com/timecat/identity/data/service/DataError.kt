package com.timecat.identity.data.service

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-11-25
 * @description null
 * @usage null
 */
data class DataError(val code: Int = 0, val msg: String?) : Exception(msg)