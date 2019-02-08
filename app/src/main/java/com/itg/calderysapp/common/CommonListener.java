package com.itg.calderysapp.common;

import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IndentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IntentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftEditModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;

import java.util.List;

public interface CommonListener  {
    public interface ApprovedIntentListener extends  BaseListener  {


        void onGetAllApprovedIntent(List<IndentModel> o);

    }
    public interface ViewDraftListener extends  BaseListener  {


        void onGetViewDraftsListAvailable(List<ViewDraftModel> o);

        void onSuccessDelete(Object message);
    }

    public interface MyIntentListener extends  BaseListener  {
        void onGetMyIntentsListAvailable(List<IndentModel> o);
    }

     public interface CreateIntentListener extends BaseListener {

        void onGetMaterialList(List<IndentModel> o);
        void onDownloadEditViewDraft(Indents model );

         void onSuccessNotification(IntentDetailModel message);
     }


    public interface DispachedListener extends BaseListener{

        void onGetAllDispachedList(List<DispachedModel> modelList);
    }

    public interface DealerListener extends  BaseListener {
        void onGetDealerList(List<DealerModel> models);
    }
}
