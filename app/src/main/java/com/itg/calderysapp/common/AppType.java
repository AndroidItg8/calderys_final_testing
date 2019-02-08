package com.itg.calderysapp.common;

import static com.itg.calderysapp.common.CommonMethod.CALDECONNECT;
import static com.itg.calderysapp.common.CommonMethod.CALDNET;
import static com.itg.calderysapp.common.CommonMethod.URL_CALDE_CONNECT;
import static com.itg.calderysapp.common.CommonMethod.URL_CALDNET;


public class AppType {
    public static final String USER_TYPE = "USRT";
    private static String url;
    private static int type=-1;

    public static int getType() {
        return type;
    }

    private static void setURL(Builder mUrl) {
        url=mUrl.mUrl;
        type=mUrl.type;

    }

    public static boolean isCaldNet(){
        return type==CommonMethod.CALDNET;
    }

    public static boolean isCaldConnect(){
        return type==CommonMethod.CALDECONNECT;
    }

    public static String getAppType(){
        String type="NO_TOPIC";
        if(isCaldConnect())
            return "CALDCONNECT";
        else if(isCaldNet())
            return "CALDNET";
        return type;
    }




    public static String getUrl(){
        return url;
    }


    public static class Builder{
        public String mUrl;
        public int type;
        public Builder setUserType(){
            if(Prefs.contains(USER_TYPE)){
                if(Prefs.getInt(USER_TYPE)==CALDNET){
                    mUrl=URL_CALDNET;
                    this.type=CALDNET;
                }else if(Prefs.getInt(USER_TYPE)==CALDECONNECT){
                    mUrl=URL_CALDE_CONNECT;
                    this.type=CALDECONNECT;

                }
            }
        return this;
        }



        public Builder getURL(){
            return this;
        }

        public void build() {
            AppType.setURL(this);
        }


    }


}
