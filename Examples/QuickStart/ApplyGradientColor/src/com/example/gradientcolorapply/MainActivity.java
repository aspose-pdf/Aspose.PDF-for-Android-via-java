package com.example.gradientcolorapply;

import com.aspose.pdf.*;
import com.aspose.pdf.drawing.GradientAxialShading;
import com.aspose.pdf.drawing.Graph;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressWarnings("static-access")
	private static void ApplyGradientColor()
	{
		String outputPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/GradientColor_out.xlsx";
		Document doc = new Document();
        Page page = doc.getPages().add();
        Graph graph = new Graph(300, 300);
        page.getParagraphs().add(graph);
        com.aspose.pdf.drawing.Rectangle rect = new com.aspose.pdf.drawing.Rectangle(0, 0, 300, 300);
        graph.getShapes().add(rect);
        rect.getGraphInfo().setFillColor(new com.aspose.pdf.Color());
        GradientAxialShading gradientAxialShading = new GradientAxialShading(Color.getRed(), Color.getBlue());
        gradientAxialShading.setStart(new Point(0, 0));
        gradientAxialShading.setEnd(new Point(300, 300));
        rect.getGraphInfo().getFillColor().setPatternColorSpace(gradientAxialShading);
        doc.save(outputPath);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ApplyGradientColor();
		try
		{
		TextView tx = (TextView)findViewById(R.id.textBox);
		tx.setText(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Table.pdf");
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
