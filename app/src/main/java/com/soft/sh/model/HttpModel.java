package com.soft.sh.model;

import com.soft.sh.bean.UpdateBean;
import com.soft.sh.param.UpdateParam;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * description: 测试网络请求
 * Date: 2016/9/9 17:49
 * User: shaobing
 */
public interface HttpModel {

    /**
     * 检查更新
     * @param  param 参数
     * @return 状态信息
     */
    @POST("common/get_latest_app")
    Observable<UpdateBean> getLatestApp(@Body UpdateParam param);
}
