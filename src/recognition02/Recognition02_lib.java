package recognition02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;

public class Recognition02_lib {
	
	VisualRecognition service;
	IamOptions iamOptions;
	ClassifyOptions classifyOptions;
	ClassifiedImages result;
	
	public Recognition02_lib() {
		
		this.service = new VisualRecognition("2018-03-19");
		this.iamOptions = new IamOptions.Builder()
		  .apiKey("U8LWtO-6jGbDoy9dFfr6_7udROnGmOp9NI5sYxaCPBOK")
		  .build();
		service.setIamCredentials(iamOptions);

	}

	public void getResult(String filwpath) {
		// TODO Auto-generated method stub
		
	 classifyOptions = null;
		try {
			classifyOptions =   new ClassifyOptions.Builder()
						  .imagesFile(new File(filwpath))
						  .imagesFilename("katana.jpg")
						  .threshold((float) 0.6)
						  .owners(Arrays.asList("IBM"))
						  .build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  result = service.classify(classifyOptions).execute();
		System.out.println(result);
	}
}
