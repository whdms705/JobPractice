package mvc1.news;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

@Service
public class RssService {

	 public ArrayList<UrlDTO> getCatCodeList(String query) {
	        Scanner sc = null;
	        ArrayList<UrlDTO> list = new ArrayList<UrlDTO>(100);
	        String id="", name="",type="",cat="",rss="";

	        try {
	        
	           sc =new Scanner(new File("C:\\project\\JobPractice\\rssurl.txt"),"UTF-8");
	      

	            while(sc.hasNextLine()){
	            	
	                String line = sc.nextLine();
	                StringTokenizer st = new StringTokenizer(line);
	                id = st.nextToken();
	                name = st.nextToken();
	                type = st.nextToken();
	                cat = st.nextToken();
	                rss = st.nextToken();
	                
	                
	                
	                if(query.equals(cat)){
	                	
	                    UrlDTO url = new UrlDTO(id, name, type, cat, rss);
	                    list.add(url);
	                }//선택한 종류 정보만  list add 
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	        return list;
	    }
	 
	 
	 
	 public ArrayList<InfoDTO> getInfoList(ArrayList<UrlDTO> list)throws Exception{
		 int count=0;
		 int i=0;
		 int j=0;
		 int z=0;
		 ArrayList<InfoDTO> infoList = new ArrayList<InfoDTO>(10);
		
		 InfoDTO info=null;
		 
		
		 
		 for(UrlDTO u:list){
			 Document doc = Jsoup.connect(u.getRss()).get();
			 
			 
			 Elements name=doc.select("item title");
			 
			 for(Element n: name){
					
					String title=n.text();
					
					info=new InfoDTO();
					info.setNews_title(title);
					infoList.add(info);
					
				}
			 
			 
			 
			 
			 Elements url=doc.select("item link");
			
			 
			 
			 for(Element r: url){
					
					String articleUrl=r.text();
					
					InfoDTO in=infoList.get(i);
					in.setNews_url(articleUrl);
					infoList.set(i, in);
					i++;
					
			 }
			 
			 Elements des=doc.select("item description");
		
			 
			 
			 for(Element d:des){
					
					String descript=d.text();
					
					InfoDTO in=infoList.get(j);
					in.setNews_description(descript);
					infoList.set(j, in);
					j++;
					
			 }
			 
			 Elements date=doc.select("item pubDate");
			
			 
			 
			 for(Element t:date){
					
					String pubdate=t.text();
				
					InfoDTO in=infoList.get(z);
					in.setNews_date(pubdate);
					infoList.set(z, in);
					z++;
					
			 }
			
			
		
			 
			 
			 
			 
		 }
		 
	
		
		 
		 return infoList;
	 }
	 
	 
	 
	 

	
	 
	 
	 
	 

	 
	 
	    // 스레드를 사용하기 위해 내장 클래스를 만들자.....
	 /*
	    public class CNewsRead extends AsyncTask<ArrayList<UrlDTO>, Void, ArrayList<NewsCatItem>> {

	        @Override
	        protected ArrayList<NewsCatItem> doInBackground(ArrayList<Url>... params) {

	            ArrayList<NewsCatItem> list = new ArrayList<NewsCatItem>();

	            ArrayList<Url> ul = (ArrayList<Url>)params[0];
	            for(Url u : ul) {
	                String rssUrl = u.getRss();
	                String type = u.getType();
	                Log.i("NewsReader", "주소 : " + rssUrl);

	                try {
	                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	                    factory.setNamespaceAware(true);        //네임스페이스 사용 지정
	                    XmlPullParser parser = factory.newPullParser();

	                    // 파서에 전달할 입력스트림을 만든다.
	                    URL url = new URL(rssUrl);

	                    switch (type) {
	                         case "UTF":
	                             parser.setInput(url.openStream(), "UTF-8");
	                             break;
	                         case "EUC":
	                             parser.setInput(url.openStream(), "EUC-KR");
	                             break;
	                    }




	                    // 이제부터 파싱을 한다
	                    boolean isItem = false;
	                    boolean isTitle = false;
	                    boolean isLink = false;
	                    boolean isDescription = false;
	                    boolean isPubDate = false;

	                    String tagName = "";
	                    NewsCatItem item = null;
	                    int eventType = parser.getEventType();
	                    Log.i("NewsReader", "파싱을 시작합니다.");

	                    while (eventType != XmlPullParser.END_DOCUMENT) {
	                        Log.i("NewsReader", "이제 반복합니다.");
	                        switch (eventType) {
	                            case XmlPullParser.START_DOCUMENT:
	                                isItem = false;
	                                isTitle = false;
	                                isLink = false;
	                                isDescription = false;
	                                isPubDate = false;

	                                break;
	                            case XmlPullParser.START_TAG:
	                                tagName = parser.getName().trim().toUpperCase();

	                                if (tagName.equals("ITEM")) isItem = true;
	                                if (isItem && tagName.equals("TITLE")) {
	                                    isTitle = true;
	                                    item = new NewsCatItem();
	                                }
	                                if (isItem && tagName.equals("LINK")) isLink = true;
	                                if (isItem && tagName.equals("DESCRIPTION")) isDescription = true;
	                                if (isItem && tagName.equals("PUBDATE")) isPubDate = true;
	                                if (isItem && tagName.equals("DATE")) isPubDate = true;
	                                break;


	                            case XmlPullParser.END_TAG:
	                                tagName = parser.getName().trim().toUpperCase();

	                                if (tagName.equals("ITEM")) isItem = false;
	                                if (isItem && tagName.equals("TITLE")) isTitle = false;
	                                if (isItem && tagName.equals("LINK")) isLink = false;
	                                if (isItem && tagName.equals("DESCRIPTION")) isDescription = false;
	                                if (isItem && tagName.equals("PUBDATE")) {
	                                    isPubDate = false;
	                                    list.add(item);
	                                }
	                                if (isItem && tagName.equals("DATE")) {
	                                    isPubDate = false;
	                                    list.add(item);
	                                }
	                                System.out.println("타일을 1개 읽음...");
	                                break;
	                            case XmlPullParser.TEXT:
	                                if (isItem && isTitle) {
	                                    String title = parser.getText();
	                                    item.setTitle(title);
	                                }
	                                if (isItem && isLink) {
	                                    String link = parser.getText();
	                                    item.setLink(link);
	                                }
	                                if (isItem && isDescription) {
	                                    String description = parser.getText().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");   //html 제거 정규식
	                                    item.setDescription(description);

	                                }
	                                if (isItem && isPubDate) {

	                                   // SimpleDateFormat sdf =
	                                   //         new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                                   // Date pubDate = sdf.parse(parser.getText());

	                                      String pubDate = parser.getText();
	                                      item.setPubDate(pubDate);
	                                }
	                                break;
	                        }
	                        eventType = parser.next();
	                    }
	                    System.out.println("파싱을 종료합니다....");

	                } catch (XmlPullParserException e) {
	                	  System.out.println(e.getMessage());
	                } catch (MalformedURLException e) {
	                	  System.out.println(e.getMessage());
	                } catch (IOException e) {
	                	  System.out.println(e.getMessage());
	                } catch (IndexOutOfBoundsException e) {
	                	  System.out.println(e.getMessage());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }

	            return list;
	        }

	        @Override
	        protected void onPostExecute(ArrayList<NewsCatItem> alist) {
	            super.onPostExecute(alist);
	            cnList = alist;
	            ArrayList<String> data = new ArrayList<String>();

	          //  SimpleDateFormat sdf =
	          //                      new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	          //  for(NewsCatItem i : alist)
	          //      data.add(i.getTitle() + "\n" + "(" + sdf.format(i.getPubDate()) + ")");

	            for(NewsCatItem i : alist)
	                cnAdapter.addItem(getResources().getDrawable(R.drawable.newsimg), i.getTitle(), i.getDescription(), i.getPubDate() + "\n");

	            cnLv.setAdapter(cnAdapter);
	        }
	    }
*/
	
	
}
