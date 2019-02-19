package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProcessCodeController {

    private String res;
//    {"EquipmentInfo":{"Equipment":[{"EquipmentCode":"CO0101","Description":"Smelter (CO0101)"},{"EquipmentCode":"CO0102","Description":"Coverter / Refining (CO0102)"},{"EquipmentCode":"CO0103","Description":"Ladles (CO0103)"},{"EquipmentCode":"CO0104","Description":"Tundish & Launders (CO0104)"},{"EquipmentCode":"OTHER","Description":"OTHER (OTHER)"}]}}

    public ProcessCodeController(String res) {
        this.res = res;
    }

    public List<SpinnerGenericModel> getProcessCode() throws JSONException {
        List<SpinnerGenericModel> eqpCode=new ArrayList<>();
        JSONObject jsonObject=new JSONObject(res);
        if(jsonObject.has("EquipmentInfo")){
            JSONObject eqp=jsonObject.getJSONObject("EquipmentInfo");
            if(eqp.has("Equipment")){
                if(eqp.get("Equipment") instanceof JSONObject){
                    JSONObject eqpData=eqp.getJSONObject("Equipment");
                    eqpCode.add(getEqpFromJSON(eqpData));
                }else if(eqp.get("Equipment") instanceof JSONArray){
                    JSONArray eqpArray=eqp.getJSONArray("Equipment");
                    for(int i=0; i<eqpArray.length(); i++){
                        JSONObject eqpData=eqpArray.getJSONObject(i);
                        eqpCode.add(getEqpFromJSON(eqpData));
                    }
                }
            }
        }
        return eqpCode;
    }

    private SpinnerGenericModel getEqpFromJSON(JSONObject eqpData) throws JSONException {
        SpinnerGenericModel model=new SpinnerGenericModel();
        model.setId(eqpData.getString("EquipmentCode"));
        model.setValue(eqpData.getString("Description"));
        return model;
    }
}
