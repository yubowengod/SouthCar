package com.example.takepictrue_save_FileUploadImage_sql_from_pc.oracle;

import android.util.Log;

import com.example.login_register_update_findinfomation.login.Login;
import com.example.upload.Data_up;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GOD on 2016/9/18.
 */
public class takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd_info_name {



    public static List<String> List_result;

    public static void get_takepictrue_save_FileUploadImage_from_pc_by_user_gw_gx_xd(String flag, String updatetime, String user, String xianlu, String chehao, String chexiang, String gw, String gx, String xd) {
        try {
//            public string[] select_all_from_identity_table(string user, string gw, string gx, string xd)
            String methodName = "select_all_from_UPDATE_PICTURE_INFO_table";
            getImageFromAndroid(methodName, flag, updatetime, user, xianlu, chehao, chexiang, gw, gx, xd);   //调用webservice
            Log.i("connectWebService", "111111111111111111111111111111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*

     */
    public static String getImageFromAndroid(String methodName, String flag, String updatetime, String user, String xianlu, String chehao, String chexiang, String gw, String gx, String xd) {
        Log.i("进入端口方法", "进入端口方法1111111111111111");
        // 创建HttpTransportSE传输对象
        HttpTransportSE ht = new HttpTransportSE(Data_up.getSERVICE_URL());
        try {
            ht.debug = true;
            // 使用SOAP1.1协议创建Envelop对象
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            // 实例化SoapObject对象
            SoapObject soapObject = new SoapObject(Data_up.getSERVICE_NAMESPACE(), methodName);

//            string flag,string user,string xianlu,string chehao,string chexiang,string gw, string gx,string xd
            soapObject.addProperty("flag", flag);
            soapObject.addProperty("updatetime", updatetime);
            soapObject.addProperty("user", Login.Login_username);
            soapObject.addProperty("xianlu", xianlu);
            soapObject.addProperty("chehao", chehao);
            soapObject.addProperty("chexiang", chexiang);
            soapObject.addProperty("gw", gw);
            soapObject.addProperty("gx", gx);
            soapObject.addProperty("xd", xd);


            envelope.bodyOut = soapObject;
            // 设置与.NET提供的webservice保持较好的兼容性
            envelope.dotNet = true;

            // 调用webservice
            ht.call(Data_up.getSERVICE_NAMESPACE() + methodName, envelope);

            if (envelope.getResponse() != null) {
                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject) envelope.bodyIn;
                SoapObject detail = (SoapObject) result.getProperty(methodName + "Result");
                // 解析服务器响应的SOAP消息
                List_result = parseProvinceOrCity(detail);
            }
        } catch (SoapFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    ;

    public static List<String> parseProvinceOrCity(SoapObject detail) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < detail.getPropertyCount(); i++) {
            // 解析出每个省份
            result.add(detail.getProperty(i).toString().split(",")[0]);
        }
        return result;
    }

    public static List<String> getList_result() {

        return List_result;
    }
}