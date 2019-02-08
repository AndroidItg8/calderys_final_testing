package com.itg.calderysapp.common;

import com.google.gson.JsonObject;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IntentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model.SAPModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IndentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.MessageModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.StroiesModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftEditModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetroController {
    @GET("login/checklogin.php")
    Call<ResponseBody> login(
            @Query("username") String email,
            @Query("password") String password);


    @Multipart
    @POST("uploadfile.php")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part absoluteFile,
                                  @Part("from") RequestBody announcement_files);


    @POST("uploadfile.php")
    Observable<ResponseBody> uploadRxFile(@Part MultipartBody.Part absoluteFile,
                                          @Part("from") RequestBody announcement_files);

//    title:rahul title
//    date:05/10/2018
//    Discription: Discription
//    upload_date:05/10/2018
//    user:admin

    @FormUrlEncoded
    @POST("updates/add.php")
    Call<ResponseBody> sendAddForm(@Field("title") String tile,
                                   @Field("Discription") String description,
                                   @Field("date") String date,
                                   @Field("file_upload") String filePath,
                                   @Field("upload_date") String date1,
                                   @Field("user") String string);

    @FormUrlEncoded
    @POST("updates/add.php")
    Call<ResponseBody> sendUpdateForm(@Field("title") String tile,
                                      @Field("Discription") String description,
                                      @Field("date") String date,
                                      @Field("file_upload") String filePath,
                                      @Field("upload_date") String date1,
                                      @Field("user") String string,
                                      @Field("id") String id);


    /**
     *
     * @param name
     * @return
     *
     * List for Both ProductTYpe and Family Group for Spinner
     * tablename:product_type
     * tablename:group_add
     * Used same Url for Both..onTable Should change.
     *
     */


    /***
     *
     * tablename:group_add
     * Response
     *
     * {"Status":1,"Errorcode":200,"data":[{"id":"15","group_name":"Firecrete","insert_by":"","created":"2015-10-27 10:48:36","modified":"0000-00-00 00:00:00","ip":""},{"id":"14","group_name":"Whytheat","insert_by":"","created":"2015-10-27 10:45:42","modified":"0000-00-00 00:00:00","ip":""},{"id":"16","group_name":"Accoset","insert_by":"","created":"2015-10-27 10:48:45","modified":"0000-00-00 00:00:00","ip":""},{"id":"17","group_name":"AC bricks","insert_by":"","created":"2015-10-27 11:12:53","modified":"0000-00-00 00:00:00","ip":""},{"id":"18","group_name":"Accast","insert_by":"","created":"2015-10-27 18:12:44","modified":"0000-00-00 00:00:00","ip":""},{"id":"19","group_name":"Accgun\/Acmongun","insert_by":"","created":"2015-10-27 18:13:10","modified":"0000-00-00 00:00:00","ip":""},{"id":"20","group_name":"Accmon","insert_by":"","created":"2015-10-27 18:13:24","modified":"0000-00-00 00:00:00","ip":""},{"id":"21","group_name":"Accplast","insert_by":"","created":"2015-10-27 18:13:38","modified":"0000-00-00 00:00:00","ip":""},{"id":"22","group_name":"Accram","insert_by":"","created":"2015-10-27 18:14:45","modified":"0000-00-00 00:00:00","ip":""},{"id":"23","group_name":"Binder","insert_by":"","created":"2015-10-27 18:15:01","modified":"0000-00-00 00:00:00","ip":""},{"id":"24","group_name":"Insulyte","insert_by":"","created":"2015-10-27 18:15:17","modified":"0000-00-00 00:00:00","ip":""},{"id":"25","group_name":"Others","insert_by":"","created":"2015-10-27 18:15:41","modified":"0000-00-00 00:00:00","ip":""},{"id":"26","group_name":"PCPF","insert_by":"","created":"2015-10-27 18:15:50","modified":"0000-00-00 00:00:00","ip":""},{"id":"27","group_name":"RBS","insert_by":"","created":"2015-10-27 18:16:01","modified":"0000-00-00 00:00:00","ip":""},{"id":"28","group_name":"Shrinkkomp","insert_by":"","created":"2015-10-28 14:00:56","modified":"0000-00-00 00:00:00","ip":""},{"id":"29","group_name":"Mortars","insert_by":"","created":"2015-10-28 14:53:12","modified":"0000-00-00 00:00:00","ip":""}]}
     * @param name
     * @return
     */


    /**
     * tablename:product_type
     * <p>
     * <p>
     * {"Status":1,"Errorcode":200,"data":[{"id":"79","product_type":"Mortars","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-28 14:53:25","ip":""},{"id":"78","product_type":"INS Bricks","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-28 14:44:36","ip":""},{"id":"77","product_type":"New products","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:45:12","ip":""},{"id":"76","product_type":"Accoset","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:44:58","ip":""},{"id":"75","product_type":"Dense bricks","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:44:44","ip":""},{"id":"74","product_type":"PCPF blocks","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:44:25","ip":""},{"id":"73","product_type":"Porosint shapes","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:44:13","ip":""},{"id":"72","product_type":"Grouts","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:43:33","ip":""},{"id":"71","product_type":"Castables","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:43:12","ip":""},{"id":"70","product_type":"Insulating castable","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:42:48","ip":""},{"id":"69","product_type":"Binders","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:42:16","ip":""},{"id":"68","product_type":"Silica DVM","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:41:59","ip":""},{"id":"67","product_type":"Special mortar","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:41:49","ip":""},{"id":"66","product_type":"Plastics","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:41:30","ip":""},{"id":"65","product_type":"Tabcast","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:41:20","ip":""},{"id":"64","product_type":"Cement kiln castable","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:40:53","ip":""},{"id":"63","product_type":"Low cement castable","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:41:03","ip":""},{"id":"62","product_type":"Dense castable","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:40:16","ip":""},{"id":"61","product_type":"Gunning material","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:40:03","ip":""},{"id":"60","product_type":"Basic ramming material","insert_by":"","created":"0000-00-00 00:00:00","modified":"2015-10-27 10:38:50","ip":""}]}
     *
     * @param name
     * @return
     */

    @FormUrlEncoded
    @POST("list.php")
    Observable<ResponseBody> getTypeOfPDSList(@Field("tablename") String name);


    @FormUrlEncoded
    @POST("index.php")
    Observable<ResponseBody> getUpdateList(@Field("tablename") String tableName,
                                           @Field("perpage") int perPage,
                                           @Field("pageno") int pageNumber);


    /**
     * For Delete
     * <p>
     * <p>
     * tablename:announcement
     * id:53
     * <p>
     * response
     * <p>
     * {"msg":"Update Delete successfully","status":"1"}
     */


    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseBody> deleteUpdateData(
            @Field("tablename") String tableName
            , @Field("id") String id);

    /**
     * /updates/edit.php
     * <p>
     * <p>
     * title:rahul title edit check last
     * date:10/10/2018
     * Discription:Discription edit check lastiukjhkj
     * upload_date:11/10/2018
     * user:admin
     * id:54
     * file_upload:file
     * <p>
     * <p>
     * {"msg":"Update successfully edit","status":"1"}
     *
     * @return
     */

    @FormUrlEncoded
    @POST("updates/edit.php")
    Call<ResponseBody> editUpdateData(@Field("title") String tile,
                                      @Field("Discription") String description,
                                      @Field("date") String date,
                                      @Field("file_upload") String filePath,
                                      @Field("upload_date") String date1,
                                      @Field("user") String string,
                                      @Field("id") String id);

    @FormUrlEncoded
    @POST("list.php")
    Observable<ResponseBody> getPDSProductList(@Field("tablename") String tableName);

    @FormUrlEncoded
    @POST("list.php")
    Observable<ResponseBody> getPDSFamilyList(@Field("tablename") String tableName);

