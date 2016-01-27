package mvc1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import mvc1.user.MemberMapper;

import mvc1.board.BoardService;

import mvc1.board.NoticeDTO;
import mvc1.board.NoticeMapper;
import mvc1.user.Member;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    
    @Autowired
	private BoardService boardService;
	
	
	
	
	
    
    @RequestMapping("/main.do")
    public String main(Model model){
    	return "main";
    }
    
    
    
    
    //user PART 
    @RequestMapping(value="/signUp.do", method=RequestMethod.GET)
    public String hello(Model model) {
        //자바 파일 처리하는 부분 
        return "signUp";
    }

    @RequestMapping(value="/signUp.do", method=RequestMethod.POST)
    public String signUp(Member member, Model model)throws Exception{
    	memberMapper.insert(member);
    	return "redirect:/main.do";
    }
    
    @RequestMapping("/login.do")
    public String login(Model model){
    	return "login";
    }
    
    @RequestMapping(value="/loginPro.do", method=RequestMethod.POST)
    public String loginPro(@RequestParam("studentNum") String studentNum ,@RequestParam("password") String password,Model model)throws Exception{
    	 
    	Member member=memberMapper.loginPro(studentNum,password);
    	
    	 model.addAttribute("member",member);
    	 return "loginPro";
    }
    

    
    //board PART
    
    @RequestMapping(value="noticeDelete.do",method=RequestMethod.POST)
    public String noticeDelete(@RequestParam("nid") int nid)throws Exception{
    	System.out.println("ndid->>"+nid);
    	
    	noticeMapper.noticeDelete(nid);
    	
    	String url="redirect:/noticeList.do";
    	return url;
    
    	
    	
    }
    
	@RequestMapping(value="noticeWrite.do", method=RequestMethod.GET)
	public ModelAndView fileUploadForm()throws Throwable {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("noticeWrite");
		
		return mav;
	}
	
	
	@RequestMapping(value="noticeInsert.do", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartHttpServletRequest mRequest)throws Exception{
		NoticeDTO notice=new NoticeDTO(); //!!!
		ModelAndView mav = new ModelAndView();
		String file=null;
		String nid=mRequest.getParameter("member_id");
		String title=mRequest.getParameter("notice_title");
		String content=mRequest.getParameter("notice_content");
		file=boardService.fileUpload(mRequest);
		
		
		
		notice.setMember_id(nid);
		notice.setNotice_title(title);
		notice.setNotice_content(content);
		notice.setNotice_file(file);
		
		
		noticeMapper.noticeTest(notice);
		
		
		mav.setViewName("main");
		
		return mav;
	}
    

    
    @RequestMapping(value="/noticeList.do",method=RequestMethod.GET)
    public String noticeList(Model model){
    	List<NoticeDTO> list=noticeMapper.noticeList();
        model.addAttribute("list",list);
        return "noticeList";
    }
    
  


    @RequestMapping(value="/noticeDetail.do",method=RequestMethod.GET)
    public String noticeDetail(@RequestParam("nid") int nid,Model model){
    	NoticeDTO notice=noticeMapper.noticeDetail(nid);
    	model.addAttribute("notice",notice);
    	return "noticeDetail";
    	
    }
    
    @RequestMapping(value="fileDownload.do",method=RequestMethod.POST)
    public void fileDownload(HttpServletRequest request,HttpServletResponse response)throws Exception{
    	System.out.println("aaaaaa");
    	
    	request.setCharacterEncoding("UTF-8");
		// 다운받을 파일의 이름을 가져옴
		String bFile=request.getParameter("file");
		System.out.println(bFile);
		//다운받을 파일이 저장되어 있는 폴더 이름
		String path=request.getRealPath("/upload/");


		// 다운받을 파일의 전체 경로를 filePath에 저장
		String filePath = path + bFile;

		// 다운받을 파일을 불러옴
		File file = new File(filePath);
		byte b[] = new byte[4096];

		// page의 ContentType등을 동적으로 바꾸기 위해 초기화시킴
		response.reset();
		response.setContentType("application/octet-stream");

		// 한글 인코딩
		String Encoding = new String(bFile.getBytes("UTF-8"), "8859_1");
		// 파일 링크를 클릭했을 때 다운로드 저장 화면이 출력되게 처리하는 부분
		response.setHeader("Content-Disposition", "attachment; filename = " + Encoding);

		// 파일의 세부 정보를 읽어오기 위해서 선언
		FileInputStream in = new FileInputStream(filePath);

		// 파일에서 읽어온 세부 정보를 저장하는 파일에 써주기 위해서 선언
		ServletOutputStream out2 = response.getOutputStream();

		int numRead;
		// 바이트 배열 b의 0번 부터 numRead번 까지 파일에 써줌 (출력)
		while((numRead = in.read(b, 0, b.length)) != -1){
			out2.write(b, 0, numRead);
		}
		
		 out2.flush();
		 out2.close();
		 in.close();

    	
    }
    

   

}