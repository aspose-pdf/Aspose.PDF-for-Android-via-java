/*
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Words. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.words.android.helloworld;

import java.io.File;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TextView;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;

public class MainActivity extends Activity {

	 public void GenerateDocument() throws Exception {

		 // This is the path to the SD card.
	     String dataDir = Environment.getExternalStorageDirectory().getPath() + File.separator;

	     // Create a new document.
	     Document doc = new Document();

	     // Use the document builder to insert text and other elements into the document.
	     DocumentBuilder builder = new DocumentBuilder(doc);
	     builder.getFont().setColor(Color.GREEN);
	     builder.writeln("Hello World!");

	     // Save the document as different formats to the memory card.
	     doc.save(dataDir + "Document Out.doc");
	     doc.save(dataDir + "Document Out.docx");
	     doc.save(dataDir + "Document Out.rtf");
	     doc.save(dataDir + "Document Out.pdf");

	 }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			GenerateDocument();
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
