package mvc1.news;

import java.util.*;
import org.apache.ibatis.annotations.Param;


public interface NewsMapper {
	
	void newsInsert(InfoDTO info);

	void newsDelete(int nid);
	
}
