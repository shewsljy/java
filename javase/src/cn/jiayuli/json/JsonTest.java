package cn.jiayuli.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args){

        String acct = "{\n" +
                "\t\"createTime\": \"20190408000000\",\n" +
                "\t\"accountId\": \"ZBCU315110023\",\n" +
                "\t\"totalTranOutAmount\": \"0\",\n" +
                "\t\"payPhone\": \"15907712244\",\n" +
                "\t\"subAccountName\": \"测试法人姓名\",\n" +
                "\t\"totalBalance\": \"0\",\n" +
                "\t\"subAccountType\": \"1\",\n" +
                "\t\"resCode\": \"1\",\n" +
                "\t\"resMsg\": \"查询成功\",\n" +
                "\t\"subAccountId\": null\n" +
                "}";

        System.out.println(acct);

        Map<String,String> map = new HashMap<String, String>();
        map.put("acct",acct);

        System.out.println(map.get("acct"));

        String bind = "{\"bankInfo\":[{\"cardNo\":\"622111111111111111\",\"idNo\":\"450111111111111111\",\"cardName\":\"渠道A\",\"sbankName\":\"中国工商银行江苏分行营业部\",\"subAccountType\":\"1\",\"sbankCode\":\"102301043010\",\"bankName\":\"中国工商银行\",\"bankCode\":\"102\",\"subAccountId\":\"pinganact10011\"},{\"cardNo\":\"622333333333333333\",\"idNo\":\"450111111111111111\",\"cardName\":\"渠道A\",\"sbankName\":\"中国工商银行江苏分行营业部\",\"subAccountType\":\"1\",\"sbankCode\":\"102301043010\",\"bankName\":\"中国工商银行\",\"bankCode\":\"102\",\"subAccountId\":\"pinganact10011\"}],\"custAcctId\":\"chnl10010\",\"resCode\":\"1\",\"resMsg\":\"查询成功\"}";
        System.out.println(bind);
        map.put("bind",bind);

        System.out.println(map.get("bind"));

        Map<String,String> acctMap = (Map)JSONObject.parseObject(acct);
        Map<String,String> bindMap = (Map)JSONObject.parseObject(bind);

        JSONObject jsonObject = new JSONObject();
        jsonObject = JSONObject.parseObject(bind);

        JSONArray jsonArray = new JSONArray();
        jsonArray = jsonObject.getJSONArray("bankInfo");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Map<String,String> bankInfoMap = (Map)json;
            System.out.println();
        }

        System.out.println(jsonArray.size());
        //(JSONObject)jsonArray.get(i);
         //JSONArray.parseObject(bankInfo);
        int a = 3;
    }
}
