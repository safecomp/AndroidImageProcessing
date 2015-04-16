package safecomp.ir.androidimageprocessing;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class DisplayActivity extends Activity {

	Intent i;
	int type;
	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		
		iv=(ImageView)findViewById(R.id.imageView);
		i=getIntent();
		type=i.getIntExtra("type",Type.original);
		
		switch(type){
		case Type.original:
			iv.setImageResource(R.drawable.lena);
			break;
		case Type.dithering:
			int op=i.getIntExtra("op",Dithering.atkinson);
			doDithering(op);
			break;
		}
	}
	private void doDithering(int op){
		Dithering d=new Dithering();
		Bitmap lenaGrayScale=BitmapFactory.decodeResource(getResources(),R.drawable.lena_gray_scale);
		switch(op){
		case Dithering.atkinson:
			iv.setImageBitmap(d.atkinson(lenaGrayScale));
			break;
		case Dithering.burkes:
			iv.setImageBitmap(d.burkes(lenaGrayScale));
			break;
		case Dithering.falseFloydSteinberg:
			iv.setImageBitmap(d.falseFloydSteinberg(lenaGrayScale));
			break;
		case Dithering.floydSteinberg:
			iv.setImageBitmap(d.floydSteinberg(lenaGrayScale));
			break;
		case Dithering.jarvisJudiceNinke:
			iv.setImageBitmap(d.jarvisJudiceNinke(lenaGrayScale));
			break;
		case Dithering.ordered2By2Bayer:
			iv.setImageBitmap(d.ordered2By2Bayer(lenaGrayScale));
			break;
		case Dithering.ordered3By3Bayer:
			iv.setImageBitmap(d.ordered3By3Bayer(lenaGrayScale));
			break;
		case Dithering.ordered4By4Bayer:
			iv.setImageBitmap(d.ordered4By4Bayer(lenaGrayScale));
			break;
		case Dithering.ordered8By8Bayer:
			iv.setImageBitmap(d.ordered8By8Bayer (lenaGrayScale));
			break;
		case Dithering.randomDithering:
			iv.setImageBitmap(d.randomDithering(lenaGrayScale));
			break;
		case Dithering.sierra:
			iv.setImageBitmap(d.sierra(lenaGrayScale));
			break;
		case Dithering.sierraLite:
			iv.setImageBitmap(d.sierraLite(lenaGrayScale));
			break;
		case Dithering.simpleLeftToRightErrorDiffusion:
			iv.setImageBitmap(d.simpleLeftToRightErrorDiffusion(lenaGrayScale));
			break;
		case Dithering.simpleThreshold:
			iv.setImageBitmap(d.simpleThreshold(lenaGrayScale));
			break;
		case Dithering.stucki:
			iv.setImageBitmap(d.stucki(lenaGrayScale));
			break;
		case Dithering.twoRowSierra:
			iv.setImageBitmap(d.twoRowSierra(lenaGrayScale));
			break;
		}
	}

}
