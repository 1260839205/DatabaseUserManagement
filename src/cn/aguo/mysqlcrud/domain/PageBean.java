package cn.aguo.mysqlcrud.domain;

import java.util.List;

/**
 * @Author 石成果
 * @Date 2020/8/24 16:30
 * @Email 1260839205@qq.com
 */
public class PageBean<T> {
    private int totalCount; //总记录数
    private int totalPageNumber; //总页码
    private List<T> listusers; //每页的数据
    private int currentPageNumber; //当前页码
    private int rows; //每页显示条数

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPageNumber, List<T> listusers, int currentPageNumber, int rows) {
        this.totalCount = totalCount;
        this.totalPageNumber = totalPageNumber;
        this.listusers = listusers;
        this.currentPageNumber = currentPageNumber;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    public void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }

    public List<T> getListusers() {
        return listusers;
    }

    public void setListusers(List<T> listusers) {
        this.listusers = listusers;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