//    product_name:AC 3030
////    family_group:AC bricks
////    product_type:Dense bricks
////    file:PDS AC 30 Word.pdf
////    uploaded_date:28/10/2018
////    share:Public
////    insertBy:admin
////    created:2018-10-28 15:09:48

    @FormUrlEncoded
    @POST("product_data_sheet/add.php")
    Call<ResponseBody> addPDS(@Field("product_name") String productName,
                              @Field("family_group") String familyGroup,
                              @Field("product_type") String productType,
                              @Field("file") String fileName,
                              @Field("uploaded_date") String date,
                              @Field("share") String fileType,
                              @Field("insertBy") String insertBy,
                              @Field("created") String created
    );

    @FormUrlEncoded
    @POST("product_data_sheet/edit.php")
    Call<ResponseBody> editPDS(@Field("product_name") String productName,
                               @Field("family_group") String familyGroup,
                               @Field("product_type") String productType,
                               @Field("file") String fileName,
                               @Field("uploaded_date") String date,
                               @Field("share") String fileType,
                               @Field("insertBy") String insertBy,
                               @Field("created") String created,
                               @Field("id") String id
    );

    @FormUrlEncoded
    @POST("index.php")
    Observable<ResponseBody> getGallery(@Field("tablename") String tbleName,
                                        @Field("perpage") int perPage,
                                        @Field("pageno") int pageNo);


    //        title:image add test
