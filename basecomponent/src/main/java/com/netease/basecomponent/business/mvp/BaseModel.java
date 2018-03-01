package com.netease.basecomponent.business.mvp;

import com.netease.basecomponent.mvp.m.BaseCoreModel;
import com.netease.basecomponent.mvp.m.IModelCallback;

/**
 * 做一些业务的相关的东西， 比如将每个业务的 apiService 在这里做一个管理
 * 封装统一请求的方法和回调
 *
 * Created by jiangcheng on 2018/3/1.
 */

public abstract class BaseModel<L extends IModelCallback> extends BaseCoreModel<L> {


}
