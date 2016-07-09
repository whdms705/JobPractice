package mvc1.user;

import java.util.*;
import org.apache.ibatis.annotations.Param;

import mvc1.news.InfoDTO;
import mvc1.news.NewsDTO;



public interface MemberMapper {
	
	Member loginPro(@Param("studentNum")String studentNum,@Param("password")String password);
	
	Member myUpdatePro(String mid);
    void insert(Member member);
    void myUpdate(Member member);
    
    List<InfoDTO> myNews(String mid); //본인이 저장한 기사 가져오기

}
