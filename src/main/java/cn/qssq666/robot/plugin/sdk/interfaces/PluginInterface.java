package cn.qssq666.robot.plugin.sdk.interfaces;

import android.content.Context;

import cn.qssq666.robot.bean.MsgItem;

/**
 * Created by qssq on 2018/1/21 qssq666@foxmail.com
 */

public interface PluginInterface {
	/**
	 * 插件作者
	 * @return
	 */
	public String getAuthorName();
	/**
	 * 当机器人插件被创建加载后，会回调配置api控制类给插件，插件可以自己存储为成员变量，在适当的逻辑中进行操作，此api接口回调支持踢人禁言,发消息
	 * @param instance
	 */
	public void onReceiveControlApi(PluginCtronolInterface instance);

	/**
	 * 插件的版本号
	 *
	 * @return
	 */
	public int getVersionCode();
	public String getBuildTime();
	/**
	 *
	 * @return 插件的版本名
	 */
	public String getVersionName();

	/**
	 *
	 * @return 插件的包名(不要和作者的包名一样!否则)为了用户的安全，恶意流氓插件我会强制处理，对于冒充官方包名的插件校验签名。所以不要用cn.
	 *         qssq666开头的包名。
	 */
	public String getPackageName();

	/**
	 * 此机器人插件的描述信息
	 *
	 * @return 返回此插件的描述信息
	 */
	public String getDescript();
	/**
	 * 插件的名字，这里当然是中文名了，给用户看的名字嘛
	 * @return
	 */
	public String getPluginName();

	// boolean isOfficial();
	/**
	 * 本插件是否被禁用了,这和卸载不同，卸载的话文件都删除了，但是是否禁用是由用户自己实现的
	 *
	 * @return
	 */
	boolean isDisable();

	/**
	 * ，在修改机器人插件配置右边的选项卡会调用setDisable
	 * 不写无法禁用，影响体验，导致的后果就是被用户卸载咯!具体怎么实现禁用请参考demo源码
	 *
	 * @param disable
	 */
	void setDisable(boolean disable);

	/**
	 * 插件被加载进来后会把宿主的上下文传递过来，不过我感觉有风险啊，有了这东西什么都可以反射了。
	 *
	 * @param context
	 */
	void onCreate(Context context);

	/**
	 * 这里是处理逻辑的关键,首先自身命令和管理员命令逻辑会先走,之后走这里提供消息判断是否处理了此消息，如果处理了就返回true,
	 *
	 * @param item
	 * @return 插件处理了本消息就返回true,那么其他插件，或者机器人将不会被处理，防止冲突。
	 */
	boolean onReceiveMsgIsNeedIntercept(MsgItem item);

	/**
	 * 这个方法暂时没用，
	 */
	void onDestory();

	/**
	 * 插件刚加载后会提供一个机器人配置查询接口，比如已经禁用了群聊功能了，你这个机器人插件不听话还进行处理，那么下场也是被卸载了.
	 *
	 * @param robotConfigInterface
	 */
	void onReceiveRobotConfig(RobotConfigInterface robotConfigInterface);

}