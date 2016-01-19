package mvc1;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ClubMapper {
    Club selectByName(String name);
   
}
