package com.example.addtextstamp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.TextView;

import com.aspose.java.awt.Color;

public class MainActivity extends Activity {
	
	@SuppressWarnings("static-access")
	private static void AddTextStamp()
	{
		String inputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/HelloWorld.pdf";
		String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/TextStamp.pdf";
		//open document
		com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(inputPath);
		//create text stamp
		com.aspose.pdf.TextStamp textStamp = new com.aspose.pdf.TextStamp("Sample Stamp");
		//set whether stamp is background
		textStamp.setBackground(true);
		//set origin
		textStamp.setXIndent(100);
		textStamp.setYIndent(100);
		//rotate stamp
		textStamp.setRotate(com.aspose.pdf.Rotation.on90);
		//set text properties
		textStamp.getTextState().setFont(new com.aspose.pdf.FontRepository().findFont("Helvetica"));
		textStamp.getTextState().setFontSize(14.0F);
		textStamp.getTextState().setFontStyle(com.aspose.pdf.FontStyles.Bold);
		textStamp.getTextState().setFontStyle(com.aspose.pdf.FontStyles.Italic);
		textStamp.getTextState().setForegroundColor(Color.GREEN);
		//add stamp to particular page
		pdfDocument.getPages().get_Item(1).addStamp(textStamp);
		//save output document
		pdfDocument.save(outputPath);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			AddTextStamp();
			tx.setText("Documents stamped successfully, please check the root of your SD card");
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
