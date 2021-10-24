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

    String MASTER_MainActivity_drawer_manager = UiSchema + RouterHub.MASTER_MainActivity + "/drawer_item_manager";

    String MASTER_MainActivity_create_block_BLOCK_RECORD = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_RECORD";
    String MASTER_MainActivity_create_block_BLOCK_DATABASE = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_DATABASE";
    String MASTER_MainActivity_create_block_BLOCK_NOVEL = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_NOVEL";
    String MASTER_MainActivity_create_block_BLOCK_MARKDOWN = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_MARKDOWN";
    String MASTER_MainActivity_create_block_BLOCK_MESSAGE = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_MESSAGE";
    String MASTER_MainActivity_create_block_BLOCK_ABOUT = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_ABOUT";
    String MASTER_MainActivity_create_block_BLOCK_TAG = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_TAG";
    String MASTER_MainActivity_create_block_BLOCK_TOPIC = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_TOPIC";
    String MASTER_MainActivity_create_block_BLOCK_MEDIA = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_MEDIA";
    String MASTER_MainActivity_create_block_BLOCK_LEADER_BOARD = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_LEADER_BOARD";
    String MASTER_MainActivity_create_block_BLOCK_APP = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_APP";
    String MASTER_MainActivity_create_block_BLOCK_COMMENT = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_COMMENT";
    String MASTER_MainActivity_create_block_BLOCK_RECOMMEND = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_RECOMMEND";
    String MASTER_MainActivity_create_block_BLOCK_CONVERSATION = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_CONVERSATION";
    String MASTER_MainActivity_create_block_BLOCK_CONTAINER = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_CONTAINER";
    String MASTER_MainActivity_create_block_BLOCK_ACTIVITY = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_ACTIVITY";
    String MASTER_MainActivity_create_block_BLOCK_FOCUS = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_FOCUS";
    String MASTER_MainActivity_create_block_BLOCK_PATH = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_PATH";
    String MASTER_MainActivity_create_block_BLOCK_TASK = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_TASK";
    String MASTER_MainActivity_create_block_BLOCK_MOMENT = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_MOMENT";
    String MASTER_MainActivity_create_block_BLOCK_DIALOG = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_DIALOG";
    String MASTER_MainActivity_create_block_BLOCK_PLUGIN = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_PLUGIN";
    String MASTER_MainActivity_create_block_BLOCK_LINK = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_LINK";
    String MASTER_MainActivity_create_block_BLOCK_BUTTON = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_BUTTON";
    String MASTER_MainActivity_create_block_BLOCK_FORUM = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_FORUM";
    String MASTER_MainActivity_create_block_BLOCK_POST = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_POST";
    String MASTER_MainActivity_create_block_BLOCK_PERMISSION = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_PERMISSION";
    String MASTER_MainActivity_create_block_BLOCK_IDENTITY = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_IDENTITY";
    String MASTER_MainActivity_create_block_BLOCK_ROLE = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_ROLE";
    String MASTER_MainActivity_create_block_BLOCK_ITEM = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_ITEM";
    String MASTER_MainActivity_create_block_BLOCK_MAIL = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_MAIL";
    String MASTER_MainActivity_create_block_BLOCK_SHOP = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_SHOP";
    String MASTER_MainActivity_create_block_BLOCK_SPACE = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_SPACE";
    String MASTER_MainActivity_create_block_BLOCK_SKIN = UiSchema + RouterHub.MASTER_MainActivity + "/create_block_BLOCK_SKIN";

    String DELETE_BLOCK = "delete_block";
    String USER_ITEM_delete_block = UiSchema + "/" + DELETE_BLOCK;
}
