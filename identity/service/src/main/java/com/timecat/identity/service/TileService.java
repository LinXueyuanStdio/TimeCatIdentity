package com.timecat.identity.service;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/5/31
 * @description 磁贴通知服务。磁贴通知必须手动取消才会消失
 * @usage 单击展开收起，长按触发
 */
public interface TileService {
    void show(Bitmap bitmap, String title, String content, Listener listener);

    interface Listener {
        void OnLongClick(Context context);
    }
}
