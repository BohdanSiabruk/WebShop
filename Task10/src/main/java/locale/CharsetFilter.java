package locale;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private String encoding;

    public void destroy() {
        // no op
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Request uri --> " + httpRequest.getRequestURI());

        if (null == request.getCharacterEncoding()) {
            System.out.println("Request encoding = null, set encoding --> " + encoding);
            request.setCharacterEncoding(encoding);
        }
        System.out.println("Filter finished");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialization starts");
        encoding = filterConfig.getInitParameter("requestEncoding");
        System.out.println("Encoding from web.xml --> " + encoding);
        if (encoding == null) {
            encoding = "UTF-8";
            System.out.println("Set up encoding --> " + encoding);
        }
        System.out.println("Filter initialization finished");
    }

}
