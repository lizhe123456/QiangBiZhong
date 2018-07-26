package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/25.
 */

public class YiMeiIndexBean {


    private List<MedicalListBean> MedicalList;
    private List<TypeListBean> TypeList;
    private List<?> Banner;

    public List<MedicalListBean> getMedicalList() {
        return MedicalList;
    }

    public void setMedicalList(List<MedicalListBean> MedicalList) {
        this.MedicalList = MedicalList;
    }

    public List<TypeListBean> getTypeList() {
        return TypeList;
    }

    public void setTypeList(List<TypeListBean> TypeList) {
        this.TypeList = TypeList;
    }

    public List<?> getBanner() {
        return Banner;
    }

    public void setBanner(List<?> Banner) {
        this.Banner = Banner;
    }

    public static class MedicalListBean {
        /**
         * Plate : {"Id":"542cb9af-a91f-40d5-8405-09268518123d","Image_url":"/Resource/PhotoFile/6791dd12-7599-4a1c-a50f-b5b31e42c484.jpg","MedicalPlateName":"韩国整形板块","Sort":0,"IsGoUp":1,"CreateDate":"2018-07-21 11:00:00","StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4"}
         * Goods : [{"Id":"642cb9af-a91f-40d5-8405-09268518123c","MedicalPlateId":"542cb9af-a91f-40d5-8405-09268518123d","MedicalPlateName":"韩国整形板块","StoreId":"43956e13-8dd6-476b-b6e4-02a73be238c4","OrganizationCode":"01899317623","StoreName":"艾美链","PlateSort":0,"GoodsSort":0,"IsGoUp":1,"Goods_ID":"142cb9af-a91f-40d5-8405-09268518123d","GoodsPrice_ID":"49e5277a-13c0-4e86-9ce8-9ae0af37bf04","Goods_Name":"韩式硅胶隆鼻","Goods_ImaPath":"/Resource/PhotoFile/7d9b5da3-22e3-41b0-b2df-a5464736dcef.jpg","Goods_IsOn":true,"Goods_IsBuy":true,"GoodsPrice_Stock":0,"GoodsPrice_Price":168,"GoodsPrice_SpecName":"盒","GoodsPrice_AttrName":"一号","GoodsPrice_VirtualPrice":300}]
         */

        private PlateBean Plate;
        private List<GoodsBean> Goods;

        public PlateBean getPlate() {
            return Plate;
        }

        public void setPlate(PlateBean Plate) {
            this.Plate = Plate;
        }

        public List<GoodsBean> getGoods() {
            return Goods;
        }

        public void setGoods(List<GoodsBean> Goods) {
            this.Goods = Goods;
        }

        public static class PlateBean {
            /**
             * Id : 542cb9af-a91f-40d5-8405-09268518123d
             * Image_url : /Resource/PhotoFile/6791dd12-7599-4a1c-a50f-b5b31e42c484.jpg
             * MedicalPlateName : 韩国整形板块
             * Sort : 0
             * IsGoUp : 1
             * CreateDate : 2018-07-21 11:00:00
             * StoreId : 43956e13-8dd6-476b-b6e4-02a73be238c4
             */

            private String Id;
            private String Image_url;
            private String MedicalPlateName;
            private int Sort;
            private int IsGoUp;
            private String CreateDate;
            private String StoreId;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getImage_url() {
                return Image_url;
            }

            public void setImage_url(String Image_url) {
                this.Image_url = Image_url;
            }

            public String getMedicalPlateName() {
                return MedicalPlateName;
            }

            public void setMedicalPlateName(String MedicalPlateName) {
                this.MedicalPlateName = MedicalPlateName;
            }

            public int getSort() {
                return Sort;
            }

            public void setSort(int Sort) {
                this.Sort = Sort;
            }

            public int getIsGoUp() {
                return IsGoUp;
            }

            public void setIsGoUp(int IsGoUp) {
                this.IsGoUp = IsGoUp;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            public String getStoreId() {
                return StoreId;
            }

            public void setStoreId(String StoreId) {
                this.StoreId = StoreId;
            }
        }

        public static class GoodsBean {
            /**
             * Id : 642cb9af-a91f-40d5-8405-09268518123c
             * MedicalPlateId : 542cb9af-a91f-40d5-8405-09268518123d
             * MedicalPlateName : 韩国整形板块
             * StoreId : 43956e13-8dd6-476b-b6e4-02a73be238c4
             * OrganizationCode : 01899317623
             * StoreName : 艾美链
             * PlateSort : 0
             * GoodsSort : 0
             * IsGoUp : 1
             * Goods_ID : 142cb9af-a91f-40d5-8405-09268518123d
             * GoodsPrice_ID : 49e5277a-13c0-4e86-9ce8-9ae0af37bf04
             * Goods_Name : 韩式硅胶隆鼻
             * Goods_ImaPath : /Resource/PhotoFile/7d9b5da3-22e3-41b0-b2df-a5464736dcef.jpg
             * Goods_IsOn : true
             * Goods_IsBuy : true
             * GoodsPrice_Stock : 0
             * GoodsPrice_Price : 168
             * GoodsPrice_SpecName : 盒
             * GoodsPrice_AttrName : 一号
             * GoodsPrice_VirtualPrice : 300
             */

            private String Id;
            private String MedicalPlateId;
            private String MedicalPlateName;
            private String StoreId;
            private String OrganizationCode;
            private String StoreName;
            private int PlateSort;
            private int GoodsSort;
            private int IsGoUp;
            private String Goods_ID;
            private String GoodsPrice_ID;
            private String Goods_Name;
            private String Goods_ImaPath;
            private boolean Goods_IsOn;
            private boolean Goods_IsBuy;
            private int GoodsPrice_Stock;
            private int GoodsPrice_Price;
            private String GoodsPrice_SpecName;
            private String GoodsPrice_AttrName;
            private int GoodsPrice_VirtualPrice;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getMedicalPlateId() {
                return MedicalPlateId;
            }

