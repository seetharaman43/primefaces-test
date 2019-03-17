package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.AxesGridLines;


import org.primefaces.model.charts.axes.radial.RadialScales;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearAngleLines;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearPointLabels;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearTicks;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;

import org.primefaces.model.charts.polar.PolarAreaChartDataSet;
import org.primefaces.model.charts.polar.PolarAreaChartModel;
import org.primefaces.model.charts.polar.PolarAreaChartOptions;

@ManagedBean(name = "testView")
@ViewScoped
public class TestView implements Serializable {
    
    private String testString;
    
    private PolarAreaChartModel polarAreaModel;
    
    @PostConstruct  
    public void init() {
        createPolarAreaModel();
    }
    
     private void createPolarAreaModel() {
        polarAreaModel = new PolarAreaChartModel();
        ChartData data = new ChartData();
         
        PolarAreaChartDataSet dataSet = new PolarAreaChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(11);
        values.add(16);
        values.add(7);
        values.add(3);
        values.add(14);
        dataSet.setData(values);
         
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(75, 192, 192)");
        bgColors.add("rgb(255, 205, 86)");
        bgColors.add("rgb(201, 203, 207)");
        bgColors.add("rgb(54, 162, 235)");
        dataSet.setBackgroundColor(bgColors);
         
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Green");
        labels.add("Yellow");
        labels.add("Grey");
        labels.add("Blue");
        data.setLabels(labels);
        
        try{
            PolarAreaChartOptions options = new PolarAreaChartOptions();
            Legend legend = new Legend();
            LegendLabel legentLabel = new LegendLabel();
            RadialScales radialScales = new RadialScales();
            RadialLinearAngleLines radialLinearAngleLines = new RadialLinearAngleLines();
            AxesGridLines gridLines = new AxesGridLines();
            RadialLinearPointLabels pointLabels = new RadialLinearPointLabels();
            RadialLinearTicks ticks = new RadialLinearTicks();

            options.setAnimateRotate(true);
            options.setAnimateScale(true);


            legend.setPosition("left");
            legentLabel.setBoxWidth(5); 
            legend.setLabels(legentLabel);
            legentLabel.setFontColor("rgb(255, 204, 153)");
            legentLabel.setFontStyle("font-family: sans-serif");
            legend.setDisplay(true);

            options.setLegend(legend);
            
            List<String> bgColors1 = new ArrayList<>();
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
            bgColors1.add("#FF33FF");
             
            
            

            gridLines.setDisplay(true);
            gridLines.setColor(bgColors1);
            gridLines.setLineWidth(3);

            ticks.setMax(30);
            ticks.setMin(5);
            ticks.setStepSize(5);
            ticks.setDisplay(true);

            radialScales.setTicks(ticks);
            radialScales.setGridLines(gridLines);
            options.setScales(radialScales);
            polarAreaModel.setOptions(options);
        }catch(Exception e)
        {
            System.out.println("Exception in options"+e);
        }
        
        
         
        polarAreaModel.setData(data);
    }
    
    
    public PolarAreaChartModel getPolarAreaModel() {
        return polarAreaModel;
    }
 
    public void setPolarAreaModel(PolarAreaChartModel polarAreaModel) {
        this.polarAreaModel = polarAreaModel;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }    
}
