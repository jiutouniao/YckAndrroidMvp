package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.EpubMarkBean;
import com.soft.xiren.db.ebook.bean.PageBean;
import com.soft.xiren.db.ebook.bean.PageMassageBean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：
 * 作者：邵兵
 * 日期：2017/6/6 10:17
 */
public class EpubMarkDbModel {
    /**
     * 获取当个书签
     * @param pageBean
     * @param type
     * @return
     */
    public synchronized static EpubMarkBean getRemark(PageMassageBean pageBean, int type){
        EpubMarkBean newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getChapterId()),
                        String.valueOf(pageBean.getEndpos()),
                        String.valueOf(pageBean.getStartpos())
                )
                .order("pageChapter asc")
                .findFirst(EpubMarkBean.class);
        return newsList;
    }

    /**
     * 获取 当前书本、当前类型、 当前章节 当前页中的所有书签
     * @param pageBean
     * @param type
     * @return
     */
    public static List<EpubMarkBean> getAllRemark(PageMassageBean pageBean,int type){
        List<EpubMarkBean> newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and curBeginPos>=?  and  curBeginPos<? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getChapterId()),
                        String.valueOf(pageBean.getStartpos()),
                        String.valueOf(pageBean.getEndpos())
                )
                .find(EpubMarkBean.class);
        return newsList;
    }



    /*****************************************************************************************************************************/




    /**
     * 删除所有标签
     * @param bookId
     */
    public static void deleteAllMarkByBookId(String bookId){
        DataSupport.deleteAll(EpubMarkBean.class,"bookId = ?",bookId);
    }
    

    /**
     * 获取所有自己目录
     * @param bookId
     * @return
     */
    public static List<EpubMarkBean> getMarkByType(String bookId,int type){
        List<EpubMarkBean> bean = DataSupport
                .where("bookId = ? and type=?",bookId,String.valueOf(type))
                .order("id desc")
                .find(EpubMarkBean.class);
        return bean;
    }

    /**
     *
     * 获取所有的想法和划线，根据 op_count进行排序
     * @param bookId
     * @return
     */
    public static List<EpubMarkBean> getAllMarkByThink(String bookId){
        List<EpubMarkBean> bean = DataSupport
                .where("bookId = ? and (type=1 or type=3 or type=4)",bookId)
                .order("op_count desc")
                .find(EpubMarkBean.class);
        return bean;
    }



    /**
     * 获取 当前书本、当前类型、 当前章节 当前页中的所有书签
     * @param pageBean
     * @param type
     * @return
     */
    public static EpubMarkBean getRemark(PageBean pageBean,int type){
        EpubMarkBean newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getPageChapter()),
                        String.valueOf(pageBean.getCurEndPos()),
                        String.valueOf(pageBean.getCurBeginPos())
                )
                .order("pageChapter asc")
                .findFirst(EpubMarkBean.class);
        return newsList;
    }


    /**
     * 获取当前页的所有划线信息
     * @param bookId
     * @param pageChapter
     * @param curEndPos
     * @param curBeginPos
     * @param type
     * @return
     */
    public static EpubMarkBean getRemark(String bookId, int pageChapter ,int curEndPos,int curBeginPos,int type){
        EpubMarkBean newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(bookId),
                        String.valueOf(type),
                        String.valueOf(pageChapter),
                        String.valueOf(curEndPos),
                        String.valueOf(curBeginPos)
                )
                .order("pageChapter asc")
                .findFirst(EpubMarkBean.class);
        return newsList;
    }

    /**
     * 获取 当前书本、当前类型、 当前章节 当前页中的所有书签
     * @param pageBean
     * @param type
     * @return
     */
    public static List<EpubMarkBean> getAllRemark(PageBean pageBean,int type){
        List<EpubMarkBean> newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getPageChapter()),
                        String.valueOf(pageBean.getCurEndPos()),
                        String.valueOf(pageBean.getCurBeginPos())
                )
                .order("pageChapter asc")
                .find(EpubMarkBean.class);
        return newsList;
    }


}
