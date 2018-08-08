package com.whmnrc.qiangbizhong.model.parameter;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/8.
 */

public class AgentshopParam {


    /**
     * PageIndex : 0
     * PageCount : 0
     * TotalCount : 0
     * KeyWord : string
     * SortType : string
     * SortIndex : 0
     * SortName : string
     * ProductTypeId : string
     */

    private int PageIndex;
    private int PageCount;
    private int TotalCount;
    private String KeyWord;
    private String SortType;
    private int SortIndex;
    private String SortName;
    private String ProductTypeId;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int PageCount) {
        this.PageCount = PageCount;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String KeyWord) {
        this.KeyWord = KeyWord;
    }

    public String getSortType() {
        return SortType;
    }

    public void setSortType(String SortType) {
        this.SortType = SortType;
    }

    public int getSortIndex() {
        return SortIndex;
    }

    public void setSortIndex(int SortIndex) {
        this.SortIndex = SortIndex;
    }

    public String getSortName() {
        return SortName;
    }

    public void setSortName(String SortName) {
        this.SortName = SortName;
    }

    public String getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(String ProductTypeId) {
        this.ProductTypeId = ProductTypeId;
    }
}
