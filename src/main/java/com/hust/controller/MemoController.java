package com.hust.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hust.entity.Memo;
import com.hust.entity.User;
import com.hust.service.MemoService;

@Controller
public class MemoController {
	
	@Autowired
    private MemoService memoService;
	
	@RequestMapping("/memo")
    public String memo(HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        String studentId = (user.getUsername());
        List<Memo> memoList = memoService.queryMemoById(studentId);
        List<Memo> homememo = memoService.queryHomeMemoById(studentId);
        session.setAttribute("memolist", memoList);
        session.setAttribute("homememo", homememo);
        return "memo";
    }
	
	@RequestMapping("/memoedit")
	public String deitMemo(HttpSession session,HttpServletRequest request) {
		Object obj = session.getAttribute("user");
        if(obj == null){
            return "redirect:/login";
        }
        String edit = request.getParameter("edit");
        if(edit != null) {
        	String studentId = ((User)session.getAttribute("user")).getUsername();
        	List<Memo> memos = memoService.queryMemoById(studentId);
        	Memo memo = memos.get(Integer.parseInt(edit));
        	session.setAttribute("editmemo", memo);
        }else {
        	session.removeAttribute("editmemo");
        }
        return "memoedit";
	}
	
	/**这种写法不对，导致出现404错误，为什么？
	@RequestMapping("/submitmemo")
	public String submitmemo(HttpSession session,HttpServletRequest request,
			                 @RequestParam("title") String title,
			                 @RequestParam("detail") String detail,
			                 @RequestParam("home") String home) {
		String action = request.getParameter("action");
		Memo memo =new Memo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        String studentId = ((User)session.getAttribute("user")).getUsername();
        memo.setStudentId(studentId);
        memo.setCreateTime(sdf.format(date));
        memo.setTitle(title);
        memo.setDetail(detail);
        memo.setHome((home.equals("true")) ? 1 : 0);
		if(action.equals("add")) {
            memoService.addMemo(memo);
		}else {//action.equals("edit")
			memoService.updateMemo(memo);
		}
		return "forward:/memo";
	}
	*/
	
	@RequestMapping("/submitmemo")
	public String submitmemo(HttpSession session,HttpServletRequest request) {
		String action = request.getParameter("action");
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String home = request.getParameter("home");
		//System.out.println(home);//如果选定，则home为on,否者为null
		Memo memo = new Memo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		String studentId = ((User)session.getAttribute("user")).getUsername();
		memo.setStudentId(studentId);
		memo.setCreateTime(sdf.format(date));
		memo.setTitle(title);
		memo.setDetail(detail);
		memo.setHome((home != null)? 1 : 0);
		if(action.equals("add")) {
			memoService.addMemo(memo);
		}else {//action.equals("edit")
			memoService.updateMemo(memo);
		}
		return "forward:/memo";
	}
	
	@RequestMapping("/memodelete")
	public String deleteMemo(HttpSession session,HttpServletRequest request) {
		String delete = request.getParameter("delete");
		List<Memo> memoList = (List<Memo>)session.getAttribute("memolist");
		Memo memo = memoList.get(Integer.parseInt(delete));
		memoService.deleteMemo(memo.getStudentId(), memo.getCreateTime());
		return "forward:/memo";
	}
	
}