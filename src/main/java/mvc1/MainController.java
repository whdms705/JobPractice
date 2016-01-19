package mvc1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import mvc1.user.MemberMapper;
import mvc1.board.NoticeDTO;
import mvc1.board.NoticeMapper;
import mvc1.user.Member;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    ClubMapper clubMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    NoticeMapper noticeMapper;
    
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
    	System.out.println("password-:"+password+"student->"+studentNum); 
    	Member member=memberMapper.loginPro(studentNum,password);
    	 System.out.println("pp");
    	 model.addAttribute("member",member);
    	 return "loginPro";
    }
    

    
    //board PART
    
    
    @RequestMapping("/noticeWrite.do")
    public String noticeWrite(Model model){
    	return "noticeWrite";
    }
    
    
    @RequestMapping(value="/noticeInsert.do", method=RequestMethod.POST)
    public String noticeInsert(NoticeDTO notice,Model model)throws Exception{
    	System.out.println("ss1");
    	noticeMapper.noticeInsert(notice);
    	System.out.println("ss2");
    	return "redirect:/main.do";
    }
    
  
    
    @RequestMapping("/noticeList.do")
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
    

   

}
