package mvc1.board;

import java.util.*;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	
	void noticeInsert(NoticeDTO notice);
	List<NoticeDTO> noticeList();
	NoticeDTO noticeDetail(int nid);
	
}