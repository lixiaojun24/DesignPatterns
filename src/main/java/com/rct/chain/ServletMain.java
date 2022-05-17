package com.rct.chain;

import java.util.ArrayList;
import java.util.List;

public class ServletMain {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.add(new HtmlFilter()).add(new SensitiveFilter());
        Request request = new Request();
        request.msg = "大家好,我要放大招了 <script>, 大家都是996的";
        Response response = new Response();
        response.msg = "response";
        chain.doFilter(request, response, chain);
        System.out.println(request.msg);
        System.out.println(response.msg);
    }
}

class Request{
    String msg;
}

class Response{
    String msg;
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}

class HtmlFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.msg = request.msg.replace("<", "[");
        request.msg = request.msg.replace(">", "]");
        chain.doFilter(request, response, chain);
        response.msg += "---HtmlFilter.doFilter---";
        return true;
    }
}

class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.msg = request.msg.replaceAll("996", "955");
        chain.doFilter(request, response, chain);
        response.msg += "---SensitiveFilter.doFilter---";
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain){
        if(index == filters.size()) return false;
        Filter filter = filters.get(index);
        index++;
        return filter.doFilter(request, response, chain);
    }
}