            public void setMedicalPlateId(String MedicalPlateId) {
                this.MedicalPlateId = MedicalPlateId;
            }

            public String getMedicalPlateName() {
                return MedicalPlateName;
            }

            public void setMedicalPlateName(String MedicalPlateName) {
                this.MedicalPlateName = MedicalPlateName;
            }

            public String getStoreId() {
                return StoreId;
            }

            public void setStoreId(String StoreId) {
                this.StoreId = StoreId;
            }

            public String getOrganizationCode() {
                return OrganizationCode;
            }

            public void setOrganizationCode(String OrganizationCode) {
                this.OrganizationCode = OrganizationCode;
            }

            public String getStoreName() {
                return StoreName;
            }

            public void setStoreName(String StoreName) {
                this.StoreName = StoreName;
            }

            public int getPlateSort() {
                return PlateSort;
            }

            public void setPlateSort(int PlateSort) {
                this.PlateSort = PlateSort;
            }

            public int getGoodsSort() {
                return GoodsSort;
            }

            public void setGoodsSort(int GoodsSort) {
                this.GoodsSort = GoodsSort;
            }

            public int getIsGoUp() {
                return IsGoUp;
            }

            public void setIsGoUp(int IsGoUp) {
                this.IsGoUp = IsGoUp;
            }

            public String getGoods_ID() {
                return Goods_ID;
            }

            public void setGoods_ID(String Goods_ID) {
                this.Goods_ID = Goods_ID;
            }

            public String getGoodsPrice_ID() {
                return GoodsPrice_ID;
            }

            public void setGoodsPrice_ID(String GoodsPrice_ID) {
                this.GoodsPrice_ID = GoodsPrice_ID;
            }

            public String getGoods_Name() {
                return Goods_Name;
            }

            public void setGoods_Name(String Goods_Name) {
                this.Goods_Name = Goods_Name;
            }

            public String getGoods_ImaPath() {
                return Goods_ImaPath;
            }

            public void setGoods_ImaPath(String Goods_ImaPath) {
                this.Goods_ImaPath = Goods_ImaPath;
            }

            public boolean isGoods_IsOn() {
                return Goods_IsOn;
            }

            public void setGoods_IsOn(boolean Goods_IsOn) {
                this.Goods_IsOn = Goods_IsOn;
            }

            public boolean isGoods_IsBuy() {
                return Goods_IsBuy;
            }

            public void setGoods_IsBuy(boolean Goods_IsBuy) {
                this.Goods_IsBuy = Goods_IsBuy;
            }

            public int getGoodsPrice_Stock() {
                return GoodsPrice_Stock;
            }

            public void setGoodsPrice_Stock(int GoodsPrice_Stock) {
                this.GoodsPrice_Stock = GoodsPrice_Stock;
            }

            public int getGoodsPrice_Price() {
                return GoodsPrice_Price;
            }

            public void setGoodsPrice_Price(int GoodsPrice_Price) {
                this.GoodsPrice_Price = GoodsPrice_Price;
            }

            public String getGoodsPrice_SpecName() {
                return GoodsPrice_SpecName;
            }

            public void setGoodsPrice_SpecName(String GoodsPrice_SpecName) {
                this.GoodsPrice_SpecName = GoodsPrice_SpecName;
            }

            public String getGoodsPrice_AttrName() {
                return GoodsPrice_AttrName;
            }

            public void setGoodsPrice_AttrName(String GoodsPrice_AttrName) {
                this.GoodsPrice_AttrName = GoodsPrice_AttrName;
            }

            public int getGoodsPrice_VirtualPrice() {
                return GoodsPrice_VirtualPrice;
            }

            public void setGoodsPrice_VirtualPrice(int GoodsPrice_VirtualPrice) {
                this.GoodsPrice_VirtualPrice = GoodsPrice_VirtualPrice;
            }
        }
    }

    public static class TypeListBean {
        /**
         * Id : 317c693a-b6a4-44aa-b401-98dd9e95ef69
         * TypeName : 玻尿酸
         * ParentId : 1
         * Describe : 塑料脸原材料
         * Keyword : 玻尿酸 尿 打针
         * Image_url : /Resource/PhotoFile/d8bb4447-308a-4669-83f2-d7ca0c9a7bab.png
         * Sort : 0
         * Status : 1
         */

        private String Id;
        private String TypeName;
        private String ParentId;
        private String Describe;
        private String Keyword;
        private String Image_url;
        private int Sort;
        private int Status;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getTypeName() {
            return TypeName;
        }

        public void setTypeName(String TypeName) {
            this.TypeName = TypeName;
        }

        public String getParentId() {
            return ParentId;
        }

        public void setParentId(String ParentId) {
            this.ParentId = ParentId;
        }

        public String getDescribe() {
            return Describe;
        }

        public void setDescribe(String Describe) {
            this.Describe = Describe;
        }

        public String getKeyword() {
            return Keyword;
        }

        public void setKeyword(String Keyword) {
            this.Keyword = Keyword;
        }

        public String getImage_url() {
            return Image_url;
        }

        public void setImage_url(String Image_url) {
            this.Image_url = Image_url;
        }

        public int getSort() {
            return Sort;
        }

        public void setSort(int Sort) {
            this.Sort = Sort;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }
    }
}
