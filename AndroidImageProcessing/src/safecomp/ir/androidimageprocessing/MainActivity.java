package safecomp.ir.androidimageprocessing;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.originalImage).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this,DisplayActivity.class);
				i.putExtra("type",Type.original);
				startActivity(i);
			}
		});
		findViewById(R.id.dithering).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this,DitheringActivity.class);
				startActivity(i);
			}
		});
		findViewById(R.id.temperatureAdjustment).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this,TemperatureAdjustmentActivity.class);
				startActivity(i);
			}
		});
		
		
	}
}
