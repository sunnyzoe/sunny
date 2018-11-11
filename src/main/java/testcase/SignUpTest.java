package testcase;

import bean.LoginReq;
import bean.SignUpReq;
import bean.SignUpResp;
import com.alibaba.fastjson.JSON;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.HttpTools;
import tools.PinYinTools;
import tools.PropertiesTools;
import tools.RandomTools;

/**
 * @program: auto-test-sunny
 * @description:
 * @author: guoya
 * @create: 2018-11-11 14:57
 **/
public class SignUpTest {

  String phone = RandomTools.getTel();
  String pwd = "sun123456";
  String userName = PinYinTools
      .toFirstChar(RandomTools.getChineseName().toLowerCase() + RandomTools.getNum(10, 99));

  Properties prop = PropertiesTools.getProperties("src\\test\\resources\\application.properties");
  String protocal = prop.getProperty("api.host.protocal");
  String ip = prop.getProperty("api.host.ip");
  String port = prop.getProperty("api.host.port");


  @Test
  public void signUpTest() {
//    String phone="15262207932";
//    String pwd="sun123456";
//    String userName="sun881028";
//    String url = "http://qa.guoyasoft.com:8080/user/signup";
//    String expect = "0000";

    String url = protocal + "://" + ip + ":" + port + "/user/signup";

    String except = "0000";

    SignUpReq signUpReq = new SignUpReq();
    signUpReq.setPhone(phone);
    signUpReq.setPwd(pwd);
    signUpReq.setRePwd(pwd);
    signUpReq.setUserName(userName);

    String reqJson = JSON.toJSONString(signUpReq, true);
    System.out.println("---------请求数据----------");
    System.out.println(reqJson);

    String respString = HttpTools
        .doPostByJson("http://qa.guoyasoft.com:8080/user/signup", reqJson, "UTF-8");
    System.out.println("----------响应正文---------");
    System.out.println(respString);

    SignUpResp signUpResp = JSON.parseObject(respString, SignUpResp.class);
    System.out.println("-------respCode-------");
    System.out.println(signUpResp.getRespBase().getRespCode());

    Assert.assertEquals(signUpResp.getRespBase().getRespCode(), "0000");


  }
@Test
  public void LoginTest() {
    LoginReq loginReq = new LoginReq();
    loginReq.setPwd(pwd);
    loginReq.setUserName(userName);
  }



}
