package net.xdclass.online_xdclass.utils;

public class JsonDate {
    //状态码 0成功
    // 1处理中 -1失败
    private Integer code;
    private  Object date;//业务数据
    private  String msg;//错误信息表示
    public  JsonDate(){}
    public JsonDate(Integer code,Object date,String  msg){
        this.code=code;
        this.date=date;
        this.msg=msg;

    }
    //成功不传回数据
    public static  JsonDate buildSuccess(){
        return  new JsonDate(0,null,null);
    }
    public static  JsonDate buildSuccess(Object data){
        return  new JsonDate(0,data,null);
    }
    public static  JsonDate buildSError(String msg){
        return  new JsonDate(-1,null,msg);
    }


    @Override
    public String toString() {
        return "JsonDate{" +
                "code=" + code +
                ", date=" + date +
                ", msg='" + msg + '\'' +
                '}';
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Object getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }

    //自定义状态码
    public static  JsonDate buildSError(Integer code, String msg){
        return  new JsonDate(code,msg,null);

    }



}
