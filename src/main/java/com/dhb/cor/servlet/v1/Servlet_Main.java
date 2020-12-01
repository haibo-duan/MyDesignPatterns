package com.dhb.cor.servlet.v1;


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
	boolean doFilter(Request request,Response response);
}

class HTMLFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response) {
		request.str = request.str.replaceAll("<","[").replaceAll(">","}");
		return true;
	}
}

class SensitiveFilter implements Filter {
	@Override
	public boolean doFilter(Request request, Response response) {
		request.str = request.str.replaceAll("966","955");
		return true;
	}
}

class FilterChain implements Filter {

	List<Filter> filters = new ArrayList<>();

	public FilterChain add(Filter f) {
		filters.add(f);
		return this;
	}

	@Override
	public boolean doFilter(Request request, Response response) {
		for(Filter f : filters) {
			f.doFilter(request,response);
		}

		return true;
	}
}

class Request{
	String str;
}

class Response {
	String str;
}