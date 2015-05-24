package safecomp.ir.androidimageprocessing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.*;


public class TempTestActivity extends Activity {

	SeekBar seekBar;
	ImageView iv;
	TemperatureAdjustment ta;
	Bitmap testImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temp_test);
		
		testImage=BitmapFactory.decodeResource(getResources(),R.drawable.temp_test);
		
		ta=new TemperatureAdjustment();
		
		iv=(ImageView)findViewById(R.id.imageView);
		
		seekBar=(SeekBar)findViewById(R.id.seekBar1);
		seekBar.setMax(200);
		seekBar.setProgress(100);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar s) {
				iv.setImageBitmap(ta.simpleMethod(testImage,s.getProgress()-100));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int value, boolean arg2) {				
			}
		});
	}
}
