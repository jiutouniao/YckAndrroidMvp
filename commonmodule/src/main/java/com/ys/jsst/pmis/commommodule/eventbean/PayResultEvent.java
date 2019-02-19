package com.ys.jsst.pmis.commommodule.eventbean;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-10-23 16:06
 */
public class PayResultEvent {
    /**
     * 支付结果  成功或失败
     */
    private boolean result;

    public PayResultEvent(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
