package in.wptrafficanalyzer.achartenginepiechart;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	private String[] mMonth = new String[] {
				"Jan", "Feb" , "Mar", "Apr", "May", "Jun",
				"Jul", "Aug" , "Sep", "Oct", "Nov", "Dec"
			};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Getting reference to the button btn_chart
        Button btnChart = (Button) findViewById(R.id.btn_chart);
        
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
    	
    	// Pie Chart Section Names
    	String[] code = new String[] {"Rotation", "Left", "Right", "Punch", "Down"};    	
    	
    	// Pie Chart Section Value
    	double[] distribution = { 20, 22, 37,3,13} ;
    	
    	// Color of each Pie Chart Sections
    	int[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW,Color.CYAN };
    	
    	// Instantiating CategorySeries to plot Pie Chart    	
    	CategorySeries distributionSeries = new CategorySeries(" Android version distribution as on October 1, 2012");
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
    	Intent intent = ChartFactory.getPieChartIntent(getBaseContext(), distributionSeries , defaultRenderer, "Tetris");    	
    	
    	// Start Activity
    	startActivity(intent);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}