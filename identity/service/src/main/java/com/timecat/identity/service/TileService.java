package com.timecat.identity.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/5/31
 * @description 磁贴通知服务。磁贴通知必须手动取消才会消失
 * @usage 单击展开收起，长按触发
 */
public interface TileService {
    /**
     * 显示磁贴
     * 完整内容为 "【title】content"
     * @param bitmap 头像
     * @param title 标题 
     * @param content 内容
     * @param listener 点击磁贴后触发
     */
    void show(@Nullable Bitmap bitmap, String title, String content, Listener listener);

    /**
     * 显示磁贴
     * @param bitmap 头像
     * @param content 内容
     * @param listener 点击磁贴后触发
     */
    void show(@Nullable Bitmap bitmap, String content, Listener listener);

    /**
     * 显示磁贴
     * 完整内容为 "【title】content"
     * @param drawable 头像
     * @param title 标题 
     * @param content 内容
     * @param listener 点击磁贴后触发
     */
    void show(@Nullable Drawable drawable, String title, String content, Listener listener);

    /**
     * 显示磁贴
     * @param drawable 头像
     * @param content 内容
     * @param listener 点击磁贴后触发
     */
    void show(@Nullable Drawable drawable, String content, Listener listener);

    /**
     * 显示磁贴，默认头像为应用图标
     * 完整内容为 "【title】content"
     * @param title 标题 
     * @param content 内容
     * @param listener 点击磁贴后触发
     */
    void show(String title, String content, Listener listener);

    /**
     * 显示磁贴
     * @param content 内容
     * @param listener 点击磁贴后触发
     */
    void show(String content, Listener listener);

    interface Listener {
        void OnLongClick(Context context);
    }
}
