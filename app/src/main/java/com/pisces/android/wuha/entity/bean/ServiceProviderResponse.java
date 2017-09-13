package com.pisces.android.wuha.entity.bean;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamisonline on 2017/9/11.
 * <p>
 * 服务提供者的响应数据
 */

public class ServiceProviderResponse extends BaseEntity {


    @SerializedName("ServiceProvider")
    private ArrayList<ServiceProvider> data;

    public ArrayList<ServiceProvider> getData() {
        return data;
    }

    public void setData(ArrayList<ServiceProvider> data) {
        this.data = data;
    }

    /**
     * 服务提供者
     */
    public static class ServiceProvider {


        /**
         * Id : 5732485075008993430
         * Name : 火车北站
         * ServiceProviderAddress : {"Id":"4947533809332902844","Latitude":104.079853,"Longitude":30.703259,"MainAddressLine":"四川省成都市二环路北三段","Name":"主要地址"}
         * ServiceProviderContact : {"Id":"5707580329792543729","Name":"主要联系方式","Phone":"87654321","MobilePhone":"10987654321","OrtherContact":"OtherContact"}
         * ServiceProviderCertificationInfo : {"Id":"4711101685671623188","BusinessLicenseImagePath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504340601&di=0c4be8cf6a460c51b9ab0d222eb48dbe&imgtype=jpg&er=1&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201406%2F27%2F20140627085544_cHFnx.jpeg","LegalPersonInfoImagePath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503745927460&di=737d4db400e280d58eb23ac26c9eebea&imgtype=0&src=http%3A%2F%2Fpic20.nipic.com%2F20120403%2F7885626_091956683185_2.jpg","IsCertificationInfo":0}
         * ServiceProviderIntroduction : {"Id":"5498726687780377447","Introduction":"这里是火车北站的简单介绍","Description":"这里是火车北站的详细描述","ImagePath":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504340745&di=94e8cd756ad398a6f6c4ce132f54253b&imgtype=jpg&er=1&src=http%3A%2F%2Fpic8.nipic.com%2F20100718%2F5401072_123826008131_2.jpg","ServiceProviderBannerPaths":[{"Id":31,"Path":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503746006389&di=0db690e39e4e0570d259395a0d3ed52e&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F09%2F79%2F55d1ed2c1098a_1024.jpg"},{"Id":32,"Path":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503746006378&di=9b3160bc22fb15d3939c593e198079cf&imgtype=0&src=http%3A%2F%2Fimg155.poco.cn%2Fmypoco%2Fmyphoto%2F20090611%2F14%2F12279062200906111412311756765842618_009.jpg"}]}
         * ServiceProviderServiceCategories : [{"Id":"4757298004609728188","Name":"宠物手术","SubCategories":[{"Id":"4900610231028091476","Name":"小型手术","Price":3800},{"Id":"5037523185200550771","Name":"中型手术","Price":4800},{"Id":"5164803786160131319","Name":"大型手术","Price":5800}]},{"Id":"5226555842452527060","Name":"预诊","SubCategories":[{"Id":"4743673771592853677","Name":"初级诊断","Price":80},{"Id":"5016144334641149622","Name":"VIP服务","Price":120}]},{"Id":"5476616203023100390","Name":"清创","SubCategories":[{"Id":"4804827369523182134","Name":"小面积","Price":1200},{"Id":"4807809450169595507","Name":"大面积","Price":4800}]}]
         * StartingPrice : 80
         * ViewingCount : 0
         * CreateTime : 2017-08-26T00:00:00
         * ServiceProviderType : 1
         * Distance : 1224.466546031413
         */

        private String Id;
        private String Name;
        private ServiceProviderAddressBean ServiceProviderAddress;
        private ServiceProviderContactBean ServiceProviderContact;
        private ServiceProviderCertificationInfoBean ServiceProviderCertificationInfo;
        private ServiceProviderIntroductionBean ServiceProviderIntroduction;
        private BigDecimal StartingPrice;
        private int ViewingCount;
        private String CreateTime;
        private int ServiceProviderType;
        private double Distance;
        private List<ServiceProviderServiceCategoriesBean> ServiceProviderServiceCategories;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public ServiceProviderAddressBean getServiceProviderAddress() {
            return ServiceProviderAddress;
        }

