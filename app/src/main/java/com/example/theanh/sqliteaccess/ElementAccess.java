package com.example.theanh.sqliteaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.theanh.framework.FrameWork;
import com.example.theanh.model.Element;

import java.util.ArrayList;
import java.util.List;

public final class ElementAccess {

    /**
     * method help get all data duplicate match actomic number
     */

    public static Element getData(String atomic_number){
        return FrameWork.elementList.get(Integer.parseInt(atomic_number) - 1);
    }

    /**
     * method help to get list elements
     * @param context
     * @return
     */
    public static List<Element> getListElement(Context context){
        List<Element> list = new ArrayList<>();
        Element element;
        String DATABASE_NAME = "EzChemistry.sqlite";

        SQLiteDatabase database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("Select * from Element_Properties", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            element = new Element();
            element.setAtomicNumber(cursor.getString(0));
            element.setAtomicWeight(cursor.getString(1));
            element.setName(cursor.getString(2));
            element.setLatinName(cursor.getString(3));
            element.setSymbol(cursor.getString(4));
            element.setDensity(cursor.getString(5));
            element.setMeltingPoint(cursor.getString(6));
            element.setBoilingPoint(cursor.getString(7));
            element.setAtomicRadius(cursor.getString(8));
            element.setConvalentRadius(cursor.getString(9));
            element.setSpecificVolume(cursor.getString(10));
            element.setSpecificHeat(cursor.getString(11));
            element.setHeatFusion(cursor.getString(12));
            element.setHeatEvaporation(cursor.getString(13));
            element.setThermalConductivity(cursor.getString(14));
            element.setPaulingElectronegativity(cursor.getString(15));
            element.setFirstIonisationEnergy(cursor.getString(16));
            element.setOxidationStates(cursor.getString(17));
            element.setLattice(cursor.getString(18));
            element.setLatticeConstant(cursor.getString(19));
            element.setElectronicConfiguration(cursor.getString(20));
            element.setGroup(cursor.getString(21));
            element.setOldGroup(cursor.getString(22));
            element.setIonCharge(cursor.getString(23));
            element.setPeriod(cursor.getString(24));
            element.setPrevalenceUniverse(cursor.getString(25));
            element.setPrevalenceSun(cursor.getString(26));
            element.setPrevalenceOceans(cursor.getString(27));
            element.setPrevalenceHuman(cursor.getString(28));
            element.setPrevalenceEarth(cursor.getString(29));
            element.setPrevalenceMeteorites(cursor.getString(30));
            element.setCasNumber(cursor.getString(31));
            element.setDiscoveryYear(cursor.getString(32));
            element.setDiscoverer(cursor.getString(33));
            element.setWikiUrl(cursor.getString(34));
            element.setSources(cursor.getString(35));
            element.setColor(cursor.getString(36));
            element.setHydrides(cursor.getString(37));
            element.setOxideds(cursor.getString(38));
            element.setChlorides(cursor.getString(39));
            element.setIdGraphic(cursor.getString(40));
            list.add(element);
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return list;
    }

}
