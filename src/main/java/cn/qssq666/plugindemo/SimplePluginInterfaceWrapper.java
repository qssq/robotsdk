package cn.qssq666.plugindemo;

import android.content.Context;

import cn.qssq666.robot.plugin.sdk.interfaces.PluginControlInterface;
import cn.qssq666.robot.plugin.sdk.interfaces.PluginInterface;
import cn.qssq666.robot.plugin.sdk.interfaces.RobotConfigInterface;

/**
 * Created by qssq on 2018/5/17 qssq666@foxmail.com
 *
 * 用户要写插件的时候可以继承这个类，这样的花，这个成员变量就不需要每次在写了
 */
public abstract class SimplePluginInterfaceWrapper implements PluginInterface {
    public Context getContext() {
        return context;
    }

    private Context context;

    public PluginControlInterface getControlApi() {
        return controlApi;
    }

    private PluginControlInterface controlApi;

    public RobotConfigInterface getConfigApi() {
        return configApi;
    }

    private RobotConfigInterface configApi;

    @Override
    public void onReceiveControlApi(PluginControlInterface instance) {
        controlApi=instance;
    }

    @Override
    public void onReceiveRobotConfig(RobotConfigInterface robotConfigInterface) {
        configApi=robotConfigInterface;
    }

    @Override
    public void onCreate(Context context) {
        this.context=context;
    }
}
