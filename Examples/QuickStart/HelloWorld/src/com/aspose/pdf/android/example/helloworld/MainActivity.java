package com.aspose.pdf.android.example.helloworld;

import com.aspose.java.awt.Color;
import com.aspose.pdf.Page;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static void HelloWorld()
	{
		//Set locale
		com.aspose.pdf.LocaleOptions.setLocale(java.util.Locale.US);
		String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath();
		com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document();
        // add a page to PDF file
        Page page= pdfDocument1.getPages().add();
        // add text in new page
        //create text fragment
        com.aspose.pdf.TextFragment textFragment = new com.aspose.pdf.TextFragment("Hello World!");
        textFragment.setPosition(new com.aspose.pdf.Position(100, 600));

        //set text properties
        textFragment.getTextState().setFont(com.aspose.pdf.FontRepository.findFont("Helvetica"));
        textFragment.getTextState().setFontSize(14);
        textFragment.getTextState().setForegroundColor(Color.BLUE);
        textFragment.getTextState().setBackgroundColor(Color.GRAY);

        // create TextBuilder object
        com.aspose.pdf.TextBuilder textBuilder = new com.aspose.pdf.TextBuilder(page);
        // append the text fragment to the PDF page
        textBuilder.appendText(textFragment);
                     
        // save the PDF file
        pdfDocument1.save(outputPath + "/HelloWorld.pdf");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			HelloWorld();
			tx.setText("Documents created successfully, please check the root of your SD card");
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
