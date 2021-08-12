package com.timecat.identity.service;

import android.app.Activity;

import androidx.annotation.NonNull;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2021/8/12
 * @description null
 * @usage null
 */
public interface ImageSelectService {
    void selectAvatar(@NonNull Activity activity, @NonNull UploadCallback callback);

    void selectImage(@NonNull Activity activity, @NonNull UploadCallback callback);

    void selectImage(@NonNull Activity activity, int cropId, @NonNull UploadCallback callback);

    //拍照
    void takeOnePhoto(@NonNull Activity activity, int cropId, @NonNull UploadCallback callback);

    //本地相册
    void selectOneLocalImage(@NonNull Activity activity, int cropId, @NonNull UploadCallback callback);

    //内置图标
    void selectOneLocalIcon(@NonNull Activity activity, int cropId, @NonNull UploadCallback callback);

    //随机图标
    void selectOneRandomAvatar(@NonNull Activity activity, int cropId, @NonNull UploadCallback callback);

    //随机大图
    void selectOneRandomImage(@NonNull Activity activity, int cropId, @NonNull UploadCallback callback);

    //我的在线相册
    void selectOneOnlineImage(@NonNull Activity activity, int cropId, @NonNull UploadCallback callback);
}
