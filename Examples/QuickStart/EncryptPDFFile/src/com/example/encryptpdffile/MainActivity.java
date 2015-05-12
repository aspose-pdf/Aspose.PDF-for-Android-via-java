package com.example.encryptpdffile;



import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static void EncryptFile()
	{
		String inputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/TextStamp.pdf";
		String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/TextStamp_encrypt.pdf";
		//open document
		com.aspose.pdf.Document document = new com.aspose.pdf.Document(inputPath);
		//encrypt PDF
		document.encrypt("user", "owner", 0, com.aspose.pdf.CryptoAlgorithm.AESx256);
		//save updated PDF
		document.save(outputPath);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			EncryptFile();
			tx.setText("Document encrypted successfully, please check the root of your SD card");
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
