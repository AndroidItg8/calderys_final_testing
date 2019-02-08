package com.itg.calderysapp.caldNet.newIndent.createIntent.model;

import android.databinding.ObservableArrayList;

import java.util.ArrayList;
import java.util.List;

public class SpinnerFileName {

        public static final String APPROVALINDICATOR="ApprovalIndicator.xml";
        public static final String  APPROVALTYPE="ApprovalType.xml";
        public static final String DISTRIBUTIONCHANNEL="DistributionChannel.xml";
        public static final String DIVISION="Division.xml";
        public static final String EQUIPMENTCODE="EquipmentCode.xml";
        public static final String INDENTTYPE="IndentType.xml";
        public static final String PAYEMENTTERMS="PayementTerms.xml";
        public static final String PLANT="Plant.xml";
        public static final String PROCESSCODE="ProcessCode.xml";
        public static final String SALESGROUP="SalesGroup.xml";
        public static final String SALESOFFICES="SalesOffices.xml";
        public static final String SALESORGANIZATION="SalesOrganization.xml";
        public static final String SALESPACKAGE="SalesPackage.xml";
        public static final String SOTYPE="SOType.xml";
        public static final String SPECIALPROCESSINDICATORS="SpecialProcessIndicators.xml";
        public static final String UNITS="Units.xml";
        public static final String STATUS="Status.xml";
        public static final String USAGEINDICATOR="UsageIndicator.xml";

        public static List<SpinnerGenericModel> generateIGST(){
                ObservableArrayList<SpinnerGenericModel> igst=new ObservableArrayList<>();
                igst.add(new SpinnerGenericModel("","--"));
                igst.add(new SpinnerGenericModel("IGST","IGST"));
                return igst;
        }

        public static List<SpinnerGenericModel> generateISGST(){
                ObservableArrayList<SpinnerGenericModel>  sgst=new ObservableArrayList<>();
                sgst.add(new SpinnerGenericModel("","--"));
                sgst.add(new SpinnerGenericModel("SGST+CGST","SGST+CGST"));
                return sgst;
        }



}
