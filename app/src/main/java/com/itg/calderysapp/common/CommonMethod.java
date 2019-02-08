package com.itg.calderysapp.common;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CommonMethod {


    public static final String FROM_SETTING = "FROM_SETTING";
    public static final String FROM_CHECK = "FROM_CHECK";
    public static final String FROM_PLANT = "FROM_PLANT";
    public static final String TBL_VIEWINDENT = "GetViewIndent";
    public static final String FROM_MATERIAL = "FROM_MATERIAL";
    public static final String USER_NAME = "userName";
    public static final String CONSIGNEE = "selectedConsignee";
    public static final String INDENT_TYPE = "IndentType";
    public static final String PLANT_CODE = "plantCode";
    public static final String DIVISION = "division";
    public static final String TRANSPORT = "Transport";
    public static final String FULL_MATERIAL = "fullMaterialData";
    public static final String FROM_PRODUCT = "FROM_PRODUCT";
    public static final String EMAIL_ID = "EMAIL_ID";
    public static final String FROM_MYINTENTS = "FROM_MYINTENTS";
    public static final String FROM_VIEW_INTENTS = "FROM_VIEW_INTENTS";
    public static final String FROM_DETAILS = "FROM_DETAILS";
    public static final String USER_DETAIL = "UserLoginDetail";
    public static final String FROM_VIEW_PLANT_INTENTS = "FROM_VIEW_PLANT_INTENTS";
    public static final String TYPE_ACTIVE = "A";
    public static final String INACTIVE = "B";
    public static final int CREATE_INDENT = 3;
    public static final String FROM_NOTIFICATION_CREATE = "FROM_NOTIFICATION_CREATE";
    public static final int INDENT_STATUS = 4;
    private static final String TAG = "CommonMethod";
//    public static final String URL_CALDE_CONNECT = "http://phpapp.calderysdistributors.com/";//production
//    public static final String URL_CALDE_CONNECT_MAIN = "https://www.calderysdistributors.com/";//production
//    public static final String URL_CALDNET = "http://32.60.39.200:81/api/caldnet/"; //production


    //    public static final String URL_CALDE_CONNECT = "http://microorange.net/calderys/";
        public static final String URL_CALDE_CONNECT = "http://calderysdistributors.itechgalaxysolutions.com/";
    public static final String URL_CALDE_CONNECT_MAIN = "http://calderysdistributors.itechgalaxysolutions.com/";
    public static final String URL_CALDNET = "http://32.60.39.205:81/api/caldnet/";// testing for local
    //    public static final String URL_CALDE_CONNECT="http://192.168.1.56/calderyapp/";
//    public static final String URL_CALDNET="http://192.168.0.107:8087/api/caldnet/";
//    public static final String URL_CALDNET = "http://13.71.4.162:8087/api/caldnet/";

    public static final int CALDNET = 1;
    public static final int CALDECONNECT = 2;
    public static final String USER_TYPE = "USER_TYPE";
    public static final String PRODUCT_TYPE = "product_type";
    public static final String FAMILY_TYPE = "group_add";
    public static final String FILE_DOWNLOAD = "FILE_DOWNLOAD";
    public static final String UPDATE_FILE_FOLDER = "announcement_files";
    public static final String FROM_SERVICE = "FROM_SERVICE";
    public static final String FILE_DOWNLOAD_SERVICE = "FILE_DOWNLOAD_SERVICE";
    public static final String PDS = "PDS";
    public static final String UPDATE = "update";
    public static final String FROM_EDIT = "FROM_EDIT";
    public static final String FROM_GALLERY = "FROM_GALLERY";
    public static final String FROM_GALLERY_LIST = "FROM_GALLERY_LIST";
    public static final String FROM_GALLERY_POSITION = "FROM_GALLERY_POSITION";
    public static final String FROM_GALLERY_DETAIL = "FROM_GALLERY_DETAIL";
    public static final String FROM_GALLERY_HOME = "FROM_GALLERY_HOME";
    public static final String FROM_GALLERY_DATA = "FROM_GALLERY_DATA";


    public static final String PERMISSION = "PERMISSION";


    public static final String PDS_FILE_FOLDER = "Product_Data_Sheet";
    public static final String TABLE_UPADTE = "announcement";
    public static final String TOKEN = "Token";
    public static final String FROM_SEARCH = "FROM_SEARCH";
    public static final String FROM_UPDATE = "FROM_UPDATE";
    public static final String FROM_PDS = "FROM_PDS";
    public static final String FROM_NOTIFICATION = "FROM_NOTIFICATION";
    public static final String FROM_NOTIFICATION_ADD = "FROM_NOTIFICATION_ADD";
    public static final String FROM_NOTIFICATION_PDS = "FROM_NOTIFICATION_PDS";


    /**
     * THis Calderys Net Constatnt Feild
     **/
    public static final String TBL_IMPORTANT_MESSAGE = "HomePageMessageList";
    public static final String TBL_SUCCESS_STORIES = "GetSuccessStoriesMaster";
    public static final int FROM_APPROVED = 3;
    public static final int FROM_REJECT = 4;
    public static final String FROM_APPROVED_INDENT = "FROM_APPROVED_INDENT";
    public static final int FROM_VIEW_INTENT = 4;
    public static final String FROM_VIEWDRAFT = "FROM_VIEWDRAFT";
    public static final int FROM_MYINTENT = 1;
    public static final int FROM_VIEW_PLANT_INTENT = 2;
    public static final String FROM_DEALER = "FROM_DEALER";
    public static final String FROM_INTENT = "FROM_INTENT";
    public static final String FROM = "FROM";
    public static final String FROM_STATUS = "FROM_STATUS";
    public static final String USER_ID = "USER_ID";

    public static final String TBL_MYINDENT = "GetMyIntent";
    public static final String TBL_DISPATCHED = "GetDispatch_Details";
    public static final String TBL_DEALER = "GetDealerList";
    public static final String DEALER = "Dealer";
    public static final String INDENT = "INDENT";
    public static final String DEALER_DATA = "DEALER_DATA";
    public static final String TBL_ViewDRAFT = "GetViewDraft";
    public static final String TBL_APPROVED_INDENT = "TBL_APPROVED_INDENT";
    public static final String FROM_MESSAGE = "FROM_MESSAGE";
    public static final String FROM_STROIES = "FROM_STROIES";


    public static String IS_LOGGIN = "IS_LOGGIN";
    public static final String TBL_PDS = "product_data_sheet";
    public static final String TBL_UPDATE_DELETE = "announcement";
    public static final String FILDER_IMAGES = "Advertisements";
    public static final String TBL_IMAGES = "advertisements";
    public static final String MIME_TYPE_IMAGE_JPG = "image/jpeg";
    public static final String MIME_TYPE_IMAGE_PNG = "image/png";
    public static final String SO_GENRATED = "S";
    public static final String PENDING = "P";
    public static final String CANCEL = "C";
    public static final String REJECT = "R";


    /**
     * class types for check where to send new entry to
     */
    public static final int UPDATE_ITEM = 1;
    public static final int GALLERY_ITEM = 33433;
    public static final int PDS_ITEM = 2;

    public static String getDDMMYYYYfromDate(Calendar c) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return simpleDateFormat.format(c.getTime());
    }
    public static String getYYYYMMDDforSAP(String date ) {
        if (date != null) {
            SimpleDateFormat simpleDateFormat = null;
            if (isValidFormat(date))
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
            else if (isValidFormatAmPm(date))
                simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a", Locale.getDefault());
            else if (isValidFormatForTDate(date)) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            }
            else if (isValidFormatForTDatedot(date)) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
            }
