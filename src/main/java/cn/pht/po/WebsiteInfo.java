/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*网站信息*/
@Entity
@Table(name = "t_website_info")
public class WebsiteInfo {

    /**
     * 网站各值名称
     */
    @Id
    private String valueName;


    /**
     * 网站各值
     */
    private String value;

    public WebsiteInfo() {
    }


    @Override
    public String toString() {
        return "WebsiteInfo{" +
                "valueName='" + valueName + '\'' +
                ", value=" + value +
                '}';
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
