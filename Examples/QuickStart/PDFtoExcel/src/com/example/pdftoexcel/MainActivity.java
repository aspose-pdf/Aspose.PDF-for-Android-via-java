package com.example.pdftoexcel;

import com.aspose.pdf.*;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressWarnings("static-access")
	private static void PDFtoExcel()
	{
		String inputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Table.pdf";
		String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Table_out.xlsx";
		// Method 1
		Document doc = new Document(inputPath);
		doc.save(outputPath, SaveFormat.Excel);
		
		// Method 2
		ExcelSaveOptions options = new ExcelSaveOptions();
		options.setInsertBlankColumnAtFirst(false);
		options.setMinimizeTheNumberOfWorksheets(true);

		Document pdfDocument = new Document(inputPath);
		pdfDocument.save(outputPath, options);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PDFtoExcel();
		try
		{
		TextView tx = (TextView)findViewById(R.id.textBox);
		tx.setText("Done.");
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
