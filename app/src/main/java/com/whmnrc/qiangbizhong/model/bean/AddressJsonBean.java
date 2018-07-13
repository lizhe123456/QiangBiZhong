package com.whmnrc.qiangbizhong.model.bean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/13.
 */

public class AddressJsonBean {


    /**
     * areaId : 110000
     * areaName : 不限
     * cities : [{"areaId":"110000","areaName":"不限","counties":[{"areaId":"110101","areaName":"不限"}]}]
     */

    private String areaId;
    private String areaName;
    private List<CitiesBean> cities;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<CitiesBean> getCities() {
        return cities;
    }

    public void setCities(List<CitiesBean> cities) {
        this.cities = cities;
    }

    public static class CitiesBean {
        /**
         * areaId : 110000
         * areaName : 不限
         * counties : [{"areaId":"110101","areaName":"不限"}]
         */

        private String areaId;
        private String areaName;
        private List<CountiesBean> counties;

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public List<CountiesBean> getCounties() {
            return counties;
        }

        public void setCounties(List<CountiesBean> counties) {
            this.counties = counties;
        }

        public static class CountiesBean {
            /**
             * areaId : 110101
             * areaName : 不限
             */

            private String areaId;
            private String areaName;

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }
        }
    }
}
