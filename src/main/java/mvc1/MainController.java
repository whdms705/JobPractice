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
import mvc1.news.InfoDTO;
import mvc1.news.NewsDTO;
import mvc1.news.NewsMapper;
import mvc1.news.RssService;
import mvc1.news.UrlDTO;
import mvc1.user.Member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class MainController {


	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private NewsMapper newsMapper;

	@Autowired
	private BoardService boardService;
	@Autowired
	private RssService rssService;


	final static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	 @RequestMapping("/test.do")
	    public String main(Model model) throws IOException{
	        
	        Document doc = Jsoup.connect("http://www.hankyung.com/news/app/newsview.php?aid=201604101629g&amp;sid=newsIndustry&amp;nid=000&rss=r").get();
	        Elements titles = doc.select("article#newsView");
	        
	        System.out.println("---------1------------------ "+titles.text());
	       /* for(Element e: titles){
	        	System.out.println("---------------2----------------");
	            System.out.println("download: " + e.text());
	        }*/
	        return "index";
	    }



	@RequestMapping(value="index.do")
	public String index(){
		return "index";
	}

	@RequestMapping(value="/main.do")
	public ModelAndView main(@RequestParam("category") String category,Model model) throws Exception{

		logger.debug("welcome() is executed, value {}", "mkyong");
		//logger.error("This is Error message", new Exception("Testing"));
		ModelAndView mav = new ModelAndView();  
		String query=category;
		ArrayList<UrlDTO> list=rssService.getCatCodeList(query);
		ArrayList<InfoDTO> infoList=rssService.getInfoList(list);

		mav.addObject("infoList",infoList);
		mav.setViewName("main");
		return mav;
	}

	//news part

	@RequestMapping(value="/newsInsert.do",method=RequestMethod.POST)
	public String newsInsert(@RequestParam("category") String category,InfoDTO info)throws Exception{
		newsMapper.newsInsert(info);
		category= URLEncoder.encode(category, "UTF-8");//redirect 한글깨짐현상 해결
		String url="redirect:/main.do?category="+category;
		return url;

	}
	
	@RequestMapping(value="/newsDelete.do",method=RequestMethod.POST)
	public String newsDelete(@RequestParam("news_id")int nid,@RequestParam("category") String category,InfoDTO info)throws Exception{
	
		String mid=info.getMember_id();
		newsMapper.newsDelete(nid);
		String url="redirect:/myPage.do?mid="+mid+"&category="+category;
		return url;
		
		
	}



	//user PART 
	@RequestMapping(value="/signUp.do",method=RequestMethod.GET)
	public String hello(Model model) {
		return "signUp";
	}

	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String signUp(Member member, Model model)throws Exception{
		memberMapper.insert(member);
		return "redirect:/index.do";
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

	
	@RequestMapping(value="/myPage.do")
	public String myPage(){
		return "myPage";
	}
	
	@RequestMapping(value="/myPage.do",method=RequestMethod.GET)
	public ModelAndView myPages(@RequestParam("category")String category,@RequestParam("mid") String mid,Model model){
		
		ModelAndView mav=new ModelAndView();
		String category1,category2,category3;
		String query=category;
		
		List<InfoDTO> list=null;
		Member member=null;
		category1="myNews";
		category2="breakaway";
		category3="update";
		if(query.equals(category1)){
			list=memberMapper.myNews(mid);
			mav.addObject("infoList",list);
		}else if(query.equals(category2)){
			
		}else if(query.equals(category3)){
			member=memberMapper.myUpdatePro(mid);
			mav.addObject("member",member);
			
		}
			mav.setViewName("myPage");
			return mav;
			
	}
	
	@RequestMapping(value="myUpdate.do",method=RequestMethod.POST)
	public String myUpdate(@RequestParam("category")String category,Member member)throws Exception{
		memberMapper.myUpdate(member);
		String url="redirect:/myPage.do?mid="+member.getStudentNum()+"&category="+category;
		return url;
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