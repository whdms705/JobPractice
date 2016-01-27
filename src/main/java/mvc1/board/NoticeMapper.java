package mvc1.board;

import java.util.*;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	
	void noticeDelete(int nid);
	void noticeInsert(NoticeDTO notice);
	List<NoticeDTO> noticeList();
	NoticeDTO noticeDetail(int nid);
	
	
	void noticeTest(NoticeDTO notice);
	
}