//            else if(isValidFormatNormal(date)){
//                simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
//            }
            if (simpleDateFormat == null)
                simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(simpleDateFormat.parse(date));
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                return simpleDateFormat2.format(calendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getDDMMYYYYfromDateServer(Calendar c) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        return simpleDateFormat.format(c.getTime());
    }


    public static boolean isValidFormat(String value) {
        Date date = null;
        if (value != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date != null;
    }

    public static boolean isValidFormatT(String value) {
        return isValidFormatForTDate(value) || isValidFormatAmPm(value);
    }

    private static boolean isValidFormatAmPm(String value) {
        Date date = null;
        if (value != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date != null;
    }

    private static boolean isValidFormatForTDate(String value) {
        Date date = null;
        if (value != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date != null;
    }

    private static boolean isValidFormatForTDatedot(String value) {
        Date date = null;
        if (value != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date != null;
    }

    public static String getDDMMYYYYfromDateServer(String date) {
        if (date != null) {
            date = getDDMMYYYYfromDateServerForField(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(simpleDateFormat.parse(date));
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
                return simpleDateFormat2.format(calendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getDDMMYYYYfromDateServerForField(String date) {
        if (date != null) {
            SimpleDateFormat simpleDateFormat = null;
            if (isValidFormat(date))
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
            else if (isValidFormatAmPm(date))
                simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a", Locale.getDefault());
            else if (isValidFormatForTDate(date)) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            }
//            else if(isValidFormatNormal(date)){
//                simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
//            }
            if (simpleDateFormat == null)
                simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(simpleDateFormat.parse(date));
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                return simpleDateFormat2.format(calendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private static boolean isValidFormatNormal(String value) {
        Date date = null;
        if (value != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return date != null;
    }

    public static int dpToPx(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * scale);
    }

    public static String convertDateToString(Calendar myCalendar) {
        SimpleDateFormat simpleDateFormats = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        return simpleDateFormats.format(myCalendar.getTime());

    }

    public static SpinnerGenericModel getXMLValueById(String apprvlStatus, String fileName) {


        SpinnerGenericModel itemModels = null;
        try {
//            parserFactory = XmlPullParserFactory.newInstance();
//            XmlPullParser parser = parserFactory.newPullParser();
//            InputStream is = context.getAssets().open(fileName);
//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//            parser.setInput(is, null);


            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            try {
                db = dbf.newDocumentBuilder();
                Document doc = db.parse(fileName);
                doc.getDocumentElement().normalize();
                itemModels = processParsingModel(doc, apprvlStatus);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemModels;
    }


    public static void setLeftRightDrawable(View view, int left, int right) {
        if (view instanceof Button)
            ((Button) view).setCompoundDrawablesWithIntrinsicBounds(left != 0 ? AppCompatResources.getDrawable(view.getContext(), left) : null, null, right != 0 ? AppCompatResources.getDrawable(view.getContext(), right) : null, null);
        else if (view instanceof EditText) {
            ((EditText) view).setCompoundDrawablesWithIntrinsicBounds(left != 0 ? AppCompatResources.getDrawable(view.getContext(), left) : null, null, right != 0 ? AppCompatResources.getDrawable(view.getContext(), right) : null, null);
        } else if (view instanceof TextView) {
            ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(left != 0 ? AppCompatResources.getDrawable(view.getContext(), left) : null, null, right != 0 ? AppCompatResources.getDrawable(view.getContext(), right) : null, null);
        }
    }

    public static void setBackgroundDrawable(View view, int left, int right) {
        view.setBackgroundDrawable(ContextCompat.getDrawable(view.getContext(), left));

//        if(android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//        } else {
//            view.setBackgroundDrawable(ContextCompat.getDrawable(view.getContext(), left));
//        }
    }


    public static String getXMLValueStringById(String apprvlStatus, String fileName) {


        SpinnerGenericModel itemModels = null;
        try {
//            parserFactory = XmlPullParserFactory.newInstance();
//            XmlPullParser parser = parserFactory.newPullParser();
//            InputStream is = context.getAssets().open(fileName);
//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//            parser.setInput(is, null);


            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            try {
                db = dbf.newDocumentBuilder();
                Document doc = db.parse(fileName);
                doc.getDocumentElement().normalize();
                itemModels = processParsingModel(doc, apprvlStatus);
                Log.d(TAG, "getXMLValueStringById: itemModels" + itemModels.getValue());
                return itemModels.getValue();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SpinnerGenericModel processParsingModel(Document doc, String apprvlStatus) {

        SpinnerGenericModel model = new SpinnerGenericModel();

        NodeList nList = doc.getElementsByTagName("ListItems");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            Element cElement = (Element) eElement.getElementsByTagName("Value").item(0);
            if (cElement.getAttribute("Value").equalsIgnoreCase(apprvlStatus
            ))
                model.setId(cElement.getAttribute("Value"));
            model.setValue(cElement.getAttribute("Text"));
            System.out.println("Model: " + new Gson().toJson(model));
        }
        return model;
    }

    public static List<SpinnerGenericModel> getYesNoModel() {
        List<SpinnerGenericModel> yesNo = new ArrayList<>();
//        yesNo.add(new SpinnerGenericModel("", "--"));
        yesNo.add(new SpinnerGenericModel("1", "YES"));
        yesNo.add(new SpinnerGenericModel("0", "NO"));
        return yesNo;
    }

    public  static  String  setValueKL(String value) {
        float N=Float.parseFloat(value);
        int prior=0,succeder=0;
        String extension="";
        if(N>999 && N<99999){
            prior=getPrior(N,1000);
            succeder=getSucceder(N,1000);
            extension="K";
        }else if(N>99999 && N<9999999)
        {
            prior=getPrior(N,100000);
            succeder=getSucceder(N,100000);
            extension="L";
        }else if(N>9999999){
            prior=getPrior(N,10000000);
            succeder=getSucceder(N,10000000);
            extension="Cr";
        }else {
            if(N<100)
                prior=getPrior(N,100);
            else
                prior= (int) N;
            succeder=getSucceder(N,100)<=0?0:getSucceder(N,100);
            extension="";
        }
String succederS =String.valueOf(succeder).length()>2?String.valueOf(succeder).substring(0,2):String.valueOf(succeder);
      return     prior+"."+succederS+" "+extension;
    }

    private static int getPrior(float number, int divisor){
        return (int) (number/divisor);
    }
    private static int getSucceder(float number, int divisor){
        return (int) (number%divisor);
    }


    public interface DownloadFileListner {
        void onSuccessFile(Object model);

        void onProgressShow();

        void onDownloadFiled(String message);

        void onProgressHide();

        void startDownload();

        void onProgressUpdate(Integer values);
    }


    public static String calculateDays(String date) {
        if (TextUtils.isEmpty(date)) {
            return "NOT AVAILABLE";
        }
        Calendar calOld = convertStringToDate(date);

        Calendar cal = Calendar.getInstance();
        Date firstDate = cal.getTime();
        Date secondDate = calOld.getTime();


        long diff = firstDate.getTime() - secondDate.getTime();


        System.out.println("Days: " + diff);

        long seconds = diff / 1000;
        String daysAgo;
        if (diff < 1000) {
            daysAgo = "NOT AVAILABLE";
            return daysAgo;
        }
        if (seconds < 60) {
            daysAgo = "Few Seconds Ago";
            return daysAgo;
        }
        long minute = seconds / 60;
        if (minute < 60) {

            daysAgo = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS) + " Minute Ago";
            return daysAgo;
        }
        long hr = minute / 60;
        if (hr < 24) {

            daysAgo = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS) + " Hours Ago";
            return daysAgo;
        }
        long days = hr / 24;
        if (days < 30) {

            daysAgo = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " Days Ago";
        } else {
            days = days / 30;
            daysAgo = days + " Month Ago";
        }
        return daysAgo;

    }

    public static Calendar convertStringToDate(String assignDate) {

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());


        Calendar date = Calendar.getInstance();
        try {
            date.setTime(formatter.parse(assignDate));

        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
        }


//        String finalString = formatter.format(date);
        return date;
    }

    public static String getMimetypeFromFileName(String mimeType) {
        if (mimeType.equalsIgnoreCase(MIME_TYPE_IMAGE_JPG))
            return ".jpg";
        else if (mimeType.equalsIgnoreCase(MIME_TYPE_IMAGE_PNG))
            return ".png";

        return null;

    }

    public static List<SpinnerGenericModel> parseXML(Context context, String fileName) {
        XmlPullParserFactory parserFactory;
        List<SpinnerGenericModel> itemModels = null;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = context.getAssets().open(fileName);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            itemModels = processParsing(parser, fileName);

        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return itemModels;
    }


    public static int getItemPositionFromXMLFile(String fileName, String id) {
        List<SpinnerGenericModel> list = parseXML(fileName);
        int i = 0;
        for (SpinnerGenericModel sgm :
                list) {
            if (sgm.getId().equalsIgnoreCase(id))
                return i;
            i++;
        }
        return i;
    }

    public static String getItemValueFromXMLFile(String fileName, String id) {
        List<SpinnerGenericModel> list = parseXML(fileName);
        String value = null;
        for (SpinnerGenericModel sgm :
                list) {
            if (sgm.getId().equalsIgnoreCase(id))
                value = sgm.getValue();
        }
        return value;
    }

    public static List<SpinnerGenericModel> parseXML(String fileName) {
        XmlPullParserFactory parserFactory;
        List<SpinnerGenericModel> itemModels = null;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = MyApplication.getInstance().getApplicationContext().getAssets().open(fileName);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            itemModels = processParsing(parser, fileName);

        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return itemModels;
    }


    public static String fileExt(String url) {
        if (url.indexOf("?") > -1) {
            url = url.substring(0, url.indexOf("?"));
        }
        if (url.lastIndexOf(".") == -1) {
            return null;
        } else {
            String ext = url.substring(url.lastIndexOf(".") + 1);
            if (ext.indexOf("%") > -1) {
                ext = ext.substring(0, ext.indexOf("%"));
            }
            if (ext.indexOf("/") > -1) {
                ext = ext.substring(0, ext.indexOf("/"));
            }
            return ext.toLowerCase();

        }
    }

    private static List<SpinnerGenericModel> processParsing(XmlPullParser parser, String fileName) {
        List<SpinnerGenericModel> list = null;
        int eventType = 0;
        try {
            eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String eltName = null;
                SpinnerGenericModel model = null;


                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<>();
                        break;


                    case XmlPullParser.START_TAG:
                        eltName = parser.getName();
                        model = new SpinnerGenericModel();
                        if ("ListItems".equals(eltName)) {
                            String startTag = parser.getName();
                            if (startTag.equalsIgnoreCase("ListItems")) {

                                model.setId(parser.getAttributeValue(null, "Value"));
                                if (fileName.equalsIgnoreCase(SpinnerFileName.PLANT)) {
                                    model.setValue(parser.getAttributeValue(null, "Text"));
                                    if (!model.getValue().equalsIgnoreCase("--")) {
                                        model.setValue("(" + parser.getAttributeValue(null, "Value") + ") " + parser.getAttributeValue(null, "Text"));
                                    }
                                } else
                                    model.setValue(parser.getAttributeValue(null, "Text"));
//                              if ("Value".equalsIgnoreCase(parser.getAttributeValue(null,"Value"))) {
                                Log.d(TAG, "processParsing: c" + parser.getAttributeValue(null, "Value"));
//                                  model.setId(parser.nextText());
//                              } else if ("Text".equalsIgnoreCase(parser.getAttributeValue(null,"Text"))) {
                                Log.d(TAG, "processParsing: nexTag" + parser.getAttributeValue(null, "Text"));
//
//                                  model.setValue(parser.nextText());
                                if (model.getId() != null && model.getValue() != null)
                                    list.add(model);
//                              }
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
//                        if((parser.getName().equalsIgnoreCase("ListItems") )){
//                            list.add(model);
//                        }
                }
                eventType = parser.next();


            }


        } catch (XmlPullParserException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        return list;
    }
}
