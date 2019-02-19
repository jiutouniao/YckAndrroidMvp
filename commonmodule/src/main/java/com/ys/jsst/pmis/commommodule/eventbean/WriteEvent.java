//package com.ys.jsst.pmis.commommodule.eventbean;
//
//import com.soft.xiren.db.ebook.bean.LineBean;
//import com.soft.xiren.db.ebook.bean.ThoughtBean;
//
//import java.io.Serializable;
//
///**
// * 描述：写想法和上传错误信息总线
// * 作者：yuyanjun
// * 时间： 2017-5-6 10:29
// */
//public class WriteEvent implements Serializable {
//
//    /**
//     * 0代表写想法     1.代表写错误  2. 代表写想法  3.写错误返回成功
//     */
//    int type;
//
//    private ThoughtBean thoughtBean;
//
//    /**
//     * 将线条变成想法步骤
//     */
//    private LineBean lineBean;
//
//    public WriteEvent(int i) {
//        this.type = i;
//    }
//
//    /**
//     * @return   0写想法 1写错误
//     */
//    public int getType() {
//        return type;
//    }
//
//
//    public void setType(int type) {
//        this.type = type;
//    }
//
//    public ThoughtBean getThoughtBean() {
//        return thoughtBean;
//    }
//
//    public void setThoughtBean(ThoughtBean thoughtBean) {
//        this.thoughtBean = thoughtBean;
//    }
//
//    public LineBean getLineBean() {
//        return lineBean;
//    }
//
//    public void setLineBean(LineBean lineBean) {
//        this.lineBean = lineBean;
//    }
//}
