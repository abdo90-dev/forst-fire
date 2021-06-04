package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForistFire extends AppCompatActivity {
    BarChart barChart ;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forist_fire);
        barChart = findViewById(R.id.barChar);
        pieChart = findViewById(R.id.pieChart);
        Map<String,Float> FFMC = new HashMap<>();
        Map<String,Float> DMC = new HashMap<>();
        Map<String,Float> DC = new HashMap<>();
        Map<String,Float> ISI = new HashMap<>();
        Map<String,Float> temp = new HashMap<>();
        Map<String,Float> RH = new HashMap<>();
        Map<String,Float> wind = new HashMap<>();
        Map<String,Float> rain = new HashMap<>();
        Map<String,Float> area = new HashMap<>();

        try {
            InputStream is = getResources().openRawResource(R.raw.forestfires_1);
            BufferedReader file = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String s,r="\\w+";
            ArrayList<String> arrayList = new ArrayList<>();
            s= file.readLine();
            Matcher matcher = Pattern.compile(r).matcher(s);



            while(matcher.find()){
                if ("day".equals(matcher.group())) {
                    while (matcher.find())
                        arrayList.add(matcher.group());
                    break;
                }
            }


            while((s=file.readLine())!=null){

                String[] s1 = s.split(",");
                if (FFMC.keySet().contains(s1[2])){
                    Float d = FFMC.get(s1[2])+Float.valueOf(s1[4]);
                    FFMC.put(s1[2],d);
                }else{
                    FFMC.put(s1[2],Float.valueOf(s1[4]));
                }

                if (DMC.keySet().contains(s1[2])){
                    Float d = DMC.get(s1[2])+Float.valueOf(s1[5]);
                    DMC.put(s1[2],d);
                }else{
                    DMC.put(s1[2],Float.valueOf(s1[5]));
                }
                if (DC.keySet().contains(s1[2])){
                    Float d = DC.get(s1[2])+Float.valueOf(s1[6]);
                    DC.put(s1[2],d);
                }else{
                    DC.put(s1[2],Float.valueOf(s1[6]));
                }
                if (ISI.keySet().contains(s1[2])){
                    Float d = ISI.get(s1[2])+Float.valueOf(s1[7]);
                    ISI.put(s1[2],d);
                }else{
                    ISI.put(s1[2],Float.valueOf(s1[7]));
                }
                if (temp.keySet().contains(s1[2])){
                    Float d = temp.get(s1[2])+Float.valueOf(s1[8]);
                    temp.put(s1[2],d);
                }else{
                    temp.put(s1[2],Float.valueOf(s1[8]));
                }
                if (RH.keySet().contains(s1[2])){
                    Float d = RH.get(s1[2])+Float.valueOf(s1[9]);
                    RH.put(s1[2],d);
                }else{
                    RH.put(s1[2],Float.valueOf(s1[9]));
                }
                if (wind.keySet().contains(s1[2])){
                    Float d = wind.get(s1[2])+Float.valueOf(s1[10]);
                    wind.put(s1[2],d);
                }else{
                    wind.put(s1[2],Float.valueOf(s1[10]));
                }
                if (rain.keySet().contains(s1[2])){
                    Float d = rain.get(s1[2])+Float.valueOf(s1[11]);
                    rain.put(s1[2],d);
                }else{
                    rain.put(s1[2],Float.valueOf(s1[11]));
                }
                if (area.keySet().contains(s1[2])){
                    Float d = area.get(s1[2])+Float.valueOf(s1[12]);
                    area.put(s1[2],d);
                }else{
                    area.put(s1[2],Float.valueOf(s1[12]));
                }

            }
            float ffmc=0.0f;
            for (String ffmc1 :FFMC.keySet()){
                ffmc += FFMC.get(ffmc1);
            }
            float dmc=0.0f;
            for (String ffmc1 :DMC.keySet()){
                dmc += DMC.get(ffmc1);
            }
            float dc=0.0f;
            for (String ffmc1 :DC.keySet()){
                dc += DC.get(ffmc1);
            }
            float isi=0.0f;
            for (String ffmc1 :ISI.keySet()){
                isi += ISI.get(ffmc1);
            }
            float temp1 =0.0f;
            for (String ffmc1 :temp.keySet()){
                temp1 += temp.get(ffmc1);
            }
            float rh=0.0f;
            for (String ffmc1 :RH.keySet()){
                rh += RH.get(ffmc1);
            }
            float wind1=0.0f;
            for (String ffmc1 :wind.keySet()){
                wind1 += wind.get(ffmc1);
            }
            float rain1=0.0f;
            for (String ffmc1 :rain.keySet()){
                rain1 += rain.get(ffmc1);
            }
            float area1=0.0f;
            for (String ffmc1 :area.keySet()){
                area1 += area.get(ffmc1);
            }
            System.out.println(area1);
        ArrayList<PieEntry>  pieEntries= new ArrayList<>();
            pieEntries.add(new PieEntry(ffmc,"FFMC"));
            pieEntries.add(new PieEntry(dmc,"DMC"));
            pieEntries.add(new PieEntry(dc,"DC"));
            pieEntries.add(new PieEntry(isi,"ISI"));
            pieEntries.add(new PieEntry(temp1,"temp"));
            pieEntries.add(new PieEntry(rh,"RH"));
            pieEntries.add(new PieEntry(wind1,"wind"));
            pieEntries.add(new PieEntry(rain1,"rain"));
            pieEntries.add(new PieEntry(area1,"area"));
            PieDataSet pieDataSet = new PieDataSet(pieEntries,"Expense category");
            ArrayList<Integer> colors = new ArrayList<>();
            for (int color : ColorTemplate.MATERIAL_COLORS){
                  colors.add(color);
            }
            for (int color : ColorTemplate.VORDIPLOM_COLORS){
                colors.add(color);
            }
            pieDataSet.setColors(colors);
            PieData pieData = new PieData(pieDataSet);
            pieData.setDrawValues(true);
            pieData.setValueFormatter(new PercentFormatter(pieChart));
            //pieData.setValueTextSize(12f);
            pieData.setValueTextColor(Color.BLACK);
            pieChart.setData(pieData);
            pieChart.invalidate();
        } catch (Exception e) {

        }
        Set<String> months = FFMC.keySet();

        ArrayList<BarEntry> FFMCArray = new ArrayList<>();
        ArrayList<BarEntry> DMCArray = new ArrayList<>();
        ArrayList<BarEntry> DCArray = new ArrayList<>();
        ArrayList<BarEntry> ISIArray = new ArrayList<>();
        ArrayList<BarEntry> tempArray = new ArrayList<>();
        ArrayList<BarEntry> RHArray = new ArrayList<>();
        ArrayList<BarEntry> windArray = new ArrayList<>();
        ArrayList<BarEntry> rainArray = new ArrayList<>();
        ArrayList<BarEntry> areaArray = new ArrayList<>();
        for (String month:months){


            FFMCArray.add(new BarEntry(1,FFMC.get(month)));
            DMCArray.add(new BarEntry(1,DMC.get(month)));
            DCArray.add(new BarEntry(1,DC.get(month)));
            ISIArray.add(new BarEntry(1,ISI.get(month)));
            tempArray.add(new BarEntry(1,temp.get(month)));
            RHArray.add(new BarEntry(1,RH.get(month)));
            windArray.add(new BarEntry(1,wind.get(month)));
            rainArray.add(new BarEntry(1,rain.get(month)));
            areaArray.add(new BarEntry(1,area.get(month)));


        }



        BarDataSet dataset = new BarDataSet(FFMCArray,"FFMC");
        dataset.setColor(Color.RED);
        BarDataSet dataset1 = new BarDataSet(DMCArray,"DMC");
        dataset1.setColor(Color.YELLOW);
        BarDataSet dataset2 = new BarDataSet(DCArray,"DC");
        dataset2.setColor(Color.GREEN);
        BarDataSet dataset3 = new BarDataSet(ISIArray,"ISI");
        dataset3.setColor(Color.GRAY);
        BarDataSet dataset4 = new BarDataSet(tempArray,"temp");
        dataset4.setColor(Color.BLACK);
        BarDataSet dataset5 = new BarDataSet(RHArray,"RH");
        dataset5.setColor(Color.BLUE);
        BarDataSet dataset6 = new BarDataSet(windArray,"wind");
        dataset6.setColor(Color.CYAN);
        BarDataSet dataset7 = new BarDataSet(rainArray,"rain");
        dataset7.setColor(Color.LTGRAY);
        BarDataSet dataset8 = new BarDataSet(areaArray,"area");
        dataset8.setColor(Color.MAGENTA);


        BarData data = new BarData(dataset,dataset1,dataset2,dataset3,dataset4,dataset5,dataset6,dataset7,dataset8);
        barChart.setData(data);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(months));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.02f;
        float groupSpace = 0.1f;
        data.setBarWidth(0.08f);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*months.size());
        barChart.getAxisRight().disableAxisLineDashedLine();
        barChart.groupBars(0,groupSpace,barSpace);
        barChart.invalidate();
        try{
        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        String s=br.readLine();
        while((s=br.readLine())!=null){

        }
    } catch (Exception e) {

    }

    setUpPieChart(pieChart);
    }
    private void setUpPieChart(PieChart pieChart){
     pieChart.setDrawHoleEnabled(true);
     pieChart.setUsePercentValues(true);
     pieChart.setEntryLabelTextSize(12f);
     pieChart.setEntryLabelColor(Color.BLACK);
     pieChart.setCenterText("spending by category");
     pieChart.setCenterTextSize(16f);
     pieChart.getDescription().setEnabled(false);
        Legend legend = pieChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);
    }
}