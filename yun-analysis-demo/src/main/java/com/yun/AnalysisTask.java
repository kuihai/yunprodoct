package com.yun;

import com.foxx.AnalysisJson;

import java.util.Map;

public class AnalysisTask {

  public static void main (String [] args){
      run();
  }

    private static void run() {
        //此项目主要是用来解析json数据
        String jsonUrl = "http://www.cninfo.com.cn/data/project/getStatisticsData?mergerMark=marginTrading";

        //定义抓取的html charset 格式
        String charset = "utf-8";

        //通过yun_json_analysis_jar包中提供的initHttpGet方法
        String jsonContent = AnalysisJson.initHttpGet(jsonUrl,charset);

        //通过yun_json_analysis_jar包中提供的initAnaly方法解析
        String needData = "marginTrading,arr{SECCODE;SECNAME;TRADEDATE}"; //这是关键的,通过https://www.json.cn 查看需要解析的结构

        //当获取的一些json字符串需要一些处理的时候,可以通过替换replace掉
        String strRep = "";

        //最后会把需要返回map的形式
        Map<String,String> map = AnalysisJson.initAnaly(jsonContent,needData,strRep);

        for (String key : map.keySet()) {
            System.out.println(key);
        }

    }
}
