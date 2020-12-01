package com.dhb.cor.servlet.v3;


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
		chain.doFilter(request,response,chain);
		System.out.println(request.str);
		System.out.println(response.str);


	}
}

interface Filter {
	boolean doFilter(Request request,Response response,FilterChain chain);
}

class HTMLFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response,FilterChain chain) {
		request.str = request.str.replaceAll("<","[").replaceAll(">","]")+"HTMLFilter ";
		chain.doFilter(request,response,chain);
		response.str += "--HTMLFilter()";
		return true;
	}
}

class SensitiveFilter implements Filter {
	@Override
	public boolean doFilter(Request request, Response response,FilterChain chain) {
		request.str = request.str.replaceAll("966","955")+"SensitiveFilter ";
		chain.doFilter(request,response,chain);
		response.str += "--SensitiveFilter()";
		return true;
	}
}


class FilterChain implements Filter {
	int index = 0;

	List<Filter> filters = new ArrayList<>();

	public FilterChain add(Filter f) {
		filters.add(f);
		return this;
	}

	@Override
	public boolean doFilter(Request request, Response response,FilterChain chain) {
		if(index == filters.size()) {
			return false;
		}
		Filter filter = filters.get(index);
		index ++;

		return filter.doFilter(request,response,chain);
	}
}

class Request{
	String str;
}

class Response {
	String str;
}