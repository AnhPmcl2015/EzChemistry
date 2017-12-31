package com.example.theanh.ezchemistry;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.Element;
import com.example.theanh.sqliteaccess.BackgroundColorAccess;
import com.example.theanh.sqliteaccess.ElementAccess;
import com.example.theanh.sqliteaccess.GraphicAccess;
import com.example.theanh.sqliteaccess.ReactionAccess;
import com.example.theanh.sqliteaccess.SqlAccess;
import com.example.theanh.sqliteaccess.TextColorAccess;

import java.util.ArrayList;
import java.util.List;


public class EzChemistry extends Activity {

    /*
        Button id of elements;
    */
    private ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23,
        btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37,btn38, btn39, btn40, btn41, btn42, btn43,btn44, btn45, btn46,
        btn47, btn48, btn49, btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58, btn59, btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69,
        btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77, btn78, btn79, btn80, btn81, btn82, btn83, btn84, btn85, btn86, btn87, btn88, btn89, btn90, btn91, btn92,
        btn93, btn94, btn95, btn96, btn97, btn98, btn99, btn100, btn101, btn102, btn103, btn104, btn105, btn106, btn107, btn108, btn109, btn110, btn111, btn112, btn113,
        btn114, btn115, btn116, btn117, btn118, btnLoadReactionWindow;

    protected List<ImageButton> btnAkaliMetals;
    protected List<ImageButton> btnAkalineEarthMetals;
    protected List<ImageButton> btnTransitionMetals;
    protected List<ImageButton> btnOtherMetals;
    protected List<ImageButton> btnMetalloids;
    protected List<ImageButton> btnOtherNonMetals;
    protected List<ImageButton> btnHalogens;
    protected List<ImageButton> btnNobleGases;
    protected List<ImageButton> btnOther;

    /*
        Button id of detail
     */
    private Button btnDetail;

    private Button btnBackgroundColor;

    /*
        Text view id of details
     */
    private TextView txtAtomic_number, txtAtomic_weight, txtSymbol, txtElectronegativity, txtElectronic_configuration, txtName, txtOxidation_states;

    /*FrameLayout Detail*/
    private FrameLayout layout_Detail;

