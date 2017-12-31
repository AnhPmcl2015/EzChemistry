package com.example.theanh.ezchemistry;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theanh.adapter.ElementAdapter;
import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.BackgroundColor;
import com.example.theanh.model.Element;
import com.example.theanh.model.Graphic;
import com.example.theanh.sqliteaccess.BackgroundColorAccess;
import com.example.theanh.sqliteaccess.ElementAccess;
import com.example.theanh.sqliteaccess.GraphicAccess;
import com.example.theanh.sqliteaccess.TextColorAccess;


public class Detail extends AppCompatActivity {

    private ListView lvSearch;
    private ElementAdapter elementAdapter;
    private Button btnImageOfElement;

    private ImageView imgImageOfElement;
    private TextView txtSymbolDetail, txtNameDetail, txtAtomicWeightDetail_1, txtLatinNameDetail, txtPeriodDetail, txtGroupDetail_1, txtDiscoveryYear_Detail,
        txtCasNumberDetail, txtDiscovererDetail, txtLatticeDetail, txtLatticeConstantDetail, txtSourcesDetail, txtColorDetail, txtElectronsDetail,txtProtonsDetail,
        txtNeutronsDetail, txtAtomicWeightDetail_2, txtDensityDetail, txtMeltingPointDetail, txtBoilingPointDetail, txtGroupDetail_2, txtOldGroupDetail,
        txtElectronConfigurationDetail, txtOxidationStatesDetail, txtIonChargeDetail, txtAtomicRadiusDetail, txtCovalentDetail, txtUniverseDetail, txtSunDetail,
        txtOceansDetai, txtHumanDetail, txtEarthDetail, txtMeteoritesDetail, txtSpecificVolumeDetail, txtSpecificHeatDetail, txtHeatFusionDetail, txtHeatEvaporationDetail,
        txtThermalConductivityDetail, txtPaulingElectronegativityDetail, txtFirstIonisationEnergyDetail, txtUniverseTitleDetail, txtSunTitleDetail, txtOceansTitleDetail,
        txtHumanTitleDetail, txtEarthTitleDetail, txtMeteoritesTitleDetail, txtHydridesDetail, txtOxidedsDetail, txtChloridesDetail;
    private LinearLayout layoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_detail);

        addControls();

        addEvents();
    }

    /**
     * method help to init layout
     */
    private void addControls(){
        // create home button on action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if(FrameWork.flagForDetail) {
            // get data from ezchemistry activity
            Bundle bundle = getIntent().getExtras();
            setDataForElement(bundle);
        }

        lvSearch = findViewById(R.id.lv_Search);
        elementAdapter = new ElementAdapter(Detail.this, FrameWork.elementList);
        lvSearch.setAdapter(elementAdapter);

        lvSearch.setEnabled(false);
        lvSearch.setVisibility(View.INVISIBLE);

        btnImageOfElement = findViewById(R.id.btnShowImageOfElement);
        imgImageOfElement = findViewById(R.id.imgImageDetail);
        layoutName = findViewById(R.id.layoutName);

        txtSymbolDetail = findViewById(R.id.txtSymbolDetail);
        txtNameDetail = findViewById(R.id.txtNameDetail);
        txtAtomicWeightDetail_1 = findViewById(R.id.txtAtomic_weightDetail_1);
        txtLatinNameDetail = findViewById(R.id.txtLatinNameDetail);
        txtPeriodDetail = findViewById(R.id.txtPeriodDetail);
        txtGroupDetail_1 = findViewById(R.id.txtGroupDetail_1);
        txtDiscoveryYear_Detail = findViewById(R.id.txtDiscoveryYearDetail);
        txtDiscovererDetail = findViewById(R.id.txtDiscovererDetail);
        txtCasNumberDetail = findViewById(R.id.txtCasNumberDetail);
        txtLatticeDetail = findViewById(R.id.txtLatticeDetail);
        txtLatticeConstantDetail = findViewById(R.id.txtLatticeConstantDetail);
        txtSourcesDetail = findViewById(R.id.txtSourcesDetail);
        txtColorDetail = findViewById(R.id.txtColorDetail);
        txtElectronsDetail = findViewById(R.id.txtElectronsDetail);
        txtProtonsDetail = findViewById(R.id.txtProtonsDetail);
        txtNeutronsDetail = findViewById(R.id.txtNeutronsDetail);
        txtAtomicWeightDetail_2 = findViewById(R.id.txtAtomic_weightDetail_2);
        txtDensityDetail = findViewById(R.id.txtDensityDetail);
        txtMeltingPointDetail = findViewById(R.id.txtMeltingPointDetail);
        txtBoilingPointDetail = findViewById(R.id.txtBoilingPointDetail);
        txtGroupDetail_2 = findViewById(R.id.txtGroupDetail_2);
        txtOldGroupDetail = findViewById(R.id.txtOldGroupDetail);
        txtElectronConfigurationDetail = findViewById(R.id.txtElectronConfigurationDetail);
        txtOxidationStatesDetail = findViewById(R.id.txtOxidationStatesDetail);
        txtIonChargeDetail = findViewById(R.id.txtIonChargeDetail);
        txtAtomicRadiusDetail = findViewById(R.id.txtAtomicRadiusDetail);
        txtCovalentDetail = findViewById(R.id.txtCovalentRadiusDetail);

        txtUniverseDetail = findViewById(R.id.txtUniverseDetail);
        txtUniverseTitleDetail = findViewById(R.id.txtUniverseTitle);
        txtSunDetail = findViewById(R.id.txtSunDetail);
        txtSunTitleDetail = findViewById(R.id.txtSunTitle);
        txtOceansDetai = findViewById(R.id.txtOceansDetail);
        txtOceansTitleDetail = findViewById(R.id.txtOceansTitle);
        txtHumanDetail = findViewById(R.id.txtHumanDetail);
        txtHumanTitleDetail = findViewById(R.id.txtHumanTitle);
        txtEarthDetail = findViewById(R.id.txtEarthDetail);
        txtEarthTitleDetail = findViewById(R.id.txtEarthTitle);
        txtMeteoritesDetail = findViewById(R.id.txtMeteoritesDetail);
        txtMeteoritesTitleDetail = findViewById(R.id.txtMeteoritesTitle);

        txtSpecificVolumeDetail = findViewById(R.id.txtSpecificVolumeDetail);
        txtSpecificHeatDetail = findViewById(R.id.txtSpecificHeatDetail);
        txtHeatFusionDetail = findViewById(R.id.txtHeatFusionDetail);
        txtHeatEvaporationDetail = findViewById(R.id.txtHeatEvaporationDetail);
        txtThermalConductivityDetail = findViewById(R.id.txtThermalConductivityDetail);
        txtPaulingElectronegativityDetail = findViewById(R.id.txtPaulingElectronegativityDetail);
        txtFirstIonisationEnergyDetail = findViewById(R.id.txtFirsIonisationEnergyDetail);

        txtHydridesDetail = findViewById(R.id.txtHydridesDetail);
        txtOxidedsDetail = findViewById(R.id.txtOxidedsDetail);
        txtChloridesDetail = findViewById(R.id.txtChloridesDetail);

        dataOfElements();
    }

    /**
     * method help to show all data of element
     */
    public void dataOfElements(){
        Element element = FrameWork.elementForDetail;
        layoutName.setBackgroundColor(Color.parseColor(BackgroundColorAccess.getBackgroundColor(GraphicAccess.getIdBackgroundColor(element.getIdGraphic()))));
        imgImageOfElement.setImageBitmap(FrameWork.toBitmap(GraphicAccess.getImage(element.getIdGraphic())));
        txtSymbolDetail.setText(element.getSymbol());
        txtNameDetail.setText(element.getName());
        txtAtomicWeightDetail_1.setText(element.getAtomicWeight() + " (g/mol)");
        int textColor = Color.parseColor(TextColorAccess.getTextColor(GraphicAccess.getIdTextColor(element.getIdGraphic())));
        txtSymbolDetail.setTextColor(textColor);
        txtNameDetail.setTextColor(textColor);
        txtAtomicWeightDetail_1.setTextColor(textColor);

        txtPeriodDetail.setText(element.getPeriod());
        txtLatinNameDetail.setText(element.getLatinName());
        txtDiscovererDetail.setText(element.getDiscoverer());
        txtDiscoveryYear_Detail.setText(element.getDiscoveryYear());
        txtCasNumberDetail.setText(element.getCasNumber());
        txtLatticeDetail.setText(element.getLattice());
        txtLatticeConstantDetail.setText(element.getLatticeConstant());
        txtSourcesDetail.setText(element.getSources());
        txtColorDetail.setText(element.getColor());

        if(!"-".equals(element.getAtomicWeight())) {
            txtElectronsDetail.setText(element.getAtomicNumber());
            txtProtonsDetail.setText(element.getAtomicNumber());
            int atomicWeight = Math.round(Float.parseFloat(element.getAtomicWeight()));
            txtNeutronsDetail.setText(atomicWeight - Integer.parseInt(element.getAtomicNumber()) + "");
        }else{
            txtNeutronsDetail.setText("-");
            txtElectronsDetail.setText("-");
            txtProtonsDetail.setText("-");
        }

        txtAtomicWeightDetail_2.setText(element.getAtomicWeight() + " (g/mol)");
        txtDensityDetail.setText(element.getDensity() + " (g/cm^3)");
        txtMeltingPointDetail.setText(element.getMeltingPoint() + " K");
        txtBoilingPointDetail.setText(element.getBoilingPoint() + " K");
        txtGroupDetail_2.setText(element.getGroup());
        txtOldGroupDetail.setText(element.getOldGroup());
        txtElectronConfigurationDetail.setText(element.getElectronicConfiguration());
        txtOxidationStatesDetail.setText(element.getOxidationStates());
        txtIonChargeDetail.setText(element.getIonCharge());
        txtAtomicRadiusDetail.setText(element.getAtomicRadius());
        txtCovalentDetail.setText(element.getConvalentRadius());

        String name = element.getName();
        txtUniverseTitleDetail.setText("Universe consists of " + name + " on:");
        txtUniverseDetail.setText(element.getPrevalenceUniverse()+"%");
        txtSunTitleDetail.setText("Sun consists of " + name + " on:");
        txtSunDetail.setText(element.getPrevalenceSun()+"%");
        txtOceansTitleDetail.setText("Oceans consists of " + name + " on:");
        txtOceansDetai.setText(element.getPrevalenceOceans()+"%");
        txtHumanTitleDetail.setText("Human consists of " + name + " on:");
        txtHumanDetail.setText(element.getPrevalenceHuman()+"%");
        txtEarthTitleDetail.setText("The Earth's crust consists of " + name + " on:");
        txtEarthDetail.setText(element.getPrevalenceEarth()+"%");
        txtMeteoritesTitleDetail.setText("Meteorites consists of " + name + " on:");
        txtMeteoritesDetail.setText(element.getPrevalenceMeteorites()+"%");

        txtSpecificHeatDetail.setText(element.getSpecificHeat());
        txtSpecificVolumeDetail.setText(element.getSpecificVolume());
        txtHeatEvaporationDetail.setText(element.getHeatEvaporation());
        txtHeatFusionDetail.setText(element.getHeatFusion());
        txtThermalConductivityDetail.setText(element.getThermalConductivity());
        txtPaulingElectronegativityDetail.setText(element.getPaulingElectronegativity());
        txtFirstIonisationEnergyDetail.setText(element.getFirstIonisationEnergy());

        txtHydridesDetail.setText(element.getHydrides());
        txtOxidedsDetail.setText(element.getOxideds());
        txtChloridesDetail.setText(element.getChlorides());
    }

    private void addEvents(){
        btnImageOfElement.setOnClickListener(e->{
            final Dialog dialog = new Dialog(Detail.this);
            dialog.setContentView(R.layout.dialog_image_of_element);

            ImageView imageView = dialog.findViewById(R.id.imgImageDetail_Dialog);
            imageView.setImageBitmap(FrameWork.toBitmap(GraphicAccess.getImage(FrameWork.elementForDetail.getIdGraphic())));

            dialog.show();
        });
    }

    private void setDataForElement(Bundle bundle){
        Element element = ElementAccess.getData(bundle.getString("atomic_number"));
        FrameWork.elementForDetail = element;
    }


    /**
     * method help to create 3 menu (search, share, connect to wiki) on action bar
     * @param menu
     *          create context menu on action bar
     * @return
     *          menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);

        shareElementData(menu);

        searchElementData(menu);

        openInternetBrower(menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * method help to share element data
     * @param menu
     *      menu on action bar
     */
    private void shareElementData(Menu menu){
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider myShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        StringBuilder message = new StringBuilder("");
        message.append("Name:" + "\t");
        message.append(FrameWork.elementForDetail.getName() + "\n");
        message.append("Atomic number: " + "\t");
        message.append(FrameWork.elementForDetail.getAtomicNumber() + "\n");
        message.append("Atomic weight:" + "\t");
        message.append(FrameWork.elementForDetail.getAtomicWeight() + "\n");
        message.append("Wiki url:" + "\t");
        message.append(FrameWork.elementForDetail.getWikiUrl() + "\t");

        Intent myIntent = new Intent();
        myIntent.setAction(Intent.ACTION_SEND);
        myIntent.putExtra(Intent.EXTRA_TEXT, message.toString());
        myIntent.setType("text/plain");
        myShareActionProvider.setShareIntent(myIntent);
    }

    /**
     * method help to search element data
     * @param menu
     *          menu on action bar
     */
    private void searchElementData(Menu menu){
        MenuItem mnuSearch = menu.findItem(R.id.action_search);
        android.support.v7.widget.SearchView a = (android.support.v7.widget.SearchView) mnuSearch.getActionView();
        a.setQueryHint("Name or Atomic number");
        a.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if("".equals(newText.trim())) {
                    lvSearch.setEnabled(false);
                    lvSearch.setVisibility(View.INVISIBLE);
                }
                else{
                    lvSearch.setEnabled(true);
                    lvSearch.setVisibility(View.VISIBLE);
                    elementAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });
    }

    /**
     * method help to open wiki link
     * @param menu
     *          menu on action bar
     */
    private void openInternetBrower(Menu menu){
        MenuItem wikiItem = menu.findItem(R.id.action_wiki);
        wikiItem.setOnMenuItemClickListener(e->{
            String url = FrameWork.elementForDetail.getWikiUrl();
            if (!url.startsWith("http://") && !url.startsWith("https://"))
                url = "http://" + url;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return false;
        });

    }
}
