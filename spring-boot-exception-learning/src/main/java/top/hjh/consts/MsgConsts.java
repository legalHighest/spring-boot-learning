package top.hjh.consts;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 14 19
 **/
public interface MsgConsts {
    //message常用维护
    String SUCCESS = "请求响应成功";
    String PARAM_ERROR = "参数非法";
    String UNAUTHRIZED_ERROR = "身份未认证";
    String FORBIDDEM_ERROR = "访问被拒绝";
    String SYSTEM_ERROR = "系统出现异常，请稍后再试或联系管理员";
    String OTHER_ERROR = "系统出现未知异常，请联系管理员";


int  CODE_200=200;
int CODE_400=400;

int CODE_401=401;

int CODE_403=403;

int CODE_500=500;

int CODE_999=999;



}
