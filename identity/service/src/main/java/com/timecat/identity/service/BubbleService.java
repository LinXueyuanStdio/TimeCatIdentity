package com.timecat.identity.service;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/5/31
 * @description 气泡通知服务。气泡通知 3 秒后自动消失
 * @usage 单击触发
 */
public interface BubbleService {
    void show(Bitmap drawable, String title, String content, Listener listener);

    interface Listener {
        void OnClick(Context context);
    }
}
