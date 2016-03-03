package mvc1.news;

public class InfoDTO {//값을 받아서 화면서 쏴줄때 사용하는 DTO
	
	private String mid;
	private String name;
    private String url;
    private String description;
    private String date;
    
    
    
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
  
  
	
    
	
	

}
