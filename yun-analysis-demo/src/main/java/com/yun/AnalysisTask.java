package com.yun;

import com.foxx.AnalysisJson;
import com.sun.org.apache.xml.internal.security.Init;

import java.util.Map;

public class AnalysisTask {

  public static void main (String [] args){
      //处理单层时候的needData(需要字段数据)写法
    //  run();
      //处理多成时候的needData 写法
      mornRun();
  }

    private static void mornRun() {
        //此项目主要是用来解析json数据(新浪的url)
        String jsonUrl = "https://finance.sina.com.cn/live/js/doc_recommend.js?_=1565341454460";

        //定义抓取的html charset 格式
        String charset = "utf-8";

        //通过yun_json_analysis_jar包中提供的initHttpGet方法
        String jsonContent = AnalysisJson.initHttpGet(jsonUrl,charset);

        //通过yun_json_analysis_jar包中提供的initAnaly方法解析
        String needData = "result,data,banner,arr{title}"; //这是关键的,通过https://www.json.cn 查看需要解析的结构

        //当获取的一些json字符串需要一些处理的时候,可以通过替换replace掉
        String strRep = "liveBanner(,);/* E6Xd/vYXk7DOWGtLav7uoKKNr9nNzwJIy/56DfNRsMv0PbzfZEEjs49rI9CJ4ZRn9hVBRWqv3NGOjd5rP7gZsDLRwD2tzpcQLfDiEvA43KGqUu/LJSg5SjihF2a06hFvmuXtH2qjMNWjzpcGEblEsK4kwpFDox45aHFnkfUANHCjEpWoKMKpkfnzDxgvD5vZwuYT03pCaaHOn0p0 */";

        //最后会把需要返回map的形式
        Map<String,String> map = AnalysisJson.initAnaly(jsonContent,needData,strRep);

        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }

    /**
     * 解析单层的 json 数据
     */
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
