package cn.pht;

import cn.pht.util.MD5Utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidubce.http.ApiExplorerClient;
import com.baidubce.http.AppSigner;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.ApiExplorerRequest;
import com.baidubce.model.ApiExplorerResponse;
import org.junit.Test;

// IP地址查询精准版 示例代码
public class RequestDemo {
    public static void main(String[] args) {
        String path = "https://jmipqueryv3.api.bdymkt.com/ip/query-v3";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.POST, path);
        request.setCredentials("044a118d70b348aaaa51db55538e12d5", "180c22ac8229449f82d0664974f2f1ee");

        // 设置header参数
        request.addHeaderParameter("Content-Type", "application/json; charset=utf-8");

        // 设置query参数
        request.addQueryParameter("ip", "125.86.165.249");


        ApiExplorerClient client = new ApiExplorerClient(new AppSigner());

        ApiExplorerResponse response = null;
        try {
            response = client.sendRequest(request);
            // 返回结果格式为Json字符串
            System.out.println(response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jsonStr = JSON.toJSONString(response);

        /*JSON字符串转换为JSON对象*/
        JSONObject jsonObject = JSONObject.parseObject(jsonStr).getJSONObject("result").getJSONObject("data");

        /*JSON对象转换为Address对象*/
        Address address = (Address) JSONObject.toJavaObject(jsonObject, Address.class);

        /*返回地址的字符串格式*/
        System.out.println(address.toString());

    }

    /*地区内部类*/
    private static class Address {

        /**
         * 国家
         */
        private String nation;

        /**
         * 省份
         */
        private String province;

        /**
         * 城市
         */
        private String city;

        /**
         * 县
         */
        /*private String county;*/

        /**
         * 服务提供商
         */
        private String isp;

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            /**
             * 追加国家
             * */
            if (!nation.equals("None") && !nation.isEmpty()) {
                stringBuffer.append(nation);

            }
            /**
             * 追加省份
             * */
            if (!province.equals("None") && !province.isEmpty()) {
                stringBuffer.append(province);
            }

            /**
             * 追加城市
             */
            if (!city.equals("None") && !city.isEmpty()) {
                stringBuffer.append(city);
            }


            /**
             * 追加县
             * */
            /*if (!county.equals("None") && !county.isEmpty()) {
                stringBuffer.append(county);
            }*/

            /**
             * 追加互联网服务提供商
             */
            if (!isp.equals("None") && !isp.equals("无ISP信息")) {
                stringBuffer.append("-").append(isp);
            }

            return stringBuffer.toString();
        }

        /**
         * 无参构造函数
         */
        public Address() {
        }

        public Address(String nation, String province, String city, String county, String isp) {
            this.nation = nation;
            this.province = province;
            this.city = city;
            /*this.county = county;*/
            this.isp = isp;
        }

        public String getnation() {
            return nation;
        }

        public void setnation(String nation) {
            this.nation = nation;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        /*
        public String getCounty() {
            return county;
        }
        */

        /*
        public void setCounty(String county) {
            this.county = county;
        }
        */

        public String getIsp() {
            return isp;
        }

        public void setIsp(String isp) {
            this.isp = isp;
        }
    }

    @Test
    public void MD5Test() {
        System.out.println(MD5Utils.code("123456"));
    }
}
