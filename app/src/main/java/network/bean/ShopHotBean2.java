package network.bean;

import java.util.List;

/**
 * Created by pengzhixian on 2018/7/19.
 */

public class ShopHotBean2 {
    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "hot_vendor=" + hot_vendor +
                    '}';
        }

        private List<HotVendorBean> hot_vendor;

        public List<HotVendorBean> getHot_vendor() {
            return hot_vendor;
        }

        public void setHot_vendor(List<HotVendorBean> hot_vendor) {
            this.hot_vendor = hot_vendor;
        }

        public static class HotVendorBean {
            @Override
            public String toString() {
                return "HotVendorBean{" +
                        "customer_id=" + customer_id +
                        ", vendor_name='" + vendor_name + '\'' +
                        ", user_type=" + user_type +
                        ", bg_image='" + bg_image + '\'' +
                        ", list=" + list +
                        '}';
            }

            private int customer_id;
            private String vendor_name;
            private int user_type;
            private String bg_image;
            private List<ListBean> list;

            public int getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(int customer_id) {
                this.customer_id = customer_id;
            }

            public String getVendor_name() {
                return vendor_name;
            }

            public void setVendor_name(String vendor_name) {
                this.vendor_name = vendor_name;
            }

            public int getUser_type() {
                return user_type;
            }

            public void setUser_type(int user_type) {
                this.user_type = user_type;
            }

            public String getBg_image() {
                return bg_image;
            }

            public void setBg_image(String bg_image) {
                this.bg_image = bg_image;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * goods_id : 572
                 * gname : 一或 | 黄山毛峰  试饮装
                 * gimg : http://statics.teayork.com/admin/uploads/images/59b9fbdc6d15b.jpg/thumb70
                 * gprice : 35.00
                 * silver_price : 0
                 * gold_price : 0
                 * promotion : {"promotion_type":2,"promotion_label":"试饮","promotion_price":"35.00","origin_price":""}
                 */

                private int goods_id;
                private String gname;
                private String gimg;
                private String gprice;
                private String silver_price;

                @Override
                public String toString() {
                    return "ListBean{" +
                            "goods_id=" + goods_id +
                            ", gname='" + gname + '\'' +
                            ", gimg='" + gimg + '\'' +
                            ", gprice='" + gprice + '\'' +
                            ", silver_price='" + silver_price + '\'' +
                            ", gold_price='" + gold_price + '\'' +
                            '}';
                }

                private String gold_price;
//                private PromotionBean promotion;

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGname() {
                    return gname;
                }

                public void setGname(String gname) {
                    this.gname = gname;
                }

                public String getGimg() {
                    return gimg;
                }

                public void setGimg(String gimg) {
                    this.gimg = gimg;
                }

                public String getGprice() {
                    return gprice;
                }

                public void setGprice(String gprice) {
                    this.gprice = gprice;
                }

                public String getSilver_price() {
                    return silver_price;
                }

                public void setSilver_price(String silver_price) {
                    this.silver_price = silver_price;
                }

                public String getGold_price() {
                    return gold_price;
                }

                public void setGold_price(String gold_price) {
                    this.gold_price = gold_price;
                }

//                public PromotionBean getPromotion() {
//                    return promotion;
//                }
//
//                public void setPromotion(PromotionBean promotion) {
//                    this.promotion = promotion;
//                }

                public static class PromotionBean {
                    /**
                     * promotion_type : 2
                     * promotion_label : 试饮
                     * promotion_price : 35.00
                     * origin_price :
                     */

                    private int promotion_type;
                    private String promotion_label;
                    private String promotion_price;
                    private String origin_price;

                    public int getPromotion_type() {
                        return promotion_type;
                    }

                    public void setPromotion_type(int promotion_type) {
                        this.promotion_type = promotion_type;
                    }

                    public String getPromotion_label() {
                        return promotion_label;
                    }

                    public void setPromotion_label(String promotion_label) {
                        this.promotion_label = promotion_label;
                    }

                    public String getPromotion_price() {
                        return promotion_price;
                    }

                    public void setPromotion_price(String promotion_price) {
                        this.promotion_price = promotion_price;
                    }

                    public String getOrigin_price() {
                        return origin_price;
                    }

                    public void setOrigin_price(String origin_price) {
                        this.origin_price = origin_price;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ShopHotBean2{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
