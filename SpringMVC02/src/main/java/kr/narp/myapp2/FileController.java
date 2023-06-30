package kr.narp.myapp2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	
	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multipartRequest, HttpServletRequest request, Model model)  throws Exception{
		
		String UPLOAD_DIR="epo";                                   // \\, /
		String uploadPath=request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		Map map = new HashMap(); // KEY,Value
		
	Enumeration<String> e= multipartRequest.getParameterNames(); // 첨부파일은 x id name같은것만읽음
	while(e.hasMoreElements()) {
	String Pname = e.nextElement(); //id
    String val=	multipartRequest.getParameter(Pname); //파일 쓰기
     map.put(Pname, val);
	}
	
	
	Iterator<String> it= multipartRequest.getFileNames();// 파일이름이 아니라-> 파일 담은 파라미터이름 
	List<String> fileList = new ArrayList<>();
	
	while(it.hasNext()) {
		String paramFName =it.next();
		 MultipartFile mfile = multipartRequest.getFile(paramFName);//파일(이름,타입,크기...기타등등) 이걸 받아줘야함
	     String oName = mfile.getOriginalFilename(); //진짜 파일 이름
	     //오리지널 파일명 저장
	     fileList.add(oName);
	     //파일 업로드 폴더 업로드 디렉토리 확인  
	     File file = new File(uploadPath+File.separator+paramFName); //file1
	     if(mfile.getSize()!=0) {
	    	 if(!file.exists()) { //파일이 존재하지 않으면, 
	    		 if(file.getParentFile().mkdir()) { //dir생성
	    			 file.createNewFile(); // 임시로 파일을 생성한다.
	    		 }
	    	 }
	    	 mfile.transferTo(new File(uploadPath+File.separator+oName)); //파일업로드
	         //파일이 있으면 알아서 생성안하넹
	     }
	     
	}
	
	map.put("fileList", fileList);
	model.addAttribute("map", map);
		return "result";
	}
	
	
	
	@RequestMapping("/download.do")
	public void download(@RequestParam("filename")String filename, 
			HttpServletResponse response,
			HttpServletRequest request
			) throws Exception {
		
		System.out.println("오냐?");
        //파일 저장된 폴더 위치 및, 넘어온 파일 명으로 파일 객체생성 			
		String UPLOAD_DIR="epo";
		String uploadPath=request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		File f=new File(uploadPath+"\\"+filename);
		
		// 클라이언트로 부터 넘어오는 파일이름에 한글이 있는경우 깨지지 않게하기 위함
		// File에 넣을 때는 인코딩 설정안해도 괜춘한가봄
		filename=URLEncoder.encode(filename, "UTF-8");
		filename=filename.replace("+"," ");
		
		// 다운로드 준비로 서버에서 클라이언트에게 다운로드 준비를 시키는 부분(다운로드 창을 띄운다)
		response.setContentLength((int)f.length());
		response.setContentType("application/x-msdownload;charset=utf-8");
		//이것 떄문에 설정한거임 헤더에 넣을 때 한글 안깨지게 하려고 
		response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		// 실제 다운로드를 하는 부분
		FileInputStream in=new FileInputStream(f); //파일읽기 준비
		OutputStream out=response.getOutputStream();
		byte[] buffer=new byte[104];
		while(true) {
			int count=in.read(buffer);
			if(count==-1) {
				break;
			}
			out.write(buffer, 0, count); //다운로드(0%......100%)
		}//_while_
		in.close();
		out.close();		
		
	} 
}
