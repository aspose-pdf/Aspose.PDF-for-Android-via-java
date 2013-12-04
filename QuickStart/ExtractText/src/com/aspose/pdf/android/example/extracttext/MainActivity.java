package com.aspose.pdf.android.example.extracttext;

import java.io.IOException;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static void ExtractText() throws IOException
	{
		String inputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/page_1.pdf";
    	String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/extractedtext.txt";
    	
		com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(inputPath);
		//create TextAbsorber object to extract text
		com.aspose.pdf.TextAbsorber textAbsorber = new com.aspose.pdf.TextAbsorber();
		//accept the absorber for all the pages
		pdfDocument.getPages().accept(textAbsorber);
		//pdfDocument.getPages().get_Item(2).accept(textAbsorber);
		//get the extracted text
		String extractedText = textAbsorber.getText();

		// create a writer and open the file
		java.io.FileWriter writer = new java.io.FileWriter(new java.io.File(outputPath));
		writer.write(extractedText);
		// write a line of text to the file
		//tw.WriteLine(extractedText);
		// close the stream
		writer.close();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			ExtractText();
			tx.setText("Text extracted successfully, please check the root of your SD card");
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
