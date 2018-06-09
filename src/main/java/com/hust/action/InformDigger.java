package com.hust.action;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.hust.entity.Inform;

public class InformDigger {
	
	public List<Inform> getInform() throws Exception{
		List<Inform> informs = new ArrayList<Inform>();
		Document doc = Jsoup.connect("http://gs.hust.edu.cn/tzgg.htm").get();//解析url,获取html页面的全部内容
		Elements content = doc.select("ul").get(2).select("a");//获取通知信息的链接
		for (int i = 0; i < 15; i++) {
            //System.out.println("http://my.dlmu.edu.cn" + content.get(i).attr("href") + " --- " + content.get(i).attr("title"));
            informs.add(this.getInform("http://gs.hust.edu.cn/" + content.get(i).attr("href")));
        }
		return informs;
	}
	public Inform getInform(String url) throws Exception{
		 Inform inform = new Inform();
		 Document doc = Jsoup.connect(url).get();
		 Elements title = doc.getElementsByClass("r_title");
		 Elements info = doc.getElementsByClass("r_p");
		 Elements pbox = doc.getElementsByClass("r_con");
		 inform.setTitle(title.text());
		 inform.setInfo(info.text());
		 inform.setPbox(pbox.text());
		 return inform;
	}
	
}