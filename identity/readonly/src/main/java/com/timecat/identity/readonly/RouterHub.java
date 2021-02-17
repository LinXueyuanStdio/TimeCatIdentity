package com.timecat.identity.readonly;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ================================================ RouterHub 用来定义路由器的路由地址, 以组件名作为前缀,
 * 对每个组件的路由地址进行分组, 可以统一查看和管理所有分组的路由地址
 * <p>
 * RouterHub 存在于基础库, 可以被看作是所有组件都需要遵守的通讯协议, 里面不仅可以放路由地址常量, 还可以放跨组件传递数据时命名的各种 Key 值 再配以适当注释,
 * 任何组件开发人员不需要事先沟通只要依赖了这个协议, 就知道了各自该怎样协同工作, 既提高了效率又降低了出错风险, 约定的东西自然要比口头上说强
 * <p>
 * 如果您觉得把每个路由地址都写在基础库的 RouterHub 中, 太麻烦了, 也可以在每个组件内部建立一个私有 RouterHub, 将不需要跨组件的 路由地址放入私有 RouterHub
 * 中管理, 只将需要跨组件的路由地址放入基础库的公有 RouterHub 中管理, 如果您不需要集中管理所有路由地址的话 这也是比较推荐的一种方式
 * <p>
 * 路由地址的命名规则为 组件名 + 页面名, 如订单组件的订单详情页的路由地址可以命名为 "/order/OrderDetailActivity"
 * <p>
 * ARouter 将路由地址中第一个 '/' 后面的字符称为 Group, 比如上面的示例路由地址中 order 就是 Group, 以 order 开头的地址都被分配该 Group 下
 * 切记不同的组件中不能出现名称一样的 Group, 否则会发生该 Group 下的部分路由地址找不到的情况!!! 所以每个组件使用自己的组件名作为 Group 是比较好的选择, 毕竟组件不会重名
 *
 * @see <a href="https://github.com/JessYanCoding/ArmsComponent/wiki#3.4">RouterHub wiki 官方文档</a>
 * Created by JessYan on 30/03/2018 18:07
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface RouterHub {

    //region burstlink
    //例子：123456789;123456789open#timecat@/login/LoginActivity&u=name&pwd=123
    String AT = "@";
    String SF = "#";
    String AND = "&";
    String SEG = ";";//link key 专用
    String OPEN = "open";
    String APP = "app";
    String TIMECAT = "timecat";
    String INTENT = "intent";
    String OPEN_TIMECAT_AT = OPEN + SF + TIMECAT + AT;
    int SPECIAL_INDEX_ERADNOVAL = 0;
    //endregion

    /**
     * Intent pendingIntent = new Intent(Intent.ACTION_VIEW);
     * pendingIntent.setData(Uri.parse(RouterHub.URL_HEADER
     * + RouterHub.MASTER_MainActivity));
     */
    String URL_HEADER = "timecat://";

    /**
     * 组名
     */
    String HOST_APP = "app";//宿主HOST_APP组件
    String WELCOME = "welcome";//欢迎组件
    String LOGIN = "login";//登录组件
    String ABOUT = "about";//关于组件
    String USER = "user";//用户组件
    String SEARCH = "search";//搜索组件
    String NOVEL = "novel";//小说组件
    String TASK = "task";//任务组件
    String NOTE = "note";//笔记组件
    String HABIT = "habit";//习惯组件
    String BURSTLINK = "burstlink";//全局连接组件
    String MINDMAP = "mindmap";//思维导图组件
    String MAIN = "main";//main 组件
    String MASTER = "master";//主线
    String GLOBAL = "global";//main 组件
    String KEYBOARD = "keyboard";//keyboard 组件
    String GITHUB = "github";//github 组件
    String DATA = "data";//data 组件
    String ARTIFACT = "artifact";//造物组件
    String LEADERBOARD = "leaderboard";//排行榜组件
    String DEVELOPER = "developer";//开发者组件
    String MOMENT = "moment";//说说组件
    String PHOTOSELECTOR = "photoselector";//图片选择组件
    String GIT = "git";//本地 git 组件
    String TIMETABLE = "timetable";//课程表组件
    String FILE_EXPLORER = "file_explorer";//文件选取组件
    String ORG = "org";//org 编辑器组件
    String IM = "im";//im 即时通讯组件
    String THEME = "theme";//换肤组件
    String PLUGIN = "plugin";//插件管理相关的组件
    String APP_DETAIL = "app_detail";//详情页组件
    String TERMINAL = "terminal";//命令行组件
    String EDITOR = "editor";//编辑器组件
    String SMALL_EDITOR = "small_editor";//small 编辑器组件
    String IDEA_EDITOR = "idea_editor";//idea 编辑器组件
    String SCARLET = "scarlet";//idea 编辑器组件
    String EXPLORER = "explorer";//文件浏览器组件
    String FILES = "files";//material 文件浏览器组件

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    String SERVICE = "service";
    String ALARM = "alarm";
    String FRAGMENT = "fragment";

    //region module-welcome 欢迎
    String WELCOME_WelcomeActivity = WELCOME + "/WelcomeActivity";
    String WELCOME_WelcomeGuideActivity = WELCOME + "/WelcomeGuideActivity";
    String WELCOME_PreSettingActivity = WELCOME + "/PreSettingActivity";
    //endregion

    //region module-login 登录
    String LOGIN_LoginActivity = LOGIN + "/LoginActivity";
    //协议
    String LOGIN_ProtocolActivity = LOGIN + "/ProtocolActivity";
    //正常注册
    String LOGIN_RegisterCheckExistActivity = LOGIN + "/RegisterCheckExistActivity";
    String LOGIN_RegisterVerificationCodeActivity = LOGIN + "/RegisterVerificationCodeActivity";
    String LOGIN_RegisterSetPwdActivity = LOGIN + "/RegisterSetPwdActivity";
    //忘记密码
    String LOGIN_ForgotPwdCheckExistActivity = LOGIN + "/ForgotPwdCheckExistActivity";
    String LOGIN_ForgotPwdVerificationCodeActivity = LOGIN + "/ForgotPwdVerificationCodeActivity";
    String LOGIN_ForgotPwdSetNewPwdActivity = LOGIN + "/ForgotPwdSetNewPwdActivity";
    //endregion

    //region 宿主HOST_APP分组
    String APP_PomodoroActivity = HOST_APP + "/PomodoroActivity";
    String APP_ScreenCaptureActivity = HOST_APP + "/ScreenCaptureActivity";
    String APP_WebActivity = HOST_APP + "/WebActivity";
    String APP_TimeCatActivity = HOST_APP + "/TimeCatActivity ";
    String APP_EnhanceNotificationActivity = HOST_APP + "/EnhanceNotificationActivity";
    String APP_SettingActivity = HOST_APP + "/SettingActivity";
    //笔记
    String APP_SettingRecordActivity = HOST_APP + "/SettingRecordActivity";
    String APP_SettingDataActivity = HOST_APP + "/SettingDataActivity";
    String APP_SettingBackupActivity = HOST_APP + "scarlet" + "/SettingBackupActivity";
    String APP_ExportActivity = HOST_APP + "scarlet" + "/ExportActivity";
    String APP_AutoExportActivity = HOST_APP + "scarlet" + "/AutoExportActivity";

    //工具
    String APP_SettingNotificationActivity = HOST_APP + "/SettingNotificationActivity";
    String APP_SettingTimeCatActivity = HOST_APP + "/SettingTimeCatActivity";
    String APP_SettingFloatingWindowActivity = HOST_APP + "/SettingFloatingWindowActivity";
    String APP_SettingFloatViewActivity = HOST_APP + "/SettingFloatViewActivity";
    String APP_SettingNLPActivity = HOST_APP + "/SettingNLPActivity";
    String APP_SettingTranslateActivity = HOST_APP + "/SettingTranslateActivity";
    String APP_SettingServiceActivity = HOST_APP + "/SettingServiceActivity";
    String APP_SettingSegWordActivity = HOST_APP + "/SettingSegWordActivity";
    String APP_SettingAssistActivity = HOST_APP + "/SettingAssistActivity";
    String APP_SettingOCRActivity = HOST_APP + "/SettingOCRActivity";
    String APP_SettingSearchActivity = HOST_APP + "/SettingSearchActivity";
    String APP_SettingBurstLinkActivity = HOST_APP + "/SettingBurstLinkActivity";
    String APP_OcrActivity = HOST_APP + "/OcrActivity";
    String APP_FloatViewWhiteListActivity = HOST_APP + "/FloatViewWhiteListActivity";

    //时间
    String APP_SettingPomodoroActivity = HOST_APP + "/SettingPomodoroActivity";
    //endregion


    //region 编辑器
    String EDITOR_RawTextEditorActivity = EDITOR + "raw" + "/RawTextEditorActivity";
    String EDITOR_RawTextSettingsActivity = EDITOR + "raw" + "/RawTextSettingsActivity";
    String EDITOR_MarkdownEditorActivity = EDITOR + "/MarkdownEditorActivity";
    String EDITOR_EditFragment = EDITOR + FRAGMENT + "/EditFragment";
    String EDITOR_VideoFragment = EDITOR + FRAGMENT + "/VideoFragment";
    String EDITOR_PictureFragment = EDITOR + FRAGMENT + "/PictureFragment";
    String EDITOR_MusicFragment = EDITOR + FRAGMENT + "/MusicFragment";
    String EDITOR_MarkdownFragment = EDITOR + FRAGMENT + "/MarkdownFragment";

    String MINDMAP_MindMapActivity = MINDMAP + "/MindMapActivity";
    String MINDMAP_MindMapFragment = MINDMAP + FRAGMENT + "/MindMapFragment";
    String MINDMAP_MindMapPlanFragment = MINDMAP + FRAGMENT + "/MindMapPlanFragment";

    String EDITOR_BlockEditorActivity = EDITOR + "/BlockEditorActivity";
    String EDITOR_BlockDetailFragment = EDITOR + FRAGMENT + "/BlockDetailFragment";
    String EDITOR_BlockCommentFragment = EDITOR + FRAGMENT + "/BlockCommentFragment";
    String EDITOR_BlockSubNodeFragment = EDITOR + FRAGMENT + "/BlockSubNodeFragment";
    String EDITOR_BlockDoingFragment = EDITOR + FRAGMENT + "/BlockDoingFragment";
    String EDITOR_BlockPunchFragment = EDITOR + FRAGMENT + "/BlockPunchFragment";
    String EDITOR_BlockKanbanFragment = EDITOR + FRAGMENT + "/BlockKanbanFragment";
    String EDITOR_BlockGitCommitsFragment = EDITOR + FRAGMENT + "/BlockGitCommitsFragment";
    String EDITOR_BlockSelfChatFragment = EDITOR + FRAGMENT + "/BlockSelfChatFragment";
    String EDITOR_BlockEditFragment = EDITOR + FRAGMENT + "/EditFragment";
    String EDITOR_BlockOrgFragment = EDITOR + "org" + FRAGMENT + "/BlockOrgFragment";
    String EDITOR_BlockOutlineFragment = EDITOR + "org" + FRAGMENT + "/OutlineFragment";
    String EDITOR_BlockRecordFragment = EDITOR + "record" + FRAGMENT + "/BlockRecordFragment";
    String EDITOR_BlockContentFragment = EDITOR + "record" + FRAGMENT + "/ContentFragment";
    String EDITOR_BlockMarkdownFragment = SCARLET + EDITOR + "/BlockMarkdownFragment";
    String EDITOR_BlockRenderMdFragment = SCARLET + EDITOR + "/EDITOR_BlockRenderMdFragment";

    String EDITOR_RecordDetailPanelFragment = EDITOR + "org" + FRAGMENT + "/RecordDetailPanelFragment";
    String EDITOR_RecordDetailFragment = EDITOR + "org" + FRAGMENT + "/RecordDetailFragment";
    String EDITOR_RecordStatisticFragment = EDITOR + "master" + FRAGMENT + "/RecordStatisticFragment";
    String EDITOR_DoingStatisticFragment = EDITOR + "master" + FRAGMENT + "/DoingStatisticFragment";
    String EDITOR_RecordContentFragment = EDITOR + "org" + FRAGMENT + "/RecordContentFragment";

    String SMALL_EDITOR_BlockSmallEditorActivity = SMALL_EDITOR + "/BlockSmallEditorActivity";
    String SMALL_EDITOR_BlockSetTimeFragment = EDITOR + FRAGMENT + "/BlockSetTimeFragment";

    String IDEA_EDITOR_BlockIdeaEditorActivity = IDEA_EDITOR + "/BlockIdeaEditorActivity";
    String IDEA_EDITOR_ImageViewerActivity = IDEA_EDITOR + "/ImageViewerActivity";
    //endregion

    //region module-master 主线
    String MASTER_MainActivity = MASTER + "/MainActivity";
    String MASTER_InfoOperationActivity = MASTER + "/InfoOperationActivity";
    String MASTER_HistoryActivity = MASTER + "/HistoryActivity";
    String MASTER_CustomChannelActivity = MASTER + "/CustomChannelActivity";
    String MASTER_SettingLeftDrawerActivity = MASTER + "/SettingLeftDrawerActivity";
    String MASTER_RecordListActivity = MASTER + "controller" + "/RecordListActivity";

    String MASTER_TaskDetailFragment = MASTER + FRAGMENT + "/TaskDetailFragment";
    String MASTER_HabitDetailFragment = MASTER + FRAGMENT + "/HabitDetailFragment";
    String MASTER_NoteDetailFragment = MASTER + FRAGMENT + "/NoteDetailFragment";
    String MASTER_PlanDetailFragment = MASTER + FRAGMENT + "/PlanDetailFragment";
    String MASTER_PlanDetailKanbanFragment = MASTER + FRAGMENT + "/PlanDetailKanbanFragment";

    String MASTER_ScheduleSupportMonthFragment = MASTER + FRAGMENT + "/ScheduleSupportMonthFragment";
    String MASTER_ScheduleSupportFourFragment = MASTER + FRAGMENT + "/ScheduleSupportFourFragment";
    String MASTER_ScheduleSupportCalendarFragment = MASTER + FRAGMENT + "/ScheduleSupportCalendarFragment";
    String MASTER_ScheduleSupportBlockFragment = MASTER + FRAGMENT + "/ScheduleSupportBlockFragment";
    String MASTER_TimeLineSupportFragment = MASTER + FRAGMENT + "/TimeLineSupportFragment";
    String MASTER_SchedulesSupportWeekFragment = MASTER + FRAGMENT + "/SchedulesSupportWeekFragment";
    String MASTER_SchedulesSupportFlowFragment = MASTER + "org" + FRAGMENT + "/SchedulesSupportFlowFragment";
    String MASTER_SchedulesSupportYMWDFragment = MASTER + FRAGMENT + "/SchedulesSupportYMWDFragment";

//    String MASTER_PlanDetailKanbanFragment = MASTER + FRAGMENT + "/PlanDetailKanbanFragment";
//    String MASTER_PlanDetailKanbanFragment = MASTER + FRAGMENT + "/PlanDetailKanbanFragment";
//    String MASTER_PlanDetailKanbanFragment = MASTER + FRAGMENT + "/PlanDetailKanbanFragment";

    String MASTER_HabitSupportEncourageFragment = MASTER + FRAGMENT + "/HabitSupportEncourageFragment";
    String MASTER_HabitSupportMultiFragment = MASTER + FRAGMENT + "/HabitSupportMultiFragment";

    String MASTER_RecordListFragment = MASTER + FRAGMENT + "/RecordListFragment";
    String MASTER_NoteListFragment = MASTER + FRAGMENT + "/NoteListFragment";
    String MASTER_ReminderListFragment = MASTER + FRAGMENT + "/ReminderListFragment";
    String MASTER_GoalListFragment = MASTER + FRAGMENT + "/GoalListFragment";
    String MASTER_AllRecordFragment = MASTER + FRAGMENT + "/AllRecordFragment";
    String MASTER_MdRecordFragment = MASTER + "scarlet" + FRAGMENT + "/MdRecordFragment";

    String MASTER_BookListFragment = MASTER + FRAGMENT + "/BookListFragment";
    String MASTER_PageListFragment = MASTER + FRAGMENT + "/PageListFragment";

    String MASTER_SelfChatFragment = MASTER + "im" + FRAGMENT + "/SelfChatFragment";
    String MASTER_LocalChatFragment = MASTER + FRAGMENT + "/LocalChatFragment";
    String MASTER_IMLocalChatFragment = MASTER + FRAGMENT + "/what/IMLocalChatFragment";
    String MASTER_LocalConversationFragment = MASTER + FRAGMENT + "/LocalConversationFragment";
    String MASTER_IMLocalChatActivity = MASTER + FRAGMENT + "/IMLocalChatActivity";

    String MASTER_RecordSettingsActivity = MASTER + "org" + "/RecordSettingsActivity";
    String MASTER_RecordStatisticActivity = MASTER + "org" + "/StatisticActivity";

    String MASTER_NewContainerActivity = MASTER + "/NewContainerActivity";
    String MASTER_EditContainerActivity = MASTER + "/EditContainerActivity";
    String MASTER_NewConversationActivity = MASTER + "/NewConversationActivity";
    String MASTER_EditConversationActivity = MASTER + "/EditConversationActivity";
    String MASTER_NewRecordActivity = MASTER + "/NewRecordActivity";
    String MASTER_EditRecordActivity = MASTER + "/EditRecordActivity";
    String MASTER_NewLinkActivity = MASTER + "/NewLinkActivity";
    String MASTER_EditLinkActivity = MASTER + "/EditLinkActivity";
    String MASTER_NewButtonActivity = MASTER + "/NewButtonActivity";
    String MASTER_EditButtonActivity = MASTER + "/EditButtonActivity";
    String MASTER_NewMediaActivity = MASTER + "/NewMediaActivity";
    String MASTER_EditMediaActivity = MASTER + "/EditMediaActivity";
    String MASTER_NewPathActivity = MASTER + "/NewPathActivity";
    String MASTER_EditPathActivity = MASTER + "/EditPathActivity";
    String MASTER_HomeActivity = MASTER + "/HomeActivity";

    //region 任务分组
    String TASK_TaskDetailActivity = EDITOR + MASTER + TASK + "/TaskDetailActivity";
    String TASK_PlanDetailActivity = EDITOR + MASTER + TASK + "/PlanDetailActivity";
    String TASK_PlanListActivity = MASTER + TASK + "/PlanListActivity";
    //endregion

    //region 习惯分组
    String HABIT_HabitDetailActivity = EDITOR + "master" + HABIT + "/HabitDetailActivity";
    //endregion

    //region 笔记分组
    String NOTE_NoteDetailActivity = EDITOR + MASTER + NOTE + "/NoteDetailActivity";
    String NOTE_NotebookDetailActivity = MASTER + NOTE + "/NotebookDetailActivity";
    String NOTE_NoteBookListActivity = MASTER + NOTE + "/NoteBookListActivity";
    //endregion
    //endregion

    //region module-about 关于
    String ABOUT_AboutActivity = ABOUT + "/AboutActivity";
    String ABOUT_HowToUseActivity = ABOUT + "/HowToUseActivity";
    String ABOUT_LicenseActivity = ABOUT + "/LicenseActivity";
    String ABOUT_DonateActivity = ABOUT + "/DonateActivity";
    String ABOUT_HabitsHelpActivity = ABOUT + "/HabitsHelpActivity";
    String ABOUT_TasksHelpActivity = ABOUT + "/TasksHelpActivity";
    String ABOUT_NotesHelpActivity = ABOUT + "/NotesHelpActivity";
    String ABOUT_HelpActivity = ABOUT + "org" + "/HelpActivity";
    //endregion

    //region module-user 用户
    String USER_UserDetailActivity = USER + "/UserDetailActivity";
    String USER_UserSettingActivity = USER + "/UserSettingActivity";
    String USER_ChatActivity = USER + "/ChatActivity";
    String USER_NewFriendActivity = USER + "/NewFriendActivity";
    String USER_UserFollowListActivity = USER + "/UserFollowListActivity";
    String USER_UserFansListActivity = USER + "/UserFansListActivity";
    String USER_MessageAlertActivity = USER + "/MessageAlertActivity";
    String USER_UserMessageActivity = USER + "/UserMessageActivity";
    String USER_FocusActivity = USER + "/FocusActivity";
    String USER_CloudActivity = USER + "/CloudActivity";
    String USER_WorldActivity = USER + "/WorldActivity";
    String USER_RecommendActivity = USER + "/RecommendActivity";
    String USER_CustomChannelActivity = USER + "/CustomChannelActivity";

    String USER_CommentDetailActivity = USER + "/CommentDetailActivity";
    String USER_MomentDetailActivity = USER + "/MomentDetailActivity";
    String USER_PostDetailActivity = USER + "/PostDetailActivity";
    String USER_AddForumActivity = USER + "/AddForumActivity";
    String USER_ForumDetailActivity = USER + "/ForumDetailActivity";
    String USER_TopicDetailActivity = USER + "/TopicDetailActivity";
    String USER_TagDetailActivity = USER + "/TagDetailActivity";
    String USER_RecommendDetailActivity = USER + "/RecommendDetailActivity";
    String USER_LeaderBoardDetailActivity = USER + "/LeaderBoardDetailActivity";

    String USER_EditUserActivity = USER + "/EditUserActivity";
    String USER_RecommendEditorActivity = USER + "/RecommendEditorActivity";

    String USER_AddMomentActivity = USER + "/AddMomentActivity";
    String USER_AddCommentActivity = USER + "/AddCommentActivity";
    String USER_AddPostActivity = USER + "/AddPostActivity";
    String USER_AddTopicActivity = USER + "/AddTopicActivity";
    String USER_AddTagActivity = USER + "/AddTagActivity";
    String USER_AddMetaPermissionActivity = USER + "/AddMetaPermissionActivity";
    String USER_AddHunPermissionActivity = USER + "/AddHunPermissionActivity";
    String USER_AddRoleActivity = USER + "/AddRoleActivity";
    String USER_AddIdentityActivity = USER + "/AddIdentityActivity";
    String USER_AddAuthActivity = USER + "/AddAuthActivity";
    String USER_AddRecommendActivity = USER + "/AddRecommendActivity";
    String USER_AddLeaderBoardActivity = USER + "/AddLeaderBoardActivity";
    String USER_AddAndroidAppActivity = USER + "/AddAndroidAppActivity";
    String USER_AddiOSAppActivity = USER + "/AddiOSAppActivity";
    String USER_AddMacAppActivity = USER + "/AddMacAppActivity";
    String USER_AddPluginAppActivity = USER + "/AddPluginAppActivity";
    String USER_AddWebAppActivity = USER + "/AddWebAppActivity";
    String USER_AddWindowsAppActivity = USER + "/AddWindowsAppActivity";
    String USER_EditPluginAppActivity = USER + "/EditPluginAppActivity";
    String USER_MailEditorActivity = USER + "/MailEditorActivity";
    String USER_SendMailActivity = USER + "/SendMailActivity";
    String USER_SendItemActivity = USER + "/SendItemActivity";
    String USER_SendCubeActivity = USER + "/SendCubeActivity";
    String USER_CubeSkillEditorActivity = USER + "/CubeSkillEditorActivity";
    String USER_CubeStarEditorActivity = USER + "/CubeStarEditorActivity";
    String USER_CubeRolesEditorActivity = USER + "/CubeRolesEditorActivity";
    String USER_CubeAttrEditorActivity = USER + "/CubeAttrEditorActivity";
    String USER_CubeSettingEditorActivity = USER + "/CubeSettingEditorActivity";

    String USER_AllAuthActivity = USER + "/AllAuthActivity";
    String USER_AllForumActivity = USER + "/AllForumActivity";
    String USER_AllMomentActivity = USER + "/AllMomentActivity";
    String USER_AllTopicActivity = USER + "/AllTopicActivity";
    String USER_AllTagActivity = USER + "/AllTagActivity";
    String USER_AllMetaPermissionActivity = USER + "/AllMetaPermissionActivity";
    String USER_AllHunPermissionActivity = USER + "/AllHunPermissionActivity";
    String USER_AllRoleActivity = USER + "/AllRoleActivity";
    String USER_AllIdentityActivity = USER + "/AllIdentityActivity";
    String USER_AllUserActivity = USER + "/AllUserActivity";
    String USER_AllLeaderBoardActivity = USER + "/AllLeaderBoardActivity";
    String USER_AllRecommendActivity = USER + "/AllRecommendActivity";
    String USER_AllAppActivity = USER + "/AllAppActivity";
    String USER_AllTraceActivity = USER + "/AllTraceActivity";
    String USER_AllMailActivity = USER + "/AllMailActivity";
    String USER_AllOwnMailActivity = USER + "/AllOwnMailActivity";
    String USER_AllOwnCubeActivity = USER + "/AllOwnCubeActivity";
    String USER_AllShopActivity = USER + "/AllShopActivity";
    String USER_ShopEditorActivity = USER + "/ShopEditorActivity";
    String USER_GameHomeActivity = USER + "/GameHomeActivity";
    String USER_ItemEditorActivity = USER + "/ItemEditorActivity";
    String USER_ThingItemEditorActivity = USER + "/ThingItemEditorActivity";
    String USER_PackageItemEditorActivity = USER + "/PackageItemEditorActivity";
    String USER_DataItemEditorActivity = USER + "/DataItemEditorActivity";
    String USER_EquipItemEditorActivity = USER + "/EquipItemEditorActivity";
    String USER_BuffItemEditorActivity = USER + "/BuffItemEditorActivity";
    String USER_CubeItemEditorActivity = USER + "/CubeItemEditorActivity";
    String USER_TaskActivity = USER + "/TaskActivity";
    String USER_AllTaskActivity = USER + "/AllTaskActivity";
    String USER_AllItemActivity = USER + "/AllItemActivity";
    String USER_UrlActivityEditorActivity = USER + "/UrlActivityEditorActivity";
    String USER_TextUrlActivityEditorActivity = USER + "/TextUrlActivityEditorActivity";
    String USER_OneTaskActivityEditorActivity = USER + "/OneTaskActivityEditorActivity";
    String USER_SevenDaySignActivityEditorActivity = USER + "/SevenDaySignActivityEditorActivity";
    String USER_AchievementActivityEditorActivity = USER + "/AchievementActivityEditorActivity";
    String USER_CardActivityEditorActivity = USER + "/CardActivityEditorActivity";
    String USER_DoubleActivityEditorActivity = USER + "/DoubleActivityEditorActivity";
    String USER_DreamActivityEditorActivity = USER + "/DreamActivityEditorActivity";
    String USER_EveryDayMainActivityEditorActivity = USER + "/EveryDayMainActivityEditorActivity";
    String USER_GetBackActivityEditorActivity = USER + "/GetBackActivityEditorActivity";
    String USER_LifeActivityEditorActivity = USER + "/LifeActivityEditorActivity";
    String USER_PriceActivityEditorActivity = USER + "/PriceActivityEditorActivity";
    String USER_DataTaskEditorActivity = USER + "/DataTaskEditorActivity";

    String LEADERBOARD_LeaderBoardHomeActivity = LEADERBOARD + "/LeaderBoardHomeActivity";
    String LEADERBOARD_LeaderBoardDetailActivity = LEADERBOARD + "/LeaderBoardDetailActivity";
    String LEADERBOARD_RecommendActivity = LEADERBOARD + "/RecommendActivity";

    String USER_FocusFragment = USER + FRAGMENT + "/FocusFragment";
    String USER_TraceFragment = USER + FRAGMENT + "/TraceFragment";
    String USER_MailFragment = USER + FRAGMENT + "/MailFragment";
    String USER_OwnMailFragment = USER + FRAGMENT + "/OwnMailFragment";
    String USER_MailDetailFragment = USER + FRAGMENT + "/MailDetailFragment";
    String USER_BagFragment = USER + FRAGMENT + "/BagFragment";
    String USER_ItemDetailFragment = USER + FRAGMENT + "/ItemDetailFragment";
    String USER_WorldFragment = USER + FRAGMENT + "/WorldFragment";
    String USER_ForumFragment = USER + FRAGMENT + "/ForumFragment";
    String USER_RecommendFragment = USER + FRAGMENT + "/RecommendFragment";
    String USER_CloudFragment = USER + FRAGMENT + "/CloudFragment";
    String USER_UserFragment = USER + FRAGMENT + "/UserFragment";
    String USER_ActivityPriceFragment = USER + FRAGMENT + "/ActivityPriceFragment";
    String USER_ActivityMainFragment = USER + FRAGMENT + "/ActivityMainFragment";
    String USER_ActivityLifeFragment = USER + FRAGMENT + "/ActivityLifeFragment";
    String USER_ActivityDreamFragment = USER + FRAGMENT + "/ActivityDreamFragment";
    String USER_ActivityCustomFragment = USER + FRAGMENT + "/ActivityCustomFragment";
    String USER_ActivityCardFragment = USER + FRAGMENT + "/ActivityCardFragment";
    String USER_ActivityAchieveFragment = USER + FRAGMENT + "/ActivityAchieveFragment";
    String USER_ActivityDoubleFragment = USER + FRAGMENT + "/ActivityDoubleFragment";
    String USER_ActivityGetBackFragment = USER + FRAGMENT + "/ActivityGetBackFragment";
    String USER_OwnItemDetailFragment = USER + FRAGMENT + "/OwnItemDetailFragment";

    String USER_GameHomeFragment = USER + FRAGMENT + "/GameHomeFragment";
    String USER_BagActivity = USER + "/BagActivity";
    String USER_ShopActivity = USER + "/ShopActivity";
    String USER_CubeActivity = USER + "/CubeActivity";
    String USER_CardActivity = USER + "/CardActivity";
    //endregion

    //region module-search 搜索
    String SEARCH_SearchActivity = SEARCH + "/SearchActivity";
    String SEARCH_SelectActivity = SEARCH + "/SelectActivity";
    String SEARCH_SearchUserFragment = SEARCH + "/SearchUserFragment";
    String SEARCH_SelectUserFragment = SEARCH + "/SelectUserFragment";
    String SEARCH_SelectHunPermissionFragment = SEARCH + "/SelectHunPermissionFragment";
    String SEARCH_SelectMetaPermissionFragment = SEARCH + "/SelectMetaPermissionFragment";
    String SEARCH_SelectIdentityFragment = SEARCH + "/SelectIdentityFragment";
    String SEARCH_SelectRoleFragment = SEARCH + "/SelectRoleFragment";
    String SEARCH_SelectAppFragment = SEARCH + "/SelectAppFragment";
    String SEARCH_SelectMailFragment = SEARCH + "/SelectMailFragment";
    String SEARCH_SelectBlockFragment = SEARCH + "/SelectBlockFragment";
    //endregion

    //region 小说
    String NOVEL_ReadBookActivity = NOVEL + "/ReadBookActivity";
    String NOVEL_BookDetailActivity = NOVEL + "/BookDetailActivity";
    String NOVEL_BookShelfActivity = NOVEL + "/BookShelfActivity";
    String NOVEL_SearchBookActivity = NOVEL + "/SearchBookActivity";
    String NOVEL_ReadStyleActivity = NOVEL + "/ReadStyleActivity";
    String NOVEL_BookListFragment = NOVEL + FRAGMENT + "/BookListFragment";

    String NOVEL_ConversationBookListActivity = NOVEL + "/ConversationBookListActivity";
    String NOVEL_ConversationBookListFragment = NOVEL + FRAGMENT + "/ConversationBookListFragment";
    String NOVEL_ConversationSearchActivity = NOVEL + "/ConversationSearchActivity";
    String NOVEL_ConversationSearchFragment = NOVEL + FRAGMENT + "/ConversationSearchFragment";
    //endregion

    //region module-main
    String MAIN_TagListActivity = MAIN + "master" + "/TagListActivity";
    String MAIN_ContainerListActivity = MAIN + "master" + "/CollectionListActivity";
    String MAIN_PermissionActivity = MAIN + "master" + "/PermissionActivity";

    String MAIN_SearchEngineActivity = MAIN + "controller" + "/SearchEngineActivity";

    String MAIN_MiniAppsActivity = MAIN + "controller" + "/MiniAppsActivity";
    String MAIN_ChooseShortcutsActivity = MAIN + "controller" + "/ChooseShortcutsActivity";
    String MAIN_SettingMiniAppActivity = MAIN + "controller" + "/SettingMiniAppActivity";
    //endregion

    //region data
    String Data_DataManagerActivity = DATA + "/DataManagerActivity";
    String Data_DataDetailActivity = DATA + "/DataDetailActivity";
    //endregion

    //region global service 服务
    String GLOBAL_WindowServiceImpl = GLOBAL + "controller" + SERVICE + "/WindowService";
    String GLOBAL_WidgetServiceImpl = GLOBAL + "master" + SERVICE + "/WidgetService";
    String GLOBAL_NotificationServiceImpl = GLOBAL + SERVICE + "/NotificationService";
    String GLOBAL_TileServiceImpl = GLOBAL + SERVICE + "/TileService";
    String GLOBAL_BubbleServiceImpl = GLOBAL + SERVICE + "/BubbleService";
    String GLOBAL_AlarmServiceImpl = GLOBAL + SERVICE + "/AlarmService";
    String GLOBAL_DegradeServiceImpl = GLOBAL + SERVICE + "/DegradeServiceImpl";
    String GLOBAL_PathReplaceServiceImpl = GLOBAL + SERVICE + "/PathReplaceServiceImpl";
    String GLOBAL_BuglyService = GLOBAL + "bugly" + SERVICE + "/BuglyServiceImpl";
    String GLOBAL_BlockService = GLOBAL + "block" + SERVICE + "/BlockServiceImpl";
    String GLOBAL_MtaService = GLOBAL + "mta" + SERVICE + "/MtaServiceImpl";
    String GLOBAL_MonitorService = GLOBAL + "monitor" + SERVICE + "/MonitorServiceImpl";
    String GLOBAL_BookShelfService = GLOBAL + "book" + SERVICE + "/BookShelfServiceImpl";
    String GLOBAL_UserService = GLOBAL + "user" + SERVICE + "/UserServiceImpl";
    String GLOBAL_ImageUploadService = GLOBAL + "user" + SERVICE + "/ImageUploadServiceImpl";
    String GLOBAL_ForumService = GLOBAL + "user" + SERVICE + "/ForumServiceImpl";
    String GLOBAL_PermissionService = GLOBAL + "user" + SERVICE + "/PermissionServiceImpl";
    String GLOBAL_ChangeReminderService = GLOBAL + "time" + SERVICE + "/ChangeReminderServiceImpl";
    String GLOBAL_HabitService = GLOBAL + "time" + SERVICE + "/HabitServiceImpl";
    String GLOBAL_PictureBedService = GLOBAL + "plugin" + SERVICE + "/PictureBedServiceImpl";
    String GLOBAL_PluginService = GLOBAL + "plugin" + SERVICE + "/PluginServiceImpl";
    String GLOBAL_FileContainerService = GLOBAL + "file" + SERVICE + "/FileContainerServiceImpl";
    String GLOBAL_OnlineContainerService = GLOBAL + "file" + SERVICE + "/OnlineContainerServiceImpl";
    String GLOBAL_BrowserContainerService = GLOBAL + "file" + SERVICE + "/BrowserContainerServiceImpl";
    String GLOBAL_ReaderContainerService = GLOBAL + "file" + SERVICE + "/ReaderContainerServiceImpl";

    String GLOBAL_TaskFloatService = GLOBAL + "floatview_task" + SERVICE + "/TaskFloatServiceImpl";
    String GLOBAL_NoteFloatService = GLOBAL + "floatview_note" + SERVICE + "/NoteFloatServiceImpl";
    String GLOBAL_HabitFloatService = GLOBAL + "floatview_habit" + SERVICE + "/HabitFloatServiceImpl";
    String GLOBAL_NovelFloatService = GLOBAL + "floatview_novel" + SERVICE + "/NovelFloatServiceImpl";
    //endregion

    //region burst link
    String BURSTLINK_BurstLinkActivity = BURSTLINK + "/BurstLinkActivity";
    //endregion

    //region keyboard
    String KEYBOARD_SettingKeyboardActivity = KEYBOARD + "/SettingKeyboardActivity";
    //endregion

    //region github
    String GITHUB_MainActivity = GITHUB + "/MainActivity";
    String GITHUB_RepoSupportFragment = GITHUB + FRAGMENT + "/RepoSupportFragment";
    String GITHUB_ThemeActivity = GITHUB + "/ThemeActivity";
    //endregion

    //region artifact 造物
    String ARTIFACT_MainActivity = ARTIFACT + "/MainActivity";
    //endregion

    // region 详情页
    String APP_DETAIL_AppDetailActivity = APP_DETAIL + "/AppDetailActivity";
    //endregion

    //region 开发者
    String DEVELOPER_DeveloperActivity = DEVELOPER + "/DeveloperActivity";
    String DEVELOPER_RecommendActivity = DEVELOPER + "/RecommendActivity";
    String DEVELOPER_MiaoKeyActivity = DEVELOPER + "/MiaoKeyActivity";
    String DEVELOPER_RecordActivity = DEVELOPER + "/RecordActivity";
    //endregion

    //region 本地Git
    String GIT_RepoListActivity = GIT + "/RepoListActivity";
    String GIT_RepoDetailActivity = GIT + "/RepoDetailActivity";
    String GIT_RepoListFragment = GIT + "/RepoListFragment";
    //endregion

    //region 课程表
    String TIMETABLE_MainActivity = TIMETABLE + "/MainActivity";
    String TIMETABLE_TimeTableSupportFragment = TIMETABLE + "/TimeTableSupportFragment";
    String TIMETABLE_SearchSchoolActivity = TIMETABLE + "/SearchSchoolActivity";
    String TIMETABLE_BindSchoolActivity = TIMETABLE + "/BindSchoolActivity";
    //  String TIMETABLE_SearchSchoolActivity = TIMETABLE  + "/SearchSchoolActivity";
    //  String TIMETABLE_SearchSchoolActivity = TIMETABLE  + "/SearchSchoolActivity";

    //endregion

    //region org 编辑器
    String ORG_MainActivity = ORG + "/MainActivity";
    String ORG_NoteBookFragment = ORG + "/NoteBookFragment";
    String ORG_ThingsActivity = ORG + "/ThingsActivity";
    String ORG_StartDoingActivity = ORG + "/StartDoingActivity";
    String ORG_SettingActivity = ORG + "/SettingActivity";

    String ORG_BrowserActivity = ORG + "/BrowserActivity";
    String ARG_STARTING_DIRECTORY = "starting_directory";
    String ARG_DIRECTORY = "directory";
    String ARG_IS_FILE_SELECTABLE = "is_file_selectable";
    //endregion

    //region im
    String IM_MainActivity = IM + "/MainActivity";
    String IM_UserDetailActivity = IM + "/UserDetailActivity";
    String IM_ChatActivity = IM + "/ChatActivity";
    String IM_NewFriendActivity = IM + "/NewFriendActivity";

    String IM_SelfChatFragment = MASTER_SelfChatFragment;
    String IM_LocalChatFragment = MASTER_LocalChatFragment;
    String IM_IMLocalChatFragment = MASTER_IMLocalChatFragment;
    String IM_LocalConversationFragment = MASTER_LocalConversationFragment;
    String IM_IMLocalChatActivity = MASTER_IMLocalChatActivity;
    //endregion

    //region FILE_EXPLORER
    String FILE_EXPLORER_FileExplorerActivity = FILE_EXPLORER + "/FileExplorerActivity";
    //endregion

    //region theme
    String THEME_ThemeActivity = THEME + "/ThemeActivity";
    //endregion

    //region plugin
    String PLUGIN_PluginListActivity = PLUGIN + "user" + "/PluginListActivity";
    String PLUGIN_PictureBedActivity = PLUGIN + "/PictureBedActivity";
    //endregion

    //region 文件浏览器
    String EXPLORER_DocumentsActivity = EXPLORER + "/DocumentsActivity";
    String EXPLORER_ExplorerFragment = EXPLORER + "/ExplorerFragment";
    //endregion

    // region terminal
    String TERMINAL_NeoTermActivity = TERMINAL + "/NeoTermActivity";
    String TERMINAL_NeoTermFragment = TERMINAL + "/NeoTermFragment";
    String TERMINAL_ShellFragment = TERMINAL + "/ShellFragment";
    //endregion

    //region 开发者
    String MOMENT_MomentFriendCircleActivity = MOMENT + "/MomentFriendCircleActivity";
    String MOMENT_PhotoBrowseActivity = MOMENT + "/PhotoBrowseActivity";
    String MOMENT_MomentFriendCircleFragment = MOMENT + FRAGMENT + "/MomentFriendCircleFragment";
    String MOMENT_MomentFriendCircleMiniFragment = MOMENT + FRAGMENT + "/MomentFriendCircleMiniFragment";
    String MOMENT_MomentFriendCircleFragmentActivity = MOMENT + "/MomentFriendCircleFragmentActivity";

    @Retention(RetentionPolicy.SOURCE)
    @interface PublishActivity {

        String path = MOMENT + "/PublishActivity";
        String key_mode = "mode";
        String key_photoList = "photoList";
        int MODE_TEXT = 0x10;
        int MODE_MULTI = 0x11;
        int requestCode = 0x21;
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface PhotoMultiBrowserActivity {

        String path = PHOTOSELECTOR + "/PhotoMultiBrowserActivity";
        String key_browserinfo = "browserinfo";
        String key_maxSelectCount = "maxSelectCount";
        String key_result = "selectedphoto";

        int requestCode = 0x20;
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface PhotoSelectActivity {

        String path = PHOTOSELECTOR + "/PhotoSelectActivity";
        String key_photoList = "photoList";
        String key_maxSelectCount = "maxSelectCount";
        String key_result = "selectedphoto";
        int requestCode = 0x22;
    }
    //endregion

    //region material files
    String FILES_FilesFragment = FILES + "/FilesFragment";
    String FILES_FilesActivity = FILES + "/FilesActivity";
    String FILES_FileListActivity = FILES + "/FileListActivity";
    //endregion

    String SCARLET_MainActivity = SCARLET + "/MainActivity";

}
