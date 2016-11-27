package com.example.upload;


import android.util.Log;

import org.kobjects.base64.Base64;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by GOD on 2016/11/26.
 */
public class gap_upload_identity_result_test {
    public static String List_result ;

    private static final String SERVICE_NAMESPACE ="http://tempuri.org/"; //http://tempuri.org/
    public static ArrayList<String> return_true_flag = new ArrayList<>();
    public  static void getImageromSdk( ArrayList<String> gapflag,ArrayList<String> pic_path){
        Log.i("进入获取图片方法", "进入获取图片方法");
        try{
            for (int i = 0; i < pic_path.size(); i++) {
                String ww=pic_path.get(i);

                String methodName = "HelloWorld";

                getImageFromAndroid(methodName,gapflag.get(i), pic_path.get(i));   //调用webservice

                Log.i("connectWebService", "start");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getImageFromAndroid(String methodName,String gapflag, String pic_path){
        Log.i("进入端口方法", "进入端口方法");

        HttpTransportSE ht = new HttpTransportSE(Data_up.getSERVICE_URL());
        try {
            ht.debug = true;
            // 使用SOAP1.1协议创建Envelop对象
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            // 实例化SoapObject对象
            SoapObject soapObject = new SoapObject(SERVICE_NAMESPACE,methodName);

            soapObject.addProperty("gapflag",gapflag);
            soapObject.addProperty("pic_path",pic_path);

            envelope.bodyOut = soapObject;
            // 设置与.NET提供的webservice保持较好的兼容性
            envelope.dotNet = true;
            // 调用webservice
            ht.call(SERVICE_NAMESPACE + methodName, envelope);

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