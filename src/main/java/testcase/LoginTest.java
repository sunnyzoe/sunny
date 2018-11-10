package testcase;

import bean.LoginReq;
import bean.LoginResp;
import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.HttpTools;

/**
 * @program: auto-test-sunny
 * @description:
 * @author: guoya
 * @create: 2018-11-10 15:14
 **/
public class LoginTest {

@Test
  public void loginTest(){

    LoginReq loginReq=new LoginReq();
    loginReq.setPwd("aaaaaa");
    loginReq.setUserName("xuepl");


    String reqJson= JSON.toJSONString(loginReq,true);
    System.out.println("---------请求数据----------");
    System.out.println(reqJson);



    String respString= HttpTools.doPostByJson("http://qa.guoyasoft.com:8080/user/login",reqJson,"UTF-8");
    System.out.println("----------响应正文---------");
    System.out.println(respString);

    LoginResp loginResp = JSON.parseObject(respString,LoginResp.class);
    System.out.println("-------respCode-------");
    System.out.println(loginResp.getRespCode());

    Assert.assertEquals(loginResp.getRespCode(),"9999");



  }

}
