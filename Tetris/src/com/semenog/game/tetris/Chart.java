package com.semenog.game.tetris;

//For Chart Display By  Balakrishna

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Chart extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_report);
        
        // Getting reference to the button btn_chart
        Button btnChart = (Button) findViewById(R.id.btnreport);
        
        // Defining click event listener for the button btn_chart
        OnClickListener clickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Draw the Income vs Expense Chart
				openChart();				
			}
		};
		
		// Setting event click listener for the button btn_chart of the MainActivity layout
		btnChart.setOnClickListener(clickListener);
        
    }
    
    private void openChart(){    	
    	
    	Log.i("Balakrishna","Balakrishna");
    	
    	// Pie Chart Section Names
    	String[] code = new String[] {"Rotation", "Left To Right", "Right To Left"};    	
    	
    	// Pie Chart Section Value
    	double[] distribution = { 25, 35, 40} ;
    	
    	// Color of each Pie Chart Sections
    	int[] colors = { Color.BLUE, Color.GREEN, Color.RED };
    	
    	
    	// Instantiating CategorySeries to plot Pie Chart    	
    	CategorySeries distributionSeries = new CategorySeries(" Android version distribution as on October 1, 2012");
    	    	
    	Log.i("Balakrishn","Balakrishna....");
    	for(int i=0 ;i < distribution.length;i++){
    		// Adding a slice with its values and name to the Pie Chart
    		distributionSeries.add(code[i], distribution[i]);
    	}   
    	
    	// Instantiating a renderer for the Pie Chart
    	DefaultRenderer defaultRenderer  = new DefaultRenderer();    	
    	for(int i = 0 ;i<distribution.length;i++){    		
    		SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();    	
    		seriesRenderer.setColor(colors[i]);
    		seriesRenderer.setDisplayChartValues(true);
    		// Adding a renderer for a slice
    		defaultRenderer.addSeriesRenderer(seriesRenderer);
    	}
    	
    	//defaultRenderer.setChartTitle("Android version distribution as on October 1, 2012 ");
    	//defaultRenderer.setChartTitleTextSize(20);
    	//defaultRenderer.setZoomButtonsVisible(true);    	    		
    		
    	// Creating an intent to plot bar chart using dataset and multipleRenderer    	
    	Intent intent = ChartFactory.getPieChartIntent(getBaseContext(), distributionSeries , defaultRenderer, "Tetris Gustures PieChart");    	
    	
    	// Start Activity
    	startActivity(intent);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}