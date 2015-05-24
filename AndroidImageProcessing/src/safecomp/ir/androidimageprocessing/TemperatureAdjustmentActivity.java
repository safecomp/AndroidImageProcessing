package safecomp.ir.androidimageprocessing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class TemperatureAdjustmentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_temperature_adjustment);
		
		findViewById(R.id.simpleMethod).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(TemperatureAdjustmentActivity.this,TempTestActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
}
