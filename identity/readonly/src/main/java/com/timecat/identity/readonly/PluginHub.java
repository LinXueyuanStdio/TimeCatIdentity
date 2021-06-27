package com.timecat.identity.readonly;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/4/12
 * @description null
 * @usage null
 */
public interface PluginHub {
    // 启动 activity
    long FROM_ID_START_ACTIVITY = 1001;
    // 启动服务
    long FROM_ID_CALL_SERVICE = 1002;
    // 图床加载
    long FROM_ID_LOAD_PICTURE = 1003;
    // 加载自定义 view
    long FROM_ID_LOAD_VIEW = 1004;

    String KEY_PLUGIN_ZIP_PATH = "pluginZipPath";
    String KEY_ACTIVITY_CLASSNAME = "KEY_ACTIVITY_CLASSNAME";
    String KEY_PLUGIN_PART_KEY = "KEY_PLUGIN_PART_KEY";

    String KEY_EXTRAS = "KEY_EXTRAS";
    String KEY_ACTION = "KEY_ACTION";// intent.setAction()
    String KEY_DATA = "KEY_DATA";// intent.setData()

    String KEY_PICTURE_PATH = "picturePath";
}