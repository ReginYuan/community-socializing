@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.HBuilder;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.appframe.AppConfig;
import io.dcloud.uniapp.extapi.exit as uni_exit;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
var firstBackTime: Number = 0;
open class GenApp : BaseApp {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLaunch(fun(_: OnLaunchOptions) {
            console.log("App Launch", " at App.uvue:5");
        }
        , instance);
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show", " at App.uvue:8");
        }
        , instance);
        onHide(fun() {
            console.log("App Hide", " at App.uvue:11");
        }
        , instance);
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress", " at App.uvue:15");
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"));
                firstBackTime = Date.now();
                setTimeout(fun(){
                    firstBackTime = 0;
                }, 2000);
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now();
                uni_exit(null);
            }
        }
        , instance);
        onExit(fun() {
            console.log("App Exit", " at App.uvue:32");
        }
        , instance);
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("uni-row" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")));
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = utsArrayOf(), emits = Map(), components = Map(), styles = GenApp.styles);
}
, fun(instance): GenApp {
    return GenApp(instance);
}
);
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles);
}
, fun(instance): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance);
}
);
val GenPagesTopicTopicClass = CreateVueComponent(GenPagesTopicTopic::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesTopicTopic.inheritAttrs, inject = GenPagesTopicTopic.inject, props = GenPagesTopicTopic.props, propsNeedCastKeys = GenPagesTopicTopic.propsNeedCastKeys, emits = GenPagesTopicTopic.emits, components = GenPagesTopicTopic.components, styles = GenPagesTopicTopic.styles);
}
, fun(instance): GenPagesTopicTopic {
    return GenPagesTopicTopic(instance);
}
);
val GenPagesMyMyClass = CreateVueComponent(GenPagesMyMy::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesMyMy.inheritAttrs, inject = GenPagesMyMy.inject, props = GenPagesMyMy.props, propsNeedCastKeys = GenPagesMyMy.propsNeedCastKeys, emits = GenPagesMyMy.emits, components = GenPagesMyMy.components, styles = GenPagesMyMy.styles);
}
, fun(instance): GenPagesMyMy {
    return GenPagesMyMy(instance);
}
);
val GenPagesMsgMsgClass = CreateVueComponent(GenPagesMsgMsg::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesMsgMsg.inheritAttrs, inject = GenPagesMsgMsg.inject, props = GenPagesMsgMsg.props, propsNeedCastKeys = GenPagesMsgMsg.propsNeedCastKeys, emits = GenPagesMsgMsg.emits, components = GenPagesMsgMsg.components, styles = GenPagesMsgMsg.styles);
}
, fun(instance): GenPagesMsgMsg {
    return GenPagesMsgMsg(instance);
}
);
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass);
    return object : UTSJSONObject() {
        var app = app
    };
}
fun main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()["app"] as VueApp).mount(app);
}
open class UniAppConfig : AppConfig {
    override var name: String = "community-socializing";
    override var appid: String = "";
    override var versionName: String = "1.0.0";
    override var versionCode: String = "100";
    override var uniCompileVersion: String = "4.06";
    constructor(){}
}
fun definePageRoutes() {
    __uniRoutes.push(PageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = PageMeta(isQuit = true), style = utsMapOf("navigationBarTitleText" to "卷王自习室")));
    __uniRoutes.push(PageRoute(path = "pages/topic/topic", component = GenPagesTopicTopicClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/my/my", component = GenPagesMyMyClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/msg/msg", component = GenPagesMsgMsgClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
}
val __uniTabBar: Map<String, Any?>? = null;
val __uniLaunchPage: Map<String, Any?> = utsMapOf("url" to "pages/index/index", "style" to utsMapOf("navigationBarTitleText" to "卷王自习室"));
@Suppress("UNCHECKED_CAST")
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/index/index";
    __uniConfig.globalStyle = utsMapOf("navigationBarTextStyle" to "black", "navigationBarTitleText" to "卷王自习室", "navigationBarBackgroundColor" to "#ffffff", "backgroundColor" to "#ffffff");
    __uniConfig.tabBar = __uniTabBar as Map<String, Any>?;
    __uniConfig.conditionUrl = "";
    __uniConfig.uniIdRouter = utsMapOf();
    __uniConfig.ready = true;
}
fun getApp(): GenApp {
    return getBaseApp() as GenApp;
}