    /*Element model*/
    private Element element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ez_chemistry);



        // init activity to display main features
        addControls();
        addEvents();


    }

    private void addControls(){

        btnLoadReactionWindow = findViewById(R.id.btnLoadReactionWindow);

        /*Element model*/
        element = ElementAccess.getData("13");

        // layout detail
        layout_Detail = findViewById(R.id.layout_Detail);

        // Button Detail
        btnDetail = findViewById(R.id.btnDetail);
        btnBackgroundColor = findViewById(R.id.btnBackgroundColor);

        txtAtomic_number = findViewById(R.id.txtAtomic_number);
        txtAtomic_weight = findViewById(R.id.txtAtomic_weight);
        txtSymbol = findViewById(R.id.txtSymbol);
        txtElectronegativity = findViewById(R.id.txtElectronegativity);
        txtElectronic_configuration = findViewById(R.id.txtElectronic_configuration);
        txtName = findViewById(R.id.txtName);
        txtOxidation_states = findViewById(R.id.txtOxidation_states);

        // Button elements                              Set tag to get ID name
        btn1 = findViewById(R.id.btn1);                 btn1.setTag("1");
        btn2 = findViewById(R.id.btn2);                 btn2.setTag("2");

        btn3 = findViewById(R.id.btn3);                 btn3.setTag("3");
        btn4 = findViewById(R.id.btn4);                 btn4.setTag("4");
        btn5 = findViewById(R.id.btn5);                 btn5.setTag("5");
        btn6 = findViewById(R.id.btn6);                 btn6.setTag("6");
        btn7 = findViewById(R.id.btn7);                 btn7.setTag("7");
        btn8 = findViewById(R.id.btn8);                 btn8.setTag("8");
        btn9 = findViewById(R.id.btn9);                 btn9.setTag("9");
        btn10 = findViewById(R.id.btn10);               btn10.setTag("10");

        btn11 = findViewById(R.id.btn11);               btn11.setTag("11");
        btn12 = findViewById(R.id.btn12);               btn12.setTag("12");
        btn13 = findViewById(R.id.btn13);               btn13.setTag("13");
        btn14 = findViewById(R.id.btn14);               btn14.setTag("14");
        btn15 = findViewById(R.id.btn15);               btn15.setTag("15");
        btn16 = findViewById(R.id.btn16);               btn16.setTag("16");
        btn17 = findViewById(R.id.btn17);               btn17.setTag("17");
        btn18 = findViewById(R.id.btn18);               btn18.setTag("18");

        btn19 = findViewById(R.id.btn19);               btn19.setTag("19");
        btn20 = findViewById(R.id.btn20);               btn20.setTag("20");
        btn21 = findViewById(R.id.btn21);               btn21.setTag("21");
        btn22 = findViewById(R.id.btn22);               btn22.setTag("22");
        btn23 = findViewById(R.id.btn23);               btn23.setTag("23");
        btn24 = findViewById(R.id.btn24);               btn24.setTag("24");
        btn25 = findViewById(R.id.btn25);               btn25.setTag("25");
        btn26 = findViewById(R.id.btn26);               btn26.setTag("26");
        btn27 = findViewById(R.id.btn27);               btn27.setTag("27");
        btn28 = findViewById(R.id.btn28);               btn28.setTag("28");
        btn29 = findViewById(R.id.btn29);               btn29.setTag("29");
        btn30 = findViewById(R.id.btn30);               btn30.setTag("30");
        btn31 = findViewById(R.id.btn31);               btn31.setTag("31");
        btn32 = findViewById(R.id.btn32);               btn32.setTag("32");
        btn33 = findViewById(R.id.btn33);               btn33.setTag("33");
        btn34 = findViewById(R.id.btn34);               btn34.setTag("34");
        btn35 = findViewById(R.id.btn35);               btn35.setTag("35");
        btn36 = findViewById(R.id.btn36);               btn36.setTag("36");

        btn37 = findViewById(R.id.btn37);               btn37.setTag("37");
        btn38 = findViewById(R.id.btn38);               btn38.setTag("38");
        btn39 = findViewById(R.id.btn39);               btn39.setTag("39");
        btn40 = findViewById(R.id.btn40);               btn40.setTag("40");
        btn41 = findViewById(R.id.btn41);               btn41.setTag("41");
        btn42 = findViewById(R.id.btn42);               btn42.setTag("42");
        btn43 = findViewById(R.id.btn43);               btn43.setTag("43");
        btn44 = findViewById(R.id.btn44);               btn44.setTag("44");
        btn45 = findViewById(R.id.btn45);               btn45.setTag("45");
        btn46 = findViewById(R.id.btn46);               btn46.setTag("46");
        btn47 = findViewById(R.id.btn47);               btn47.setTag("47");
        btn48 = findViewById(R.id.btn48);               btn48.setTag("48");
        btn49 = findViewById(R.id.btn49);               btn49.setTag("49");
        btn50 = findViewById(R.id.btn50);               btn50.setTag("50");
        btn51 = findViewById(R.id.btn51);               btn51.setTag("51");
        btn52 = findViewById(R.id.btn52);               btn52.setTag("52");
        btn53 = findViewById(R.id.btn53);               btn53.setTag("53");
        btn54 = findViewById(R.id.btn54);               btn54.setTag("54");

        btn55 = findViewById(R.id.btn55);               btn55.setTag("55");
        btn56 = findViewById(R.id.btn56);               btn56.setTag("56");
        btn57 = findViewById(R.id.btn57);               btn57.setTag("57");
        btn58 = findViewById(R.id.btn58);               btn58.setTag("58");
        btn59 = findViewById(R.id.btn59);               btn59.setTag("59");
        btn60 = findViewById(R.id.btn60);               btn60.setTag("60");
        btn61 = findViewById(R.id.btn61);               btn61.setTag("61");
        btn62 = findViewById(R.id.btn62);               btn62.setTag("62");
        btn63 = findViewById(R.id.btn63);               btn63.setTag("63");
        btn64 = findViewById(R.id.btn64);               btn64.setTag("64");
        btn65 = findViewById(R.id.btn65);               btn65.setTag("65");
        btn66 = findViewById(R.id.btn66);               btn66.setTag("66");
        btn67 = findViewById(R.id.btn67);               btn67.setTag("67");
        btn68 = findViewById(R.id.btn68);               btn68.setTag("68");
        btn69 = findViewById(R.id.btn69);               btn69.setTag("69");
        btn70 = findViewById(R.id.btn70);               btn70.setTag("70");
        btn71 = findViewById(R.id.btn71);               btn71.setTag("71");
        btn72 = findViewById(R.id.btn72);               btn72.setTag("72");
        btn73 = findViewById(R.id.btn73);               btn73.setTag("73");
        btn74 = findViewById(R.id.btn74);               btn74.setTag("74");
        btn75 = findViewById(R.id.btn75);               btn75.setTag("75");
        btn76 = findViewById(R.id.btn76);               btn76.setTag("76");
        btn77 = findViewById(R.id.btn77);               btn77.setTag("77");
        btn78 = findViewById(R.id.btn78);               btn78.setTag("78");
        btn79 = findViewById(R.id.btn79);               btn79.setTag("79");
        btn80 = findViewById(R.id.btn80);               btn80.setTag("80");
        btn81 = findViewById(R.id.btn81);               btn81.setTag("81");
        btn82 = findViewById(R.id.btn82);               btn82.setTag("82");
        btn83 = findViewById(R.id.btn83);               btn83.setTag("83");
        btn84 = findViewById(R.id.btn84);               btn84.setTag("84");
        btn85 = findViewById(R.id.btn85);               btn85.setTag("85");
        btn86 = findViewById(R.id.btn86);               btn86.setTag("86");

        btn87 = findViewById(R.id.btn87);               btn87.setTag("87");
        btn88 = findViewById(R.id.btn88);               btn88.setTag("88");
        btn89 = findViewById(R.id.btn89);               btn89.setTag("89");
        btn90 = findViewById(R.id.btn90);               btn90.setTag("90");
        btn91 = findViewById(R.id.btn91);               btn91.setTag("91");
        btn92 = findViewById(R.id.btn92);               btn92.setTag("92");
        btn93 = findViewById(R.id.btn93);               btn93.setTag("93");
        btn94 = findViewById(R.id.btn94);               btn94.setTag("94");
        btn95 = findViewById(R.id.btn95);               btn95.setTag("95");
        btn96 = findViewById(R.id.btn96);               btn96.setTag("96");
        btn97 = findViewById(R.id.btn97);               btn97.setTag("97");
        btn98 = findViewById(R.id.btn98);               btn98.setTag("98");
        btn99 = findViewById(R.id.btn99);               btn99.setTag("99");
        btn100 = findViewById(R.id.btn100);             btn100.setTag("100");
        btn101 = findViewById(R.id.btn101);             btn101.setTag("101");
        btn102 = findViewById(R.id.btn102);             btn102.setTag("102");
        btn103 = findViewById(R.id.btn103);             btn103.setTag("103");
        btn104 = findViewById(R.id.btn104);             btn104.setTag("104");
        btn105 = findViewById(R.id.btn105);             btn105.setTag("105");
        btn106 = findViewById(R.id.btn106);             btn106.setTag("106");
        btn107 = findViewById(R.id.btn107);             btn107.setTag("107");
        btn108 = findViewById(R.id.btn108);             btn108.setTag("108");
        btn109 = findViewById(R.id.btn109);             btn109.setTag("109");

        btn110 = findViewById(R.id.btn110);             btn110.setTag("110");
        btn111 = findViewById(R.id.btn111);             btn111.setTag("111");
        btn112 = findViewById(R.id.btn112);             btn112.setTag("112");
        btn113 = findViewById(R.id.btn113);             btn113.setTag("113");
        btn114 = findViewById(R.id.btn114);             btn114.setTag("114");
        btn115 = findViewById(R.id.btn115);             btn115.setTag("115");
        btn116 = findViewById(R.id.btn116);             btn116.setTag("116");
        btn117 = findViewById(R.id.btn117);             btn117.setTag("117");
        btn118 = findViewById(R.id.btn118);             btn118.setTag("118");

        btnAkaliMetals = new ArrayList<>();
        btnAkalineEarthMetals = new ArrayList<>();
        btnTransitionMetals = new ArrayList<>();
        btnOtherMetals = new ArrayList<>();
        btnOtherNonMetals = new ArrayList<>();
        btnMetalloids = new ArrayList<>();
        btnHalogens = new ArrayList<>();
        btnNobleGases = new ArrayList<>();
        btnOther = new ArrayList<>();

        btnAkaliMetals.add(btn3);
        btnAkaliMetals.add(btn11);
        btnAkaliMetals.add(btn19);
        btnAkaliMetals.add(btn37);
        btnAkaliMetals.add(btn55);
        btnAkaliMetals.add(btn87);

        btnAkalineEarthMetals.add(btn4);
        btnAkalineEarthMetals.add(btn12);
        btnAkalineEarthMetals.add(btn20);
        btnAkalineEarthMetals.add(btn38);
        btnAkalineEarthMetals.add(btn56);
        btnAkalineEarthMetals.add(btn88);

        btnHalogens.add(btn9);
        btnHalogens.add(btn17);
        btnHalogens.add(btn35);
        btnHalogens.add(btn53);

        btnNobleGases.add(btn2);
        btnNobleGases.add(btn10);
        btnNobleGases.add(btn18);
        btnNobleGases.add(btn36);
        btnNobleGases.add(btn54);
        btnNobleGases.add(btn86);

        btnOtherMetals.add(btn13);
        btnOtherMetals.add(btn31);
        btnOtherMetals.add(btn49);
        btnOtherMetals.add(btn81);
        btnOtherMetals.add(btn50);
        btnOtherMetals.add(btn82);
        btnOtherMetals.add(btn83);
        btnOtherMetals.add(btn84);

        btnOtherNonMetals.add(btn6);
        btnOtherNonMetals.add(btn7);
        btnOtherNonMetals.add(btn8);
        btnOtherNonMetals.add(btn15);
        btnOtherNonMetals.add(btn16);
        btnOtherNonMetals.add(btn34);

        btnOther.add(btn110);
        btnOther.add(btn111);
        btnOther.add(btn112);
        btnOther.add(btn113);
        btnOther.add(btn114);
        btnOther.add(btn115);
        btnOther.add(btn116);
        btnOther.add(btn117);
        btnOther.add(btn118);

        btnMetalloids.add(btn5);
        btnMetalloids.add(btn14);
        btnMetalloids.add(btn32);
        btnMetalloids.add(btn51);
        btnMetalloids.add(btn52);
        btnMetalloids.add(btn85);
        btnMetalloids.add(btn33);

        btnTransitionMetals.add(btn21);
        btnTransitionMetals.add(btn22);
        btnTransitionMetals.add(btn23);
        btnTransitionMetals.add(btn24);
        btnTransitionMetals.add(btn25);
        btnTransitionMetals.add(btn26);
        btnTransitionMetals.add(btn27);
        btnTransitionMetals.add(btn28);
        btnTransitionMetals.add(btn29);
        btnTransitionMetals.add(btn30);

        btnTransitionMetals.add(btn39);
        btnTransitionMetals.add(btn40);
        btnTransitionMetals.add(btn41);
        btnTransitionMetals.add(btn42);
        btnTransitionMetals.add(btn43);
        btnTransitionMetals.add(btn44);
        btnTransitionMetals.add(btn45);
        btnTransitionMetals.add(btn46);
        btnTransitionMetals.add(btn47);
        btnTransitionMetals.add(btn48);

        btnTransitionMetals.add(btn71);
        btnTransitionMetals.add(btn72);
        btnTransitionMetals.add(btn73);
        btnTransitionMetals.add(btn74);
        btnTransitionMetals.add(btn75);
        btnTransitionMetals.add(btn76);
        btnTransitionMetals.add(btn77);
        btnTransitionMetals.add(btn78);
        btnTransitionMetals.add(btn79);
        btnTransitionMetals.add(btn80);

        btnTransitionMetals.add(btn103);
        btnTransitionMetals.add(btn104);
        btnTransitionMetals.add(btn105);
        btnTransitionMetals.add(btn106);
        btnTransitionMetals.add(btn107);
        btnTransitionMetals.add(btn108);
        btnTransitionMetals.add(btn109);

        btnTransitionMetals.add(btn57);
        btnTransitionMetals.add(btn58);
        btnTransitionMetals.add(btn59);
        btnTransitionMetals.add(btn60);
        btnTransitionMetals.add(btn61);
        btnTransitionMetals.add(btn62);
        btnTransitionMetals.add(btn63);
        btnTransitionMetals.add(btn64);
        btnTransitionMetals.add(btn65);
        btnTransitionMetals.add(btn66);
        btnTransitionMetals.add(btn67);
        btnTransitionMetals.add(btn68);
        btnTransitionMetals.add(btn69);
        btnTransitionMetals.add(btn70);

        btnTransitionMetals.add(btn89);
        btnTransitionMetals.add(btn90);
        btnTransitionMetals.add(btn91);
        btnTransitionMetals.add(btn92);
        btnTransitionMetals.add(btn93);
        btnTransitionMetals.add(btn94);
        btnTransitionMetals.add(btn95);
        btnTransitionMetals.add(btn96);
        btnTransitionMetals.add(btn97);
        btnTransitionMetals.add(btn98);
        btnTransitionMetals.add(btn99);
        btnTransitionMetals.add(btn100);
        btnTransitionMetals.add(btn101);
        btnTransitionMetals.add(btn102);
    }

    private void addEvents(){
        EventForElementsButton event = new EventForElementsButton();
        btn1.setOnClickListener(event);
        btn10.setOnClickListener(event);
        btn11.setOnClickListener(event);
        btn12.setOnClickListener(event);
        btn13.setOnClickListener(event);
        btn14.setOnClickListener(event);
        btn15.setOnClickListener(event);
        btn16.setOnClickListener(event);
        btn17.setOnClickListener(event);
        btn18.setOnClickListener(event);
        btn19.setOnClickListener(event);
        btn2.setOnClickListener(event);
        btn20.setOnClickListener(event);
        btn21.setOnClickListener(event);
        btn22.setOnClickListener(event);
        btn23.setOnClickListener(event);
        btn24.setOnClickListener(event);
        btn25.setOnClickListener(event);
        btn26.setOnClickListener(event);
        btn27.setOnClickListener(event);
        btn28.setOnClickListener(event);
        btn29.setOnClickListener(event);
        btn3.setOnClickListener(event);
        btn30.setOnClickListener(event);
        btn31.setOnClickListener(event);
        btn32.setOnClickListener(event);
        btn33.setOnClickListener(event);
        btn34.setOnClickListener(event);
        btn35.setOnClickListener(event);
        btn36.setOnClickListener(event);
        btn37.setOnClickListener(event);
        btn38.setOnClickListener(event);
        btn39.setOnClickListener(event);
        btn4.setOnClickListener(event);
        btn40.setOnClickListener(event);
        btn41.setOnClickListener(event);
        btn42.setOnClickListener(event);
        btn43.setOnClickListener(event);
        btn44.setOnClickListener(event);
        btn45.setOnClickListener(event);
        btn46.setOnClickListener(event);
        btn47.setOnClickListener(event);
        btn48.setOnClickListener(event);
        btn49.setOnClickListener(event);
        btn5.setOnClickListener(event);
        btn50.setOnClickListener(event);
        btn51.setOnClickListener(event);
        btn52.setOnClickListener(event);
        btn53.setOnClickListener(event);
        btn54.setOnClickListener(event);
        btn55.setOnClickListener(event);
        btn56.setOnClickListener(event);
        btn57.setOnClickListener(event);
        btn58.setOnClickListener(event);
        btn59.setOnClickListener(event);
        btn6.setOnClickListener(event);
        btn60.setOnClickListener(event);
        btn61.setOnClickListener(event);
        btn62.setOnClickListener(event);
        btn63.setOnClickListener(event);
        btn64.setOnClickListener(event);
        btn65.setOnClickListener(event);
        btn66.setOnClickListener(event);
        btn67.setOnClickListener(event);
        btn68.setOnClickListener(event);
        btn69.setOnClickListener(event);
        btn7.setOnClickListener(event);
        btn70.setOnClickListener(event);
        btn71.setOnClickListener(event);
        btn72.setOnClickListener(event);
        btn73.setOnClickListener(event);
        btn74.setOnClickListener(event);
        btn75.setOnClickListener(event);
        btn76.setOnClickListener(event);
        btn77.setOnClickListener(event);
        btn78.setOnClickListener(event);
        btn79.setOnClickListener(event);
        btn8.setOnClickListener(event);
        btn80.setOnClickListener(event);
        btn81.setOnClickListener(event);
        btn82.setOnClickListener(event);
        btn83.setOnClickListener(event);
        btn84.setOnClickListener(event);
        btn85.setOnClickListener(event);
        btn86.setOnClickListener(event);
        btn87.setOnClickListener(event);
        btn88.setOnClickListener(event);
        btn89.setOnClickListener(event);
        btn9.setOnClickListener(event);
        btn90.setOnClickListener(event);
        btn91.setOnClickListener(event);
        btn92.setOnClickListener(event);
        btn93.setOnClickListener(event);
        btn94.setOnClickListener(event);
        btn95.setOnClickListener(event);
        btn96.setOnClickListener(event);
        btn97.setOnClickListener(event);
        btn98.setOnClickListener(event);
        btn99.setOnClickListener(event);
        btn100.setOnClickListener(event);
        btn101.setOnClickListener(event);
        btn102.setOnClickListener(event);
        btn103.setOnClickListener(event);
        btn104.setOnClickListener(event);
        btn105.setOnClickListener(event);
        btn106.setOnClickListener(event);
        btn107.setOnClickListener(event);
        btn108.setOnClickListener(event);
        btn109.setOnClickListener(event);
        btn110.setOnClickListener(event);
        btn112.setOnClickListener(event);
        btn113.setOnClickListener(event);
        btn114.setOnClickListener(event);
        btn115.setOnClickListener(event);
        btn116.setOnClickListener(event);
        btn117.setOnClickListener(event);
        btn118.setOnClickListener(event);

        // Set click event for btnDetail
       btnDetail.setOnClickListener(e->showDetailOfElement());

       btnDetail.setOnLongClickListener(e->displayAnnotationsOfButtonDetail());

       btnBackgroundColor.setOnClickListener(e->displayDialogFilterElements());

       btnLoadReactionWindow.setOnClickListener(e->displayReactionWindow());
    }

    /**
     * class to handle event click and long click on button
     */
    class EventForElementsButton implements View.OnClickListener, View.OnLongClickListener{
        @Override
        public void onClick(View view) {
            // get data of element
            ImageButton btn = (ImageButton) view;
            String tag = (String) btn.getTag();
            element = ElementAccess.getData(tag);

            // set some main properties of element
            txtAtomic_number.setText(element.getAtomicNumber());
            txtAtomic_weight.setText(element.getAtomicWeight());
            txtName.setText(element.getName());
            txtSymbol.setText(element.getSymbol());
            txtOxidation_states.setText(element.getOxidationStates());
            txtElectronegativity.setText(element.getPaulingElectronegativity());
            txtElectronic_configuration.setText(element.getElectronicConfiguration());


             // instead of using values/color.xml, I import data to database to reduce line of code in
             //      addControls() method, it's also help application run faster when init application

            // set background color for button detail
            layout_Detail.setBackgroundColor(Color.parseColor(BackgroundColorAccess.getBackgroundColor(GraphicAccess.getIdBackgroundColor(element.getIdGraphic()))));

            // set symbol text color of button detail
            txtSymbol.setTextColor(Color.parseColor(TextColorAccess.getTextColor(GraphicAccess.getIdTextColor(element.getIdGraphic()))));
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    /**
     * method help handle click event of button detail
     */
    private void showDetailOfElement(){
        FrameWork.flagForDetail = true;
        Intent intent = new Intent(EzChemistry.this, Detail.class);

        Bundle bundle = new Bundle();
        bundle.putString("atomic_number", element.getAtomicNumber());

        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * method help to display annotations of button detail
     */
    private boolean displayAnnotationsOfButtonDetail(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(EzChemistry.this);
        LayoutInflater factory = LayoutInflater.from(EzChemistry.this);
        final View view = factory.inflate(R.layout.dialog_annotations_of_button_detail, null);
        builder.setView(view);
        builder.show();

        return false;
    }

    /**
     * method help to display dialog box to choose what element'type that user wants to show
     */
    private void displayDialogFilterElements(){
        final Dialog dialog = new Dialog(EzChemistry.this);
        dialog.setContentView(R.layout.dialog_display_filter_elements);
        dialog.setTitle("Choose categories");
        Button btnAlkaliMetalElements = dialog.findViewById(R.id.btnAlkaliMetalElements);
        Button btnAlkalineEarthMetalElements = dialog.findViewById(R.id.btnAlkalineEarthMetalElements);
        Button btnTransitionElements = dialog.findViewById(R.id.btnTransitionMetalElements);
        Button btnOtherMetalElements = dialog.findViewById(R.id.btnOtherMetalsElements);
        Button btnMetalloidElements = dialog.findViewById(R.id.btnMetalloidElements);
        Button btnOtherNonmetalElements = dialog.findViewById(R.id.btnOtherNonmetalElements);
        Button btnHalogenElements = dialog.findViewById(R.id.btnHalogenElements);
        Button btnNobleGasElements = dialog.findViewById(R.id.btnNobleGasElements);
        Button btnOtherElements = dialog.findViewById(R.id.btnOtherElements);
        Button btnAllElements = dialog.findViewById(R.id.btnAllElements);

        btnAlkaliMetalElements.setOnClickListener(e-> {
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });

        btnAllElements.setOnClickListener(e->{
            if(!FrameWork.flagForFilterElements){
                dialog.dismiss();
                return;
            }
            else{
                btn1.setEnabled(true);
                btn1.setVisibility(View.VISIBLE);

                for(ImageButton btn : btnAkaliMetals){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnAkalineEarthMetals){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnTransitionMetals){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnOtherMetals){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnMetalloids){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnOtherNonMetals){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnHalogens){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnNobleGases){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
                for(ImageButton btn : btnOther){
                    btn.setVisibility(View.VISIBLE);
                    btn.setEnabled(true);
                }
            }
            FrameWork.flagForFilterElements = false;
            dialog.dismiss();
        });

        btnAlkalineEarthMetalElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }

            FrameWork.flagForFilterElements = true;
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            dialog.dismiss();
        });

        btnTransitionElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }

            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);

            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });

        btnOtherMetalElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });

        btnMetalloidElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });

        btnOtherNonmetalElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });

        btnHalogenElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });

        btnNobleGasElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });

        btnOtherElements.setOnClickListener(e->{
            for(ImageButton btn : btnAkaliMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnAkalineEarthMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnTransitionMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnMetalloids){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOtherNonMetals){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnHalogens){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnNobleGases){
                btn.setVisibility(View.INVISIBLE);
                btn.setEnabled(false);
            }
            for(ImageButton btn : btnOther){
                btn.setVisibility(View.VISIBLE);
                btn.setEnabled(true);
            }
            btn1.setEnabled(false);
            btn1.setVisibility(View.INVISIBLE);
            FrameWork.flagForFilterElements = true;
            dialog.dismiss();
        });
        dialog.show();
    }

    private void displayReactionWindow(){
        Intent intent = new Intent(EzChemistry.this, ReactionWindow.class);
        startActivity(intent);
    }
}
