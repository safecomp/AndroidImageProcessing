package safecomp.ir.androidimageprocessing;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;;
public class DitheringActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dithering);
		
		final Intent i=new Intent(DitheringActivity.this,DisplayActivity.class);
		i.putExtra("type",Type.dithering);
		
		findViewById(R.id.atkinson).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.atkinson);
				startActivity(i);
			}
		});
		findViewById(R.id.burkes).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.burkes);
				startActivity(i);
			}
		});
		findViewById(R.id.falseFloydSteinberg).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.falseFloydSteinberg);
				startActivity(i);
			}
		});
		findViewById(R.id.floydSteinberg).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.floydSteinberg);
				startActivity(i);
			}
		});
		findViewById(R.id.jarvisJudiceNinke).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.jarvisJudiceNinke);
				startActivity(i);
			}
		});
		findViewById(R.id.ordered2By2Bayer).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.ordered2By2Bayer);
				startActivity(i);
			}
		});
		findViewById(R.id.ordered3By3Bayer).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.ordered3By3Bayer);
				startActivity(i);
			}
		});
		findViewById(R.id.ordered4By4Bayer).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.ordered4By4Bayer);
				startActivity(i);
			}
		});
		findViewById(R.id.ordered8By8Bayer).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.ordered8By8Bayer);
				startActivity(i);
			}
		});
		findViewById(R.id.randomDithering).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.randomDithering);
				startActivity(i);
			}
		});
		findViewById(R.id.sierra).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.sierra);
				startActivity(i);
			}
		});
		findViewById(R.id.sierraLite).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.sierraLite);
				startActivity(i);
			}
		});
		findViewById(R.id.simpleLeftToRightErrorDiffusion).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.simpleLeftToRightErrorDiffusion);
				startActivity(i);
			}
		});
		findViewById(R.id.simpleThreshold).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.simpleThreshold);
				startActivity(i);
			}
		});
		findViewById(R.id.stucki).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.stucki);
				startActivity(i);
			}
		});
		findViewById(R.id.twoRowSierra).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				i.putExtra("op",Dithering.twoRowSierra);
				startActivity(i);
			}
		});






	}
}
