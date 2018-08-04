package com.whmnrc.qiangbizhong.model.bean;


import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class ShopBean {


    private List<PalteListBean> PalteList;
    private List<TypeListBean> TypeList;
    private List<BannerBean> Banner;

    public List<PalteListBean> getPalteList() {
        return PalteList;
    }

    public void setPalteList(List<PalteListBean> PalteList) {
        this.PalteList = PalteList;
    }

    public List<TypeListBean> getTypeList() {
        return TypeList;
    }

    public void setTypeList(List<TypeListBean> TypeList) {
        this.TypeList = TypeList;
    }

    public List<BannerBean> getBanner() {
        return Banner;
    }

    public void setBanner(List<BannerBean> Banner) {
        this.Banner = Banner;
    }

    public static class PalteListBean {
        /**
         * Plate : {"Id":"7f0129b0-f182-4cfa-8103-f3dd5a1dbb11","Image_url":"http://192.168.1.157:8011/Resource/PhotoFile/b08ff826-8dbf-4a02-b020-e15b9dd20c12.png","MedicalPlateName":"超值商品","Sort":1,"IsGoUp":1,"CreateDate":"2018-07-28 14:35:26","StoreId":null,"ShopType":0}
         * Goods : [{"Id":"ae748fbe-b38a-44ef-a968-4d381107e07b","MedicalPlateId":"7f0129b0-f182-4cfa-8103-f3dd5a1dbb11","MedicalPlateName":"超值商品","StoreId":null,"OrganizationCode":null,"StoreName":null,"PlateSort":1,"GoodsSort":99,"IsGoUp":1,"Goods_ID":"40ce8944-6441-405d-bb98-c8cc835a8bac","GoodsPrice_ID":"2b378dca-c2ed-4b1e-90e4-0f8d087e26f8","Goods_Name":"IPhone","Goods_ImaPath":"http://192.168.1.157:8011/Resource/PhotoFile/fcd07f96-22a0-4311-81b4-bfb64a053490.png","Goods_IsOn":true,"Goods_IsBuy":true,"GoodsPrice_Stock":1000,"GoodsPrice_Price":4500,"GoodsPrice_SpecName":"Iphone 黑色","GoodsPrice_AttrName":"32G","GoodsPrice_VirtualPrice":6000}]
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
             * Id : 7f0129b0-f182-4cfa-8103-f3dd5a1dbb11
             * Image_url : http://192.168.1.157:8011/Resource/PhotoFile/b08ff826-8dbf-4a02-b020-e15b9dd20c12.png
             * MedicalPlateName : 超值商品
             * Sort : 1
             * IsGoUp : 1
             * CreateDate : 2018-07-28 14:35:26
             * StoreId : null
             * ShopType : 0
             */

            private String Id;
            private String Image_url;
            private String MedicalPlateName;
            private int Sort;
            private int IsGoUp;
            private String CreateDate;
            private Object StoreId;
            private int ShopType;

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

            public Object getStoreId() {
                return StoreId;
            }

            public void setStoreId(Object StoreId) {
                this.StoreId = StoreId;
            }

            public int getShopType() {
                return ShopType;
            }

            public void setShopType(int ShopType) {
                this.ShopType = ShopType;
            }
        }

        public static class GoodsBean {
            /**
             * Id : ae748fbe-b38a-44ef-a968-4d381107e07b
             * MedicalPlateId : 7f0129b0-f182-4cfa-8103-f3dd5a1dbb11
             * MedicalPlateName : 超值商品
             * StoreId : null
             * OrganizationCode : null
             * StoreName : null
             * PlateSort : 1
             * GoodsSort : 99
             * IsGoUp : 1
             * Goods_ID : 40ce8944-6441-405d-bb98-c8cc835a8bac
             * GoodsPrice_ID : 2b378dca-c2ed-4b1e-90e4-0f8d087e26f8
             * Goods_Name : IPhone
             * Goods_ImaPath : http://192.168.1.157:8011/Resource/PhotoFile/fcd07f96-22a0-4311-81b4-bfb64a053490.png
             * Goods_IsOn : true
             * Goods_IsBuy : true
             * GoodsPrice_Stock : 1000
             * GoodsPrice_Price : 4500
             * GoodsPrice_SpecName : Iphone 黑色
             * GoodsPrice_AttrName : 32G
             * GoodsPrice_VirtualPrice : 6000
             */

            private String Id;
            private String MedicalPlateId;
            private String MedicalPlateName;
            private Object StoreId;
            private Object OrganizationCode;
            private Object StoreName;
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

            public Object getStoreId() {
                return StoreId;
            }

            public void setStoreId(Object StoreId) {
                this.StoreId = StoreId;
            }

            public Object getOrganizationCode() {
                return OrganizationCode;
            }

            public void setOrganizationCode(Object OrganizationCode) {
                this.OrganizationCode = OrganizationCode;
            }

            public Object getStoreName() {
                return StoreName;
            }

            public void setStoreName(Object StoreName) {
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
         * Id : 3724c9bf-6e23-485c-9797-0934df178d59
         * TypeName : 日用百货
         * ParentId : 0
         * Describe : 日用百货
         * Keyword : 日用百货
         * Image_url : http://192.168.1.157:8011/Resource/PhotoFile/0717122e-3a2d-4422-9693-b8444b57ebf6.png
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

    public static class BannerBean {
        /**
         * Banner_ID : 7f0afb95-e2ba-43e1-bb36-76eed1c6de04
         * Banner_Url : http://192.168.1.157:8011/Resource/PhotoFile/76d66575-b992-4dc2-9ef8-50a76c725610.png
         * Banner_LinkUrl : /Resource/PhotoFile/76d66575-b992-4dc2-9ef8-50a76c725610.png
         * AppBanner_LikUrl : null
         * Category : 商城首页轮播图
         * Banner_Sort : 5
         * Name : null
         * Descriable : null
         */

        private String Banner_ID;
        private String Banner_Url;
        private String Banner_LinkUrl;
        private Object AppBanner_LikUrl;
        private String Category;
        private int Banner_Sort;
        private Object Name;
        private Object Descriable;

        public String getBanner_ID() {
            return Banner_ID;
        }

        public void setBanner_ID(String Banner_ID) {
            this.Banner_ID = Banner_ID;
        }

        public String getBanner_Url() {
            return Banner_Url;
        }

        public void setBanner_Url(String Banner_Url) {
            this.Banner_Url = Banner_Url;
        }

        public String getBanner_LinkUrl() {
            return Banner_LinkUrl;
        }

        public void setBanner_LinkUrl(String Banner_LinkUrl) {
            this.Banner_LinkUrl = Banner_LinkUrl;
        }

        public Object getAppBanner_LikUrl() {
            return AppBanner_LikUrl;
        }

        public void setAppBanner_LikUrl(Object AppBanner_LikUrl) {
            this.AppBanner_LikUrl = AppBanner_LikUrl;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }

        public int getBanner_Sort() {
            return Banner_Sort;
        }

        public void setBanner_Sort(int Banner_Sort) {
            this.Banner_Sort = Banner_Sort;
        }

        public Object getName() {
            return Name;
        }

        public void setName(Object Name) {
            this.Name = Name;
        }

        public Object getDescriable() {
            return Descriable;
        }

        public void setDescriable(Object Descriable) {
            this.Descriable = Descriable;
        }
    }
}
