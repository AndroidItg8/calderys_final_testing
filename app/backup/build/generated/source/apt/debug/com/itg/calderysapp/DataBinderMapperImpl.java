package com.itg.calderysapp;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.itg.calderysapp.databinding.ActivityConsigneeListBindingImpl;
import com.itg.calderysapp.databinding.ActivityConsingeeAddBindingImpl;
import com.itg.calderysapp.databinding.ActivityCreateIntentBindingImpl;
import com.itg.calderysapp.databinding.ActivityMaterailAddBindingImpl;
import com.itg.calderysapp.databinding.ActivityProductListBindingImpl;
import com.itg.calderysapp.databinding.ActivityTransportListBindingImpl;
import com.itg.calderysapp.databinding.ContentConsigneeListBindingImpl;
import com.itg.calderysapp.databinding.ContentConsingeeAddBindingImpl;
import com.itg.calderysapp.databinding.ContentCreateIntentBindingImpl;
import com.itg.calderysapp.databinding.ContentMaterailAddBindingImpl;
import com.itg.calderysapp.databinding.ContentProductListBindingImpl;
import com.itg.calderysapp.databinding.ContentTransportListBindingImpl;
import com.itg.calderysapp.databinding.ItemRvCosigneeItemBindingImpl;
import com.itg.calderysapp.databinding.ItemRvIntentMaterialBindingImpl;
import com.itg.calderysapp.databinding.ItemRvProductBindingImpl;
import com.itg.calderysapp.databinding.ItemRvTransportBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCONSIGNEELIST = 1;

  private static final int LAYOUT_ACTIVITYCONSINGEEADD = 2;

  private static final int LAYOUT_ACTIVITYCREATEINTENT = 3;

  private static final int LAYOUT_ACTIVITYMATERAILADD = 4;

  private static final int LAYOUT_ACTIVITYPRODUCTLIST = 5;

  private static final int LAYOUT_ACTIVITYTRANSPORTLIST = 6;

  private static final int LAYOUT_CONTENTCONSIGNEELIST = 7;

  private static final int LAYOUT_CONTENTCONSINGEEADD = 8;

  private static final int LAYOUT_CONTENTCREATEINTENT = 9;

  private static final int LAYOUT_CONTENTMATERAILADD = 10;

  private static final int LAYOUT_CONTENTPRODUCTLIST = 11;

  private static final int LAYOUT_CONTENTTRANSPORTLIST = 12;

  private static final int LAYOUT_ITEMRVCOSIGNEEITEM = 13;

  private static final int LAYOUT_ITEMRVINTENTMATERIAL = 14;

  private static final int LAYOUT_ITEMRVPRODUCT = 15;

  private static final int LAYOUT_ITEMRVTRANSPORT = 16;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(16);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.activity_consignee_list, LAYOUT_ACTIVITYCONSIGNEELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.activity_consingee_add, LAYOUT_ACTIVITYCONSINGEEADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.activity_create_intent, LAYOUT_ACTIVITYCREATEINTENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.activity_materail_add, LAYOUT_ACTIVITYMATERAILADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.activity_product_list, LAYOUT_ACTIVITYPRODUCTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.activity_transport_list, LAYOUT_ACTIVITYTRANSPORTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.content_consignee_list, LAYOUT_CONTENTCONSIGNEELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.content_consingee_add, LAYOUT_CONTENTCONSINGEEADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.content_create_intent, LAYOUT_CONTENTCREATEINTENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.content_materail_add, LAYOUT_CONTENTMATERAILADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.content_product_list, LAYOUT_CONTENTPRODUCTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.content_transport_list, LAYOUT_CONTENTTRANSPORTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.item_rv_cosignee_item, LAYOUT_ITEMRVCOSIGNEEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.item_rv_intent_material, LAYOUT_ITEMRVINTENTMATERIAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.item_rv_product, LAYOUT_ITEMRVPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.itg.calderysapp.R.layout.item_rv_transport, LAYOUT_ITEMRVTRANSPORT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCONSIGNEELIST: {
          if ("layout/activity_consignee_list_0".equals(tag)) {
            return new ActivityConsigneeListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_consignee_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONSINGEEADD: {
          if ("layout/activity_consingee_add_0".equals(tag)) {
            return new ActivityConsingeeAddBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_consingee_add is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCREATEINTENT: {
          if ("layout/activity_create_intent_0".equals(tag)) {
            return new ActivityCreateIntentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_create_intent is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMATERAILADD: {
          if ("layout/activity_materail_add_0".equals(tag)) {
            return new ActivityMaterailAddBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_materail_add is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTLIST: {
          if ("layout/activity_product_list_0".equals(tag)) {
            return new ActivityProductListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTRANSPORTLIST: {
          if ("layout/activity_transport_list_0".equals(tag)) {
            return new ActivityTransportListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_transport_list is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTCONSIGNEELIST: {
          if ("layout/content_consignee_list_0".equals(tag)) {
            return new ContentConsigneeListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_consignee_list is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTCONSINGEEADD: {
          if ("layout/content_consingee_add_0".equals(tag)) {
            return new ContentConsingeeAddBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_consingee_add is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTCREATEINTENT: {
          if ("layout/content_create_intent_0".equals(tag)) {
            return new ContentCreateIntentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_create_intent is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTMATERAILADD: {
          if ("layout/content_materail_add_0".equals(tag)) {
            return new ContentMaterailAddBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_materail_add is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTPRODUCTLIST: {
          if ("layout/content_product_list_0".equals(tag)) {
            return new ContentProductListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_product_list is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTTRANSPORTLIST: {
          if ("layout/content_transport_list_0".equals(tag)) {
            return new ContentTransportListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_transport_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRVCOSIGNEEITEM: {
          if ("layout/item_rv_cosignee_item_0".equals(tag)) {
            return new ItemRvCosigneeItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_rv_cosignee_item is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRVINTENTMATERIAL: {
          if ("layout/item_rv_intent_material_0".equals(tag)) {
            return new ItemRvIntentMaterialBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_rv_intent_material is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRVPRODUCT: {
          if ("layout/item_rv_product_0".equals(tag)) {
            return new ItemRvProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_rv_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRVTRANSPORT: {
          if ("layout/item_rv_transport_0".equals(tag)) {
            return new ItemRvTransportBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_rv_transport is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(32);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "materialAddViewModel");
      sKeys.put(2, "materialModel");
      sKeys.put(3, "pONumber");
      sKeys.put(4, "cST");
      sKeys.put(5, "totalPrice");
      sKeys.put(6, "dispatchDate");
      sKeys.put(7, "consigneeListModel");
      sKeys.put(8, "units");
      sKeys.put(9, "consigneeName");
      sKeys.put(10, "division");
      sKeys.put(11, "transporterName");
      sKeys.put(12, "indentType");
      sKeys.put(13, "lSTDate");
      sKeys.put(14, "model");
      sKeys.put(15, "plantCode");
      sKeys.put(16, "createIndentModel");
      sKeys.put(17, "materialPricing");
      sKeys.put(18, "spinnerModel");
      sKeys.put(19, "consigneeModel");
      sKeys.put(20, "transportModel");
      sKeys.put(21, "vAT");
      sKeys.put(22, "transporterCode");
      sKeys.put(23, "indentCode");
      sKeys.put(24, "indentDate");
      sKeys.put(25, "materialName");
      sKeys.put(26, "productCode");
      sKeys.put(27, "pODate");
      sKeys.put(28, "productListModel");
      sKeys.put(29, "consigneeCode");
      sKeys.put(30, "totalDiscount");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(16);

    static {
      sKeys.put("layout/activity_consignee_list_0", com.itg.calderysapp.R.layout.activity_consignee_list);
      sKeys.put("layout/activity_consingee_add_0", com.itg.calderysapp.R.layout.activity_consingee_add);
      sKeys.put("layout/activity_create_intent_0", com.itg.calderysapp.R.layout.activity_create_intent);
      sKeys.put("layout/activity_materail_add_0", com.itg.calderysapp.R.layout.activity_materail_add);
      sKeys.put("layout/activity_product_list_0", com.itg.calderysapp.R.layout.activity_product_list);
      sKeys.put("layout/activity_transport_list_0", com.itg.calderysapp.R.layout.activity_transport_list);
      sKeys.put("layout/content_consignee_list_0", com.itg.calderysapp.R.layout.content_consignee_list);
      sKeys.put("layout/content_consingee_add_0", com.itg.calderysapp.R.layout.content_consingee_add);
      sKeys.put("layout/content_create_intent_0", com.itg.calderysapp.R.layout.content_create_intent);
      sKeys.put("layout/content_materail_add_0", com.itg.calderysapp.R.layout.content_materail_add);
      sKeys.put("layout/content_product_list_0", com.itg.calderysapp.R.layout.content_product_list);
      sKeys.put("layout/content_transport_list_0", com.itg.calderysapp.R.layout.content_transport_list);
      sKeys.put("layout/item_rv_cosignee_item_0", com.itg.calderysapp.R.layout.item_rv_cosignee_item);
      sKeys.put("layout/item_rv_intent_material_0", com.itg.calderysapp.R.layout.item_rv_intent_material);
      sKeys.put("layout/item_rv_product_0", com.itg.calderysapp.R.layout.item_rv_product);
      sKeys.put("layout/item_rv_transport_0", com.itg.calderysapp.R.layout.item_rv_transport);
    }
  }
}
