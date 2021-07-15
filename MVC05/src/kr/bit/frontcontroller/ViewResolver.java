package kr.bit.frontcontroller;

public class ViewResolver {
	// View의 경로를 만들어줌.
	
	public static String makeView(String nextPage) {
		
		// 경로가 수정되면 이 부분만 수정하면 된다.
		
		return "/WEB-INF/member/" + nextPage + ".jsp";
	}

}
