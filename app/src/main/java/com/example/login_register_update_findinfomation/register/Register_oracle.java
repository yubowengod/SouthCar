package com.example.login_register_update_findinfomation.register;

import android.util.Log;

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
 * Created by GOD on 2016/9/22.
 */
public class Register_oracle {
    public static String List_result ;

    public static void getImageromSdk(String username,String password,String question,String answer){
        try{
            String methodName = "register_infomation";
            getImageFromAndroid(methodName,username,password,question,answer);   //调用webservice
            Log.i("connectWebService", "start");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getImageFromAndroid(String methodName,String username,String password,String question,String answer){
        Log.i("进入端口方法", "进入端口方法");
        // 创建HttpTransportSE传输对象
        HttpTransportSE ht = new HttpTransportSE(Data_up.getSERVICE_URL());
        try {
            ht.debug = true;
            // 使用SOAP1.1协议创建Envelop对象
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            // 实例化SoapObject对象
            SoapObject soapObject = new SoapObject(Data_up.getSERVICE_NAMESPACE(),methodName);

            soapObject.addProperty("username",username);
            soapObject.addProperty("password",password);
            soapObject.addProperty("question",question);
            soapObject.addProperty("answer",answer);
            soapObject.addProperty("level","1");

            envelope.bodyOut = soapObject;
            // 设置与.NET提供的webservice保持较好的兼容性
            envelope.dotNet = true;

            // 调用webservice
            ht.call(Data_up.getSERVICE_NAMESPACE() + methodName, envelope);

            if (envelope.getResponse() != null) {
                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject) envelope.bodyIn;
                List_result = result.getProperty(0).toString();
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
    };



    public static String getList_result(){

        return List_result;
    }
}