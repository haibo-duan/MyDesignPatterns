package com.dhb.cor.servlet.v4;


import java.util.ArrayList;
import java.util.List;

public class Servlet_Main {

	public static void main(String[] args) {

		Request request = new Request();
		request.str = "大家好&&&&&&&&&&&&&&&& <script>  欢迎。。";

		Response response = new Response();
		response.str = "";

		FilterChain chain = new FilterChain();
		chain.add(new HTMLFilter()).add(new SensitiveFilter());
		chain.doFilter(request,response);
		System.out.println(request.str);
		System.out.println(response.str);


	}
}

interface Filter {
	void doFilter(Request request,Response response,FilterChain chain);
}

class HTMLFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		request.str = request.str.replaceAll("<","[").replaceAll(">","]")+"HTMLFilter ";
		chain.doFilter(request,response);
		response.str += "--HTMLFilter()";
	}
}

class SensitiveFilter implements Filter {
	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		request.str = request.str.replaceAll("966","955")+"SensitiveFilter ";
		chain.doFilter(request,response);
		response.str += "--SensitiveFilter()";
	}
}


class FilterChain {
	int index = 0;

	List<Filter> filters = new ArrayList<>();

	public FilterChain add(Filter f) {
		filters.add(f);
		return this;
	}

	public void doFilter(Request request, Response response) {
		if(index == filters.size()) {
			return;
		}
		Filter filter = filters.get(index);
		index ++;

		filter.doFilter(request,response,this);
	}
}

class Request{
	String str;
}

class Response {
	String str;
}