package com.example.concatenatepdffiles;

import com.aspose.pdf.Page;
import com.aspose.pdf.facades.PdfFileEditor;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static void concatenateDOM()
	{
		String inputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Page_1.pdf";
		String inputPath1=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Page_2.pdf";
		String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Conctenate_DOM.pdf";
		//open first document
		com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(inputPath);
		//open second document
		com.aspose.pdf.Document pdfDocument2 = new com.aspose.pdf.Document(inputPath1);
		//add pages of second document to the first
		pdfDocument1.getPages().add(pdfDocument2.getPages());

		//save concatenated output file
		pdfDocument1.save(outputPath);
	}
	
	private static void ConcatenateFac()
	{
		String inputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Page_1.pdf";
		String inputPath1=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Page_2.pdf";
		String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Conctenate_fac.pdf";
		//create PdfFileEditor object
		PdfFileEditor pdfEditor = new PdfFileEditor();
		//array of files
		String[] filesArray = new String[2];
		filesArray[0] = inputPath;
		filesArray[1] = inputPath1;
		//concatenate files
		pdfEditor.concatenate(filesArray, outputPath);
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			concatenateDOM();
			tx.setText("Document concatenated successfully, please check the root of your SD card");
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
