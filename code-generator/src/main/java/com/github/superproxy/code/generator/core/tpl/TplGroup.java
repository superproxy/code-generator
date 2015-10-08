package com.github.superproxy.code.generator.core.tpl;

import java.util.ArrayList;
import java.util.List;


/**
 * 定义模版所在的组和
 */
public class TplGroup {

    private String tplGroupName;
    private String tplGroupDescription;
    private List<TplInfo> tplInfoList = new ArrayList<TplInfo>();

    public String getTplGroupDescription() {
        return tplGroupDescription;
    }

    public void setTplGroupDescription(String tplGroupDescription) {
        this.tplGroupDescription = tplGroupDescription;
    }

    public String getTplGroupName() {
        return tplGroupName;
    }

    public void setTplGroupName(String tplGroupName) {
        this.tplGroupName = tplGroupName;
    }

    public List<TplInfo> getTplInfoList() {
        return tplInfoList;
    }

    public void setTplInfoList(List<TplInfo> tplInfoList) {
        this.tplInfoList = tplInfoList;
    }
}