//        Discription:image add test description
//        upload_date:03/21/2018
//        date:03/21/2018
//        insertBy:admin
//        file:download 66.jpg
    @FormUrlEncoded
    @POST("advertisements/add.php")
    Call<ResponseBody> addImages(@Field("title") String tile,
                                 @Field("Discription") String description,
                                 @Field("upload_date") String date,
                                 @Field("date") String date1,
                                 @Field("insertBy") String inserBy,
                                 @Field("file") String filePath);

    @FormUrlEncoded
    @POST("advertisements/edit.php")
    Call<ResponseBody> editImages(@Field("title") String tile,
                                  @Field("Discription") String description,
                                  @Field("upload_date") String date,
                                  @Field("date") String date1,
                                  @Field("insertBy") String inserBy,
                                  @Field("file") String filePath,
                                  @Field("id") String id);
    //    pageno:2
//    tablename:announcement
//    searchkeyword:products
//    perpage:10
//    field[0]:title
//    field[1]:Discription


    @FormUrlEncoded
    @POST("search.php")
    Observable<ResponseBody> getSearchListFromUpdate(@Field("pageno") int page,
                                                     @Field("tablename") String tblUpdate,
                                                     @Field("searchkeyword") String searchWord,
                                                     @Field("perpage") int limit,
                                                     @Field("field[0]") String title,
                                                     @Field("field[1]") String discription);


//    pageno:1
////    tablename:product_data_sheet
////    searchkeyword:plastics
////    perpage:10
////    field[0]:product_name
////    field[1]:family_group
////    field[2]:product_type

    @FormUrlEncoded
    @POST("search.php")
    Observable<ResponseBody> getSearchListFromPDS(@Field("pageno") int page,
                                                  @Field("tablename") String tblUpdate,
                                                  @Field("searchkeyword") String searchWord,
                                                  @Field("perpage") int limit,
                                                  @Field("field[0]") String productName,
                                                  @Field("field[1]") String familyGroup,
                                                  @Field("field[2]") String productType);


    // CaldNet Controller


    @GET("GetLogin")
    Call<ResponseBody> loginCaldNet(
            @Query("UserId") String email,
            @Query("Paswword") String password);


    //PageSize:10
    //PageNo:1


    @GET("GetMyIntent")
    Observable<List<IndentModel>> getIndentList(@Query("PageSize") int limit,
                                                @Query("PageNo") int pageNo, @Query("UserID") String userID);


    //    PageSize:10000
//    PageNo:1
//    UserID:Atul.Nandanwar@calderys.com
//    dealer_code:1000008352
    @GET("GetIntentListByUser")
    Observable<List<IndentModel>> getApproveIntentList(@Query("PageSize") int limit,
                                                       @Query("PageNo") int pageNo, @Query("UserID") String userID, @Query("dealer_code") String param);


    //    PageSize:10
//    PageNo:1
//    IndentCode:1000004601-1707-0098
//    dealer_code:1000008352
    @GET("GetSearchIdIntentList")
    Observable<List<IndentModel>> getApproveSearchIntentList(@Query("PageSize") int limit,
                                                             @Query("PageNo") int pageNo, @Query("IndentCode") String intentCode, @Query("dealer_code") String param);


    //    PageSize:10
//    PageNo:1
//    IndentCode:1000008352-1406-0001
//    dealer_code:1000008352
//    sdate:01/06/2013
//    EDate:27/11/2018
    @GET("GetApprovedList")
    Observable<List<IndentModel>> getApproveList(
            @Query("PageSize") int limit,
            @Query("PageNo") int pageNo,
            @Query("IndentCode") String intentCode,
            @Query("dealer_code") String param,
            @Query("sdate") String dateStart,
            @Query("EDate") String dateEnd,
            @Query("UserID") String userId);


