package com.timecat.identity.service;

import androidx.annotation.NonNull;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/8/12
 * @description null
 * @usage null
 */
public interface UploadCallback {
    void onSuccess(@NonNull String url);

    void onFail(@NonNull String e);
}
