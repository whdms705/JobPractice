package mvc1.board;



import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@Service
public class BoardService {
	
	
	public String fileUpload(MultipartHttpServletRequest mRequest) {

		
		
		
		String isSuccess=null;
		
		//String uploadPath = "/file/";
		
		String uploadPath =mRequest.getRealPath("/upload/");
		
		
		
		File dir = new File(uploadPath);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		Iterator<String> iter = mRequest.getFileNames();
		while(iter.hasNext()) {
			String uploadFileName = iter.next();
			
			MultipartFile mFile = mRequest.getFile(uploadFileName);
			String originalFileName = mFile.getOriginalFilename();
			String saveFileName = originalFileName;
			
			if(saveFileName != null && !saveFileName.equals("")) {
				if(new File(uploadPath + saveFileName).exists()) {
					saveFileName = saveFileName + "_" + System.currentTimeMillis();
					System.out.println("board->"+saveFileName);
				}
				
				try {
					System.out.println("uploadpath->"+uploadPath+"board->"+saveFileName);
					mFile.transferTo(new File(uploadPath + saveFileName));
					isSuccess =saveFileName;				
				} catch (IllegalStateException e) {
					e.printStackTrace();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			} // if end
		} // while end
		return isSuccess;
	} // fileUpload end

}