//    PageSize:2
//    PageNo:1
//    POnumber:AGA/0509


    @GET("GetDispatch_Details")
    Observable<List<DispachedModel>> getDispachedList(@Query("PageSize") int page,
                                                      @Query("PageNo") int pageNo,
                                                      @Query("SOnumber") String parameter);

    //    PageSize:10
//    PageNo:1
//    UserID:Atul.Nandanwar@calderys.com
    @GET("GetDealerList")
    Observable<List<DealerModel>> getDealerList(@Query("PageSize") int limit,
                                                @Query("PageNo") int pageNo, @Query("UserID") String userID);

    //    PageSize:10
//    PageNo:1
    //DealerCode =1000008352
    @GET("GetDealerListByDealerCode")
    Observable<List<DealerModel>> getDealerListBySearch(@Query("PageSize") int limit,
                                                        @Query("PageNo") int pageNo, @Query("DealerCode") String dealerCode);


//        PageSize:2
//        PageNo:1
//        dealer_code:1000000005


    @GET("GetIntentItem")
    Observable<List<IndentModel>> getSingleIntent(@Query("PageSize") int limit, @Query("PageNo") int pageNo, @Query("dealer_code") String parameter);

    @GET("HomePageMessageList")
    Observable<List<MessageModel>> getImportantMessage(@Query("Type") String type);


    @GET("GetSuccessStoriesMaster")
    Observable<List<StroiesModel>> getStroiesList(@Query("Type") String type);

//    PageSize:4
//    PageNo:1
//    UserID:1000001729

    @GET("GetViewDraft")
    Observable<List<ViewDraftModel>> getViewDraftList(@Query("PageSize") int limit,
                                                      @Query("PageNo") int page,
                                                      @Query("UserID") String userId);

    @POST("DeleteMessage")
    Call<ResponseBody> deleteSettingMessage(@Body JsonObject jsonObject);

    @POST("DeleteSuccessStories")
    Call<ResponseBody> deleteSettingStories(@Body JsonObject jsonObject);

    @POST("PutUpdateMessage")
    Call<ResponseBody> updateSettingMessage(@Body JsonObject jsonObject);

    @POST("PutUpdateSuccessStories")
    Call<ResponseBody> updateSettingStories(@Body JsonObject jsonObject);

    @POST("PostsaveSuccessStories")
    Call<ResponseBody> postSettingStories(@Body JsonObject jsonObject);

    @POST("PostsaveMessage")
    Call<ResponseBody> postSettingMessage(@Body JsonObject jsonObject);

    @POST("DraftCancel")
    Call<ResponseBody> deleteViewDraft(@Body JsonObject jsonObject);

//    PageSize:10
//    PageNo:1
//    IndentCode:1000008352-1406-0001
//    dealer_code:1000008352
//    sdate:01/06/2013
//    EDate:27/11/2018

    @GET("GetApprovedList")
    Observable<List<IndentModel>> getApprovedIndent(@Query("PageSize") int limit,
                                                    @Query("PageNo") int pageNo,
                                                    @Query("IndentCode") String IndentCode,
                                                    @Query("dealer_code") String DealerCode,
                                                    @Query("sdate") String startDate,
                                                    @Query("EDate") String endDate);

//    IndentCode:1000000070-1310-0013
//        IndentDate:22/10/2013

    @GET("EditViewDraft")
    Observable<ResponseBody> getEditDraftModel(@Query("IndentCode") String indentCode,
                                                    @Query("IndentDate") String indentDate);


//    PageSize:10
//    PageNo:1
//    PlantCode:krw
//    sdate:01/06/2013
//    EDate:28/11/2018


    @GET("GetViewPlantIntent")
    Observable<List<IndentModel>> getViewPlantIntent(@Query("PageSize") int limit,
                                                     @Query("PageNo") int pageNo,
                                                     @Query("PlantCode") String tbleName,
                                                     @Query("sdate") String parameter,
                                                     @Query("EDate") String parameter2);

    @GET("GetCountries")
    Observable<ResponseBody> downloadCountries();

    //        PageSize:3
