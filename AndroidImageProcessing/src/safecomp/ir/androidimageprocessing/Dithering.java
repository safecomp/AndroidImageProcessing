package safecomp.ir.androidimageprocessing;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * 
 * Gray Scale Dithering
 * 
 * @author safeallah ramezanzadeh (safecomp)
 * 
 * http://safecomp.ir
 * 
 * My Tutorial about Dithering : http://www.safecomp.ir/fa/node/167
 *
 */
public class Dithering {
	
	final static int ordered2By2Bayer  =1;
	final static int ordered3By3Bayer =2;
	final static int ordered4By4Bayer =3;
	final static int ordered8By8Bayer =4;
	final static int floydSteinberg  =5;
	final static int jarvisJudiceNinke=6;
	final static int sierra=7;
	final static int twoRowSierra=8;
	final static int sierraLite=9;
	final static int atkinson=10;
	final static int stucki=11;
	final static int burkes=12;
	final static int falseFloydSteinberg=13;
	final static int simpleLeftToRightErrorDiffusion=14;
	final static int randomDithering=15;
	final static int simpleThreshold=16;
	

	int threshold=128;
	
	public Dithering(){
		
	}
	public Dithering(int threshold){
		this.threshold=threshold;
	}

	/*
	 * 2 by 2 Bayer Ordered Dithering
	 * 
	 * 1 3
	 * 4 2
	 * 
	 * (1/5)
	 * 
	 */
	public Bitmap ordered2By2Bayer(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int matrix[][] = { 
				{ 1, 3 },
				{ 4, 2 },
				};

		int width = src.getWidth();
		int height = src.getHeight();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;

				gray = gray + (gray * matrix[x % 2][y % 2]) / 5;

				if (gray < threshold) {
					gray = 0;
				} else {
					gray = 255;
				}

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}
	/*
	 * 3 by 3 Bayer Ordered Dithering
	 * 
	 *  3 7 4
	 *  6 1 9
	 *  2 8 5
	 *  
	 *  (1/10)
	 */
	public Bitmap ordered3By3Bayer(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int matrix[][] = { 
				{ 3, 7, 4},
				{ 6, 1, 9 }, 
				{ 2, 8, 5 },
				};

		int width = src.getWidth();
		int height = src.getHeight();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;

				gray = gray + (gray * matrix[x % 3][y % 3]) / 10;

				if (gray < threshold) {
					gray = 0;
				} else {
					gray = 255;
				}

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	
	/*
	 * 4 by 4 Bayer Ordered Dithering
	 * 
	 *  1 9 3 11
	 *  13 5 15 7
	 *  4 12 2 10
	 *  16 8 14 6
	 *  (1/17)
	 */
	public Bitmap ordered4By4Bayer(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int matrix[][] = { 
				{ 1, 9, 3, 11 },
				{ 13, 5, 15, 7 }, 
				{ 4, 12, 2, 10 },
				{ 16, 8, 14, 6 } };

		int width = src.getWidth();
		int height = src.getHeight();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;

				gray = gray + (gray * matrix[x % 4][y % 4]) / 17;

				if (gray < threshold) {
					gray = 0;
				} else {
					gray = 255;
				}

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}
	
	
	/*
	 * 8 by 8 Bayer Ordered Dithering
	 * 
	 *  1 49 13 61 4 52 16 64
	 *  33 17 45 29 36 20 48 32
	 *  9 57 5 53 12 60 8 56
	 *  41 25 37 21 44 28 40 24
	 *  3 51 15 63 2 50 14 62
	 *  35 19 47 31 34 18 46 30
	 *  11 59 7 55 10 58 6 54
	 *  43 27 39 23 42 26 38 22
	 *  
	 *  (1/65)
	 */
	public Bitmap ordered8By8Bayer(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int matrix[][] = { 
				{ 1 ,49 ,13 ,61 ,4 ,52 ,16 ,64 },
				{ 33 ,17 ,45 ,29 ,36 ,20 ,48 ,32 }, 
				{ 9 ,57 ,5 ,53 ,12 ,60 ,8 ,56 },
				{ 41 ,25 ,37 ,21 ,44 ,28 ,40 ,24},
				{3 ,51 ,15 ,63 ,2 ,50 ,14 ,62},
				{35 ,19 ,47 ,31 ,34 ,18 ,46 ,30},
				{11 ,59 ,7 ,55 ,10 ,58 ,6 ,54},
				{43 ,27 ,39 ,23 ,42 ,26 ,38 ,22}
				};

		int width = src.getWidth();
		int height = src.getHeight();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;

				gray = gray + (gray * matrix[x % 8][y % 8]) / 65;

				if (gray < threshold) {
					gray = 0;
				} else {
					gray = 255;
				}

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}


	/*
	 * Floyd-Steinberg Dithering
	 * 
	 *   X 7 
	 * 3 5 1
	 * 
	 * (1/16)
	 */
	public Bitmap floydSteinberg(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}
				errors[x + 1][y] += (7 * error) / 16;
				errors[x - 1][y + 1] += (3 * error) / 16;
				errors[x][y + 1] += (5 * error) / 16;
				errors[x + 1][y + 1] += (1* error) / 16;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * Jarvis, Judice , Ninke Dithering
	 * 
	 *     X 7 5
	 * 3 5 7 5 3 
	 * 1 3 5 3 1
	 * 
	 * (1/48)
	 */
	public Bitmap jarvisJudiceNinke(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 2; y++) {
			for (int x = 2; x < width - 2; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}

				errors[x + 1][y] += (7 * error) / 48;
				errors[x + 2][y] += (5 * error) / 48;

				errors[x - 2][y + 1] += (3 * error) / 48;
				errors[x - 1][y + 1] += (5 * error) / 48;
				errors[x][y + 1] += (7 * error) / 48;
				errors[x + 1][y + 1] += (5 * error) / 48;
				errors[x + 2][y + 1] += (3 * error) / 48;

				errors[x - 2][y + 2] += (1 * error) / 48;
				errors[x - 1][y + 2] += (3 * error) / 48;
				errors[x][y + 2] += (5 * error) / 48;
				errors[x + 1][y + 2] += (3 * error) / 48;
				errors[x + 2][y + 2] += (1 * error) / 48;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * Sierra Dithering
	 * 
	 *     X 5 3 
	 * 2 4 5 4 2 
	 *   2 3 2
	 * 
	 * (1/32)
	 */
	public Bitmap sierra(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 2; y++) {
			for (int x = 2; x < width - 2; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}

				errors[x + 1][y] += (5 * error) / 32;
				errors[x + 2][y] += (3 * error) / 32;

				errors[x - 2][y + 1] += (2 * error) / 32;
				errors[x - 1][y + 1] += (4 * error) / 32;
				errors[x][y + 1] += (5 * error) / 32;
				errors[x + 1][y + 1] += (4 * error) / 32;
				errors[x + 2][y + 1] += (2 * error) / 32;

				errors[x - 1][y + 2] += (2 * error) / 32;
				errors[x][y + 2] += (3 * error) / 32;
				errors[x + 1][y + 2] += (2 * error) / 32;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * Two-Row Sierra Dithering
	 * 
	 *     X 4 3 
	 * 1 2 3 2 1
	 * 
	 * (1/16)
	 */
	public Bitmap twoRowSierra(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 1; y++) {
			for (int x = 2; x < width - 2; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}

				errors[x + 1][y] += (4 * error) / 16;
				errors[x + 2][y] += (3 * error) / 16;

				errors[x - 2][y + 1] += (1 * error) / 16;
				errors[x - 1][y + 1] += (2 * error) / 16;
				errors[x][y + 1] += (3 * error) / 16;
				errors[x + 1][y + 1] += (2 * error) / 16;
				errors[x + 2][y + 1] += (1 * error) / 16;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * Sierra Lite Dithering
	 * 
	 *   X 2
	 * 1 1
	 * 
	 * (1/4)
	 */
	public Bitmap sierraLite(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}

				errors[x + 1][y] += (2 * error) / 4;

				errors[x - 1][y + 1] += (1 * error) / 4;
				errors[x][y + 1] += (1 * error) / 4;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * Atkinson Dithering
	 * 
	 *   X 1 1 
	 * 1 1 1
	 *   1
	 * 
	 * (1/8)
	 */
	public Bitmap atkinson(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 2; y++) {
			for (int x = 1; x < width - 2; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}

				errors[x + 1][y] += error / 8;
				errors[x + 2][y] += error / 8;

				errors[x - 1][y + 1] += error / 8;
				errors[x][y + 1] += error / 8;
				errors[x + 1][y + 1] += error / 8;

				errors[x][y + 2] += error / 8;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * Stucki Dithering
	 * 
	 *     X 8 4 
	 * 2 4 8 4 2 
	 * 1 2 4 2 1
	 * 
	 * (1/42)
	 */
	public Bitmap stucki(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 2; y++) {
			for (int x = 2; x < width - 2; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}

				errors[x + 1][y] += (8 * error) / 42;
				errors[x + 2][y] += (4 * error) / 42;

				errors[x - 2][y + 1] += (2 * error) / 42;
				errors[x - 1][y + 1] += (4 * error) / 42;
				errors[x][y + 1] += (8 * error) / 42;
				errors[x + 1][y + 1] += (4 * error) / 42;
				errors[x + 2][y + 1] += (2 * error) / 42;

				errors[x - 2][y + 2] += (1 * error) / 42;
				errors[x - 1][y + 2] += (2 * error) / 42;
				errors[x][y + 2] += (4 * error) / 42;
				errors[x + 1][y + 2] += (2 * error) / 42;
				errors[x + 2][y + 2] += (1 * error) / 42;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * Burkes Dithering
	 * 
	 *     X 8 4 
	 * 2 4 8 4 2
	 * 
	 * (1/32)
	 */
	public Bitmap burkes(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 1; y++) {
			for (int x = 2; x < width - 2; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}

				errors[x + 1][y] += (8 * error) / 32;
				errors[x + 2][y] += (4 * error) / 32;

				errors[x - 2][y + 1] += (2 * error) / 32;
				errors[x - 1][y + 1] += (4 * error) / 32;
				errors[x][y + 1] += (8 * error) / 32;
				errors[x + 1][y + 1] += (4 * error) / 32;
				errors[x + 2][y + 1] += (2 * error) / 32;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	/*
	 * False Floyd-Steinberg Dithering
	 * 
	 * X 3
	 * 3 2
	 * 
	 * (1/8)
	 */
	public Bitmap falseFloydSteinberg(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		int error = 0;
		int errors[][] = new int[width][height];
		for (int y = 0; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				if (gray + errors[x][y] < threshold) {
					error = gray + errors[x][y];
					gray = 0;
				} else {
					error = gray + errors[x][y] - 255;
					gray = 255;
				}
				errors[x + 1][y] += (3 * error) / 8;
				errors[x][y + 1] += (3 * error) / 8;
				errors[x + 1][y + 1] += (2 * error) / 8;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	public Bitmap simpleLeftToRightErrorDiffusion(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		for (int y = 0; y < height; y++) {
			int error = 0;

			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;
				int delta;

				if (gray + error < threshold) {
					delta = gray;
					gray = 0;
				} else {
					delta = gray - 255;
					gray = 255;
				}

				if (Math.abs(delta) < 10)
					delta = 0;

				error += delta;

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	public Bitmap randomDithering(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
				src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();
		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;

				int threshold = (int) (Math.random() * 1000) % 256;

				if (gray < threshold) {
					gray = 0;
				} else {
					gray = 255;
				}

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}

	public Bitmap simpleThreshold(Bitmap src) {
		Bitmap out = Bitmap.createBitmap(src.getWidth(), src.getHeight(),src.getConfig());

		int alpha, red;
		int pixel;
		int gray;

		int width = src.getWidth();
		int height = src.getHeight();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				pixel = src.getPixel(x, y);

				alpha = Color.alpha(pixel);
				red = Color.red(pixel);

				gray = red;

				if (gray < threshold) {
					gray = 0;
				} else {
					gray = 255;
				}

				out.setPixel(x, y, Color.argb(alpha, gray, gray, gray));
			}
		}

		return out;
	}
}
