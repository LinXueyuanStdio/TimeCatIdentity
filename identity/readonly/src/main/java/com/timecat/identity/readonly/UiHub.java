package com.timecat.identity.readonly;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/10/19
 * @description UI 权限 ID
 * @usage null
 */
public interface UiHub {
    String UiSchema = "ui://";
    String BUTTON = "button";
    String CHECKBOX = "checkbox";
    String EDITTEXT = "edittext";
    String DRAWER_ITEM_MANAGER = "drawer_item_manager";
    String DELETE_BLOCK = "delete_block";
    String MASTER_MainActivity_drawer_manager = UiSchema + RouterHub.MASTER_MainActivity + "/" + DRAWER_ITEM_MANAGER;
    String USER_ITEM_delete_block = UiSchema + "/" + DELETE_BLOCK;
}
