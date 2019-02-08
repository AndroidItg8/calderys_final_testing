package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class IndentController {
    private String res;

    private static final String TAG = "IndentController";

    public IndentController(String res) {
        this.res = res;
    }

    public Indents getModel() throws JSONException {
        Indents indents = null;

        JSONObject jsonObject = new JSONObject(res);
        if (res != null) {
            if (jsonObject.has("IndentInfo")) {
                JSONObject indentInfo = jsonObject.getJSONObject("IndentInfo");
                if (indentInfo.has("Indents")) {
                    JSONObject jindents = indentInfo.getJSONObject("Indents");
                    indents = new Gson().fromJson(jindents.toString(), Indents.class);
                    Log.d(TAG, "getModel: " + new Gson().toJson(indents));
                    List<Product_> myProducts = new ArrayList<>();
                    Object o = indents.getConsignee();
                    if(o!=null) {

                        JSONObject consignee = new JSONObject(new Gson().toJson(o));
                        if (consignee.has("consignee")) {
                            if (consignee instanceof JSONObject) {
                                JSONObject n = consignee.getJSONObject("consignee");
                                indents.setConsigneeName(n.getString("ConsigneeName"));
                            }
                        }
                    }


                        Object s = indents.getPlant();
                        if (s != null) {
                            JSONObject plant = new JSONObject(new Gson().toJson(s));
                            if (plant.has("plant")) {
                                if (plant.get("plant") instanceof JSONObject) {
                                    JSONObject n = plant.getJSONObject("plant");
                                    indents.setPlantName(n.getString("plant_name"));
                                    indents.setPlantCode(n.getString("plant_code"));
                                }
                            }
                        }

                        Object product = indents.getProduct();
                        if (product != null) {
                            JSONObject jProduct = new JSONObject(new Gson().toJson(product));
                            if (jProduct.has("product")) {
                                if (jProduct.get("product") instanceof JSONArray) {
                                    JSONArray products = jProduct.getJSONArray("product");
                                    if (products != null) {
                                        for (int i = 0; i < products.length(); i++) {
                                            JSONObject jP = products.getJSONObject(i);
                                            Product_ p = new Gson().fromJson(jP.toString(), Product_.class);
                                            myProducts.add(p);
                                        }
                                    }
                                } else if (jProduct.get("product") instanceof JSONObject) {
                                    JSONObject jP = jProduct.getJSONObject("product");
                                    Product_ p = new Gson().fromJson(jP.toString(), Product_.class);
                                    myProducts.add(p);
                                }
                            }
                            Product pC = new Product();
                            pC.setProduct(myProducts);
                            indents.setProduct(pC);

                            for (Product_ p :
                                    myProducts) {

                                JSONObject pName = new JSONObject(new Gson().toJson(p.getProductMaster()));
                                if (pName.has("productMaster")) {
                                    if (pName.get("productMaster") instanceof JSONObject) {
                                        JSONObject n = pName.getJSONObject("productMaster");
                                        p.setProductName(n.getString("ProductName"));
                                    }
                                }




                            if(p.getTransportMaster()!=null) {
                                    JSONObject tName = new JSONObject(new Gson().toJson(p.getTransportMaster()));
                                if (tName.has("TransportMaster")) {
                                    if (tName.get("TransportMaster") instanceof JSONObject) {
                                        JSONObject n = tName.getJSONObject("TransportMaster");
                                        p.setTransporterName(n.getString("TransporterName"));
                                        p.setTransporterCode(n.getString("TransporterCode"));
                                    }
                                }
                            }
                            }

                        }


                }
            }
        }
            Log.d(TAG, "getModel Final: " + new Gson().toJson(indents));
            return indents;
        }

}
