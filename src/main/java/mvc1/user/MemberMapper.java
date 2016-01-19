package mvc1.user;

import java.util.*;
import org.apache.ibatis.annotations.Param;



public interface MemberMapper {
	
	Member loginPro(@Param("studentNum")String studentNum,@Param("password")String password);
	
    void insert(Member member);

}