        public void setServiceProviderAddress(ServiceProviderAddressBean ServiceProviderAddress) {
            this.ServiceProviderAddress = ServiceProviderAddress;
        }

        public ServiceProviderContactBean getServiceProviderContact() {
            return ServiceProviderContact;
        }

        public void setServiceProviderContact(ServiceProviderContactBean ServiceProviderContact) {
            this.ServiceProviderContact = ServiceProviderContact;
        }

        public ServiceProviderCertificationInfoBean getServiceProviderCertificationInfo() {
            return ServiceProviderCertificationInfo;
        }

        public void setServiceProviderCertificationInfo(ServiceProviderCertificationInfoBean ServiceProviderCertificationInfo) {
            this.ServiceProviderCertificationInfo = ServiceProviderCertificationInfo;
        }

        public ServiceProviderIntroductionBean getServiceProviderIntroduction() {
            return ServiceProviderIntroduction;
        }

        public void setServiceProviderIntroduction(ServiceProviderIntroductionBean ServiceProviderIntroduction) {
            this.ServiceProviderIntroduction = ServiceProviderIntroduction;
        }

        public BigDecimal getStartingPrice() {
            return StartingPrice;
        }

        public void setStartingPrice(BigDecimal StartingPrice) {
            this.StartingPrice = StartingPrice;
        }

        public int getViewingCount() {
            return ViewingCount;
        }

