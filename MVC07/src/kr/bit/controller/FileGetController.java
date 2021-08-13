package kr.bit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileGetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String filename = request.getParameter("filename");
		System.out.println(filename);
		
		String UPLOAD_DIR="file_repo";
		String uploadPath=request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		
		File f = new File(uploadPath+"\\"+filename);
		// 클라이언트에서 넘어오는 파일 이름에 한글이 있는 경우 깨지지 않게하기 위함.
		filename = URLEncoder.encode(filename, "UTF-8");
		filename = filename.replace("+", " ");
		
		// 다운로드 준비 : 서버에서 클라이언트에게 다운로드 준비를 시키는 부분으로, 다운로드 창을 띄운다.
		response.setContentLength((int) f.length());
		response.setContentType("application/x-msdownload;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expire", "0");
		
		// 실제 다운로드를 하는 부분
		FileInputStream in = new FileInputStream(f);
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		while(true) {
			int count = in.read(buffer); // 1024 바이트씩 다운.
			if(count == -1){
				break;
			}
			out.write(buffer, 0, count); // 실제 다운로드 되는 부분
  		}
		in.close();
		out.close();
		
		return null;
	}

}
