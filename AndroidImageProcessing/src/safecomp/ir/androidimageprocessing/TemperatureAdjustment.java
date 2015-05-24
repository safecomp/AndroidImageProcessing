package safecomp.ir.androidimageprocessing;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Temperature Adjustment Algorithms
 * 
 * @author safeallah ramezanzadeh (safecomp)
 * 
 * http://safecomp.ir
 * 
 */
public class TemperatureAdjustment {
	
	public Bitmap simpleMethod(Bitmap src,int temperatureAdjustment) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				src.getConfig());

		int alpha, red , green , blue;
		int pixel;

		int width = src.getWidth();
		int height = src.getHeight();
		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				
				red = Color.red(pixel);
				green = Color.green(pixel);
				blue = Color.blue(pixel);

				
				//add temperatureAdjustment to RED
				red=(red+temperatureAdjustment);
				if(red>255)
					red=255;
				else if(red<0)
					red=0;
				
				//Don't change GREEN
				//g=g; :D
				
				//subtract temperatureAdjustment from BLUE
				blue=(blue-temperatureAdjustment);
				if(blue>255)
					blue=255;
				else if(blue<0)
					blue=0;
				
				out.setPixel(x, y, Color.argb(alpha, red, green, blue));
			}
		}

		return out;
	}
}
