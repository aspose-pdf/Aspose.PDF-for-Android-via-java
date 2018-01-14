package com.example.gettableusingtableabsorber;

import com.aspose.pdf.*;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@SuppressWarnings("static-access")
	private static void UseTableAbsorber()
	{
		String inputPath = "/mnt/sdcard/Table.pdf";
		String outputPath = "/mnt/sdcard/Table_out.pdf";
		
		Document pdfDocument = new Document(inputPath);
		// Create TableAbsorber object to find tables
		TableAbsorber absorber = new TableAbsorber();

		// Visit first page with absorber
		absorber.visit(pdfDocument.getPages().get_Item(1));

		// Get access to first table on page, their first cell and text fragments in it
		Table table = (Table) absorber.getTableList().get_Item(0);
		
		Cell cell = table.getRows().get_Item(0).getCells().get_Item(0);
		
		TextFragment fragment = (TextFragment) cell.getParagraphs().get_Item(1);

		// Change text of the first text fragment in the cell
		fragment.setText ("Hello World!");

		pdfDocument.save(outputPath);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UseTableAbsorber();
		try
		{
		TextView tx = (TextView)findViewById(R.id.textBox);
		tx.setText("Done");
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
