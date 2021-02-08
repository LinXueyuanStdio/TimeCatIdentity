package com.timecat.identity.service;

import androidx.annotation.NonNull;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020-01-20
 * @description 论坛服务
 * @usage 如果使用第三方云服务商的话，请实现这个服务
 */
public interface ForumService {
    void exist(String name, @NonNull ExistCallback existCallback);

    interface ExistCallback {
        void onExist(String blockId);

        void notFound();
    }

}