//        PageNo:1
//        IndentCode:
//        dealer_code:
//        sdate:01/06/2013
//        EDate:28/11/2018
////        Status:
//
//
//
//    PageSize:10
//    PageNo:1
//    IndentCode:
//    dealer_code:
//    sdate:01/03/2013
//    EDate:28/11/2018
//    Status:/**/

//    PageSize:3
//    PageNo:1
//    IndentCode:1000008345-1406-0003
//    dealer_code:100000345
//    sdate:01/03/2013
//    EDate:05/12/2018
//    Status:S

    @GET("GetViewIndent")
    Observable<List<IndentModel>> getViewIndent(@Query("PageSize") int limit,
                                                @Query("PageNo") int pageNo,
                                                @Query("IndentCode") String parameter,
                                                @Query("dealer_code") String parameter2,
                                                @Query("sdate") String parameter3,
                                                @Query("EDate") String parameter4,
                                                @Query("Status") String parameter5
    );

    @GET("GetRegion")
    Observable<ResponseBody> downloadRegion(@Query("CountryCode") String id);

    @POST("AddConsignees")
    Observable<ResponseBody> storeConsignee(@Body ConsigneeModel model);

    @POST("ApprovalRejectIndent")
    Observable<ResponseBody> updateIndent(@Body JsonObject jsonObject);


//    {
//        "UserType":"DD",
//            "indent_code":"dfsdf",
//            "UserID":"sdfs",
//            "IsRejection":"dsfsd",
//            "SO_Type":"sdfsd",
//            "indent_status":"S",
//            "ApprovedBy":"fdsf",
//            "Comments":"sdfsd",
//            "SO_number":"sfd",
//            "Sales_Org":"",
//            "DistChannel":"",
//            "Division":"",
//            "SalesOffice":"",
//            "SalesGroup":"",
//            "UsageIndicator":"",
//            "SpecialProcIndicator":"",
//            "Partner":"",
//            "ProcessCode":"",
//            "EquipmentCode":"",
//            "SalesPackage":"",
//            "ApprovalType":"y"
//    }


//    { "UserType":"C",
//           "IndentCode":"1000008345-1811-0606",
//           "UserID":"Atul.Nandanwar@calderys.com",
//           "IsRejection":"false",
//           "SO_Type":"ZSAM",
//           "indent_status":"S",
//           "ApprovedBy":"krw",
//           "Comments":"thikana",
//           "SO_number":"ZSAM",
//           "Sales_Org":"CALDERYS INDIA  REFS. LTD(NRW)",
//           "DistChannel":"SS",
//           "Division":"US",
//           "SalesOffice":"DEL",
//           "SalesGroup":"FGS",
//           "UsageIndicator":"CUS",
//           "SpecialProcIndicator":"ZRMS",
//           "Partner":"100009988",
//           "ProcessCode":"CO-001",
//           "EquipmentCode":"CO0101",
//           "SalesPackage":"CALDERYS INDIA  REFS. LTD(NRW)",
//           "ApprovalType":"Y"
//}


    @GET("GetPlantList")
    Observable<ResponseBody> downloadPlants();

    @GET("GetConsigneeDetails")
    Observable<List<ConsigneeListModel>> downloadConsignee(@Query("PageSize") int limit, @Query("PageNo") int pageNo, @Query("dealer_code") String dealerCode);


    @POST("SearchListTransport")
    Observable<List<TransportModel>> downloadTransport(@Body JsonObject jsonObject);

    @POST("GetListMaterial")
    Observable<List<MaterialModel>> getProductList(@Body JsonObject jsonObject);

    @POST("SearchListMaterial")
    Observable<List<MaterialModel>> searchProductList(@Body JsonObject jsonObject);

    @POST("CreateIndent")
    Observable<ResponseBody> createIndent(@Body IndentsModel model);


    @POST("PostSaveProduct")
    Observable<ResponseBody> saveProducts(@Body List<SaveMaterialModel> materiaList);

    @POST("ApprovedIndentUsingSAP")
    Observable<ResponseBody> approvedIndentUsingSAP(@Body SAPModel model);


    @GET("GetEquipmentCode")
    Observable<ResponseBody> downloadEqp(@Query("ProcessCode") String id);
}
