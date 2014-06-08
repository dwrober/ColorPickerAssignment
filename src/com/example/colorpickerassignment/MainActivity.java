package com.example.colorpickerassignment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private int MAX = 255;
	private int MIN = 0;
	
	private NumberPicker redPicker;
	private NumberPicker greenPicker;
	private NumberPicker bluePicker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	private void setupNumberPickers() {
		final String[] nums = new String[256];
		for(int i=0; i<nums.length; i++) {
		   nums[i] = Integer.toString(i);
		}
		
		redPicker = (NumberPicker) findViewById(R.id.red);
		greenPicker = (NumberPicker) findViewById(R.id.green);
		bluePicker = (NumberPicker) findViewById(R.id.blue);

		setupPicker(redPicker, nums);
		setupPicker(greenPicker, nums);
		setupPicker(bluePicker, nums);
		
		addRedListeners();
	}
	
	private void addRedListeners() {
		redPicker.setOnValueChangedListener( new NumberPicker.
	            OnValueChangeListener() {
	            @Override
	            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
	            	Log.i("RedChange", "From: " + Integer.toString(oldVal) + " to newVal: " + Integer.toString(newVal));
	            }
	        });
		
		greenPicker.setOnValueChangedListener( new NumberPicker.
	            OnValueChangeListener() {
	            @Override
	            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
	            	Log.i("GreenChange", "From: " + Integer.toString(oldVal) + " to newVal: " + Integer.toString(newVal));
	            }
	        });
		
		bluePicker.setOnValueChangedListener( new NumberPicker.
	            OnValueChangeListener() {
	            @Override
	            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
	            	Log.i("BlueChange", "From: " + Integer.toString(oldVal) + " to newVal: " + Integer.toString(newVal));
	            }
	        });
	}
	
	private void setupPicker(NumberPicker np, String[] nums) {
		np.setMaxValue(MAX);
		np.setMinValue(0);
		np.setWrapSelectorWheel(true);
		np.setDisplayedValues(nums);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		setupNumberPickers();
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