        public void setViewingCount(int ViewingCount) {
            this.ViewingCount = ViewingCount;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getServiceProviderType() {
            return ServiceProviderType;
        }

        public void setServiceProviderType(int ServiceProviderType) {
            this.ServiceProviderType = ServiceProviderType;
        }

        public double getDistance() {
            return Distance;
        }

        public void setDistance(double Distance) {
            this.Distance = Distance;
        }

        public List<ServiceProviderServiceCategoriesBean> getServiceProviderServiceCategories() {
            return ServiceProviderServiceCategories;
        }

        public void setServiceProviderServiceCategories(List<ServiceProviderServiceCategoriesBean> ServiceProviderServiceCategories) {
            this.ServiceProviderServiceCategories = ServiceProviderServiceCategories;
        }

        public static class ServiceProviderAddressBean {
            /**
             * Id : 4947533809332902844
             * Latitude : 104.079853
             * Longitude : 30.703259
             * MainAddressLine : 四川省成都市二环路北三段
             * Name : 主要地址
             */

            private String Id;
            private double Latitude;
            private double Longitude;
            private String MainAddressLine;
            private String Name;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public double getLatitude() {
                return Latitude;
            }

            public void setLatitude(double Latitude) {
                this.Latitude = Latitude;
            }

            public double getLongitude() {
                return Longitude;
            }

            public void setLongitude(double Longitude) {
                this.Longitude = Longitude;
            }

            public String getMainAddressLine() {
                return MainAddressLine;
            }

            public void setMainAddressLine(String MainAddressLine) {
                this.MainAddressLine = MainAddressLine;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class ServiceProviderContactBean {
            /**
             * Id : 5707580329792543729
             * Name : 主要联系方式
             * Phone : 87654321
             * MobilePhone : 10987654321
             * OrtherContact : OtherContact
             */

            private String Id;
            private String Name;
            private String Phone;
            private String MobilePhone;
            private String OrtherContact;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getPhone() {
                return Phone;
            }

            public void setPhone(String Phone) {
                this.Phone = Phone;
            }

            public String getMobilePhone() {
                return MobilePhone;
            }

            public void setMobilePhone(String MobilePhone) {
                this.MobilePhone = MobilePhone;
            }

            public String getOrtherContact() {
                return OrtherContact;
            }

            public void setOrtherContact(String OrtherContact) {
                this.OrtherContact = OrtherContact;
            }
        }

        public static class ServiceProviderCertificationInfoBean {
            /**
             * Id : 4711101685671623188
             * BusinessLicenseImagePath : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504340601&di=0c4be8cf6a460c51b9ab0d222eb48dbe&imgtype=jpg&er=1&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201406%2F27%2F20140627085544_cHFnx.jpeg
             * LegalPersonInfoImagePath : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503745927460&di=737d4db400e280d58eb23ac26c9eebea&imgtype=0&src=http%3A%2F%2Fpic20.nipic.com%2F20120403%2F7885626_091956683185_2.jpg
             * IsCertificationInfo : 0
             */

            private String Id;
            private String BusinessLicenseImagePath;
            private String LegalPersonInfoImagePath;
            private int IsCertificationInfo;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getBusinessLicenseImagePath() {
                return BusinessLicenseImagePath;
            }

            public void setBusinessLicenseImagePath(String BusinessLicenseImagePath) {
                this.BusinessLicenseImagePath = BusinessLicenseImagePath;
            }

            public String getLegalPersonInfoImagePath() {
                return LegalPersonInfoImagePath;
            }

            public void setLegalPersonInfoImagePath(String LegalPersonInfoImagePath) {
                this.LegalPersonInfoImagePath = LegalPersonInfoImagePath;
            }

            public int getIsCertificationInfo() {
                return IsCertificationInfo;
            }

            public void setIsCertificationInfo(int IsCertificationInfo) {
                this.IsCertificationInfo = IsCertificationInfo;
            }
        }

        public static class ServiceProviderIntroductionBean {
            /**
             * Id : 5498726687780377447
             * Introduction : 这里是火车北站的简单介绍
             * Description : 这里是火车北站的详细描述
             * ImagePath : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504340745&di=94e8cd756ad398a6f6c4ce132f54253b&imgtype=jpg&er=1&src=http%3A%2F%2Fpic8.nipic.com%2F20100718%2F5401072_123826008131_2.jpg
             * ServiceProviderBannerPaths : [{"Id":31,"Path":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503746006389&di=0db690e39e4e0570d259395a0d3ed52e&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F09%2F79%2F55d1ed2c1098a_1024.jpg"},{"Id":32,"Path":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503746006378&di=9b3160bc22fb15d3939c593e198079cf&imgtype=0&src=http%3A%2F%2Fimg155.poco.cn%2Fmypoco%2Fmyphoto%2F20090611%2F14%2F12279062200906111412311756765842618_009.jpg"}]
             */

            private String Id;
            private String Introduction;
            private String Description;
            private String ImagePath;
            private List<ServiceProviderBannerPathsBean> ServiceProviderBannerPaths;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getIntroduction() {
                return Introduction;
            }

            public void setIntroduction(String Introduction) {
                this.Introduction = Introduction;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public String getImagePath() {
                return ImagePath;
            }

            public void setImagePath(String ImagePath) {
                this.ImagePath = ImagePath;
            }

            public List<ServiceProviderBannerPathsBean> getServiceProviderBannerPaths() {
                return ServiceProviderBannerPaths;
            }

            public void setServiceProviderBannerPaths(List<ServiceProviderBannerPathsBean> ServiceProviderBannerPaths) {
                this.ServiceProviderBannerPaths = ServiceProviderBannerPaths;
            }

            public static class ServiceProviderBannerPathsBean {
                /**
                 * Id : 31
                 * Path : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503746006389&di=0db690e39e4e0570d259395a0d3ed52e&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F09%2F79%2F55d1ed2c1098a_1024.jpg
                 */

                private int Id;
                private String Path;

                public int getId() {
                    return Id;
                }

                public void setId(int Id) {
                    this.Id = Id;
                }

                public String getPath() {
                    return Path;
                }

                public void setPath(String Path) {
                    this.Path = Path;
                }
            }
        }

        public static class ServiceProviderServiceCategoriesBean {
            /**
             * Id : 4757298004609728188
             * Name : 宠物手术
             * SubCategories : [{"Id":"4900610231028091476","Name":"小型手术","Price":3800},{"Id":"5037523185200550771","Name":"中型手术","Price":4800},{"Id":"5164803786160131319","Name":"大型手术","Price":5800}]
             */

            private String Id;
            private String Name;
            private List<SubCategoriesBean> SubCategories;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public List<SubCategoriesBean> getSubCategories() {
                return SubCategories;
            }

            public void setSubCategories(List<SubCategoriesBean> SubCategories) {
                this.SubCategories = SubCategories;
            }

            public static class SubCategoriesBean {
                /**
                 * Id : 4900610231028091476
                 * Name : 小型手术
                 * Price : 3800
                 */

                private String Id;
                private String Name;
                private BigDecimal Price;

                public String getId() {
                    return Id;
                }

                public void setId(String Id) {
                    this.Id = Id;
                }

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public BigDecimal getPrice() {
                    return Price;
                }

                public void setPrice(BigDecimal Price) {
                    this.Price = Price;
                }
            }
        }
    }

}
