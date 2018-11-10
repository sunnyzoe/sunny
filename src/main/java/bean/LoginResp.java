package bean;

/**
 * @program: auto-test-sunny
 * @description:
 * @author: guoya
 * @create: 2018-11-10 15:13
 **/
public class LoginResp {
  private int respCode;
  private String respDesc;

  public int getRespCode() {
    return respCode;
  }

  public void setRespCode(int respCode) {
    this.respCode = respCode;
  }

  public String getRespDesc() {
    return respDesc;
  }

  public void setRespDesc(String respDesc) {
    this.respDesc = respDesc;
  }

  @Override
  public String toString() {
    return "LoginResp{" +
        "respCode=" + respCode +
        ", respDesc='" + respDesc + '\'' +
        '}';
  }
}
