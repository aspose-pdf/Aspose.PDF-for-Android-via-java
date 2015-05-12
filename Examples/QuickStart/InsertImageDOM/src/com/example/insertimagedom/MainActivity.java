package com.example.insertimagedom;


import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static void InsertImageDOM() throws IOException
	{
		//String inputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/HelloWorld_TextReplace.pdf";
    	String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/HelloWorld.pdf";
    	String imagePath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/2Landscape_TestPage.jpg";
    	
		//open first document
		com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document();
		//set coordinates
		int lowerLeftX = 0;
		int lowerLeftY = 0;
		int upperRightX = 600;
		int upperRightY = 840;

		//get the page where image needs to be added
		com.aspose.pdf.Page page = pdfDocument1.getPages().add();
		//load image into stream
		java.io.FileInputStream  imageStream = new java.io.FileInputStream(new java.io.File(imagePath));
		//add image to Images collection of Page Resources
		page.getResources().getImages().add(imageStream);
		//using GSave operator: this operator saves current graphics state
		page.getContents().add(new com.aspose.pdf.Operator.GSave());
		//create Rectangle and Matrix objects
		com.aspose.pdf.Rectangle rectangle = new com.aspose.pdf.Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
		com.aspose.pdf.Matrix matrix = new com.aspose.pdf.Matrix(new double[] { rectangle.getURX() - rectangle.getLLX(), 0, 0, rectangle.getURY()- rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY() });
		//using ConcatenateMatrix (concatenate matrix) operator: defines how image must be placed
		page.getContents().add(new com.aspose.pdf.Operator.ConcatenateMatrix(matrix));
		com.aspose.pdf.XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
		//using Do operator: this operator draws image
		page.getContents().add(new com.aspose.pdf.Operator.Do(ximage.getName()));
		//using GRestore operator: this operator restores graphics state
		page.getContents().add(new com.aspose.pdf.Operator.GRestore());
		// save the newly generated PDF file
		pdfDocument1.save(outputPath);

		// close image stream
		imageStream.close();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			InsertImageDOM();
			tx.setText("Image added successfully, please check the root of your SD card");
		} catch (Exception e) {
			tx.setText("Error during document processing: " + e.getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
