package com.soft.xiren.db.ebook.model;

import com.soft.xiren.db.ebook.bean.MarkBean;
import com.soft.xiren.db.ebook.bean.PageBean;
import com.soft.xiren.db.ebook.bean.PageMassageBean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 描述：
 * 作者：邵兵
 * 日期：2017/6/6 10:17
 */
public class MarkDbModel {
    /**
     * 获取当个书签
     * @param pageBean
     * @param type
     * @return
     */
    public synchronized static MarkBean getRemark(PageMassageBean pageBean, int type){
        MarkBean newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getChapterId()),
                        String.valueOf(pageBean.getEndpos()),
                        String.valueOf(pageBean.getStartpos())
                )
                .order("pageChapter asc")
                .findFirst(MarkBean.class);
        return newsList;
    }

    /**
     * 获取 当前书本、当前类型、 当前章节 当前页中的所有书签
     * @param pageBean
     * @param type
     * @return
     */
    public static List<MarkBean> getAllRemark(PageMassageBean pageBean,int type){
        List<MarkBean> newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and curBeginPos>=?  and  curBeginPos<? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getChapterId()),
                        String.valueOf(pageBean.getStartpos()),
                        String.valueOf(pageBean.getEndpos())
                )
                .find(MarkBean.class);
        return newsList;
    }



    /*****************************************************************************************************************************/




    /**
     * 删除所有标签
     * @param bookId
     */
    public static void deleteAllMarkByBookId(String bookId){
        DataSupport.deleteAll(MarkBean.class,"bookId = ?",bookId);
    }
    

    /**
     * 获取所有自己目录
     * @param bookId
     * @return
     */
    public static List<MarkBean> getMarkByType(String bookId,int type){
        List<MarkBean> bean = DataSupport
                .where("bookId = ? and type=?",bookId,String.valueOf(type))
                .order("id desc")
                .find(MarkBean.class);
        return bean;
    }



    /**
     *
     * 获取所有的想法和划线，根据 op_count进行排序
     * @param bookId
     * @return
     */
    public static List<MarkBean> getAllMarkByLine(String bookId){
        List<MarkBean> bean = DataSupport
                .where("bookId = ? and (type=1 or type=3 or type=4)",bookId)
                .order("op_count desc")
                .find(MarkBean.class);
        return bean;
    }
    /**
     *
     * 获取所有的想法和划线，根据 op_count进行排序
     * @param bookId
     * @return
     */
    public static List<MarkBean> getAllMarkByThink(String bookId){
        List<MarkBean> bean = DataSupport
                .where("bookId = ? and (type=1 or type=3 or type=4)",bookId)
                .order("op_count desc")
                .find(MarkBean.class);
        return bean;
    }
    /**
     *
     * 获取整页想法
     * @param bookId
     * @return
     */
    public static List<MarkBean> getMarkByThink(String bookId,int page){
        List<MarkBean> bean = DataSupport
                .where("bookId = ? and ( type=3 or type=4) and pageChapter=?",bookId,String.valueOf(page))
                .find(MarkBean.class);
        return bean;
    }

    /**
     * 获取所有的书签
     * @param bookId
     * @return
     */
    public static List<MarkBean> getAllMarkByBookMark(String bookId){
        List<MarkBean> bean = DataSupport
                .where("bookId = ? and type=0",bookId)
                .order("op_count desc")
                .find(MarkBean.class);
        return bean;
    }

    /**
     * 获取pdf当页是否是书签
     * @param bookId
     * @return
     */
    public static List<MarkBean> getAllMarkByBookMark(String bookId,int pageChapter){
        List<MarkBean> bean = DataSupport
                .where("bookId = ? and type=0 and  pageChapter = ?",bookId, String.valueOf(pageChapter))
                .order("id desc")
                .find(MarkBean.class);
        return bean;
    }

    /**
     * 删除单个标签
     * @param bean
     * @return
     */
    public static int deleteMark(MarkBean bean){
      int count = DataSupport.delete(MarkBean.class,bean.getId());
        return count;
    }
    /**
     * 删除单个标签
     * @param op_count
     * @return
     */
    public static int deleteMark(String op_count){
        int count = DataSupport.deleteAll(MarkBean.class, "op_count = ?", op_count);
        return count;
    }


    /**
     * 根据章节获取当前位置
     * @param bean
     * @return
     */
    public static int getPageIdByMark(MarkBean bean){
        int count= DataSupport
                .where("bookId=? and pageChapter<?",
                        String.valueOf(bean.getBookId()),
                        String.valueOf(bean.getPageChapter()))
                .count(PageBean.class);
        int count2= DataSupport
                .where("bookId=? and pageChapter=? and curBeginPos<? ",
                        String.valueOf(bean.getBookId()),
                        String.valueOf(bean.getPageChapter()),
                        String.valueOf(bean.getCurEndPos()))
                .count(PageBean.class);
        return count+count2;
    }


    /**
     * 获取 当前书本、当前类型、 当前章节 当前页中的所有书签
     * @param pageBean
     * @param type
     * @return
     */
    public static MarkBean getRemark(PageBean pageBean,int type){
        MarkBean newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getPageChapter()),
                        String.valueOf(pageBean.getCurEndPos()),
                        String.valueOf(pageBean.getCurBeginPos())
                )
                .order("pageChapter asc")
                .findFirst(MarkBean.class);
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
    public static MarkBean getRemark(String bookId, int pageChapter ,int curEndPos,int curBeginPos,int type){
        MarkBean newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(bookId),
                        String.valueOf(type),
                        String.valueOf(pageChapter),
                        String.valueOf(curEndPos),
                        String.valueOf(curBeginPos)
                )
                .order("pageChapter asc")
                .findFirst(MarkBean.class);
        return newsList;
    }

    /**
     * 获取 当前书本、当前类型、 当前章节 当前页中的所有书签
     * @param pageBean
     * @param type
     * @return
     */
    public static List<MarkBean> getAllRemark(PageBean pageBean,int type){
        List<MarkBean> newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(pageBean.getBookId()),
                        String.valueOf(type),
                        String.valueOf(pageBean.getPageChapter()),
                        String.valueOf(pageBean.getCurEndPos()),
                        String.valueOf(pageBean.getCurBeginPos())
                )
                .order("pageChapter asc")
                .find(MarkBean.class);
        return newsList;
    }


    /**
     * 获取 当前书本、当前类型、 当前章节 当前页中的所有书签
     * @param type
     * @return
     */
    public static List<MarkBean> getAllRemark(String bookId,int pageChapter, int curBeginPos, int curEndPos ,int type){
        List<MarkBean> newsList = DataSupport
                .where("bookId = ?  and type = ? and pageChapter=? and  curBeginPos<? and curBeginPos>=? ",
                        String.valueOf(bookId),
                        String.valueOf(type),
                        String.valueOf(pageChapter),
                        String.valueOf(curEndPos),
                        String.valueOf(curBeginPos)
                )
                .order("pageChapter asc")
                .find(MarkBean.class);
        return newsList;
    }

}
